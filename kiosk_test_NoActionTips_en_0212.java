package com.kiosk.testCase;

import org.testng.annotations.Test;

import com.method.commonOperater;

import junit.framework.TestCase;

public class kiosk_test_NoActionTips_en_0212 extends TestCase {
	
    @Test
	public void testNoActionTips_backToHome_en_0212() {
	
		//开始点餐
		commonOperater.findElementByText(kiosk_paras.home_menu_English).click();
		commonOperater.findElementByText(kiosk_paras.Eng_chooseMethod_DineIn).click();;
		commonOperater.sleep(kiosk_paras.maxSleepTime);
		commonOperater.sleep(12);
		
	}

}
