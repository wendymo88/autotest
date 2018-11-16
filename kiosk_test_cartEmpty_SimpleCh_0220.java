package com.kiosk.testCase;

import org.testng.annotations.Test;

import com.method.commonOperater;

import junit.framework.TestCase;

public class kiosk_test_cartEmpty_SimpleCh_0220 extends TestCase {
	
	
	@Test
	public void test_cartEmpty_en_0220() {
	
	
		//开始点餐
		commonOperater.findElementByText(kiosk_paras.home_menu_simpleChinese).click();
		commonOperater.findElementByText(kiosk_paras.SimpleCh_chooseMethod_TakeAway).click();
		commonOperater.sleep(2);
		
		//点击购物车
		commonOperater.findElementByTextDim(kiosk_paras.btn_cart_SimpleCh).click();
		commonOperater.sleep(1);

		//点击确定
		commonOperater.findElementByText(kiosk_paras.btn_ok_SimplCh).click();;
		//tip:Please choose at least 1 item.
		
		//返回首页
		commonOperater.findElementByText(kiosk_paras.btn_StartOver_SimpleCh).click();;
	}

}
