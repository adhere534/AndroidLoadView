package com.adhere.emun;

import com.adhere.factory.ViewStateFactory;
import com.adhere.state.LoadState.LoadingStateLoad;
import com.adhere.state.LoadState.EmptyStateLoad;
import com.adhere.state.LoadState.ErrorStateLoad;
import com.adhere.state.LoadState.SuccssedStateLoad;
import com.adhere.state.TopBarState.ILoadViewState;

/**
 * Author:gaojun
 * time:2016/2/26
 */
public enum LoadResult {

	LOADING(ViewStateFactory.getInstance().createView(LoadingStateLoad.class)),
		ERROR(ViewStateFactory.getInstance().createView(ErrorStateLoad.class)),
	 EMPTY(ViewStateFactory.getInstance().createView(EmptyStateLoad.class)),
	 SUCCESS(ViewStateFactory.getInstance().createView(SuccssedStateLoad.class));

		ILoadViewState state;

		LoadResult(ILoadViewState state) {
			this.state = state;
		}

		public ILoadViewState getState() {
			return state;
		}
	}
