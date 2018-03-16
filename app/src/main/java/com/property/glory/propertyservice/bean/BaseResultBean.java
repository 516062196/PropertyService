package com.property.glory.propertyservice.bean;

/**
 * Created by Android Studio.
 * Des: 请求结果bean
 * User: sky_fly_cloud
 * Date: 2018/2/25
 * Time: 下午2:45
 */

public class BaseResultBean<T>
{
    /**
     * response code
     */
    private String code = "8860001";
    /**
     * response message
     */
    private String msg = "系统错误";

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * response object
     */
    private T data;

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

//    public T getResultBean()
//    {
//        return resultBean;
//    }
//
//    public void setResultBean(T resultBean)
//    {
//        this.resultBean = resultBean;
//    }
}
