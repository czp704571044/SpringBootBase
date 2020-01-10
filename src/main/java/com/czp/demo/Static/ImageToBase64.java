package com.czp.demo.Static;

import com.czp.demo.Util.BaseUtil;
import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.InputStream;

public class ImageToBase64 {
   public static String ImageToBase64(String path){
       byte[] data = null;
       try(InputStream in = new FileInputStream(path)){
            data = new byte[in.available()];
            in.read(data);
       }catch(Exception e){
        e.printStackTrace();
       }
       BASE64Encoder encoder = new BASE64Encoder();
       return encoder.encode(data);
   }
}
