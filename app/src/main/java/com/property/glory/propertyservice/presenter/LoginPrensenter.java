package com.property.glory.propertyservice.presenter;

//import com.sky.fly.rr.bean.UserInfoBean;
//import com.sky.fly.rr.listener.ReqHttpCallBack;
//import com.sky.fly.rr.view.ILoginView;

import com.property.glory.propertyservice.bean.User;
import com.property.glory.propertyservice.bean.UserInfoBean;
import com.property.glory.propertyservice.http.ReqHttpCallBack;
import com.property.glory.propertyservice.view.ILoginView;

/**
 * Created by Android Studio.
 * Des:the description of current file
 * User: sky_fly_cloud
 * Date: 2018/2/25
 * Time: 下午5:11
 */

public class LoginPrensenter extends BasePrensenter<ILoginView<User>,User>
{
    public LoginPrensenter(ILoginView<User> iLoginView)
    {
        attachView(iLoginView);
    }

    /**
     * 登录
     * @param userName
     * @param userPassword
     */
    public void login(String userName,String userPassword)
    {
        uiView.showProgressView("加载中...");
        addObservable("login", httpApi.login(userName, userPassword), new ReqHttpCallBack<User>()
        {
            @Override
            public void reqSuccess(User result)
            {

                uiView.loginResult(result);
            }

            @Override
            public void reqOnError(String code, String msg)
            {

                uiView.showPrompt(msg);
            }
        });
    }
}
