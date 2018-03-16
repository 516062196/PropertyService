package com.property.glory.propertyservice.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.property.glory.propertyservice.presenter.IBasePrensenter;

/**
 * Created by Administrator on 2018/3/7.
 */

public abstract class BaseFragment<p extends IBasePrensenter> extends Fragment {
    protected p prensenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        prensenter = getPrensenter();

    }
    protected abstract p getPrensenter();
}
