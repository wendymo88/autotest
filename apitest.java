package com.method;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;

import javax.net.ssl.*;

import org.omg.CORBA.portable.InputStream;

public class apitest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//接口测试脚本
    	try
    	{
	        URL myURL = new URL(" https://trybindo.com/api/v2/login?username=ii@ii.com&password=123456&client_id=1clvjqb9fmv5bkjoq2akbc1h4&client_secret=1tfcglxmnjv4t263dji05wmjr");
	    	HttpsURLConnection test=(HttpsURLConnection)myURL.openConnection();
	    	test.setRequestMethod("POST");
	    	test.setDoInput(true);
	    	test.setDoOutput(true);
	    	test.connect();
	    	System.out.println("====="+test.getResponseMessage());

	    	InputStreamReader insr = new InputStreamReader(test.getInputStream());
	        int respInt = insr.read();
	        StringBuffer f=new StringBuffer();
	        while (respInt != -1) {
	            f.append((char)respInt);
	            respInt = insr.read();
	        }
	        System.out.println(f);
	        
	        //获取token
	        String[] s=f.toString().split(",");
//	        for(int i=0;i<s.length;i++)
//	        {
//	        	System.out.println(s[i]);
//	        	System.out.println(i);
//	        }
	        String tokenid=s[3].split(":")[0].replace("\"", "");
	        String tokenvaule=s[3].split(":")[1].replace("\"", "");
	        System.out.println(tokenid);
	        System.out.println(tokenvaule);


	        
	        URL myURL2 = new URL("https://gateway.trybindo.com/v2/stores/6865/invoices/201809261232227763170019/check");
	    	HttpsURLConnection test2=(HttpsURLConnection)myURL2.openConnection();
	    	test2.setRequestMethod("GET");
	    	test2.setDoInput(true);
	    	test2.setDoOutput(true);
	    	test2.setRequestProperty("X-USER-ACCESS-TOKEN", tokenvaule);
//	        JSONObject jsonParam = new JSONObject();
//			jsonParam.put("per_page", "0");
//			jsonParam.put("hobbies", new String[] {"hiking", "swimming"});
//            byte[] data = (jsonParam.toString()).getBytes();
//	        String json = "{\"2\":\"efg\",\"1\":\"abc\"}";   
//	        JSONObject json_test = JSONObject.quote(json)
//	        System.out.println(json_test.get("2"));
//	    	test2.setRequestProperty("Content-Length", String.valueOf(data.length));

	    	test2.connect(); 
	    	OutputStream out = new DataOutputStream(test2.getOutputStream()) ;			
	    	// 写入请求的字符串			
//	    	out.write((jsonParam.toString()).getBytes());			
//	    	out.flush();

	    	System.out.println("====="+test2.getResponseMessage());

	    	// 请求返回的状态			
	    	if (HttpURLConnection.HTTP_OK == test2.getResponseCode())
	    	{				
	    		System.out.println("连接成功");				
	    		// 请求返回的数据				
	    		InputStream in1 = (InputStream) test2.getInputStream();				
	    		try {		
		    	    	StringBuffer sb=new StringBuffer();
		    			String readLine=new String();				      
		    			BufferedReader responseReader=new BufferedReader(new InputStreamReader(in1,"UTF-8"));				      
		    			while((readLine=responseReader.readLine())!=null)
		    			{				        
		    				sb.append(readLine).append("\n");				     
		    			}				      
		    			responseReader.close();				    
		    			System.out.println(sb.toString());									
	    			}
	    		catch (Exception e1) {					
	    			e1.printStackTrace();				
	    			}			
	    		} 
	    	else
	    		{				
	    			System.out.println("error++");		
	    			
	    			
	    		}

	        
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
	}

}
