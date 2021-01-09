package com.mtp.bar.utils;

import java.security.MessageDigest;

/**
* @Description: md5密码加密
* @Param: 
* @return: 
* @Author: YuanJing
* @Date: 2019/8/28
*/ 
public class MD5Util {
	
	public static String encrypt(String msg,String key){
		return md5(md5(msg)+key);
	}
	
	
	public static String md5(String msg) {
		
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			//指定MD5加密的编码
			byte md5[] = md.digest(msg.getBytes("utf-8"));
			String strRet = "";
			for(int i = 0; i < md5.length; i++){
				strRet = strRet + String.format("%02x", md5[i]);
			}
			return strRet;
		} catch (Exception e) {
			return "";
		}

	}
	


}
