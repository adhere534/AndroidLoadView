package com.adhere.state.TopBarState;

import android.content.Context;
import android.view.View;

import java.util.HashMap;

/**
 * Author by gaojun on 16/2/28.
 */
public interface ITopBarState {

    public View getInstance(Context context);
    public void setId(int rid);
    public void excute(HashMap<Integer, Object> params);
}
