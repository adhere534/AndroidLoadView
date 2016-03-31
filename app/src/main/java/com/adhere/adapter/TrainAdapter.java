package com.adhere.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.adhere.entity.Train;
import com.adhere.viewholder.TrainViewHolder;


public class TrainAdapter extends RecyclerArrayAdapter<Train.RowsEntity> {
    public TrainAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new TrainViewHolder(parent);
    }
}
