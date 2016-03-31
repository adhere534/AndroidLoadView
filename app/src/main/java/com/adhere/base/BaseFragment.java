package com.adhere.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.adhere.emun.LoadResult;
import com.adhere.utils.ViewUtils;
import com.adhere.view.LoadingPager;


public abstract class BaseFragment extends LazyFragment{

	private LoadingPager mLoadingPager;
	// 标志位，标志已经初始化完成。
	private boolean isPrepared;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		if (mLoadingPager == null) { // 之前的frameLayout 已经记录了一个父类了 父类是之前的ViewPager
			mLoadingPager = new LoadingPager(getActivity()
					) {
				@Override
				protected View createSuccessView() {
					return BaseFragment.this.createSuccessView();
				}

				@Override
				protected void load() {
					BaseFragment.this.load();
				}
			};
			mLoadingPager.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					mLoadingPager.show();
				}
			});
			init();
			isPrepared=true;
			lazyLoad();
		} else {
			ViewUtils.removeSelfFromParent(mLoadingPager);// 移除frameLayout之前的父类
		}
		return mLoadingPager;
	}




	public void show() {
		if (mLoadingPager != null) {
			mLoadingPager.show();
		}
	}



	@Override
	protected void lazyLoad() {
		if(!isPrepared || !isVisible) {
			return;
		}
		show();
	}

	/**
	 * 初始化请求网络工具、此方法view还没有创建
	 */
	protected  abstract  void init();


	/**
	 * 加载网络数据
	 */
	protected abstract void load();


	/**
	 * 刷新页面工程
	 *
	 * @return
	 */
	protected abstract View createSuccessView();



	protected void setResult(LoadResult loadResult){
		mLoadingPager.setResult(loadResult);
	}




}
