package com.kiosk.testCase;

import org.testng.annotations.Test;

import com.method.commonOperater;

import junit.framework.TestCase;

public class kiosk_test_ChooceType_SimpleCh_200 extends TestCase {
	
	
	@Test
	public void test_ChooseTypeBack_en_0220() {
	
	
		//开始点餐
		commonOperater.findElementByText(kiosk_paras.home_menu_simpleChinese).click();
		commonOperater.sleep(1);
		commonOperater.findElementByText(kiosk_paras.btn_Back_SimpleCh).click();
		commonOperater.sleep(2);
	
	}

}
