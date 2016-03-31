package com.adhere.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.adhere.adapter.RecyclerArrayAdapter;
import com.adhere.adapter.TrainGridAdapter;
import com.adhere.base.BaseFragment;
import com.adhere.emun.LoadResult;
import com.adhere.entity.Train;
import com.adhere.utils.T;
import com.adhere.utils.UIUtils;
import com.adhere.utils.ViewUtils;
import com.adhere.view.CommRecyclerView;
import com.example.adhere.loadview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:gaojun
 * time:2016/2/26
 */
public class GameFragment extends BaseFragment {
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
		recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
		recyclerView.setAdapterWithProgress(adapter);
	}

	@Override
	protected void load() {
		UIUtils.getHandler().postDelayed(new Runnable() {
			@Override
			public void run() {
				setResult(LoadResult.SUCCESS);
			}
		},2000);
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
}
