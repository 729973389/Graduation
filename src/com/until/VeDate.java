package com.until;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class VeDate {
    public static String getStringId(){
        Random rand=new Random();
        Date currentTime=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
        String dateString =simpleDateFormat.format(currentTime);
        return dateString+(rand.nextInt(900)+100);//0-900中生成一个随机的一个值
    }
    public static String getStringDateShort(){
        Date currentTime=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String datetime=format.format(currentTime);
        return datetime;
    }

    public static String geteStringDatex(){
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyyHHddHHmmss");
        return format.format(date);
    }
    public static long getDays(String date1, String date2) {
        if (date1 == null || date1.equals(""))
            return 0;
        if (date2 == null || date2.equals(""))
            return 0;
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        Date mydate = null;
        try {
            date = myFormatter.parse(date1);
            mydate = myFormatter.parse(date2);
        } catch (Exception e) {
        }
        long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);/*转成秒*/
        return day;
    }
    public static String getNextDay(String nowdate,String delay){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String mdate="";
        Date d=strToDate(nowdate);
        long myTime=(d.getTime()/1000)+Integer.parseInt(delay)*24*60*60;
        d.setTime(myTime*1000);
        mdate=format.format(d);
        return mdate;
    }
    public static Date strToDate(String strDate){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos=new ParsePosition(0);
        Date strtodate=format.parse(strDate,pos);
        return strtodate;

    }











}
