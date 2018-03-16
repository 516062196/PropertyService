package com.property.glory.propertyservice.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Toast工具类
 */
public class ToastUtil {  

    private static Toast toast;  

    public static void showToast(Context context,   
        String content) {  
        if (toast == null) {  
            toast = Toast.makeText(context,  
                         content,   
                         Toast.LENGTH_SHORT);  
        } else {  
            toast.setText(content);  
        } 
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();  
    }  

}  
