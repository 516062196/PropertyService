package com.property.glory.propertyservice.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.property.glory.propertyservice.R;
import com.property.glory.propertyservice.base.MVPBaseActivity;
import com.property.glory.propertyservice.bean.BaseResultBean;
import com.property.glory.propertyservice.bean.User;
import com.property.glory.propertyservice.presenter.ChangePwdPrensenter;
import com.property.glory.propertyservice.presenter.LoginPrensenter;
import com.property.glory.propertyservice.utils.Constants;
import com.property.glory.propertyservice.utils.MD5;
import com.property.glory.propertyservice.utils.ToastUtil;
import com.property.glory.propertyservice.utils.Validation;
import com.property.glory.propertyservice.view.ILoginView;

public class ChangePasswordActivity extends MVPBaseActivity<ChangePwdPrensenter> implements ILoginView<BaseResultBean> {
    EditText oldword, newword, sureword;
    Validation va = new Validation();
String workerId;
    SharedPreferences mySharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        oldword = (EditText) findViewById(R.id.oldword);
        newword = (EditText) findViewById(R.id.newword);
        sureword = (EditText) findViewById(R.id.sureword);
        mySharedPreferences = getSharedPreferences(Constants.APPLICATION_NAME,
                Activity.MODE_PRIVATE);
        // 实例化SharedPreferences.Editor对象（第二步）
        editor = mySharedPreferences.edit();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    protected ChangePwdPrensenter getPrensenter() {
        return new ChangePwdPrensenter(this);
    }

    public void changeword(View view) {
        switch (view.getId()) {
            case R.id.btnchangeword:
                if (!oldword.getText().toString().trim().equals(""))
                    if (!newword.getText().toString().trim().equals("")) {
                        if (!sureword.getText().toString().trim().equals("")) {
                            if (va.checkPassWord(oldword.getText().toString().trim())) {
                                if (va.checkPassWord(newword.getText().toString().trim())) {
                                    if (newword.getText().toString().trim().equals(sureword.getText().toString().trim())) {
                                        String workerid=mySharedPreferences.getString("workerId", "");
                                        System.out.println(MD5.Md5(oldword.getText().toString().trim()));
                                        prensenter.changgepwd(workerid, MD5.Md5(oldword.getText().toString().trim()),MD5.Md5(newword.getText().toString().trim()),MD5.Md5(sureword.getText().toString().trim()));
                                    } else {
                                        ToastUtil.showToast(ChangePasswordActivity.this, "两次输入密码不一致");
                                    }
                                } else {
                                    ToastUtil.showToast(ChangePasswordActivity.this, "请输入正确新密码");
                                }
                            } else {
                                ToastUtil.showToast(ChangePasswordActivity.this, "请输入正确旧密码");
                            }
                        } else {
                            ToastUtil.showToast(ChangePasswordActivity.this, "请输入验证密码");
                        }
                    } else {
                        ToastUtil.showToast(ChangePasswordActivity.this, "请输入新密码");
                    }
                else {
                    ToastUtil.showToast(ChangePasswordActivity.this, "请输入旧密码");
                }
                break;
        }
    }

    @Override
    public void showProgressView(String showText) {

    }

    @Override
    public void dismissProgressView() {

    }

    @Override
    public void showPrompt(String showText) {
        ToastUtil.showToast(ChangePasswordActivity.this, showText);
    }

    @Override
    public void loginResult(BaseResultBean result) {

    }

    @Override
    public void backResult(String msg) {
        ToastUtil.showToast(ChangePasswordActivity.this, "修改密码成功");
        Intent  intent=new Intent(ChangePasswordActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
