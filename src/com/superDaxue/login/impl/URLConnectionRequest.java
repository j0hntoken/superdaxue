package com.superDaxue.login.impl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.superDaxue.login.IRequest;

public class URLConnectionRequest implements IRequest{
	public static void main(String[] args) {
		String path="http://202.203.209.96/v5api/api/Curriculum";
		List<NameValuePair> mapHeader=new ArrayList<NameValuePair>();
		/*mapHeader.add(new BasicNameValuePair("Host","202.203.209.96"));
		mapHeader.add(new BasicNameValuePair("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,* /*;q=0.8"));
		mapHeader.add(new BasicNameValuePair("Referer","http://202.203.209.96/v5"));
		mapHeader.add(new BasicNameValuePair("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.85 Safari/537.36"));
		*///mapHeader.add(new BasicNameValuePair("Authorization",""));
		try {
			String temp=new URLConnectionRequest().doGet(mapHeader,path);
			System.out.println(temp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String doGet(List<NameValuePair> headers, String url) {
	        String result = "";  
	        BufferedReader in = null;  
	        try {  
	            String urlName = url;  
	            URL realUrl = new URL(urlName);  
	            // 打开和URL之间的连接  
	            URLConnection conn = realUrl.openConnection();  
	            for (NameValuePair valuePair : headers) {
	            	conn.setRequestProperty(valuePair.getName(), valuePair.getValue());
	    		}
	            // 建立实际的连接  
	            conn.connect();  
	            // 获取所有响应头字段  
	            Map<String, List<String>> map = conn.getHeaderFields();  
	            // 遍历所有的响应头字段  
	            for (String key : map.keySet()) {  
	                System.out.println(key + "--->" + map.get(key));  
	            }  
	            // 定义BufferedReader输入流来读取URL的响应  
	            in = new BufferedReader(  
	                    new InputStreamReader(conn.getInputStream()));  
	            String line;  
	            while ((line = in.readLine()) != null) {  
	                result += "/n" + line;  
	            }  
	        } catch (Exception e) {  
	            System.out.println("发送GET请求出现异常！" + e);  
	            e.printStackTrace();  
	        }  
	        // 使用finally块来关闭输入流  
	        finally {  
	            try {  
	                if (in != null) {  
	                    in.close();  
	                }  
	            } catch (IOException ex) {  
	                ex.printStackTrace();  
	            }  
	        }  
	        return result;  
	    }  
	
	 public String doPost(List<NameValuePair> headers,List<NameValuePair> pamars,String url) {
	        PrintWriter out = null;  
	        BufferedReader in = null;  
	        String result = "";  
	        try {  
	            URL realUrl = new URL(url);  
	            // 打开和URL之间的连接  
	            URLConnection conn = realUrl.openConnection();  
	            // 设置通用的请求属性  
	            for (NameValuePair valuePair : headers) {
	            	conn.setRequestProperty(valuePair.getName(), valuePair.getValue());
	    		}
	            // 发送POST请求必须设置如下两行  
	            conn.setDoOutput(true);  
	            conn.setDoInput(true);  
	            // 获取URLConnection对象对应的输出流  
	            out = new PrintWriter(conn.getOutputStream());  
	            // 发送请求参数  
	            out.print(pamars);  
	            // flush输出流的缓冲  
	            out.flush();  
	            Map<String, List<String>> map = conn.getHeaderFields();  
	            // 遍历所有的响应头字段  
	            for (String key : map.keySet()) {  
	                System.out.println(key + "--->" + map.get(key));  
	            }  
	            // 定义BufferedReader输入流来读取URL的响应  
	            in = new BufferedReader(  
	                    new InputStreamReader(conn.getInputStream()));  
	            String line;  
	            while ((line = in.readLine()) != null) {  
	                result += "/n" + line;  
	            }  
	        } catch (Exception e) {  
	            System.out.println("发送POST请求出现异常！" + e);  
	            e.printStackTrace();  
	        }  
	        // 使用finally块来关闭输出流、输入流  
	        finally {  
	            try {  
	                if (out != null) {  
	                    out.close();  
	                }  
	                if (in != null) {  
	                    in.close();  
	                }  
	            } catch (IOException ex) {  
	                ex.printStackTrace();  
	            }  
	        }  
	        return result;  
	    }

	public String getCodeCookie(String url, String savePath) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCookie() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGetUrl(List<NameValuePair> headers, String url) {
		// TODO Auto-generated method stub
		return null;
	}

	public String doGet(List<NameValuePair> headers, String url, int time) {
		// TODO Auto-generated method stub
		return null;
	}

	public String doGet(List<NameValuePair> headers, String url, String charset) {
		// TODO Auto-generated method stub
		return null;
	}

}
