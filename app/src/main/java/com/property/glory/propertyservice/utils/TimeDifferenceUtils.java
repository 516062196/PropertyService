package com.property.glory.propertyservice.utils;
/**
 * 计算时间差
 * @author Administrator
 *
 */
public class TimeDifferenceUtils {
/**
 * 计算时间显示天，小时，分钟
 * 
 * @param rest
 *            时间差
 * @param belong
 * @param rest
 * @return
 */
public String getTimeDifference(long rest){
	int days = (int) (rest / (1000 * 60 * 60 * 24));
	int	 hours = (int) ((rest % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
	int minutes = (int) (rest % (1000 * 60 * 60)) / (1000 * 60);
	int seconds = (int) (rest % (1000 * 60)) / 1000;
	if(days==0){
		if(hours==0){
			if(minutes==0){
				return seconds+"秒";
				
			}else{
				return minutes+"分";
				
			}
			
		}else{
			return hours+"小时";
		
		}
	}else{
		return days+"天";
	
	}
	
	
}
}
