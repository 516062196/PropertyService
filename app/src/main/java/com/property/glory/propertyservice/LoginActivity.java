package com.property.glory.propertyservice;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.property.glory.propertyservice.activity.MainActivity;
import com.property.glory.propertyservice.base.MVPBaseActivity;
import com.property.glory.propertyservice.bean.User;
import com.property.glory.propertyservice.presenter.LoginPrensenter;
import com.property.glory.propertyservice.utils.Constants;
import com.property.glory.propertyservice.utils.MD5;
import com.property.glory.propertyservice.utils.ToastUtil;
import com.property.glory.propertyservice.utils.Validation;
import com.property.glory.propertyservice.view.ILoginView;

public class LoginActivity extends MVPBaseActivity<LoginPrensenter> implements ILoginView<User> {
    EditText editusername, editpassword;
    SharedPreferences mySharedPreferences;
    SharedPreferences.Editor editor;
    Button btnlogin;
    Validation va;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editpassword = (EditText) findViewById(R.id.editpassword);
        editusername = (EditText) findViewById(R.id.editusername);
        btnlogin = (Button) findViewById(R.id.btnlogin);
        mySharedPreferences = getSharedPreferences(Constants.APPLICATION_NAME,
                Activity.MODE_PRIVATE);
        // 实例化SharedPreferences.Editor对象（第二步）
        editor = mySharedPreferences.edit();
        if(!mySharedPreferences.getString("workerId", "").equals("")){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
        va = new Validation();
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editusername.getText().toString().length() > 0) {
                    if (editpassword.getText().toString().length() > 0) {
                        if (va.isphone(editusername.getText().toString())) {
                            if (va.checkPassWord(editpassword.getText().toString())) {
                                prensenter.login(editusername.getText().toString(), MD5.Md5(editpassword.getText().toString()));
                            } else {
                                ToastUtil.showToast(LoginActivity.this, "请输入正确的密码");
                            }
                        } else {
                            ToastUtil.showToast(LoginActivity.this, "请输入正确的手机号码");
                        }
                    } else {
                        ToastUtil.showToast(LoginActivity.this, "请输入密码");
                    }
                } else {
                    ToastUtil.showToast(LoginActivity.this, "请输入手机号码");
                }

            }
        });

    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    protected LoginPrensenter getPrensenter() {
        return new LoginPrensenter(this);
    }

    @Override
    public void showProgressView(String showText) {

    }

    @Override
    public void dismissProgressView() {

    }

    @Override
    public void showPrompt(String showText) {
ToastUtil.showToast(LoginActivity.this,showText);
    }

    @Override
    public void loginResult(User result) {
        System.out.println("1" + result.getPersonalinfo().getOnline());
        editor.putString("workerId",
                result.getPersonalinfo().getWorkerId());
        editor.putString("petName",
                result.getPersonalinfo().getPetName());
        editor.putString("photo",
                result.getPersonalinfo().getPhoto());
        editor.putString("name",
                result.getPersonalinfo().getName());
        editor.putString("departmentName",
                result.getPersonalinfo().getDepartmentName());
        editor.putString("position",
                result.getPersonalinfo().getPosition());
        editor.putString("online",
                result.getPersonalinfo().getOnline());
        editor.putString("branchName",
                result.getPersonalinfo().getBranchName());
        editor.putString("phone",
                result.getPersonalinfo().getPhone());
        editor.commit();
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void backResult(String msg) {

    }
}
