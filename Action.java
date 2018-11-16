package com.test.frame;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.Assert.Assertion;
import com.method.commonOperater;

public class Action {
	
	public List<String> actionName =null;
	
	
	//点击操作
	public static void click(WebElement ele) {
	  ele.click();
	  commonOperater.sleep(3);
	}
	
	//输入文本框
	public static void input(WebElement ele, String text) {
		ele.click();
		ele.clear();
		ele.sendKeys(text);
		commonOperater.sleep(1);
	}
	
	//校验信息
	public static void verify(WebElement ele, String text) {
		Assertion.verifyEquals(ele.getAttribute("text"), text);
		commonOperater.sleep(1);
	}
	
	//等待操作 
	public static void sleep(WebElement ele, String text) {
		commonOperater.sleep(1);
	}
	
	
	public static void takeAction(Step step)
	{
		switch(step.actionType)
		{
			case CLICK:Action.click(step.webElement);break;
			case INPUT:Action.input(step.webElement,step.actionValue);break;
		}
	}

}

