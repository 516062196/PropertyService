package com.property.glory.propertyservice.base;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;

import com.property.glory.propertyservice.R;
import com.property.glory.propertyservice.presenter.IBasePrensenter;
import com.readystatesoftware.systembartint.SystemBarTintManager;

//import com.sky.fly.rr.presenter.IBasePrensenter;

/**
 * Created by Android Studio.
 * Des:the description of current file
 * User: sky_fly_cloud
 * Date: 2018/2/25
 * Time: 下午4:59
 */

public abstract class MVPBaseActivity<p extends IBasePrensenter> extends BaseActivity
{
    protected  p prensenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        prensenter = getPrensenter();
        super.onCreate(savedInstanceState);
        applyKitKatTranslucency();
    }

    protected  abstract p getPrensenter();
    /**
     * Apply KitKat specific translucency.
     */
    private void applyKitKatTranslucency() {

        // KitKat translucent navigation/status bar.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
            SystemBarTintManager mTintManager = new SystemBarTintManager(this);
            mTintManager.setStatusBarTintEnabled(true);

            mTintManager.setStatusBarTintResource(R.color.blue);//通知栏所需颜色
        }

    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }
}
