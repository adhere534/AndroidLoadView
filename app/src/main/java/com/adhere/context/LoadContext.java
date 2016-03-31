package com.adhere.context;

import android.view.View;

import com.adhere.emun.LoadResult;
import com.adhere.state.TopBarState.ILoadViewState;

/**
 *  Author:gaojun
 *  time:2016/2/26
 */
public class LoadContext {

	//默认
	ILoadViewState mState = LoadResult.LOADING.getState();
    //单例
    static LoadContext loadContext = new LoadContext();
    public static LoadContext getLoadContext(){
    	return loadContext;
    }
    
    public void setState(ILoadViewState state){
    	mState=state;
    }
    

    public ILoadViewState getState(){
        return mState;
    }

    public View createView(){
    	return mState.createView();
    }
    
    public int state(){
    	return mState.state();

    }

}
