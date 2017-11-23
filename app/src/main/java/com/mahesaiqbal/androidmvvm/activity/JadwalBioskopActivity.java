package com.mahesaiqbal.androidmvvm.activity;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.mahesaiqbal.androidmvvm.R;
import com.mahesaiqbal.androidmvvm.adapter.ListJadwalAdapter;
import com.mahesaiqbal.androidmvvm.api.ApiInteractorImpl;
import com.mahesaiqbal.androidmvvm.databinding.ActivityJadwalBioskopBinding;
import com.mahesaiqbal.androidmvvm.model.api.JadwalBioskop;
import com.mahesaiqbal.androidmvvm.model.view.Jadwal;
import com.mahesaiqbal.androidmvvm.model.viewmodel.JadwalViewModel;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

public class JadwalBioskopActivity extends AppCompatActivity {

    private static final String TAG = "JadwalBioskopActivity";

    private ActivityJadwalBioskopBinding bioskopBinding;
    private ListJadwalAdapter listJadwalAdapter;
    private CompositeSubscription subscription = new CompositeSubscription();
    private JadwalViewModel jadwalViewModel;
    private ProgressDialog progressDialog;
    private int id;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bioskopBinding = DataBindingUtil.setContentView(this, R.layout.activity_jadwal_bioskop);
        progressDialog = new ProgressDialog(this);
        jadwalViewModel = new JadwalViewModel(new ApiInteractorImpl(), AndroidSchedulers.mainThread());
        id = getIntent().getIntExtra("position_id", 0);
        getSupportActionBar().setTitle("Jadwal Bioskop");
        loadData();
    }

    private void loadData() {
        showLoading();
        subscription.add(jadwalViewModel.getJadwalBioskop(1)
                .subscribe(new Observer<JadwalBioskop>() {
                    @Override public void onCompleted() {
                        hideLoading();
                    }

                    @Override public void onError(Throwable e) {
                        hideLoading();
                        showSnack("Failed load data");
                        Log.e(TAG, "onError: ", e);
                    }

                    @Override public void onNext(JadwalBioskop jadwalBioskop) {
                        updateUi(jadwalBioskop);
                    }
                }));
    }

    private void updateUi(JadwalBioskop jadwalBioskop) {
        Jadwal jadwal = new Jadwal(jadwalBioskop.getKota());
        bioskopBinding.setJadwal(jadwal);
        listJadwalAdapter = new ListJadwalAdapter(jadwalBioskop.getData());
        bioskopBinding.listJadwal.setLayoutManager(new LinearLayoutManager(this));
        bioskopBinding.listJadwal.setAdapter(listJadwalAdapter);
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        subscription.unsubscribe();
    }

    private void showLoading() {
        progressDialog.setMessage("Please wait...");
        progressDialog.show();
    }

    private void hideLoading() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    private void showSnack(String message) {
        Snackbar.make(bioskopBinding.listJadwal, message, Snackbar.LENGTH_SHORT).show();
    }
}