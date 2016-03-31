package com.adhere.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.adhere.adapter.RecyclerArrayAdapter;
import com.adhere.adapter.TrainAdapter;
import com.adhere.base.BaseFragment;
import com.adhere.emun.LoadResult;
import com.adhere.entity.Train;
import com.adhere.utils.GsonUtils;
import com.adhere.utils.NetUtils;
import com.adhere.utils.T;
import com.adhere.utils.UIUtils;
import com.adhere.utils.ViewUtils;
import com.adhere.view.CommRecyclerView;
import com.example.adhere.loadview.R;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;


import okhttp3.Request;

/**
 * Author:gaojun
 * time:2016/2/26
 */
public class HomeFragment extends BaseFragment implements  RecyclerArrayAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener{

	private CommRecyclerView recyclerView;
	private TrainAdapter adapter;
	private View view;
	private int page = 0;


	// 当Fragment挂载的activity创建的时候调用
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
//		show();
	}


	@Override
	public View createSuccessView() {
		view=UIUtils.inflate(R.layout.activity_loadmore);
		initView();
		return view;
	}


	//此方法必须在View创建成功后调用
	private void initView() {
		recyclerView= ViewUtils.findViewById(view, R.id.recyclerView);
		recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
		recyclerView.setAdapterWithProgress(adapter);
		recyclerView.setRefreshListener(this);
	}

	@Override
	protected void init() {
		adapter = new TrainAdapter(getActivity());
		adapter.setMore(R.layout.view_more, this);
		adapter.setNoMore(R.layout.view_nomore);
		adapter.setOnItemLongClickListener(new RecyclerArrayAdapter.OnItemLongClickListener() {
			@Override
			public boolean onItemClick(int position) {
				adapter.remove(position);
				return true;
			}
		});
		adapter.setError(R.layout.view_error).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				adapter.resumeMore();
			}
		});
		adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
			@Override
			public void onItemClick(int position) {
				T.showSnackShort(view,adapter.getItem(position).getAssistant());
			}
		});
	}

	@Override
	protected  void load() {
		//获取网络请求加载数据
//		page=0;
//		getData(page);
		onRefresh();
	}

	//上拉加载更多
	@Override
	public void onLoadMore() {
		UIUtils.getHandler().postDelayed(new Runnable() {
			@Override
			public void run() {
				//刷新
				if (!NetUtils.isNetworkConnected(getActivity())) {
					adapter.pauseMore();
					return;
				}
				page++;
				getData();
			}
		}, 3000);

	}


	private void getData() {
		//真实网络数据
		String url="http://222.240.201.172/train/service/training.ashx?action=1&year=2015";//page未使用到 真实项目需要使用
		//快捷开发网络请求框架
		//post就使用Post
		OkHttpUtils
				.get()
				.url(url)
				.build()
				.execute(new MyStringCallback());
	}


	//这是post请求
//	public void postString()
//	{
//		OkHttpUtils
//				.postString()
//				.url(url)
//				.mediaType(MediaType.parse("application/json; charset=utf-8"))
//				.content(new Gson().toJson(new User("123", "123")))
//				.build()
//				.execute(new MyStringCallback());

//	}




	public class MyStringCallback extends StringCallback
	{
		@Override
		public void onBefore(Request request)
		{
			super.onBefore(request);
		}

		@Override
		public void onAfter()
		{
			super.onAfter();
		}


		@Override
		public void onError(okhttp3.Call call, Exception e) {
			//通常为网络异常
			setResult(LoadResult.ERROR);
		}

		@Override
		public void onResponse(String response) {
			Train train = GsonUtils.getInstance().fromJson(response, Train.class);
			if (train.getRows().size() > 0) {
				judgeRefresh(page);
				adapter.addAll(train.getRows());
				setResult(LoadResult.SUCCESS);
			} else {
				if (page == 0) {
					setResult(LoadResult.EMPTY);
				}
			}
		}

		@Override
		public void inProgress(float progress)
		{
		}

	}

	private void judgeRefresh(int page) {
		if(recyclerView!=null&&recyclerView.isRefreshing()&&page==0){
            adapter.clear();
            recyclerView.setRefreshing(false);
        }
	}


	//下拉刷新调用
	@Override
	public void onRefresh() {
		page = 0;
		UIUtils.getHandler().postDelayed(new Runnable() {
			@Override
			public void run() {
				//刷新
				if (!NetUtils.isNetworkConnected(getActivity())) {
					adapter.pauseMore();
					return;
				}
				getData();
				page=1;
			}
		}, 2000);
	}
}
