package com.weixin.Utils;

import com.weixin.model.ResponseMsg;

/**
 * 用于将微信返回的信息对象转成XML报文
 * @author Cls_
 *
 */
public class WxMsgObjToXml {
	
	/**
	 * 将文本类的信息转为XML报文
	 * @param msg
	 * @return
	 */
	public static String toTextMsgXml(ResponseMsg msg){
		StringBuffer sb = new StringBuffer();
		sb.append("<xml>");
		sb.append("<ToUserName><![CDATA["+msg.getToUserName()+"]]></ToUserName>");
		sb.append("<FromUserName><![CDATA["+msg.getFromUserName()+"]]></FromUserName>");
		sb.append("<CreateTime>"+msg.getCreateTime()+"</CreateTime>");
		sb.append("<MsgType><![CDATA[text]]></MsgType>");
		sb.append("<Content><![CDATA["+msg.getContent()+"]]></Content>");
		sb.append("</xml>");
		return sb.toString();
	}
}
