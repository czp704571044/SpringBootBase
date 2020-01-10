package com.czp.demo.Util;

import javax.servlet.ServletRequest;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//sout使用System.out.println();
public class myUtil {
    // 判断号码格式
    public static boolean isMobileNo(String mobileNo) {
        boolean bflag = false;
        Pattern p;
        Matcher m;
        try {
            if (mobileNo != null && mobileNo.length() == 11) {
                p = Pattern.compile("^[1][3,4,5,6,7,8,9][0-9]{9}$"); // 验证手机号
                m = p.matcher(mobileNo.trim());
                bflag = m.matches();
            } else {
                bflag = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bflag;
    }

    // 验证邮箱
    public static boolean isEmail(String email) {
        boolean bflag = false;
        Pattern p;
        Matcher m;
        String str = "^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$";
        try {
            if (email != null && !email.equals("")) {
                p = Pattern.compile(str); // 验证邮箱
                m = p.matcher(email.trim());
                bflag = m.matches();
            } else {
                bflag = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bflag;
    }

    // 判断是否为纯正整数 正整数
    public static boolean isPureNumer(String str) {
        if (isNull(str) != null) {
            Pattern pattern = Pattern.compile("[0-9]*");
            Matcher isNum = pattern.matcher(str);
            if (!isNum.matches()) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    // 处理空值空值
    public static String isNull(String codeValue) {
        String Str = null;
        try {
            if (codeValue != null) {
                if (codeValue.trim().equals("0000")) {
                    Str = null;
                } else {
                    if (codeValue.trim().toUpperCase().equals("NULL")) {
                        Str = null;
                    } else if (codeValue.trim().isEmpty()) {
                        Str = null;
                    } else {
                        if (codeValue.trim().equals("")) {
                            Str = null;
                        } else {
                            Str = codeValue.trim();
                        }
                    }
                }
            } else {
                Str = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Str;
    }

    // 字符串转日期 format yyyy-MM-dd HH:mm:ss
    public static Date stringToDate(String value, String format) {
        Date date = null;
        if (value == null) {
            return null;
        }
        if (format == null || format.equals("")) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            date = sdf.parse(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    // 日期转字符串 yyyy-MM-dd HH:mm:ss
    public static String dateToString(Date date, String format) {
        String dateStr = null;
        if (date == null) {
            return null;
        }
        if (format == null || format.equals("")) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            dateStr = sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateStr;
    }
    //以什么编码加密
    public static String strToUrl(String strurl, String charset) {
        String str = "";
        try {
            str = URLEncoder.encode(strurl, charset);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return str;
    }

    //以什么编码解码
    public static String urlToStr(String str, String charset) {
        String strurl = "";
        try {
            strurl = URLDecoder.decode(str, charset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strurl;
    }
    //double保留几位小数
    public static double formatRoundDulbel(double roundNum, int iFalg) {
        BigDecimal bb = new BigDecimal(roundNum);
        double d1 = bb.setScale(iFalg, BigDecimal.ROUND_HALF_UP).doubleValue();
        return d1;
    }
    //float保留几位小数
    public static float formatRoundFloat(float roundNum, int iFalg) {
        BigDecimal bb = new BigDecimal(roundNum);
        float f1 = bb.setScale(iFalg, BigDecimal.ROUND_HALF_UP).floatValue();
        return f1;
    }
    // 字符串转INT
    public static int StrToInt(String str) {
        int n = 0;
        try {
            if (str != null && !str.isEmpty()) {
                n = Integer.parseInt(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }
    // 字符串转单精度
    public static float strToFloat(String str) {
        float f = 0.0f;
        try {
            f = Float.parseFloat(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
    // 字符串转Long
    public static long strToLong(String str) {
        long lnum = 0;
        try {
            if (str != null && !str.isEmpty()) {
                lnum = Long.parseLong(str.trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lnum;
    }
    // INT转字符串
    public static String intToStr(int n) {
        String str = "";
        try {
            str = String.valueOf(n);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
    // 获取时间戳毫秒
    public static String getMillis() {
        String millisStr = null;
        try {
            millisStr = "" + System.currentTimeMillis();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return millisStr;
    }
    //验证是否是yyyMMddHHmmss字符串
    public static boolean isValidDateTime(String str) {
        boolean bflag = true;
        SimpleDateFormat dateTimeformat = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            if (str != null && !str.trim().isEmpty()) {
                if (str.length() == 14) {
                    dateTimeformat.setLenient(false);
                    dateTimeformat.parse(str);
                } else {
                    bflag = false;
                }
            } else {
                bflag = false;
            }
        } catch (ParseException e) {
            bflag = false;
        }
        return bflag;
    }
    //获取系统小时
    public static int getSysHour(){
        int hour=9;
        try{
            Calendar now = Calendar.getInstance();
            hour =  now.get(Calendar.HOUR_OF_DAY);
        }catch(Exception e){e.printStackTrace();}
        return hour;
    }
    //取几天前的日期
    public static String getNDayAgo(int dayNum)
    {
        String runDay=null;
        try{
            Calendar ndayAgo = Calendar.getInstance();
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            ndayAgo.add(Calendar.DATE, -dayNum);
            runDay = sdf1.format(ndayAgo.getTime());
        }catch(Exception e){e.printStackTrace();}
        if(runDay!=null && !runDay.trim().isEmpty()){
            runDay=runDay+" 00:00:00";
        }else{
            runDay="2001-01-01 00:00:00";
        }
        return runDay;
    }
    //取4位随机数
    public static String get4CharRandomNum(){
        String randomStr=null;
        try{
            randomStr=""+((Math.random()*9000)+1000);
        }catch(Exception e){e.printStackTrace();}
        return randomStr;
    }
    //去掉换行符
    public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }
    //分转成元
    public static String fromFenToYuan(String fen) {
        String yuan = "";
        int MULTIPLIER = 100;
        Pattern pattern = Pattern.compile("^[0-9][0-9]*{1}");
        Matcher matcher = pattern.matcher(fen);
        if (matcher.matches()) {
            yuan = new BigDecimal(fen).divide(new BigDecimal(MULTIPLIER)).setScale(2).toString();
        } else {
            System.out.println("参数格式不正确!");
        }
        return yuan;
    }
    //元转成分
    public static String fromYuanToFen(String yuan) {
        String fen = "";
        Pattern pattern = Pattern.compile("^[0-9]+(.[0-9]{2})?{1}");
        Matcher matcher = pattern.matcher(yuan);
        if (matcher.matches()) {
            try {
                NumberFormat format = NumberFormat.getInstance();
                Number number = format.parse(yuan);
                double temp = number.doubleValue() * 100.0;
                // 默认情况下GroupingUsed属性为true 不设置为false时,输出结果为2,012
                format.setGroupingUsed(false);
                // 设置返回数的小数部分所允许的最大位数
                format.setMaximumFractionDigits(0);
                fen = format.format(temp);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("参数格式不正确!");
        }
        return fen;
    }
    //当前日期加天数
    public static String nowDatePlusDay(int num){
        String enddate =null;
        Date d;
        try{
            d = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Calendar ca = Calendar.getInstance();
            ca.add(Calendar.DATE, num);
            d = ca.getTime();
            enddate = format.format(d);
        }catch(Exception e){e.printStackTrace();}
        return enddate;
    }
    //指定日期加天数
    public static String datePlusDay(String assignDate,int num){
        SimpleDateFormat format;
        String enddate=null;
        try{
            format = new SimpleDateFormat("yyyy-MM-dd");
            Date  currdate = format.parse(assignDate);
            Calendar ca = Calendar.getInstance();
            ca.setTime(currdate);
            ca.add(Calendar.DATE, num);
            currdate = ca.getTime();
            enddate = format.format(currdate);
        }catch(Exception e){e.printStackTrace();}
        return enddate;
    }
    //删除最后字符
    public static String delLastChar(String str){
        String returnStr=null;
        try{
            returnStr=str.substring(0, str.length()-1);
        }catch(Exception e){e.printStackTrace();}
        return returnStr;
    }
    //获取UUID
    public static String getUUID(){
        String uuidStr=null;
        try{
            uuidStr= UUID.randomUUID().toString().replaceAll("-", "");
        }catch(Exception e){e.printStackTrace();}
        return uuidStr;
    }
    //计算二时间相差分钟
    public static int getDateDifferMin(Date endDate, Date nowDate) {
        // 获得两个时间的毫秒时间差异
        int min =0;
        if(endDate!=null && nowDate!=null){
            long diff = endDate.getTime() - nowDate.getTime();
            min=(int)(diff / (1000 * 60));
        }
        return min;
    }
    //取提交参数
    public static String getRequestStr(ServletRequest request){
        String requestPara = "";
        try{
            if(request!=null){
                Map<String, String[]> params = request.getParameterMap();
                if(params!=null){
                    for (String key : params.keySet()) {
                        String[] values = params.get(key);
                        for (int i = 0; i < values.length; i++) {
                            String value = values[i];
                            requestPara +="["+ key + "=" + myUtil.logStr(value) + "] ";
                        }
                    }
                    // 去掉最后一个空格
                    if(requestPara!=null && !requestPara.trim().isEmpty()){
                        requestPara = requestPara.substring(0, requestPara.length() - 1);
                    }
                }else{
                    requestPara = "无提交参数";
                }
            }else{
                requestPara = "request is null";
            }

        }catch(Exception e){
            requestPara=e.toString();
            e.printStackTrace();}
        return requestPara;
    }
    // 格式化日志产数字符长度
    public static String logStr(String para) {
        String str = null;
        int nLen = 50;
        try {
            if (para != null && !para.trim().isEmpty()) {
                nLen = para.length();
                if (nLen > 30) {
                    nLen = 20;
                }
                str = para.substring(0, nLen);
            } else {
                str = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
    //获取类名和方法名 Thread.currentThread() .getStackTrace()
    public static String getClassMethodName(StackTraceElement[] stackTraceElement){
        String classMethodName="";
        try{
            //Thread.currentThread() .getStackTrace();
            if(stackTraceElement!=null && stackTraceElement.length>0){
                classMethodName=stackTraceElement[1].getClassName()+"."+stackTraceElement[1].getMethodName();
            }
        }catch(Exception e){e.printStackTrace();}
        return classMethodName;
    }
}
