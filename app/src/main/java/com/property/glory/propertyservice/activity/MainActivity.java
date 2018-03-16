package com.property.glory.propertyservice.activity;

import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

import com.property.glory.propertyservice.R;
import com.property.glory.propertyservice.base.MVPBaseActivity;
import com.property.glory.propertyservice.bean.UserInfoBean;
import com.property.glory.propertyservice.fragment.CommunicationFragment;
import com.property.glory.propertyservice.fragment.MainFragment;
import com.property.glory.propertyservice.presenter.RegisterPrensenter;
import com.property.glory.propertyservice.view.ILoginView;

//import com.sky.fly.rr.R;
//import com.sky.fly.rr.base.BaseActivity;
//import com.sky.fly.rr.base.MVPBaseActivity;
//import com.sky.fly.rr.bean.UserInfoBean;
//import com.sky.fly.rr.presenter.IBasePrensenter;
//import com.sky.fly.rr.presenter.LoginPrensenter;
//import com.sky.fly.rr.presenter.RegisterPrensenter;
//import com.sky.fly.rr.view.ILoginView;

/**
 * register page
 */
public class MainActivity extends MVPBaseActivity<RegisterPrensenter> implements View.OnClickListener, ILoginView<UserInfoBean>
{
    private Fragment[] fragments;
    private MainFragment mainFragment;
    private CommunicationFragment communicationFragment;
    private Button[] mTabs;
    private int index=0;
    int currentTabIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        register();
        mainFragment = new MainFragment();
        communicationFragment = new CommunicationFragment();
        fragments = new Fragment[] { mainFragment, communicationFragment
                 };
        mTabs = new Button[2];
        mTabs[0] = (Button) findViewById(R.id.btn1);
        mTabs[1] = (Button) findViewById(R.id.btn2);
        mTabs[0].setSelected(true);
        currentTabIndex = 0;
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, mainFragment)
                .show(mainFragment).commit();// }
    }

    public void onTabClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                index = 0;
                // mTabs[3].setSelected(false);
                mTabs[1].setSelected(false);

                break;
            case R.id.btn2:
                index = 1;
                // mTabs[3].setSelected(false);
                mTabs[0].setSelected(false);

                break;


        }
        if (currentTabIndex != index) {
            FragmentTransaction trx = getSupportFragmentManager()
                    .beginTransaction();
            trx.hide(fragments[currentTabIndex]);
            if (!fragments[index].isAdded()) {
                trx.add(R.id.fragment_container, fragments[index]);
            }

            trx.show(fragments[index]).commit();

        }

        mTabs[currentTabIndex].setSelected(false);
        // 把当前tab设为选中状态
        mTabs[index].setSelected(true);

        currentTabIndex = index;
    }
    @Override
    protected RegisterPrensenter getPrensenter() {
        return new RegisterPrensenter(this);
    }


    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }



    @Override
    public void onClick(View view) {

    }

    @Override
    public void loginResult(UserInfoBean result) {
//        System.out.println("haha"+result.getAndroidVersion());
    }

    @Override
    public void backResult(String msg) {

    }

    /**
     *
     */
    public void register(){
    prensenter.login();
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
}
