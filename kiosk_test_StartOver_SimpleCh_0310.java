package com.kiosk.testCase;

import org.testng.annotations.Test;

import com.method.commonOperater;

import junit.framework.TestCase;

public class kiosk_test_StartOver_SimpleCh_0310 extends TestCase {
	
	
	@Test
	public void test_OrderFood_en_0400() {
	
	
		//开始点餐
		commonOperater.findElementByText(kiosk_paras.home_menu_simpleChinese).click();
		commonOperater.findElementByText(kiosk_paras.SimpleCh_chooseMethod_DineIn).click();;
		commonOperater.sleep(2);
		
		//选择汉堡王，选择
		commonOperater.findElementByText(kiosk_paras.Eng_rest_BurgerKing).click();
		commonOperater.sleep(2);
		commonOperater.findElementByText(kiosk_paras.Eng_rest_BurgerKing_type_Add_on).click();
		commonOperater.sleep(2);
		commonOperater.clickByCoordinate(570, 620);
		commonOperater.sleep(1);
		commonOperater.findElementByTextDim(kiosk_paras.btn_cart_SimpleCh).click();
		//commonOperater.findElementByText(kiosk_paras.btn_noThanks_en).click(); --推荐菜单，后台没配数据
		
		//重新下单
		commonOperater.findElementByText(kiosk_paras.btn_StartOver_SimpleCh).click();
		commonOperater.sleep(1);
		commonOperater.findElementByText(kiosk_paras.btn_yes_SimplCh).click();
		commonOperater.sleep(1);
		
	}

}
