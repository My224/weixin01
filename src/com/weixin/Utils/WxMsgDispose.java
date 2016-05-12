package com.weixin.Utils;

import com.weixin.model.RequestMsg;
import com.weixin.model.ResponseMsg;

/**
 * 用于处理接收到的信息，进行相应的处理，并返回信息报文
 * @author Cls_
 *
 */
public class WxMsgDispose {
	
	public static String rtWxMsg(RequestMsg rxe){
		
		String returnMsg = null;
		//处理文本类型消息
		if ("text".equals(rxe.getMsgType())) {
			ResponseMsg msg = new ResponseMsg();
			msg.setFromUserName(rxe.getToUserName());
			msg.setToUserName(rxe.getFromUserName());
			msg.setContent("测试通过！");
			returnMsg = WxMsgObjToXml.toTextMsgXml(msg);
		}
		
		return returnMsg;
		
	}
}
