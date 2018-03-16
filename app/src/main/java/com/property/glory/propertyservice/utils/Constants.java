package com.property.glory.propertyservice.utils;

/**
 * 常用常量
 * 
 */
public class Constants {
	public static final String APPLICATION_NAME = "glory";
	// 单次最多发送图片数
	public static final int MAX_IMAGE_SIZE = 9;
	// 首选项:发布帖子临时图片
	public static final String PREF_TEMP_IMAGES_POST = "pref_temp_images_post";
	// 首选项:投诉建议临时图片
	public static final String PREF_TEMP_IMAGES_SUGGESTION = "pref_temp_images_post_suggestion";
	// 首选项:投诉建议临时图片
	public static final String PREF_TEMP_IMAGES_PUBLICSERVICE = "pref_temp_images_post_publicservice";
	/**
	 * 后台基本路径-曹倩 http://ruijiajiatest.xicp.io/app/
	 */
//	public static final String BASEURL = "http://ruijiajiatest.xicp.io/app/";
	/**
	 * 后台基本路径-张君毅 
	 */
//	public static final String BASEURL = "http://zhangjunyi8.oicp.net/app/";
	/**
	 * 生产服务器路径
	 */
//	public static final String BASEURL = "https://52ruijiajia.com/app/";
	/**
	 * 测试服务器
	 */
	
	public static final String BASEURL = "http://temp.52ruijiajia.com/app/";
	//环信相关参数
	 public static final String MESSAGE_ATTR_IS_VOICE_CALL = "is_voice_call";
	    public static final String MESSAGE_ATTR_IS_VIDEO_CALL = "is_video_call";
	    
	    public static final String MESSAGE_ATTR_IS_BIG_EXPRESSION = "em_is_big_expression";
	    public static final String MESSAGE_ATTR_EXPRESSION_ID = "em_expression_id";
	 
	    
	    
		public static final int CHATTYPE_SINGLE = 1;
	    public static final int CHATTYPE_GROUP = 2;
	    public static final int CHATTYPE_CHATROOM = 3;
	    
	    public static final String EXTRA_CHAT_TYPE = "chatType";
	    public static final String EXTRA_USER_ID = "userId";
		public static final String NEW_FRIENDS_USERNAME = "item_new_friends";
		public static final String GROUP_USERNAME = "item_groups";
		public static final String CHAT_ROOM = "item_chatroom";
		public static final String ACCOUNT_REMOVED = "account_removed";
		public static final String ACCOUNT_CONFLICT = "conflict";
		public static final String CHAT_ROBOT = "item_robots";
		public static final String MESSAGE_ATTR_ROBOT_MSGTYPE = "msgtype";
		public static final String ACTION_GROUP_CHANAGED = "action_group_changed";
		public static final String ACTION_CONTACT_CHANAGED = "action_contact_changed";
		
		//Myinfo中保存环信账号
		public static final String KEY_USERNAME = "username";
		//环信相关参数
}
