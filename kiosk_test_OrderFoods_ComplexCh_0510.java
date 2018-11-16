package com.kiosk.testCase;

import org.testng.annotations.Test;

import com.method.commonOperater;

import junit.framework.TestCase;

public class kiosk_test_OrderFoods_ComplexCh_0510 extends TestCase {
	


	
	@Test
	public void test_OrderFoods_en_0510() {
		
		
		//开始点餐
		commonOperater.findElementByText(kiosk_paras.home_menu_complexChinese).click();
		commonOperater.findElementByText(kiosk_paras.ComplexCh_chooseMethod_DineIn).click();;
		commonOperater.sleep(2);
		
		//选择BaikohkenRamen，选择组合方式
		commonOperater.findElementByText(kiosk_paras.Eng_rest_BaikohkenRamen).click();
		commonOperater.sleep(3);
		commonOperater.clickByCoordinate(550, 610);
		commonOperater.sleep(2);
		commonOperater.findElementByText(kiosk_paras.btn_ok_ComplexCh).click();
		
		//选择饮料
		commonOperater.findElementByText(kiosk_paras.Eng_rest_BaikohkenRamen_type_drinks).click();
		commonOperater.sleep(2);
		commonOperater.clickByCoordinate(570, 620);
		commonOperater.sleep(1);
	
		//选择另一加餐馆SchoolFood
		commonOperater.findElementByText(kiosk_paras.btn_Menu_ComplexCh).click();
		commonOperater.sleep(2);
		commonOperater.findElementByText(kiosk_paras.Eng_rest_SchoolFood).click();
		commonOperater.sleep(3);
		commonOperater.clickByCoordinate(550, 610);
		commonOperater.sleep(1);
		commonOperater.findElementByText(kiosk_paras.btn_ok_ComplexCh).click();
		
		//选择配菜
		commonOperater.findElementByText(kiosk_paras.Eng_rest_SchoolFood_type).click();
		commonOperater.sleep(3);
		commonOperater.clickByCoordinate(550, 610);
		commonOperater.sleep(1);
		
		//去支付
		commonOperater.findElementByTextDim(kiosk_paras.btn_cart_ComplexCh).click();
		//commonOperater.findElementByText(kiosk_paras.btn_noThanks_en).click(); --推荐菜单，后台没配数据
		commonOperater.findElementByTextDim(kiosk_paras.btn_pay_ComplexCh).click();
		commonOperater.sleep(1);
		
		//选择信用卡支付
		commonOperater.findElementByText(kiosk_paras.pay_QR_ComplexCh).click();
		commonOperater.sleep(2);
		
		commonOperater.findElementByText(kiosk_paras.result_goHome_ComplexCh).click();
		
	}
	
	
	

}
