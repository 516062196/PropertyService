package com.property.glory.propertyservice.utils;

import android.view.View;
import android.widget.ListView;

/**
 * 计算listview滑动高度工具类
 * @author Administrator
 *
 */
public class Listviewheight {
	/**
	 * 计算listview滑动高度方法
	 * 
	 */
	public static int getScrollY(ListView listview) {  
	    View c = listview.getChildAt(0);  
	    if (c == null) {  
	        return 0;  
	    }  
	    int firstVisiblePosition = listview.getFirstVisiblePosition();  
	    int top = c.getTop();  
	    return -top + firstVisiblePosition * c.getHeight() ;  
	}  
}
