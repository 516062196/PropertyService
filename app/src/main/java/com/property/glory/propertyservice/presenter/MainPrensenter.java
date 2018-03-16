package com.property.glory.propertyservice.presenter;

import android.content.SyncStatusObserver;

import com.property.glory.propertyservice.bean.User;
import com.property.glory.propertyservice.http.ReqHttpCallBack;
import com.property.glory.propertyservice.view.ILoginView;

/**
 * Created by Administrator on 2018/3/7.
 */

public class MainPrensenter  extends BasePrensenter<ILoginView<User>,User> {
    public MainPrensenter(ILoginView<User> iLoginView)
    {
        attachView(iLoginView);
    }

    /**
     * 登录
     * @param workerId
     *
     */
    public void login(String workerId)
    {
        uiView.showProgressView("加载中...");

        addObservable("login", httpApi.main(workerId), new ReqHttpCallBack<User>()
        {
            @Override
            public void reqSuccess(User result)
            {
                System.out.println("1111111111111111");
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
