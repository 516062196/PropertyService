package com.property.glory.propertyservice.http;

/**
 * Created by Android Studio.
 * Des:the description of current file
 * User: sky_fly_cloud
 * Date: 2018/2/26
 * Time: 上午9:46
 */

public interface ReqHttpCallBack<T>
{
    /**
     * 请求成功有数据
     * @param result
     */
    public void reqSuccess(T result);


    /**
     * 请求失败
     * @param code
     * @param msg
     */
    public void reqOnError(String code, String msg);
}
