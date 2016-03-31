package com.example.adhere.loadview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.adhere.factory.FragmentFactory;
import com.adhere.listener.TopBarClickListener;
import com.adhere.utils.UIUtils;
import com.adhere.utils.ViewUtils;
import com.adhere.view.CommTopBarLayout;


/**
 * Author:gaojun
 * time:2016/2/26
 */
public class FragmentVPActivity extends FragmentActivity {
	// tab名字数组
	private String[] tab_names;
	private ViewPager mViewPager;

	private PagerTabStrip pager_tab_strip;
	private View view;
	private CommTopBarLayout mTopbarLayout;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		view = UIUtils.inflate(R.layout.fragment_main);
		setContentView(view);
		init();
	}

	private void init() {
//		tab的头内容
		tab_names = UIUtils.getStringArray(R.array.tab_names);
		// 滑动
		mViewPager = (ViewPager) findViewById(R.id.vp);

		mViewPager.setAdapter(new MainAdapter(getSupportFragmentManager()));
		mViewPager.setOffscreenPageLimit(2);
//		滑动的时候 加载状态
		mViewPager
				.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						super.onPageSelected(position);
//						BaseFragment createFragment = FragmentFactory
//								.createFragment(position);
//						createFragment.show();// 当切换界面的时候重加载界面获取状态
					}
				});
//		更改颜色
		pager_tab_strip = ViewUtils.findViewById(view, R.id.pager_tab_strip);
		// 标签下划线的颜色
		pager_tab_strip.setTabIndicatorColor(UIUtils
				.getColor(R.color.indicatorcolor));
		mTopbarLayout=ViewUtils.findViewById(view,R.id.topbarLayout);
		mTopbarLayout.setTopBarClickListener(new TopBarClickListener() {
			@Override
			public void leftClick() {
				finish();
			}

			@Override
			public void rightClick() {

			}
		});

	}

	private class MainAdapter extends FragmentStatePagerAdapter {
		// 每个条目返回的fragmetn
		public MainAdapter(android.support.v4.app.FragmentManager fm) {
			super(fm);
		}
		// 每个条目返回的fragment
		@Override
		public Fragment getItem(int arg0) {
			return FragmentFactory.createFragment(arg0);
		}

		// 一共有幾個條目
		@Override
		public int getCount() {
			return tab_names.length;
		}

		// 返回每個條目的标题
		@Override
		public CharSequence getPageTitle(int position) {
			return tab_names[position];
		}
	}

}
