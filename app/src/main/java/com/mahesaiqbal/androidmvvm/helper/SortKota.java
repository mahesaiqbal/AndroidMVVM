package com.mahesaiqbal.androidmvvm.helper;

import com.mahesaiqbal.androidmvvm.model.api.ListKota;

import java.util.ArrayList;

/**
 * Created by mahesaiqbal on 11/23/2017.
 */

public class SortKota {

    private ArrayList<ListKota.DataBean> arrayList;
    private Integer count, count2;

    public SortKota(ArrayList<ListKota.DataBean> affs) {
        count = new Integer(1);
        count2 = new Integer(0);
        arrayList = arrangeNumbers(affs);
    }

    public ArrayList<ListKota.DataBean> arrangeNumbers(ArrayList<ListKota.DataBean> list) {
        while (list.size() > 1 && count != list.size() - 1) {
            if (list.get(count2).getIntId() > list.get(count).getIntId()) {
                list.add(count, list.get(count2));
                list.remove(count2 + 1);
            }
            if (count2 == list.size() - 1) {
                count++;
                count2 = count + 1;
            } else {
                count2++;
            }
        }
        return list;
    }

    public ArrayList<ListKota.DataBean> getArrayList() {
        return arrayList;
    }
}
