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
public class SubjectFragment extends BaseFragment  {


	@Override
	protected void init() {
	}

	@Override
	protected View createSuccessView() {

		return UIUtils.inflate(R.layout.activity_main);
	}

	@Override
	protected void load() {
		UIUtils.getHandler().postDelayed(new Runnable() {
			@Override
			public void run() {
				setResult(LoadResult.ERROR);
			}
		},2000);

	}
}
