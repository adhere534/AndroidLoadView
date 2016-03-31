package com.adhere.view;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.adhere.config.ConfigUtils;
import com.adhere.context.TopRightBarContext;
import com.adhere.listener.TopBarClickListener;
import com.adhere.state.TopBarState.RightEmptyState;
import com.adhere.state.TopBarState.RightImageViewState;
import com.adhere.state.TopBarState.RightTextViewState;
import com.example.adhere.loadview.R;

import java.util.HashMap;


/**
 * Author by gaojun on 16/2/28.
 * description：
 * 采用动态生成
 * 此类可以无限扩展 按需求定制
 * 目前设计为：
 * 左ImageView 中TextView 右ImageView/TextView
 */
public class CommTopBarLayout extends RelativeLayout{

	private ZoomImageView ivLeft;
	private TextView tv_title;
	private TopBarClickListener topBarClickListener;
	private String str_title;
	private RelativeLayout.LayoutParams leftLayoutParams;
	private RelativeLayout.LayoutParams rightLayoutParams;
	private RelativeLayout.LayoutParams tvTitleLayoutParams;
	//设置margin
	private final static int offsize=15;
	private static int leftBtnId=1;
	private static int titleTvId=2;
	private static int rightBtnId=3;
	private int rightSrc;
    private int topLeftSrc;
	private String rightText;
	private int rightColor;
	private int titleTvColor;
	private float titleTextSize;
	private float rightTextSize;
    private static HashMap<Integer,Object> params  =new HashMap<>();
	@SuppressWarnings("ResourceType")
	public CommTopBarLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		//从参数列表中获取参数
		//TypedArray实例是个属性的容器，context.obtainStyledAttributes()方法返回得到。AttributeSet是节点的属性集合
		//第二个参数为 为获取到值时的默认值
		TypedArray ta=context.obtainStyledAttributes(attrs, R.styleable.TopBar);
		str_title=ta.getString(R.styleable.TopBar_topTitle);
		topLeftSrc=ta.getResourceId(R.styleable.TopBar_topLeftSrc, 0);
		rightSrc=ta.getResourceId(R.styleable.TopBar_topRightSrc, 0);
		rightText =ta.getString(R.styleable.TopBar_topRightText);
		rightColor =ta.getColor(R.styleable.TopBar_topRightTextColor, 0);
		titleTextSize=ta.getInteger(R.styleable.TopBar_topTitleTextSize, 10);
		titleTvColor=ta.getColor(R.styleable.TopBar_topTitleTextColor, 0);
		rightTextSize=ta.getInteger(R.styleable.TopBar_topRightTextSize, 10);
		ta.recycle();
		ivLeft=new ZoomImageView(context);
		tv_title=new TextView(context);
		if(rightSrc==0){
			if(rightText!=null){
				TopRightBarContext.getInstance().setTopBarState(new RightTextViewState());
			}else{
				TopRightBarContext.getInstance().setTopBarState(new RightEmptyState());
			}
		}else{
			TopRightBarContext.getInstance().setTopBarState(new RightImageViewState());
		}
		ivLeft.setId(leftBtnId);
		tv_title.setId(titleTvId);
		TopRightBarContext.getInstance().setId(rightBtnId);

		setParams();
		//为组件配置布局参数
		leftLayoutParams =new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
		rightLayoutParams =new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
		tvTitleLayoutParams=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);

		leftLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
		leftLayoutParams.setMargins(offsize, 0, 0, 0);//左上右下
		leftLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);

		rightLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
		rightLayoutParams.setMargins(0, 0, offsize, 0);//左上右下
		rightLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);

		tvTitleLayoutParams.setMargins(offsize, 0, offsize, 0);//左上右下
//		tvTitleLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
//		tvTitleLayoutParams.addRule(RelativeLayout.LEFT_OF, rightBtnId);
//		tvTitleLayoutParams.addRule(RelativeLayout.RIGHT_OF, leftBtnId);
		tvTitleLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
		tv_title.setGravity(Gravity.CENTER);
		addView(ivLeft, leftLayoutParams);
		addView(TopRightBarContext.getInstance().getViewInstance(getContext()), rightLayoutParams);
		addView(tv_title, tvTitleLayoutParams);
		ivLeft.setImageResource(topLeftSrc);

		TopRightBarContext.getInstance().excute(params);
        tv_title.setEllipsize(TruncateAt.MIDDLE);
        tv_title.setSingleLine(true);
        tv_title.setText(str_title);
        tv_title.setTextSize(titleTextSize);
        tv_title.setTextColor(titleTvColor);

		ivLeft.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (topBarClickListener != null) {
					topBarClickListener.leftClick();
				}
			}
		});
		TopRightBarContext.getInstance().getViewInstance(getContext()).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (topBarClickListener != null) {
					topBarClickListener.rightClick();
				}
			}
		});
	}

	private void setParams() {
		params.put(ConfigUtils.TOP_IV_RIGHT_SRC,rightSrc);
		params.put(ConfigUtils.TOP_TV_RIGHT_TEXT, rightText);
		params.put(ConfigUtils.TOP_TV_RIGHT_TEXT_COLOR, rightColor);
		params.put(ConfigUtils.TOP_TV_RIGHT_TEXT_SIZE,rightTextSize);

	}

	//是否隐藏和显示
	public void setLeftVisible(boolean isVisible){
		if(isVisible){
			ivLeft.setVisibility(VISIBLE);
		}else{
			ivLeft.setVisibility(GONE);
		}
	}
	//是否隐藏和显示
	public void setRightVisible(boolean isVisible){
		if(isVisible){
			TopRightBarContext.getInstance().getViewInstance(getContext()).setVisibility(VISIBLE);
		}else{
			TopRightBarContext.getInstance().getViewInstance(getContext()).setVisibility(GONE);
		}
	}


	public void setTitleText(String titleText){
		tv_title.setText(titleText);
	}


	/*
	 * 单击监听事件
	 */
	public void setTopBarClickListener(TopBarClickListener topBarClickListener){
		this.topBarClickListener=topBarClickListener;
	}
}