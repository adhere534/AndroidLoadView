package com.adhere.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.adhere.adapter.RecyclerArrayAdapter;
import com.adhere.adapter.TrainGridAdapter;
import com.adhere.base.BaseFragment;
import com.adhere.emun.LoadResult;
import com.adhere.entity.Ad;
import com.adhere.entity.Train;
import com.adhere.utils.T;
import com.adhere.utils.UIUtils;
import com.adhere.utils.ViewUtils;
import com.adhere.view.CommRecyclerView;
import com.bumptech.glide.Glide;
import com.example.adhere.loadview.R;
import com.jude.rollviewpager.PointHintView;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;


import java.util.ArrayList;
import java.util.List;


/**
 * Author:gaojun
 * time:2016/2/26
 */
public class AppFragment extends BaseFragment {

	private CommRecyclerView recyclerView;
	private View view;
	TrainGridAdapter adapter;
	private List<Train.RowsEntity> mData;

	@Override
	protected void init() {
		mData = new ArrayList<>();
		adapter = new TrainGridAdapter(getActivity());
		adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
			@Override
			public void onItemClick(int position) {
				T.showSnackShort(view, "点击");
			}
		});
		initData();
	}

	@Override
	protected View createSuccessView() {
		if (view == null) {
			view = UIUtils.inflate(R.layout.activity_loadmore);
			initView();
		}
		return view;
	}

	private void initView() {
		recyclerView = ViewUtils.findViewById(view, R.id.recyclerView);
		recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()
		));
		recyclerView.setAdapterWithProgress(adapter);
		adapter.addHeader(new RecyclerArrayAdapter.ItemView() {
			@Override
			public View onCreateView(ViewGroup parent) {
				RollPagerView header = new RollPagerView(getActivity());
				header.setHintView(new PointHintView(getActivity()));
				header.setHintPadding(0, 0, 0, (int) UIUtils.dip2px(8));
				header.setPlayDelay(2000);
				header.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) UIUtils.dip2px(200)));
				header.setAdapter(new BannerAdapter());
				return header;
			}

			@Override
			public void onBindView(View headerView) {

			}
		});
		adapter.addFooter(new RecyclerArrayAdapter.ItemView() {
			@Override
			public View onCreateView(ViewGroup parent) {
				TextView tv = new TextView(getActivity());
				tv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) UIUtils.dip2px(56)));
				tv.setGravity(Gravity.CENTER);
				tv.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
				tv.setText("(-_-)/~这是我的腿部啊");
				return tv;
			}

			@Override
			public void onBindView(View headerView) {

			}
		});
	}

	/**
	 * 请求服务器获取数据
	 */
	@Override
	protected void load() {
		UIUtils.getHandler().postDelayed(new Runnable() {
			@Override
			public void run() {
				setResult(LoadResult.SUCCESS);
			}
		}, 2000);
	}


	/**
	 * 测试数据
	 */

	private void initData(){
		for(int i=0;i<8;i++){
			mData.add(new Train.RowsEntity());
		}
		adapter.addAll(mData);
    }


	public  List<Ad> getAdList(){
		ArrayList<Ad> arr = new ArrayList<>();
		arr.add(new Ad("http://i1.hdslb.com/u_user/80fcc32d0b5d3565377847bd9dd06dc3.jpg","http://www.bilibili.com/topic/1003.html"));
		arr.add(new Ad("http://i2.hdslb.com/u_user/e97a1632329cac1fa6ab3362e7233a08.jpg","http://www.bilibili.com/topic/v2/1004.html"));
		arr.add(new Ad("http://i2.hdslb.com/u_user/f19f0e44328a4190a48acf503c737c50.png","http://yoo.bilibili.com/html/activity/cq2015/index.html"));
		arr.add(new Ad("http://i1.hdslb.com/u_user/7ee1aeadc8257f43fa6b806717c9c398.png","http://www.bilibili.com/html/activity-acsociety.html"));
		return arr;
	}


	private class BannerAdapter extends StaticPagerAdapter {
		private List<Ad> list;
		public BannerAdapter(){
			list = getAdList();
		}

		@Override
		public View getView(ViewGroup container, final int position) {
			ImageView imageView = new ImageView(getActivity());
			imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			Glide.with(getActivity())
					.load(list.get(position).getImage())
					.into(imageView);
			//点击事件
			imageView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					T.showSnackShort(view, "点击");
				}
			});
			return imageView;
		}

		@Override
		public int getCount() {
			return list.size();
		}
	}
}
