package com.property.glory.propertyservice.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.property.glory.propertyservice.view.IBaseView;

//import com.sky.fly.rr.R;
//import com.sky.fly.rr.utils.DialogUtils;
//import com.sky.fly.rr.utils.ToastUtils;
//import com.sky.fly.rr.utils.loadview.LoadViewHelperUtil;
//import com.sky.fly.rr.utils.view.HeaderView;
//import com.sky.fly.rr.view.IBaseView;

/**
 * Created by Android Studio.
 * Des:基类Activity
 * User: sky_fly_cloud
 * Date: 2018/2/25
 * Time: 下午3:03
 */
public abstract class BaseActivity extends FragmentActivity implements IBaseView
{
//    protected LoadViewHelperUtil actionBarLoadViewHelperUtil;
//    protected HeaderView headerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        initView();
        initListener();
    }

    /**
     * 初始化actionBar view
     */
    public void initActionView()
    {
//        actionBarLoadViewHelperUtil =  new LoadViewHelperUtil(findViewById(R.id.titleView));
//        headerView = (HeaderView) LayoutInflater.from(this).inflate(R.layout.action_bar_view,null);
    }

    /**
     * 显示替换view
     * @param contentView
     */
    public void showActionView(View contentView)
    {
//        if (actionBarLoadViewHelperUtil != null)
//        {
//            actionBarLoadViewHelperUtil.showView(contentView);
//        }
    }

    /**
     * 显示替换view
     * @param layoutId
     */
    public void showActionView(int layoutId)
    {
//        if (actionBarLoadViewHelperUtil != null)
//        {
//            actionBarLoadViewHelperUtil.showView(layoutId);
//        }
    }

    /**
     * 初始化view
     */
    public abstract void initView();

    /**
     * 初始化事件监听
     */
    public abstract void initListener();

//    @Override
//    public void showProgressView(String showText)
//    {
//        DialogUtils.showProgressDialog(this,showText);
//    }
//
//    @Override
//    public void dismissProgressView()
//    {
//        DialogUtils.dissmissProgressDialog();
//    }
//
//    @Override
//    public void showPrompt(String showText)
//    {
//        ToastUtils.showPrompt(this,showText);
//    }
}
