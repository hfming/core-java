package com.hfming.object;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *   @author hfm
 *  @version 1.01 2019-10-17
 */
public class CalendarAndDateTest {

	public static void main(String[] args) throws ParseException {
		// 获取当前系统时间的对象。
		Date date = new Date();
		System.out.println("年份："+date.toString());

		// 获取了当前的系统时间
		Calendar calendar = Calendar.getInstance();
		System.out.println("年份："+ calendar.get(Calendar.YEAR));
		System.out.println("月份："+ (calendar.get(Calendar.MONTH)+1));
		System.out.println("日："+ calendar.get(Calendar.DATE));
		System.out.println("时："+ calendar.get(Calendar.HOUR_OF_DAY));
		System.out.println("分："+ calendar.get(Calendar.MINUTE));
		System.out.println("秒："+ calendar.get(Calendar.SECOND));
		// xxxx 年 xx 月 xx 日 xx:xx:xx */
		// 创建日期格式化类对象
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy 年 MM 月 dd 日 HH:mm:ss");
		// 把日期对象转换指定格式的字符串 format
		/*String text = dateFormat.format(new Date());
		System.out.println("当前系统时间："+ text);*/
		// 字符串----> 时间对象 字符串的格式必须要与 SimpleDateformat 指定的模式要一致，否则报错。
		String text = "1990 年 09 月 08 日 07:01:00";
		Date date2 = dateFormat.parse(text);
		System.out.println(date2);
	}
}
