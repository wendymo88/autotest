package com.method;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class test {


public static String readFile(File file, String charset){
        if(charset == null){
            charset = "UTF-8";
        }
         
        if(file.isFile() && file.exists()){
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, charset);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                 
                StringBuffer sb = new StringBuffer();
                String text = null;
                while((text = bufferedReader.readLine()) != null){
                    sb.append(text);
                }
                return sb.toString();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        return null;
    }


	

	public static void writeToFile(String content){    
	    try {
	        File file = new File("/Users/bindo/Documents/performance_test/result/recultCompare.txt");
	        if(!file.exists()){
	            file.createNewFile();
	        }
	        FileWriter fw = new FileWriter(file,true);
	        BufferedWriter bw = new BufferedWriter(fw);
	        bw.write(content);
	        bw.close(); fw.close();
	        System.out.println("test2 done!");
	         
	    } catch (Exception e) {
	        // TODO: handle exception
	    }
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File posLog=new File("/Users/bindo/Documents/performance_test/result/test.txt");
		File pmsLog=new File("/Users/bindo/Documents/performance_test/result/test2.txt");
		
        StringBuffer succeededresult = new StringBuffer();
        StringBuffer failresult = new StringBuffer();
        StringBuffer noresult = new StringBuffer();
        failresult.append("pos ok but pms fail");
		
		String posLogStr=readFile(posLog, null);
		String pmsLogStr=readFile(pmsLog, null);
		
		String[] posLogArrage=posLogStr.split("}");
		
		for (String s : posLogArrage) {
			String[] eles=s.split("\"");
			String resultMsg=eles[eles.length-1];
			System.out.println(resultMsg);
			
			String[] numberStr=resultMsg.split(" ");
			String number=numberStr[numberStr.length-1];

			System.out.println(number);

			if(resultMsg.toLowerCase().contains("fail"))
			{
				failresult.append("POS 失败日志订单号：“+number+”\n");
				failresult.append(resultMsg+"\n");
				
				
				if(pmsLogStr.contains(number))
				{
					String frontlog=pmsLogStr.split(number)[0];
					String[] endlog=frontlog.split("time");
					String endlogStr=endlog[endlog.length-1];
					System.out.println("time"+endlogStr+number);
					String level=endlogStr.split(" ")[1];
					System.out.println(level);
					
					if(level.contains("debug"))
					{
						failresult.append("PMS日志显示成功"+number+": \n");
					}
					else if(level.contains("warning")||level.contains("error"))
					{
						failresult.append("PMS日志显示失败订单号:"+number);
						failresult.append("time"+endlogStr+number+"\n");
					}
					
				}
				else 
				{
					failresult.append("PMS日志未找到订单号: "+number);
				}
				
			}
			else if(resultMsg.toLowerCase().contains("post"))
			{

			    
				if(pmsLogStr.contains(number))
				{
					String frontlog=pmsLogStr.split(number)[0];
					String[] endlog=frontlog.split("time");
					String endlogStr=endlog[endlog.length-1];
					System.out.println("time"+endlogStr+number);
					String level=endlogStr.split(" ")[1];
					System.out.println(level);
					
					if(level.contains("debug"))
					{
						succeededresult.append("订单日志同步成功:"+ number+"\n");
					}
					else if(level.contains("warning")||level.contains("error"))
					{
						
						failresult.append(number+":");
						failresult.append("time"+endlogStr+number+"\n");
					}
					
				}
				else 
				{
					noresult.append("POS 发送请求成功，但是pms 没有找到这个订单日志： "+number);
				}
				
				
			}
		
			
		}
		
		
		writeToFile(succeededresult.toString());
		writeToFile(failresult.toString());
		writeToFile(noresult.toString());

		
	}

}
