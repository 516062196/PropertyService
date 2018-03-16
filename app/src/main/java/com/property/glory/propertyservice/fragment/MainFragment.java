package com.property.glory.propertyservice.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.view.FocusFinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.property.glory.propertyservice.LoginActivity;
import com.property.glory.propertyservice.R;
import com.property.glory.propertyservice.activity.MainActivity;
import com.property.glory.propertyservice.activity.PersonalAataActivity;
import com.property.glory.propertyservice.activity.SettingActivity;
import com.property.glory.propertyservice.bean.User;
import com.property.glory.propertyservice.presenter.IBasePrensenter;
import com.property.glory.propertyservice.presenter.LoginPrensenter;
import com.property.glory.propertyservice.presenter.MainPrensenter;
import com.property.glory.propertyservice.utils.Constants;
import com.property.glory.propertyservice.utils.MD5;
import com.property.glory.propertyservice.view.ILoginView;

/**
 * Created by Administrator on 2018/3/7.
 */

public  class MainFragment extends BaseFragment <MainPrensenter> implements ILoginView<User> {
    SharedPreferences mySharedPreferences;
    SharedPreferences.Editor editor;
    TextView textordernum,textworknum,textshopnum,textservicesnum,textallordernum,textmyordernum;
    ImageView imgsetting;
    int authority1,authority2,authority3,authority4,authority5,authority6,authority7,authority8,authority9,authority10;
    RelativeLayout rl_data;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater
                .inflate(R.layout.fragment_main_layout, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mySharedPreferences = getActivity().getSharedPreferences(Constants.APPLICATION_NAME,
                Activity.MODE_PRIVATE);
        // 实例化SharedPreferences.Editor对象（第二步）
        editor = mySharedPreferences.edit();

        initview();
        imgsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), SettingActivity.class);
                startActivity(intent);
            }
        });
        rl_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), PersonalAataActivity.class);
                startActivity(intent);
            }
        });
    }
    public void initview(){
        rl_data=(RelativeLayout) getActivity(). findViewById(R.id.rl_data);
        textordernum=(TextView) getActivity(). findViewById(R.id.textordernum);
        textshopnum=(TextView) getActivity(). findViewById(R.id.textshopnum);
        textservicesnum=(TextView) getActivity(). findViewById(R.id.textservicesnum);
        textallordernum=(TextView) getActivity(). findViewById(R.id.textallordernum);
        textmyordernum=(TextView) getActivity(). findViewById(R.id.textmyordernum);
        textworknum=(TextView) getActivity(). findViewById(R.id.textworknum);
        imgsetting=(ImageView) getActivity(). findViewById(R.id.imgsetting);

    }

    @Override
    public void onResume() {
        super.onResume();
        if(!mySharedPreferences.getString("workerId", "").equals("")){
            prensenter.login(mySharedPreferences.getString("workerId", ""));
        }
    }

    @Override
    protected MainPrensenter getPrensenter() {
        return new MainPrensenter(this);
    }

    @Override
    public void showProgressView(String showText) {

    }

    @Override
    public void dismissProgressView() {

    }

    @Override
    public void showPrompt(String showText) {

    }

    @Override
    public void loginResult(User result) {
//        authority 为1表示有权限,authority 为2表示没权限
   try{
       for(int i=0;i<=result.getMenulist().size();i++){
           if(result.getMenulist().get(i).getModuleName().equals("工单中心")){
               textordernum.setText(result.getMenulist().get(i).getUndealNo1());
               authority1=Integer.valueOf(result.getMenulist().get(i).getAuthority());}
           if(result.getMenulist().get(i).getModuleName().equals("我的任务")){
               textworknum.setText(result.getMenulist().get(i).getUndealNo1());
               authority2=Integer.valueOf(result.getMenulist().get(i).getAuthority());}
           if(result.getMenulist().get(i).getModuleName().equals("新建工单")){

               authority3=Integer.valueOf(result.getMenulist().get(i).getAuthority());}
           if(result.getMenulist().get(i).getModuleName().equals("报事报修")){

               authority4=Integer.valueOf(result.getMenulist().get(i).getAuthority());}
           if(result.getMenulist().get(i).getModuleName().equals("住户管理")){

               authority5=Integer.valueOf(result.getMenulist().get(i).getAuthority());}
           if(result.getMenulist().get(i).getModuleName().equals("服务订单")){
               textservicesnum.setText(result.getMenulist().get(i).getUndealNo1());
               authority6=Integer.valueOf(result.getMenulist().get(i).getAuthority());}
           if(result.getMenulist().get(i).getModuleName().equals("商品订单")){
               textshopnum.setText(result.getMenulist().get(i).getUndealNo1());
               authority7=Integer.valueOf(result.getMenulist().get(i).getAuthority());}
           if(result.getMenulist().get(i).getModuleName().equals("帖子管理")){

               authority8=Integer.valueOf(result.getMenulist().get(i).getAuthority());}
           if(result.getMenulist().get(i).getModuleName().equals("发帖")){

               authority9=Integer.valueOf(result.getMenulist().get(i).getAuthority());}
           if(result.getMenulist().get(i).getModuleName().equals("业务统计")){
               textallordernum.setText(result.getMenulist().get(i).getUndealNo1());
               authority10=Integer.valueOf(result.getMenulist().get(i).getAuthority());}
           if(result.getMenulist().get(i).getModuleName().equals("业务统计")){
               textmyordernum.setText(result.getMenulist().get(i).getUndealNo2());
             }
       }

        }catch (Exception e){}

    }

    @Override
    public void backResult(String msg) {

    }

}
