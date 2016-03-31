package com.adhere.state.LoadState;

import android.view.View;

import com.adhere.state.TopBarState.ILoadViewState;
import com.adhere.utils.UIUtils;
import com.example.adhere.loadview.R;

public class EmptyStateLoad implements ILoadViewState {


	@Override
	public View createView() {
		return UIUtils.inflate(R.layout.loadpage_empty);
	}

	@Override
	public int state() {
		return View.VISIBLE;
	}

	
}
