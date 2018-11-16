package com.kiosk.testCase;

import org.testng.annotations.*;

import com.method.commonOperater;

import junit.framework.TestCase;

public class kiosk_test_NoActionTips_en_0211 extends TestCase {
	
	
	
	@Test
	public void testNoActionTips_en_0211() {
	
	
		//选择语言和方式，进入餐馆
		commonOperater.findElementByText(kiosk_paras.home_menu_English).click();
		commonOperater.findElementByText(kiosk_paras.Eng_chooseMethod_DineIn).click();;
		commonOperater.sleep(kiosk_paras.maxSleepTime);
		
		//检查点：弹框提示是否正确
		System.out.println("开始第一次检查");
		if(commonOperater.findElementByTextDim(kiosk_paras.tips_noAction_en)!=null)
		{
//			Assertion.verifyEquals(true, true, "弹框提示正确");
		}
		else{
			
//			 Assertion.verifyEquals(true, false, "弹框提示错误,详情请查看截图"+commonOperater.getScreenShot());
		}
		commonOperater.findElementByText(kiosk_paras.btn_no_en);
		
		
//		commonOperater.sleep(kiosk_paras.maxSleepTime);
//		System.out.println("开始第二次检查");
//		commonOperater.findElementByText(kiosk_paras.btn_no_en);
//		commonOperater.sleep(1);
//		
//		//检查点：是否返回首页
//		if(commonOperater.findElementByText(kiosk_paras.home_menu_English)!=null)
//		{
//			 Assertion.verifyEquals(true, true, "返回首页正确");
//		}else{
//			 commonOperater.getScreenShot();
//			 Assertion.verifyEquals(true, false,"返回首页错误,详情请查看截图"+commonOperater.getScreenShot() );
//		}
	}
	
	

	
	

	

}
