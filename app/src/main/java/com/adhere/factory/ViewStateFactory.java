package com.adhere.factory;

import com.adhere.state.TopBarState.ILoadViewState;

/**
 * 作者：高俊 on 2016/3/1 0001 12:31
 * description：
 * ViewState生产工厂
 */
public final class ViewStateFactory {
    private static ViewStateFactory sManager;
    public static ViewStateFactory getInstance() {
        if (null == sManager) {
            sManager = new ViewStateFactory();
        }
        return sManager;
    }

    //工厂方法
    public <T extends ILoadViewState> T createView(Class<T> cls){
        ILoadViewState state=null;
        try {
            state= (ILoadViewState) Class.forName(cls.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) state;
    }




}
