package com.mahesaiqbal.androidmvvm.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.mahesaiqbal.androidmvvm.R;
import com.mahesaiqbal.androidmvvm.adapter.ListKotaAdapter;
import com.mahesaiqbal.androidmvvm.api.ApiInteractorImpl;
import com.mahesaiqbal.androidmvvm.databinding.ActivityListKotaBinding;
import com.mahesaiqbal.androidmvvm.model.api.ListKota;
import com.mahesaiqbal.androidmvvm.model.viewmodel.KotaViewModel;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

public class ListKotaActivity extends AppCompatActivity {
    private static final String TAG = "ListKotaActivity";

    private ActivityListKotaBinding binding;
    private ListKotaAdapter listKotaAdapter;
    private CompositeSubscription subscription = new CompositeSubscription();
    private KotaViewModel kotaViewModel;
    private ProgressDialog progressDialog;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list_kota);
        progressDialog = new ProgressDialog(this);

        getSupportActionBar().setTitle("Daftar Kota");

        kotaViewModel = new KotaViewModel(new ApiInteractorImpl(), AndroidSchedulers.mainThread());
        if (isInternetConnectionAvailable())
            loadListKota();
    }

    private void loadListKota() {
        showLoading();
        subscription.add(kotaViewModel.getListKota()
                .subscribe(new Observer<ListKota>() {
                    @Override public void onCompleted() {
                        hideLoading();
                    }

                    @Override public void onError(Throwable e) {
                        hideLoading();
                        showSnack(e.getMessage());
                    }

                    @Override public void onNext(ListKota listKota) {
                        updateUi(listKota.getData());
                    }
                }));
    }

    private void updateUi(List<ListKota.DataBean> data) {
        listKotaAdapter = new ListKotaAdapter(data, new ListKotaAdapter.OnClickImpl() {
            @Override
            public void onCLickView(int position) {
                Intent intent = new Intent(ListKotaActivity.this, JadwalBioskopActivity.class);
                intent.putExtra("position_id", position);
                startActivity(intent);
            }
        });
        binding.listKota.setLayoutManager(new LinearLayoutManager(this));
        binding.listKota.setAdapter(listKotaAdapter);
    }

    private boolean isInternetConnectionAvailable() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork.isConnectedOrConnecting();
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
        Snackbar.make(binding.listKota, message, Snackbar.LENGTH_SHORT).show();
    }
}