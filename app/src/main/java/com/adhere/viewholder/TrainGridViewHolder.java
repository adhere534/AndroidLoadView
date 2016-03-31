package com.adhere.viewholder;

import android.view.ViewGroup;
import android.widget.ImageView;

import com.adhere.adapter.BaseViewHolder;
import com.adhere.entity.Train;
import com.example.adhere.loadview.R;


public class TrainGridViewHolder extends BaseViewHolder<Train.RowsEntity> {


    private ImageView mImg_face;
    public TrainGridViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_gridperson);
        mImg_face = $(R.id.person_face);
    }

    @Override
    public void setData(final Train.RowsEntity train,int position){
        mImg_face.setImageResource(R.mipmap.ic_launcher);

    }
}
