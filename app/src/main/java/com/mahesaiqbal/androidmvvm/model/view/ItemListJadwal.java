package com.mahesaiqbal.androidmvvm.model.view;

import android.databinding.BaseObservable;

import com.mahesaiqbal.androidmvvm.BR;

import java.util.List;

/**
 * Created by mahesaiqbal on 11/23/2017.
 */

public class ItemListJadwal extends BaseObservable {

    private String movie;
    private String poster;
    private String genre;
    private String duration;
    private List<JadwalBean> jadwal;

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
        notifyPropertyChanged(BR.listJadwal);
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
        notifyPropertyChanged(BR.listJadwal);
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
        notifyPropertyChanged(BR.listJadwal);
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
        notifyPropertyChanged(BR.listJadwal);
    }

    public List<JadwalBean> getJadwal() {
        return jadwal;
    }

    public void setJadwal(List<JadwalBean> jadwal) {
        this.jadwal = jadwal;
    }

    public static class JadwalBean {

        private String bioskop;
        private String harga;
        private List<String> jam;

        public JadwalBean(String bioskop, String harga, List<String> jam) {
            this.bioskop = bioskop;
            this.harga = harga;
            this.jam = jam;
        }

        public String getBioskop() {
            return bioskop;
        }

        public void setBioskop(String bioskop) {
            this.bioskop = bioskop;
        }

        public String getHarga() {
            return harga;
        }

        public void setHarga(String harga) {
            this.harga = harga;
        }

        public List<String> getJam() {
            return jam;
        }

        public void setJam(List<String> jam) {
            this.jam = jam;
        }
    }

}
