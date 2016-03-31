package com.adhere.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.adhere.entity.Train;
import com.adhere.viewholder.TrainGridViewHolder;


public class TrainGridAdapter extends RecyclerArrayAdapter<Train.RowsEntity> {
    public TrainGridAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new TrainGridViewHolder(parent);
    }
}
