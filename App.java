package com.method;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.remote.MobileCapabilityType;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws MalformedURLException  
    {
    	
    	//设备信息记录
    	//command:  aapt dump badging /Users/bindo/eclipse-workspace/eight/APK/UC.apk
        //lanchactivity:   com.UCMobile`.main.UCMobile
    	//package:  com.UCMobile emulator-5554
    	
     	//command:  aapt dump badging /Users/bindo/eclipse-workspace/eight/APK/weixin.apk
        //lanchactivity:   com.tencent.mm.ui.LauncherUI
    	//package:  com.tencent.mm
    	
    	//夜神devices
    	//adb connect 127.0.0.1:62001
    	//deviceName : 127.0.0.1:62001
    	//adb disconnect 127.0.0.1:62001
    	
    	
    	//A8 payment apk
    	//0123456789ABCDEF
    	//com.bindo.paymentapp.dev
    	//com.bindo.paymentapp.MainActivity
    	
    	
    	
    	
    
    	
    	WebDriver iosDriver;
    	DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    	desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPad Air 2");
    	desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
    	desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
    	desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.4.1");
    	desiredCapabilities.setCapability("udid", "3e09961ef3b8882fa457320294c60d929aef9b33");
    	desiredCapabilities.setCapability("bundleId", "com.bindo.bindo-pos-dev");
    	desiredCapabilities.setCapability("noReset", true);


    	URL url = new URL("http://127.0.0.1:4723/wd/hub");
    	iosDriver = new RemoteWebDriver(url, desiredCapabilities);
    	commonOperater.sleep(5);
    	
//    	iosDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"新外賣單\"]\n")).click();
    	iosDriver.findElement(By.id("新外賣單")).click();

    	commonOperater.sleep(5);

    	iosDriver.quit();
    	
//    	iosDriver.findElement(By.className("TextField")).sendKeys("www.baidu.com");
  
    }
}
