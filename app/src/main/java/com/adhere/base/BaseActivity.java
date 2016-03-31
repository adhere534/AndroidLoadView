package com.adhere.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.adhere.emun.LoadResult;
import com.adhere.utils.UIUtils;
import com.adhere.view.LoadingPager;



/**
 * Author:gaojun
 * time:2016/2/26
 */
public abstract class BaseActivity extends Activity {
	public LoadingPager mLoadingPage;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mLoadingPage = new LoadingPager(UIUtils.getContext()){
			@Override
			protected View createSuccessView() {
				return BaseActivity.this.createSuccessView();
			}

			@Override
			protected void load() {
				BaseActivity.this.load();
			}
		};
//		可以点击
		mLoadingPage.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mLoadingPage.show();
			}
		});
//		显示 loading的页面
		mLoadingPage.show();
		setContentView(mLoadingPage);
		init();
		load();
	}


	/**
	 * 初始化请求网络工具、此方法view还没有创建
	 */
	protected  abstract  void init();

	/**
	 * 刷新页面工程
	 *
	 * @return
	 */
	protected abstract View createSuccessView();

     protected abstract void load();


	public void setResult(LoadResult loadResult){
		mLoadingPage.setResult(loadResult);
	}

}
