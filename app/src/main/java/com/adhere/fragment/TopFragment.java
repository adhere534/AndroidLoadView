package com.adhere.fragment;

import android.view.View;

import com.adhere.base.BaseFragment;
import com.adhere.emun.LoadResult;
import com.adhere.utils.UIUtils;
import com.example.adhere.loadview.R;


/**
 * Author:gaojun
 * time:2016/2/26
 */
public class TopFragment extends BaseFragment {


	@Override
	protected void init() {

	}

	@Override
	protected View createSuccessView() {

		return UIUtils.inflate(R.layout.activity_main2);
	}

	@Override
	protected void load() {
		UIUtils.postDelayed(new Runnable() {
			@Override
			public void run() {
				setResult(LoadResult.EMPTY);
			}
		},2000);
	}
}
