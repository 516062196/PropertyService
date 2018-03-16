package com.property.glory.propertyservice.utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.text.TextUtils;

//import com.hyphenate.util.HanziToPinyin;
//import net.sf.json.JSONArray;
//import com.luckyhome.entity.Order;

/**
 * 用于验证的各种输入的工具类
 * 
 */
public class Validation {
	/**
	 * 验证邮箱
	 * 
	 * @param s
	 * @return
	 */
	public boolean isemail(String str) {
		String email = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		Pattern pattern = Pattern.compile(email);
		Matcher isNum = pattern.matcher(str);
		if (isNum.matches()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 验证手机号码
	 * 
	 * @param s
	 * @return
	 */
	public boolean isphone(String s) {
		String phone = "[1][3587]\\d{9}";
		// Pattern pattern = Pattern.compile(phone);
		// Matcher isNum = pattern.matcher(str);
		// if (isNum.matches()) {
		// return true;
		// }else {
		// return false;
		// }
		return s.matches("[1][3|4|5|7|8]\\d{9}");
	}

	/**
	 * 验证用户名一般字母开头，允许字母数字下划线，6-18个字节
	 * 
	 * @param s
	 * @return
	 */
	public boolean checkString(String s) {
		return s.matches("{6,6}");

	}

	/**
	 * 验证密码，长度在6~20之间
	 * 
	 * @param s
	 * @return
	 */
	public boolean checkPassWord(String s) {
		return s.matches("^\\w{6,18}$");

	}

	/**
	 * 验证码，长度在4位
	 * 
	 * @param s
	 * @return
	 */
	public boolean checkcode(String s) {
		return s.matches("^\\w{4,4}$");

	}

	/**
	 * 过滤敏感词
	 */
	public  Boolean Sensitivewords(String str) {
		String words = "三个呆婊,社会主义灭亡,打倒中国,灭亡中国,亡党,亡国,粉碎四人帮,殃视一党执政,一党专制,一党专政,专制政权,讨伐中宣部,反party,反共,灭共,贱人,装b,大sb,傻逼,傻b,煞逼,煞笔,刹笔,傻比,沙比,欠干,婊子养的,我日你,我操,我草,卧艹,卧槽,爆你菊,艹你,cao你,你他妈,真他妈,别他吗,草你吗,草你丫,操你妈,擦你妈,操你娘,操他妈,日你妈,干你妈,干你娘,娘西皮,狗,操狗,草狗,杂种,狗日的,操你祖宗,操你全家,操你大爷,妈逼,你麻痹,麻痹的,妈了个逼,马勒,狗娘养,贱比,贱b,下贱,死全家,全家死光,全家不得好死,全家死绝,白痴,无耻,sb,杀b,你吗b,你妈的,婊子,贱货,人渣,性伴侣,精子,射精,诱奸,强奸,做爱,性爱,快感,屌,a片,咪咪,兽性,sm,阉割,干你,干死,我干,我日";
		String flag, toals = "";
		Boolean flag1=false;
		List<String> list = new ArrayList<String>();
		StringBuffer sb = new StringBuffer(words);
		for (int i = 0; i < words.length(); i++) {

			flag = "" + sb.charAt(i);
			if (flag.equals(",")) {
				list.add(toals);
				toals="";
			} else {
				toals = toals + sb.charAt(i);
			}
		}
		for (int i = 0; i < list.size(); i++) {
//			str=	str.replace(list.get(i), "***");
			if(str.indexOf(list.get(i)) != -1){
				flag1=true;
			}
		}
		
		
		return flag1;

	}
	/**
	 * 判断是否包含表情
	 * @param string
	 * @return
	 */
	public boolean isEmoji(String string) {
        Pattern p = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",
            Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(string);
        return m.find();
    }
	/**
	 * 字符串太长，显示不完整，截取一部分。str对象字符串，i截取长度
	 */
public String removestr(String str,int i){
	if(str.length()>=i){
		str=str.substring(0, i)+"...";
	}
	return str;
}
/**
 * 保留两位小数
 */
public String changeprice(String str){
	DecimalFormat    df   = new DecimalFormat("######0.00");
	
	try {
		double price=Double.valueOf(str);
		str=df.format(price);
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	return str;
	
}
/**
 * 判断是否业主认证
 */
public  Boolean Ownerstate(String str,String words) {
//	String words = "三个呆婊,社会主义灭亡,打倒中国,灭亡中国,亡党,亡国,粉碎四人帮,殃视一党执政,一党专制,一党专政,专制政权,讨伐中宣部,反party,反共,灭共,贱人,装b,大sb,傻逼,傻b,煞逼,煞笔,刹笔,傻比,沙比,欠干,婊子养的,我日你,我操,我草,卧艹,卧槽,爆你菊,艹你,cao你,你他妈,真他妈,别他吗,草你吗,草你丫,操你妈,擦你妈,操你娘,操他妈,日你妈,干你妈,干你娘,娘西皮,狗,操狗,草狗,杂种,狗日的,操你祖宗,操你全家,操你大爷,妈逼,你麻痹,麻痹的,妈了个逼,马勒,狗娘养,贱比,贱b,下贱,死全家,全家死光,全家不得好死,全家死绝,白痴,无耻,sb,杀b,你吗b,你妈的,婊子,贱货,人渣,性伴侣,精子,射精,诱奸,强奸,做爱,性爱,快感,屌,a片,咪咪,兽性,sm,阉割,干你,干死,我干,我日";
	String flag, toals = "";
	Boolean flag1=false;
	List<String> list = new ArrayList<String>();
	StringBuffer sb = new StringBuffer(words);
	for (int i = 0; i < words.length(); i++) {

		flag = "" + sb.charAt(i);
		if (flag.equals(",")) {
			list.add(toals);
			toals="";
		} else {
			toals = toals + sb.charAt(i);
		}
	}
	for (int i = 0; i < list.size(); i++) {
//		str=	str.replace(list.get(i), "***");
		if(str.indexOf(list.get(i)) != -1){
			flag1=true;
		}
	}
	
	
	return flag1;

}
/**
 * 根据字符串获取当前首字母
 *
 * @param name
 * @return
 */
//public String getLetter(String name) {
//    String DefaultLetter = "#";
//    if (TextUtils.isEmpty(name)) {
//        return DefaultLetter;
//    }
//    char char0 = name.toUpperCase().charAt(0);
//    if (Character.isDigit(char0)) {
//        return DefaultLetter;
//    }
//    ArrayList<HanziToPinyin.Token> l = HanziToPinyin.getInstance().get(name.substring(0, 1));
//    if (l != null && l.size() > 0 && l.get(0).target.length() > 0) {
//        HanziToPinyin.Token token = l.get(0);
//        // toLowerCase()返回小写， toUpperCase()返回大写
//        String letter = token.target.substring(0, 1).toUpperCase();
//        char c = letter.charAt(0);
//        // 这里的 'a' 和 'z' 要和letter的大小写保持一直。
//        if (c < 'A' || c > 'Z') {
//            return DefaultLetter;
//        }
//        return letter;
//    }
//    return DefaultLetter;
//}
}
