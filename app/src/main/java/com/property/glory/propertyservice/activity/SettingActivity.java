package com.property.glory.propertyservice.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.property.glory.propertyservice.R;

public class SettingActivity extends Activity {
RelativeLayout rl_change;
TextView textTitle;
ImageView imgback,imgsetting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        rl_change=(RelativeLayout)findViewById(R.id.rl_change);
        textTitle=(TextView)findViewById(R.id.textTitle);
        imgback=(ImageView)findViewById(R.id.imgback);
        imgsetting=(ImageView)findViewById(R.id.imgsetting);
        imgsetting.setVisibility(View.GONE);
        imgback.setVisibility(View.VISIBLE);
        textTitle.setText("设置");
        rl_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SettingActivity.this,ChangePasswordActivity.class);
                startActivity(intent);
            }
        });
    }
}
