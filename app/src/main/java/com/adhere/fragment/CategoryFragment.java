package com.adhere.fragment;

import android.view.View;

import com.adhere.base.BaseFragment;
import com.adhere.emun.LoadResult;
import com.adhere.utils.UIUtils;
import com.example.adhere.loadview.R;


public class CategoryFragment extends BaseFragment{


	@Override
	protected void init() {
	}

	@Override
	protected View createSuccessView() {
		return UIUtils.inflate(R.layout.activity_main);
	}

	@Override
	protected void load() {
		setResult(LoadResult.SUCCESS);
	}
}
