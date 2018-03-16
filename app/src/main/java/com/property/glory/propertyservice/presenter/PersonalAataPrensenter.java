package com.property.glory.propertyservice.presenter;

import com.property.glory.propertyservice.bean.BaseResultBean;
import com.property.glory.propertyservice.bean.User;
import com.property.glory.propertyservice.http.ReqHttpCallBack;
import com.property.glory.propertyservice.view.ILoginView;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by Administrator on 2018/3/13.
 */

public class PersonalAataPrensenter extends BasePrensenter<ILoginView<BaseResultBean>,String>implements  PersonaldataPrensenterInterface {
    public PersonalAataPrensenter(ILoginView<BaseResultBean> iLoginView)
    {
        attachView(iLoginView);
    }

    /**
     * 上传图片
     * @param userName
     * @param file
     */
    public void uploadimg(String userName, File file)
    {
        uiView.showProgressView("加载中...");


        // 创建 RequestBody，用于封装构建RequestBody
        RequestBody requestFile =
                RequestBody.create(MediaType.parse("multipart/form-data"), file);

// MultipartBody.Part  和后端约定好Key，这里的partName是用image
        MultipartBody.Part body =
                MultipartBody.Part.createFormData(file.getName(), file.getName(), requestFile);
        addObservable("login", httpApi.uploadimg(body), new ReqHttpCallBack<String>()
        {


            @Override
            public void reqSuccess(String result) {
                uiView.backResult(result);
            }

            @Override
            public void reqOnError(String code, String msg)
            {
                System.out.println("失败");
                uiView.showPrompt(msg);
            }
        });

    }
    /**
     * 保存个人资料
     * @param workerId
     * @param photo
     */
    public void savedata(String workerId, String photo)
    {
        uiView.showProgressView("加载中...");



        addObservable("login", httpApi.saveHeadPhoto(workerId,photo), new ReqHttpCallBack<String>()
        {


            @Override
            public void reqSuccess(String result) {
                uiView.backResult("success");
            }

            @Override
            public void reqOnError(String code, String msg)
            {

                uiView.showPrompt(msg);
            }
        });

    }

    @Override
    public void refreshdata() {

    }
}
