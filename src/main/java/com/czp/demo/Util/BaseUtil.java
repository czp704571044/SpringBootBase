package com.czp.demo.Util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseUtil {
    // 加密
    public static String encodeData(String str) {
        //L.p("str-->"+str);
        byte[] b;
        String s = null;
        try {
            if(str!=null && !str.trim().equals("")){
                b = str.getBytes("utf-8");
                if (b != null) {
                    s = new BASE64Encoder().encode(b);
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return replaceBlank(s);
    }

    // 解密
    public static String decodeData(String s) {
        byte[] b;
        String result = null;
        if (s != null) {
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                b = decoder.decodeBuffer(s);
                result = new String(b, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
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
}
