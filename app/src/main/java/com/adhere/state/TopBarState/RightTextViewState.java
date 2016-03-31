package com.adhere.state.TopBarState;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.adhere.config.ConfigUtils;

import java.util.HashMap;

/**
 * Author by gaojun on 16/2/28.
 */
public class RightTextViewState implements ITopBarState {

    private TextView mTextView;
    @Override
    public View getInstance(Context context) {
        if(mTextView==null){
            mTextView=new TextView(context);
        }
        return mTextView;
    }

    @Override
    public void setId(int rid) {
        if(mTextView!=null){
            mTextView.setId(rid);
        }

    }

    @Override
    public void excute(HashMap<Integer,Object> params) {
        String text= (String) params.get(ConfigUtils.TOP_TV_RIGHT_TEXT);
        int color= (int)params.get(ConfigUtils.TOP_TV_RIGHT_TEXT_COLOR);
        int textSize= (int) params.get(ConfigUtils.TOP_TV_RIGHT_TEXT_SIZE);
        mTextView.setText(text);
        mTextView.setTextColor(color);
        mTextView.setTextSize(textSize);
    }
}
