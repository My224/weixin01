package com.weixin.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.weixin.Utils.WxMsgDispose;
import com.weixin.Utils.WxXmlToMsgObj;
import com.weixin.model.RequestMsg;

@WebServlet("/WeiXinInit")
public class WeiXinInit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WeiXinInit() {
        super();
    }
    
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//定义token，跟微信上的一致，用于对接(暂时写这里，之后可以写在配置文件里)
	    String token = "weixintest";
		
		//获取微信服务器发送过来的四个参数
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		
		//获取输出
		Writer out = response.getWriter();
		
		//将token、timestamp、nonce三个参数进行字典序排序
		String arr[] ={token,timestamp,nonce};
		Arrays.sort(arr);
		
		//将三个参数字符串拼接成一个字符串进行sha1加密
		//用Apache的commons-codec工具包，其中的DigestUtils类有SHA加密方法可以直接调用
		//jar包放在WEB-INF/lib文件夹下，一般会自动引入
		String encryption = DigestUtils.sha1Hex((arr[0]+arr[1]+arr[2]).getBytes());
		
		//开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
		if(signature.equals(encryption)){
			out.write(echostr);
		}
		
		//关闭输出
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");  
        response.setCharacterEncoding("UTF-8");  
        /** 读取接收到的xml消息 */  
        StringBuffer sb = new StringBuffer();  
        InputStream is = request.getInputStream();  
        InputStreamReader isr = new InputStreamReader(is, "UTF-8");  
        BufferedReader br = new BufferedReader(isr);  
        String s = "";  
        while ((s = br.readLine()) != null) {  
            sb.append(s);  
        }  
        String xml = sb.toString(); //次即为接收到微信端发送过来的xml数据  
        
        RequestMsg rxe = WxXmlToMsgObj.getMsgEntity(xml); 
        
        Writer out = response.getWriter();
        out.write(WxMsgDispose.rtWxMsg(rxe));
        out.flush();
        out.close();
     
        br.close();
        isr.close();
        is.close();
	}

}
