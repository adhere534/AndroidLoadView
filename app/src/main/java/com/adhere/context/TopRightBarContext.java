package com.adhere.context;

import android.content.Context;
import android.view.View;

import com.adhere.state.TopBarState.ITopBarState;
import com.adhere.state.TopBarState.RightEmptyState;

import java.util.HashMap;

/**
 * Author:gaojun
 * time:2016/2/26
 */
public class TopRightBarContext {


    ITopBarState topBarState = new RightEmptyState();
    private static TopRightBarContext topRightBarContext =new TopRightBarContext();

    public static TopRightBarContext getInstance(){
        return topRightBarContext;
    }


    public void setTopBarState(ITopBarState topBarState){
        this.topBarState=topBarState;
    }

    public View getViewInstance(Context context){
        return topBarState.getInstance(context);
    }
    public void setId(int rid){
        topBarState.setId(rid);
    }
    public void excute(HashMap<Integer,Object> params){
        topBarState.excute(params);
    }



}
