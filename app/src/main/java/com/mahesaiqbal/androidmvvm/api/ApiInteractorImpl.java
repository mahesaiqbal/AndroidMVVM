package com.mahesaiqbal.androidmvvm.api;

import com.mahesaiqbal.androidmvvm.model.api.JadwalBioskop;
import com.mahesaiqbal.androidmvvm.model.api.ListKota;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by mahesaiqbal on 11/23/2017.
 */

public class ApiInteractorImpl implements ApiInteractor {

    private ApiServices apiServices;

    public ApiInteractorImpl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ibacor.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        apiServices = retrofit.create(ApiServices.class);
    }

    @Override public Observable<ListKota> getListKota() {
        return apiServices.getListKota().subscribeOn(Schedulers.io());
    }

    @Override public Observable<JadwalBioskop> getJadwalBioskop(int id) {
        return apiServices.getjadwalBioskop(id).subscribeOn(Schedulers.io());
    }

}