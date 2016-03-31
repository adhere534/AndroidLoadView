package com.example.adhere.loadview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;

import com.adhere.factory.FragmentFactory;
import com.adhere.listener.TopBarClickListener;
import com.adhere.utils.AppManager;
import com.adhere.utils.T;
import com.adhere.utils.UIUtils;
import com.adhere.view.ChangeColorIconWithTextView;
import com.adhere.view.CommTopBarLayout;
import com.adhere.view.ForbidScroolViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:gaojun
 * time:2016/2/28
 */
public class TabFragmentActivity extends FragmentActivity implements View.OnClickListener{

    private ForbidScroolViewPager mViewPager;
    private FragmentPagerAdapter mAdapter;
    private String[] mTitles ;
    private List<ChangeColorIconWithTextView> mTabIndicator = new ArrayList<>();
    private CommTopBarLayout mCommTopBarLayout;
    private long exitTime;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);
        setContentView(R.layout.tab_framment_main);
        initView();
        initDatas();
        initTabIndicator();
    }

    private void initView() {
        mViewPager = (ForbidScroolViewPager) findViewById(R.id.id_viewpager);
        //主界面四个Tab是否可以滚动
        mViewPager.setScrollable(true);
        mCommTopBarLayout= (CommTopBarLayout) findViewById(R.id.topbarLayout);
        mViewPager
                .addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        super.onPageSelected(position);
//                        BaseFragment createFragment = FragmentFactory
//                                .createFragment(position);
//                        createFragment.show();// 当切换界面的时候重加载界面获取状态
                        mCommTopBarLayout.setTitleText(mTitles[position]);

                    }
                });

        mCommTopBarLayout.setTopBarClickListener(new TopBarClickListener() {
            @Override
            public void leftClick() {
                finish();
            }
        });
    }

    private void initDatas() {
        mTitles= UIUtils.getStringArray(R.array.TabTitle);
        //设置默认为首页
        mCommTopBarLayout.setTitleText(mTitles[0]);
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager())
        {

            @Override
            public int getCount()
            {
                return mTitles.length;
            }

            @Override
            public Fragment getItem(int arg0)
            {
                return FragmentFactory.createFragment(arg0);

            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitles[position];
            }
        };

        mViewPager.setAdapter(mAdapter);
    }



    private void initTabIndicator()
    {
        ChangeColorIconWithTextView one = (ChangeColorIconWithTextView) findViewById(R.id.id_indicator_one);
        ChangeColorIconWithTextView two = (ChangeColorIconWithTextView) findViewById(R.id.id_indicator_two);
        ChangeColorIconWithTextView three = (ChangeColorIconWithTextView) findViewById(R.id.id_indicator_three);
        ChangeColorIconWithTextView four = (ChangeColorIconWithTextView) findViewById(R.id.id_indicator_four);



        mTabIndicator.add(one);
        mTabIndicator.add(two);
        mTabIndicator.add(three);
        mTabIndicator.add(four);


        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        one.setIconDown(true);
    }


    @Override
    public void onClick(View view) {
        resetOtherTabs();

        switch (view.getId())
        {
            case R.id.id_indicator_one:
                mTabIndicator.get(0).setIconDown(true);
                mViewPager.setCurrentItem(0,false);
                break;
            case R.id.id_indicator_two:
                mTabIndicator.get(1).setIconDown(true);
                mViewPager.setCurrentItem(1,false);
                break;
            case R.id.id_indicator_three:
                mTabIndicator.get(2).setIconDown(true);
                mViewPager.setCurrentItem(2,false);
                break;
            case R.id.id_indicator_four:
                mTabIndicator.get(3).setIconDown(true);
                mViewPager.setCurrentItem(3,false);
                break;
        }
    }

    /**
     * 重置其他的Tab
     */
    private void resetOtherTabs()
    {
        for (int i = 0; i < mTabIndicator.size(); i++)
        {
            mTabIndicator.get(i).setIconDown(false);
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN)
        {
            if((System.currentTimeMillis()-exitTime) > 3000)  //System.currentTimeMillis()无论何时调用，肯定大于2000
            {
                T.showSnackShort(mViewPager, "再按一次返回");
                exitTime = System.currentTimeMillis();
            }
            else
            {
//                FragmentFactory.clear();
                finish();
            }

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
