package com.adhere.state.LoadState;

import android.view.View;

import com.adhere.state.TopBarState.ILoadViewState;

public class SuccssedStateLoad implements ILoadViewState {

	@Override
	public View createView() {
		return null;

	}

	@Override
	public int state() {
		return View.VISIBLE;
	}

}
