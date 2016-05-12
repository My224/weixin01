package com.weixin.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	/**
	 * 获取当前时间的年月日时分秒字符串
	 * @return
	 */
	public static String getFormatNowDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMDDHHmmss");
		return sdf.format(new Date());
	}
}
