package com.property.glory.propertyservice.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
/**
 * 检查网络状态
 *
 */
public class InternetUtils {
	 public  boolean isNetworkAvailable(Context context) {  
	        ConnectivityManager connectivity = (ConnectivityManager) context  
	                .getSystemService(Context.CONNECTIVITY_SERVICE);  
	        if (connectivity != null) {  
	            NetworkInfo info = connectivity.getActiveNetworkInfo();  
	            if (info != null && info.isConnected())   
	            {  
	                // 当前网络是连接的  
	                if (info.getState() == NetworkInfo.State.CONNECTED)   
	                {  
	                    // 当前所连接的网络可用  
	                    return true;  
	                }  
	            }  
	        }  
	        return false;  
	    }  
	/*
	 * 判断是否有网络连接 
	 */
	public boolean isNetworkConnected(Context context) { 
		if (context != null) { 
		ConnectivityManager mConnectivityManager = (ConnectivityManager) context 
		.getSystemService(Context.CONNECTIVITY_SERVICE); 
		NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo(); 
		if (mNetworkInfo != null) { 
		return mNetworkInfo.isAvailable(); 
		} 
		} 
		return false; 
		} 
	/*
	 * 判断WIFI网络是否可用 
	 */
	public boolean isWifiConnected(Context context) { 
		if (context != null) { 
		ConnectivityManager mConnectivityManager = (ConnectivityManager) context 
		.getSystemService(Context.CONNECTIVITY_SERVICE); 
		NetworkInfo mWiFiNetworkInfo = mConnectivityManager 
		.getNetworkInfo(ConnectivityManager.TYPE_WIFI); 
		if (mWiFiNetworkInfo != null) { 
		return mWiFiNetworkInfo.isAvailable(); 
		} 
		} 
		return false; 
		} 
	/*
	 * 判断MOBILE网络是否可用 
	 */
//	public boolean isMobileConnected(Context context) { 
//		if (context != null) { 
//		ConnectivityManager mConnectivityManager = (ConnectivityManager) context 
//		.getSystemService(Context.CONNECTIVITY_SERVICE); 
//		NetworkInfo mMobileNetworkInfo = mConnectivityManager 
//		.getNetworkInfo(ConnectivityManager.TYPE_MOBILE); 
//		if (mMobileNetworkInfo != null) { 
//		return mMobileNetworkInfo.isAvailable(); 
//		} 
//		} 
//		return false; 
//		} 
	/*
	 * 
	 * 获取当前网络连接的类型信息
	 */
	public static int getConnectedType(Context context) { 
		if (context != null) { 
		ConnectivityManager mConnectivityManager = (ConnectivityManager) context 
		.getSystemService(Context.CONNECTIVITY_SERVICE); 
		NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo(); 
		if (mNetworkInfo != null && mNetworkInfo.isAvailable()) { 
		return mNetworkInfo.getType(); 
		} 
		} 
		return -1; 
		} 
}
