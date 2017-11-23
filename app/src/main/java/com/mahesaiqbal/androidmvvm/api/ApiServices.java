package com.mahesaiqbal.androidmvvm.api;

import com.mahesaiqbal.androidmvvm.model.api.JadwalBioskop;
import com.mahesaiqbal.androidmvvm.model.api.ListKota;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by mahesaiqbal on 11/23/2017.
 */

public interface ApiServices {
    @GET("/api/jadwal-bioskop")
    Observable<ListKota> getListKota();

    @GET("/api/jadwal-bioskop")
    Observable<JadwalBioskop> getjadwalBioskop(@Query("id") int id);
}
