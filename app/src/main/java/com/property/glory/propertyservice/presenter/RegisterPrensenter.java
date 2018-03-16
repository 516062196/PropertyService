package com.property.glory.propertyservice.presenter;

//import com.sky.fly.rr.bean.UserInfoBean;
//import com.sky.fly.rr.listener.ReqHttpCallBack;
//import com.sky.fly.rr.utils.SystemUtils;
//import com.sky.fly.rr.view.ILoginView;

import com.property.glory.propertyservice.bean.UserInfoBean;
import com.property.glory.propertyservice.http.HttpApi;
import com.property.glory.propertyservice.http.ReqHttpCallBack;
import com.property.glory.propertyservice.view.ILoginView;

//import static com.property.glory.propertyservice.http.HttpApi.register;

/**
 * Created by Android Studio.
 * Des:the description of current file
 * User: sky_fly_cloud
 * Date: 2018/2/25
 * Time: 下午5:11
 */

public class RegisterPrensenter extends BasePrensenter<ILoginView<UserInfoBean>,UserInfoBean>
{
    public RegisterPrensenter(ILoginView<UserInfoBean> iLoginView)
    {
        attachView(iLoginView);
    }

    /**
     * 登录
     *
     */
    public void login()
    {
//        uiView.showProgressView("加载中...");
        addObservable("login", httpApi.register(), new ReqHttpCallBack<UserInfoBean>()
        {
            @Override
            public void reqSuccess(UserInfoBean result)
            {
//                SystemUtils.println("释放资源1:"+result.getAndroidVersion());
                uiView.loginResult(result);
            }

            @Override
            public void reqOnError(String code, String msg)
            {
//                SystemUtils.println("释放资源2:"+msg);
//                uiView.showPrompt(msg);
            }
        });
    }
}
