package com.adhere.listener;

import android.view.View;

import com.adhere.adapter.RecyclerArrayAdapter;

public interface EventDelegate {
    void addData(int length);
    void clear();

    void stopLoadMore();
    void pauseLoadMore();
    void resumeLoadMore();

    void setMore(View view, RecyclerArrayAdapter.OnLoadMoreListener listener);
    void setNoMore(View view);
    void setErrorMore(View view);
}
