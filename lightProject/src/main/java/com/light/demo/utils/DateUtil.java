package com.light.demo.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 日期工具类
 * */
public class DateUtil {

    /**
     * 字符串转日期对象
     *
     * @param str
     * @param format
     * @return
     */
    public static Date formatString(String str, String format) throws ParseException {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(str);
    }

    /**
     * 日期对象转字符串
     */
    public static String formatDate(Date date, String format) {
        String result = "";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        if (date != null) {
            result = sdf.format(date);
        }
        return result;
    }

    /*
     * 获取当前时间字符串
     * */
    public static String getCurrentDateStr() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}
