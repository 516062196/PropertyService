package com.property.glory.propertyservice.view;

/**
 * Created by Android Studio.
 * Des:the description of current file
 * User: sky_fly_cloud
 * Date: 2018/2/25
 * Time: 下午5:03
 */

public interface IBaseView
{
    /**
     * 显示加载进度条
     * @param showText
     */
    public void showProgressView(String showText);

    /**
     *  隐藏加载进度条
     */
    public void dismissProgressView();

    /**
     * 显示吐司
     * @param showText
     */
    public void showPrompt(String showText);
}
