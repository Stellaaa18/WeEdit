package com.imooc.demo.tools;

import java.text.SimpleDateFormat;

public class tool {
	public static String getTime()
	{
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String TimeString = time.format(new java.util.Date());
        return TimeString;
	}
}
