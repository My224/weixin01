package com.weixin.model;

import com.weixin.Utils.DateUtil;

/**
 * 返回消息的实体类对象
 * @author Cls_
 *
 */
public class ResponseMsg {
	
	String ToUserName;
	String FromUserName;
	String MsgType;	
	String Content;
	
	public String getCreateTime() {
		return DateUtil.getFormatNowDate();
	}
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}

	
}
