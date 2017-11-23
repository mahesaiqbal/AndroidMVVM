package com.mahesaiqbal.androidmvvm.model.viewmodel;

import com.mahesaiqbal.androidmvvm.api.ApiInteractor;
import com.mahesaiqbal.androidmvvm.model.api.ListKota;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by mahesaiqbal on 11/23/2017.
 */

public class KotaViewModel {

    private ApiInteractor interactor;
    private Scheduler scheduler;

    public KotaViewModel(ApiInteractor interactor, Scheduler scheduler) {
        this.interactor = interactor;
        this.scheduler = scheduler;
    }

    public Observable<ListKota> getListKota(){
        return interactor.getListKota().observeOn(scheduler);
    }
}
