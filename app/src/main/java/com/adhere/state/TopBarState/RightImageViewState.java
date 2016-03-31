package com.adhere.state.TopBarState;

import android.content.Context;
import android.view.View;

import com.adhere.config.ConfigUtils;
import com.adhere.view.ZoomImageView;

import java.util.HashMap;

/**
 * Author by gaojun on 16/2/28.
 */
public class RightImageViewState implements ITopBarState {

    private ZoomImageView imageView;


    @Override
    public View getInstance(Context context) {
        if(imageView==null){
            imageView=new ZoomImageView(context);
        }
        return imageView;
    }

    @Override
    public void setId(int rid) {
        if(imageView!=null){
            imageView.setId(rid);
        }
    }

    @Override
    public void excute(HashMap<Integer,Object> params) {
        int rid = (int) params.get(ConfigUtils.TOP_IV_RIGHT_SRC);
         imageView.setImageResource(rid);
    }
}
