package com.property.glory.propertyservice.http;

//import com.sky.fly.rr.bean.BaseResultBean;
//import com.sky.fly.rr.bean.UserInfoBean;


//import io.reactivex.Observable;
//import retrofit2.http.Field;
//import retrofit2.http.FormUrlEncoded;
//import retrofit2.http.POST;

import android.annotation.TargetApi;
//import android.database.Observable;
import android.os.Build;

import com.property.glory.propertyservice.bean.BaseResultBean;
import com.property.glory.propertyservice.bean.User;
import com.property.glory.propertyservice.bean.UserInfoBean;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by Android Studio.
 * Des:the description of current file
 * User: sky_fly_cloud
 * Date: 2018/2/25
 * Time: 下午2:42
 */

public interface HttpApi
{
    //测试服务器路劲
    String BaseUrl = "http://temp.52ruijiajia.com/app/";
    //曹倩服务器路劲
//    String BaseUrl = "http://ruijiajiatest.xicp.io/app/";
    /**
     * 登录接口
     * @param userName 用户名
     * @param userPassword 密码
     * @return
     */
    @FormUrlEncoded
    @POST("staff/login")
    Observable<BaseResultBean<User>> login(@Field("phone") String userName,
                                           @Field("password") String userPassword);
    /**
     * 登录接口

     * @return
     * @param
     */


    @POST("version")
     Observable<BaseResultBean<UserInfoBean>> register();
    /**
 * 首页接口
 */
@FormUrlEncoded
@POST("staff/home")
Observable<BaseResultBean<User>> main(@Field("workerId") String workerId);
    /**
     * 修改密码接口
     */
    @FormUrlEncoded
    @POST("staff/modifyPwd")
    Observable<BaseResultBean<BaseResultBean>> changgepwd(@Field("workerId") String workerId, @Field("oldpwd") String oldpwd, @Field("newpwd") String newpwd, @Field("newpwd2nd") String newpwd2nd);
    /**
     * 上传文件图片接口
     */
    @Multipart
    @POST("uploadImage")
    Observable<BaseResultBean<String>> uploadimg(@Part MultipartBody.Part file );
    /**
     * 修改资料接口
     */
    @FormUrlEncoded
    @POST("staff/saveHeadPhoto")
    Observable<BaseResultBean<String>> saveHeadPhoto(@Field("workerId") String workerId ,@Field("photo") String photo);
}
