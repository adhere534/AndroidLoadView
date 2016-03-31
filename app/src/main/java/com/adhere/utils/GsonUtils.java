package com.adhere.utils;

import com.google.gson.Gson;

/**
 * 作者：高俊 on 2016/2/1 0001 17:35
 */
public class GsonUtils {

    private static Gson gson;

    public static Gson getInstance(){
        if(gson==null){
            synchronized (GsonUtils.class){
                if(gson==null){
                    gson=new Gson();
                }
            }
        }
        return gson;
    }
}
