package com.property.glory.propertyservice.presenter;

import com.property.glory.propertyservice.bean.BaseResultBean;

//import com.property.glory.propertyservice.bean.User;
import com.property.glory.propertyservice.http.ReqHttpCallBack;
import com.property.glory.propertyservice.view.ILoginView;

/**
 * Created by Administrator on 2018/3/13.
 */

public class ChangePwdPrensenter extends BasePrensenter<ILoginView<BaseResultBean>,BaseResultBean>{
    public ChangePwdPrensenter(ILoginView<BaseResultBean> iLoginView)
    {
        attachView(iLoginView);
    }
    /**
     * 修改密码
     * @param workerId
     * @param oldword
     */
    public void changgepwd(String workerId,String oldword,String newword,String sureword)
    {
        uiView.showProgressView("加载中...");
        addObservable("login", httpApi.changgepwd(workerId,oldword,newword,sureword), new ReqHttpCallBack<BaseResultBean>()
        {
            @Override
            public void reqSuccess(BaseResultBean result)
            {

                uiView.backResult("success");
            }

            @Override
            public void reqOnError(String code, String msg)
            {

                uiView.showPrompt(msg);
            }
        });
    }
}
