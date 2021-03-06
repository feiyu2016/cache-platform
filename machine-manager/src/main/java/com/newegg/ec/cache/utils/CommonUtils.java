package com.newegg.ec.cache.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by lf52 on 2017/12/8.
 */
public class CommonUtils {

    private static Logger logger= Logger.getLogger(CommonUtils.class);

    public static String getUuid(){
        return UUID.randomUUID().toString();
    }

    public static String fomatTime(String time){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmm");
        return format.format(Long.parseLong(time));
    }

    public static String getFormatTime(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }

    public static String getNowDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        return sdf.format(new Date());
    }

    public static Timestamp getTimestamp(){
        return new Timestamp(System.currentTimeMillis());
    }

    public static String getAddress(){
        String ip = "";
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch ( UnknownHostException e ) {
            logger.error( e );
        }
        return ip;
    }

    public static String getCurrentDetailHour(){
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        return df.format(new Date());
    }

    public static String getCurrentDate(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }

    public static int getTime(){
        return (int) (System.currentTimeMillis() / 1000);
    }

    public static int getDay(){
        Date dNow = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String currentDay = sdf.format(dNow); //格式化当前时间
        return Integer.valueOf( currentDay );
    }
    public static int getHour(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public static int getMinute(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MINUTE);
    }

    public static int getTimeStamp(String dateStr, String format){
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat( format );
        int timeStemp = 0;
        Date date= null;
        try {
            date = simpleDateFormat .parse( dateStr );
        } catch (ParseException e) {
            logger.error( e );
        }
        if( null == date ){
            return 0;
        }
        long tmp = date.getTime();
        timeStemp = (int) (tmp / 1000);
        return timeStemp;
    }


    public static Map<String, String> changeStrToMap(String info){
        Map<String, String> resMap = new HashMap<>();
        if( !StringUtils.isBlank(info) ){
            String[] infoArr = info.split(",");
            for(String item : infoArr){
                String[] temps = item.split("=");
                if( temps.length == 2 ){
                    resMap.put( temps[0], temps[1] );
                }
            }
        }
        return resMap;
    }

}
