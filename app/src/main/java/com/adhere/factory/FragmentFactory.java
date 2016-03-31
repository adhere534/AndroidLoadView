package com.adhere.factory;

import android.support.v4.app.Fragment;

import com.adhere.base.BaseFragment;
import com.adhere.fragment.AppFragment;
import com.adhere.fragment.CategoryFragment;
import com.adhere.fragment.GameFragment;
import com.adhere.fragment.HomeFragment;
import com.adhere.fragment.SubjectFragment;
import com.adhere.fragment.TopFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:gaojun
 * time:2016/2/26
 */
public class FragmentFactory {

	//缓存
	private static Map<Integer, Fragment> mFragments = new HashMap<Integer, Fragment>();

	//根据position生产Fragment产品
	public static BaseFragment createFragment(int position) {
		BaseFragment fragment = null;
		fragment = (BaseFragment) mFragments.get(position);  //在集合中取出来Fragment
		if (fragment == null) {  //如果再集合中没有取出来 需要重新创建
			if (position == 0) {
				fragment = new HomeFragment();
			} else if (position == 1) {
				fragment = new AppFragment();
			} else if (position == 2) {
				fragment = new GameFragment();
			} else if (position == 3) {
				fragment = new SubjectFragment();
			} else if (position == 4) {
				fragment = new CategoryFragment();
			} else if (position == 5) {
				fragment = new TopFragment();
			}
			if (fragment != null) {
				mFragments.put(position, fragment);// 把创建好的Fragment存放到集合中缓存起来
			}
		}
		return fragment;
	}


	public static void clear(){
		if(mFragments.size()>0){
			mFragments.clear();
		}
	}

}
