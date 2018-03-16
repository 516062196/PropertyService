package com.property.glory.propertyservice.view;

/**
 * Created by Android Studio.
 * Des:the description of current file
 * User: sky_fly_cloud
 * Date: 2018/2/25
 * Time: 下午5:06
 */

public interface ILoginView<T> extends IBaseView
{
    /**
     * 登录成功回调
     * @param result
     */
    public void loginResult(T result);
    /**
     * 返回成功数据为空回调
     * @param msg
     */
    public void backResult(String msg);
    /**
     * 返回成功数据且为首页user数据T
     * @param msg
     */
//    public void backuserdata(T msg);


}
