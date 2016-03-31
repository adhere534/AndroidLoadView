package com.adhere.viewholder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.adhere.adapter.BaseViewHolder;
import com.adhere.entity.Train;
import com.bumptech.glide.Glide;
import com.example.adhere.loadview.R;



public class TrainViewHolder extends BaseViewHolder<Train.RowsEntity> {


    private TextView mTv_name;
    private ImageView mImg_face;
    private TextView mTv_sign;
    //测试图
    String images[] ={"https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2219111387,1251569665&fm=116&gp=0.jpg",
            "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=857474335,3434157710&fm=116&gp=0.jpg",
            "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3841157212,2135341815&fm=116&gp=0.jpg",
    "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1519095430,2307521081&fm=116&gp=0.jpg",
            "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2443410229,3359307221&fm=116&gp=0.jpg",
            "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2443410229,3359307221&fm=116&gp=0.jpg",
            "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2443410229,3359307221&fm=116&gp=0.jpg",
            "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2443410229,3359307221&fm=116&gp=0.jpg",
    };
    public TrainViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_person);
        mTv_name = $(R.id.person_name);
        mTv_sign = $(R.id.person_sign);
        mImg_face = $(R.id.person_face);
    }

    @Override
    public void setData(final Train.RowsEntity train,int position){

        mTv_name.setText(train.getAssistant());
        mTv_sign.setText(train.getCampus());
        mImg_face.setImageResource(R.mipmap.ic_launcher);
        Glide.with(getContext())
                .load(images[position > images.length - 1 ? 0 : position])
                .into(mImg_face);
    }
}
