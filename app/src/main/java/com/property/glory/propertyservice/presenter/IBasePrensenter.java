package com.property.glory.propertyservice.presenter;

/**
 * Created by Android Studio.
 * Des:the description of current file
 * User: sky_fly_cloud
 * Date: 2018/2/25
 * Time: 下午5:00
 */

public interface IBasePrensenter<V>
{
    void attachView(V view);

    void detachView();
}
