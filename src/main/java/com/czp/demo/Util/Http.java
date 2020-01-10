package com.czp.demo.Util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Http {
    public static String get(String url, String param) {
        String line = "", result ="", website;
        int code;
        HttpURLConnection httpurlconnection = null;
        BufferedReader in = null;
        try {
            if (url != null && !url.trim().equals("")) {
                if (param != null && !param.equals("")) {
                    website = url.trim() + "?" + param.trim();
                } else {
                    website = url.trim();
                }
                URL ur = new URL(website);
                httpurlconnection = (HttpURLConnection) ur.openConnection();
                httpurlconnection.setConnectTimeout(3000);
                httpurlconnection.setReadTimeout(30000);
                code = httpurlconnection.getResponseCode();
                if (200 == code) {
                    in = new BufferedReader(new InputStreamReader(httpurlconnection.getInputStream()));
                    if (null != in) {
                        while ((line = in.readLine()) != null) {
                            result = result + line;
                        }
                        in.close();
                        in = null;
                    } else {
                        result = "ERR:response is null";
                    }
                } else {
                    result = "ERR:"+code;
                }
            } else {
                result = "ERR:param is null";
            }
        } catch (Exception e) {
            result = "ERR:" + e.toString();
        } finally {
            try {
                if (httpurlconnection != null) {
                    httpurlconnection.disconnect();
                }
            } catch (Exception e1) {
            }
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
            }
        }

        return result;
    }
    // post
    public static String post(String url, String param) {
        String line = "", result = "", postPara = "";
        int code = 0;
        HttpURLConnection httpurlconnection = null;
        URL ur;
        BufferedReader in = null;
        try {

            if (url != null && !url.trim().equals("")) {
                if (param != null && !param.equals("")) {
                    postPara = param.trim();
                } else {
                    postPara = "&";
                }
                ur = new URL(url.trim());
                httpurlconnection = (HttpURLConnection) ur.openConnection();
                httpurlconnection.setConnectTimeout(10000); // jdk 1.5
                httpurlconnection.setReadTimeout(60000); // jdk 1.5
                httpurlconnection.setDoOutput(true);
                httpurlconnection.setRequestMethod("POST");
                String header;
                httpurlconnection.setRequestProperty("Charset", "utf-8");
                httpurlconnection.setRequestProperty("Accept-Charset",  "utf-8");
                httpurlconnection.getOutputStream().write(postPara.getBytes("utf-8"));
                httpurlconnection.getOutputStream().flush();
                httpurlconnection.getOutputStream().close();
                code = httpurlconnection.getResponseCode();
                if (200 == code) {
                    in = new BufferedReader(new InputStreamReader(httpurlconnection.getInputStream()));
                    if (null != in) {
                        while ((line = in.readLine()) != null) {
                            result = result + line;
                        }
                        in.close();
                        in = null;
                    }
                } else {
                    result = "ERR:"+code;
                }
            } else {
                result = "ERR:param is null";
            }
        } catch (Exception e) {
            result = "ERR:"+e.toString();
            e.printStackTrace();
        } finally {
            try {
                if (httpurlconnection != null) {
                    httpurlconnection.disconnect();
                }
            } catch (Exception e1) {
            }
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
            }
        }
        return result;
    }
    // post XML
    public static String postXml(String url, String str) {
        String line = "", result = "";
        int code = 0;
        HttpURLConnection httpurlconnection = null;
        BufferedReader in = null;
        URL ur = null;
        try {
            ur = new URL(url);
            httpurlconnection = (HttpURLConnection) ur.openConnection();
            httpurlconnection.setDoOutput(true);
            httpurlconnection.setDoInput(true);
            httpurlconnection.setRequestMethod("POST");
            httpurlconnection.setInstanceFollowRedirects(true);
            httpurlconnection.setRequestProperty("Charset", "GB18030");
            httpurlconnection.setRequestProperty("contentType", "application/json");
            //httpurlconnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            // httpurlconnection.setRequestProperty("content-type",
            // "text/html");
            //httpurlconnection.setRequestProperty("Accept-Charset", "utf-8");
            httpurlconnection.setConnectTimeout(30000); // 链接超时
            httpurlconnection.setReadTimeout(30000); // 读出超时
            httpurlconnection.connect();
            DataOutputStream out = new DataOutputStream(httpurlconnection.getOutputStream()); // 输入
            //out.print(str.getBytes("UTF-8"));
            //out.print(str.trim());
            out.writeBytes(str);
            out.flush();
            out.close();
            /////////////////////////////////////////////////////
            code = httpurlconnection.getResponseCode();
            if (200 == code) {
                in = new BufferedReader(new InputStreamReader(httpurlconnection.getInputStream(), "utf-8"));
                if (null != in) {
                    while ((line = in.readLine()) != null) {
                        result = result + line;
                    }
                    in.close();
                    in = null;
                }
            } else {
                result = "ERR:"+code;
            }
        } catch (Exception e) {
            result = "ERR:"+e.toString();
            e.printStackTrace();
        } finally {
            if (httpurlconnection != null) {
                try {
                    httpurlconnection.disconnect();
                } catch (Exception eee) {
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (Exception ee) {
                }
            }
        }
        return result;
    }

    public static String postJson(String submitUrl, String json) {
        URL url = null;
        String postResponseStr=null;
        HttpURLConnection httpURLConnection =null;
        BufferedReader getResponseBytes =null;
        PrintWriter printWriter =null;
        StringBuilder sb =null;
        try {
            url = new URL(submitUrl);
            httpURLConnection=(HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");// 提交模式
            httpURLConnection.setConnectTimeout(10000);//连接超时 单位毫秒
            httpURLConnection.setReadTimeout(180000);//读取超时 单位毫秒
            // 发送POST请求必须设置如下两行
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            //httpURLConnection.setRequestProperty("Accept", "application/json");

            httpURLConnection.setRequestProperty("Content-Type", "text/plain");
            httpURLConnection.setRequestProperty("connection", "Keep-Alive");
            httpURLConnection.setRequestProperty("Charsert", "UTF-8");
            //httpURLConnection.setRequestProperty("Content-type", "application/json; charset=utf-8");
            // 获取URLConnection对象对应的输出流
            printWriter = new PrintWriter(httpURLConnection.getOutputStream());
            printWriter.write(json);
            printWriter.flush();
            //printWriter.close();
            int httpRspCode = httpURLConnection.getResponseCode();
            if (httpRspCode == HttpURLConnection.HTTP_OK) {
                sb = new StringBuilder();
                // 开始获取数据
                getResponseBytes = new BufferedReader(
                        new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));
                String line = null;
                while ((line = getResponseBytes.readLine()) != null) {
                    sb.append(line);
                }
                getResponseBytes.close();
                postResponseStr=sb.toString();
            }else{
                postResponseStr="ERR:"+httpRspCode;
            }
        } catch (Exception e) {
            postResponseStr="ERR:"+e.getMessage();
            e.printStackTrace();
        }finally {
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception eee) {
                }
            }
            if (getResponseBytes != null) {
                try {
                    getResponseBytes.close();
                } catch (Exception ee) {
                }
            }
            if (printWriter != null) {
                try {
                    printWriter.close();
                } catch (Exception eeee) {
                }
            }
            if (sb != null) {
                try {
                    sb=null;
                } catch (Exception eeeee) {
                }
            }
        }

        return postResponseStr;
    }
    public static void main(String args[])throws Exception{
        Http http=new Http();
    }
}
