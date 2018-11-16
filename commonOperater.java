package com.method;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class commonOperater {
	
	public static AndroidDriver  driver =null;
	public static String screenShotPaht="/Users/bindo/eclipse-workspace/autotest/target/screenShotPic";
	
	
	//初始化环境信息和driver
	public static void initEnv(DesiredCapabilities caps) throws MalformedURLException
	{
		if(driver==null)
		{
			 driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		     driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		    
		     System.out.println("driver 连接成功！");
		     try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block 
				e.printStackTrace();
			}

		}
		
	}
	//检查控件是否存在
	public static boolean isExixtElement(By by)
	{
		
		try {
			driver.findElement(by);
		}
		catch(NoSuchElementException e)
		{
			return false;
			
		}
	  return true;
		
	}
	
	//检查控件是否消失
	public static boolean waitForDisapear(By by,int second) throws InterruptedException
	{
		
		for (int i=0;i<=second;i++)
		{
			if(commonOperater.isExixtElement(by))
			{
				Thread.sleep(1000);
				System.out.println("count num+"+i);
			}
			else{
				return true;
			
			}
		}
		return false;
	}
	

	//检查控件是否出现
	public static boolean waitForAppearByText(String text,int second) throws InterruptedException
	{
		
		for (int i=0;i<=second;i++)
		{
			if(commonOperater.findElementByText(text)==null)
			{
				Thread.sleep(1000);
				System.out.println("等待"+i+"秒，元素控件出现");
			}
			else{
				return true;
			
			}
		}
		return false;
	}
	
	//通过text查找元素
	public static WebElement findElementByText(String text)
	{
		List<WebElement> textlist = new ArrayList<WebElement>();
		textlist.addAll(driver.findElementsByClassName("android.widget.TextView"));
		textlist.addAll(driver.findElementsByClassName("android.widget.EditText"));

		
		for(int i=0;i<textlist.size();i++)
		{
			if(textlist.get(i).getAttribute("text").equals(text))
			{
				System.out.println("查找元素成功："+text);
				return textlist.get(i);
			}
			
		}
		
		System.out.println("查找元素失败："+text);
		return null;
		
		
	}
	
	//通过text查找元素
		public static WebElement findElement(ElementType type, String eleParas)
		{
			WebElement  webEle=null;
			String[] classlist=eleParas.split(":");
			switch(type)
			{
				case ID: webEle=commonOperater.findElementById(eleParas);break;
				case TEXT:webEle= commonOperater.findElementByText(eleParas);break;
				case DIMTEXT: webEle=commonOperater.findElementByTextDim(eleParas);break;
				case CLASSNAME: webEle=driver.findElementsByClassName(classlist[0]).get(Integer.parseInt(classlist[1]));break;

			}
		
		   return webEle;
		  
			
			
		}
		
	
	//通过text查找元素
	public static WebElement findElementById(String id)
	{
		WebElement ele=driver.findElementById(id);
		
		if(ele != null)
		{
			System.out.println("查找元素成功："+id);
			return ele;
		}
			
		
		System.out.println("查找元素失败："+id);
		return null;
		
		
	}
	
	//通过text模糊查找元素
	public static WebElement findElementByTextDim(String text)
	{
		List<WebElement> list = driver.findElementsByClassName("android.widget.TextView");
		System.out.println(list.size());

		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getAttribute("text"));
			if(list.get(i).getAttribute("text").contains(text))
			{
				return list.get(i);
			}
			
		}
		return null;
		
		
	}
	//获取app文件路径
	public static String getAPKPath(String apkName) {
		File workSpacePath=new File(System.getProperty("user.dir"));
    	File folder=new File(workSpacePath,"APK");
    	File appPath=new File(folder,apkName);
    	return appPath.getAbsolutePath();
	}
	
	public static void endOperater() {
		driver.quit();
		 System.out.println("driver 断开连接！");
	}
	
	public static void sleep(int second) {
		try {
			System.out.println("------sleep "+second+"s ------------");
			Thread.sleep(second*1000) ;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//通过坐标点击
	public static void clickByCoordinate(int x,int y)
	{
		driver.tap(1, x,y, 0);
	}
	
	//获取截屏图片
	public static String getScreenShot() 
	{
		//设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		String date = df.format(new Date());
		String filePath=screenShotPaht+"/"+date+".png";
		File screenShotFile=driver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShotFile, new File(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filePath;
	}
	
	//read file
	public static void readFile(String path) throws IOException
	{
		File file = new File(path);  
		BufferedReader reader = new BufferedReader(new FileReader(file));  
		String tempString = null;  
		
		while((tempString = reader.readLine()) != null) {
			System.out.println(tempString);
			if(tempString.startsWith("Step"))
			{
				System.out.println(tempString);
				
			}else if(tempString.startsWith("type")) {
				
			}
			
			
		}
		
		reader.close();



	}
}
