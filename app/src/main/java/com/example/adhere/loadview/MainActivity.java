package com.example.adhere.loadview;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.adhere.base.BaseActivity;
import com.adhere.emun.LoadResult;
import com.adhere.factory.FragmentFactory;
import com.adhere.listener.TopBarClickListener;
import com.adhere.utils.T;
import com.adhere.utils.UIUtils;
import com.adhere.utils.ViewUtils;
import com.adhere.view.CommTopBarLayout;

/**
 * Author:gaojun
 * time:2016/2/26
 */
public class MainActivity extends BaseActivity implements OnClickListener {

	private CommTopBarLayout mCommTopBarLayout;


	@Override
	public void init() {


	}

	// 刷新页面工程
	@Override
	public View createSuccessView() {
		final View inflate = UIUtils.inflate(R.layout.activity_main_go);
		Button tv= ViewUtils.findViewById(inflate, R.id.pagerTapButton);
		Button tv2= ViewUtils.findViewById(inflate, R.id.viewPagerButton);
		mCommTopBarLayout=ViewUtils.findViewById(inflate,R.id.topbarLayout);
		tv.setOnClickListener(this);
		tv2.setOnClickListener(this);
		mCommTopBarLayout.setTopBarClickListener(new TopBarClickListener() {
			@Override
			public void leftClick() {

				T.showSnackShort(inflate,"返回");
			}

			@Override
			public void rightClick() {
				T.showSnackShort(inflate,"搜索");
			}
		});
		return inflate;

	}


	@Override
	protected void onDestroy() {
		super.onDestroy();
		FragmentFactory.clear();
	}

	// 刷新页面工程
	@Override
	protected void load() {
		UIUtils.postDelayed(new Runnable() {
			@Override
			public void run() {
				setResult(LoadResult.SUCCESS);
			}
		},2000);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.pagerTapButton:
				UIUtils.Go(this,FragmentVPActivity.class,null);
				break;
			case R.id.viewPagerButton:
				UIUtils.Go(this,TabFragmentActivity.class,null);
				break;
			default:
				break;
		}
	}
}
