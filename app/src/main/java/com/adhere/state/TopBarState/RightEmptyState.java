package com.adhere.state.TopBarState;

import android.content.Context;
import android.view.View;

import java.util.HashMap;

/**
 * Author by gaojun on 16/2/28.
 */
public class RightEmptyState implements ITopBarState {

    View view;
    @Override
    public View getInstance(Context context) {
        if(view==null){
            view = new View(context);
        }
        view.setVisibility(View.GONE);
        return view;
    }

    @Override
    public void setId(int rid) {
    }

    @Override
    public void excute(HashMap<Integer, Object> params) {

    }
}
