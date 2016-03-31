package com.adhere.view;


import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.adhere.context.LoadContext;
import com.adhere.emun.LoadResult;
import com.adhere.state.LoadState.EmptyStateLoad;
import com.adhere.state.LoadState.ErrorStateLoad;
import com.adhere.state.LoadState.LoadingStateLoad;
import com.adhere.state.LoadState.SuccssedStateLoad;
import com.adhere.state.TopBarState.ILoadViewState;

/**
 *
 * Author:gaojun
 * time:2016/2/26
 * 加载顺序 load -->showPagerView-->createSuccessView
 */
public abstract class LoadingPager extends FrameLayout {


	//加载的View
	private View mLoadView;
	//记录上一次的状态
	private ILoadViewState mILoadViewState;

	public LoadingPager(Context context) {
		super(context);
		//默认为加载
		setState(LoadResult.LOADING);
	}

	public LoadingPager(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		setState(LoadResult.LOADING);
	}

	public LoadingPager(Context context, AttributeSet attrs) {
		super(context, attrs);
		setState(LoadResult.LOADING);
	}
	//设置状态
	private void setState(final LoadResult state) {
		LoadContext.getLoadContext().setState(state.getState());
		showPagerView();
	}



	private void showPagerView() {
		    removeAllView();
		if (LoadContext.getLoadContext().getState() instanceof SuccssedStateLoad) {
			addView(createSuccessView(), new LayoutParams
			(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		}else{
			addOhterView();
		}
		if(mLoadView !=null) {
			mLoadView.setVisibility(LoadContext.getLoadContext().state() == VISIBLE ? VISIBLE : INVISIBLE);
		}
	}


	private void removeAllView() {
		if(getChildCount()>0){
            removeAllViews();
        }
	}

	//添加View
	private void addOhterView() {
		mLoadView = LoadContext.getLoadContext().createView();
		if(mLoadView !=null) {
			addView(mLoadView, new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.MATCH_PARENT));
		}
	}
	//重新加载
	public void show() {
		if(mILoadViewState instanceof ErrorStateLoad || mILoadViewState instanceof EmptyStateLoad || mILoadViewState ==null){
			setState(LoadResult.LOADING);
		}
		if(LoadContext.getLoadContext().getState() instanceof LoadingStateLoad){
			load();
		}
	}
	/**
	 * 用户界面
	 *
	 * @return
	 */
	protected abstract View createSuccessView();

	protected abstract void load();

	public void setResult(LoadResult loadResult){
		//如果已经成功加载了，则不需要再次加载
		if(mILoadViewState !=LoadResult.SUCCESS.getState()){
			mILoadViewState =loadResult.getState();
			setState(loadResult);
		}
	}

}
