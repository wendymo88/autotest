package com.kiosk.testCase;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.method.commonOperater;

public class kiosk_paras {

	//----device infos----//
	public static String deviceName="4DVRLHEK91";
	public static String platformVersion="6.0.1";
	public static String platformName="android";
	public static boolean noReset=true;
	
	//----app infos-----//
	public static String appName="kiosk.apk";
	public static String appPackage="com.rn_kiosk";
	public static String appActivity="com.rn_kiosk.MainActivity";
	
	//---other infos----//
	public static String automationName="Appium";
	
	
	//---Home page infos----//
	public static String home_menu_simpleChinese="自助点餐";
	public static String home_menu_complexChinese="自助點餐";
	public static String home_menu_English="START ORDERING";
	
	//---choose Predurement method page infos----//
	public static String Eng_chooseMethod_DineIn="Dine In";
	public static String Eng_chooseMethod_TakeAway="Take Away";
	public static String SimpleCh_chooseMethod_DineIn="堂食";
	public static String SimpleCh_chooseMethod_TakeAway="打包";
	public static String ComplexCh_chooseMethod_DineIn="堂食";
	public static String ComplexCh_chooseMethod_TakeAway="打包";
	
	

	
	//---restaurants page infos----//
	public static String Eng_rest_BurgerKing="Burger King";
	public static String Eng_rest_BurgerKing_type_combo="Combo";
	public static String Eng_rest_BurgerKing_type_drinks="Drinks";
	public static String Eng_rest_BurgerKing_type_Add_on="Add-on";
	
	public static String Eng_rest_BaikohkenRamen="Baikohken Ramen";
	public static String Eng_rest_BaikohkenRamen_type_combo="NEW";
	public static String Eng_rest_BaikohkenRamen_type_drinks="Drinks";
	
	
	public static String Eng_rest_SchoolFood="School Food";
	public static String Eng_rest_SchoolFood_type="Blooming Mari";
	
	
	
	
	//---pay page infos----//
	public static String pay_creditCard_en="Credit Card";
	public static String pay_Octopus_en="Octopus";
	public static String pay_QR_en="UnionPay Quick Pass / Alipay / Wechat Pay";
	
	public static String pay_creditCard_SimpleCh="Credit Card";
	public static String pay_Octopus_SimpleCh="Octopus";
	public static String pay_QR_SimpleCh="UnionPay Quick Pass / Alipay / Wechat Pay";
	
	public static String pay_creditCard_ComplexCh="Credit Card";
	public static String pay_Octopus_ComplexCh="Octopus";
	public static String pay_QR_ComplexCh="UnionPay Quick Pass / Alipay / Wechat Pay";
	
	
	//---result page infos ---//
	public static String result_goHome_en="Back to Home Now";
	public static String result_goHome_SimpleCh="返回首頁";
	public static String result_goHome_ComplexCh="返回首页";
	
	
	//Start Over
	public static String btn_StartOver_en="Start Over";
	public static String btn_StartOver_SimpleCh="重新下单";
	public static String btn_StartOver_ComplexCh="重新落單";
	
	
	//CART  DIM
	public static String btn_cart_en="CART (";
	public static String btn_cart_SimpleCh="购物车";
	public static String btn_cart_ComplexCh="購物車";

	//PAY  DIM
	public static String btn_pay_en="PAY NOW";
	public static String btn_pay_SimpleCh="支付";
	public static String btn_pay_ComplexCh="支付";
	
	//tips
	public static String btn_noThanks_en="No, Thanks";
	public static String btn_yes_en="Yes";
	public static String btn_ok_en="OK";
	public static String btn_no_en="No";
	
	//？？？？
	public static String btn_noThanks_SimplCh="不，谢谢！";
	public static String btn_yes_SimplCh="好的";
	public static String btn_ok_SimplCh="好的";
	public static String btn_no_eSimplCh="不";
	public static String btn_noThanks_ComplexCh="不，謝謝！";
	public static String btn_yes_ComplexCh="好的";
	public static String btn_ok_ComplexCh="好的";
	public static String btn_no_ComplexCh="不";
	
	
	//Menu
	public static String btn_Menu_en="Menu";
	public static String btn_Menu_SimpleCh="菜单";
	public static String btn_Menu_ComplexCh="菜單";
	
	//Back
	public static String btn_Back_en="Back";
	public static String btn_Back_SimpleCh="返回";
	public static String btn_Back_ComplexCh="返回";
	
	//tips conent
	public static String tips_noAction_en="Do you want to continue";
	public static String tips_cartEmpty_en="Please choose at least 1 item.";
	public static String tips_startOver_en="";
	
	public static String tips_noAction_SimpleCh="Do you want to continue";
	public static String tips_cartEmpty_SimpleCh="Please choose at least 1 item.";
	public static String tips_startOver_SimleCh="";
	public static String tips_noAction_ComplexCh="Do you want to continue";
	public static String tips_cartEmpty_CompleCh="Please choose at least 1 item.";
	public static String tips_startOver_ComplexCh="";
	
	//max sleep time
    public static int maxSleepTime=30;
	
	
	//config params
	public static DesiredCapabilities getCaps() {
		DesiredCapabilities capabilities=new DesiredCapabilities();
    	capabilities.setCapability("platformName", kiosk_paras.platformName);// 设备平台
        capabilities.setCapability("deviceName", kiosk_paras.deviceName );// 设备名称
        capabilities.setCapability("platformVersion", kiosk_paras.platformVersion);// 版本
        capabilities.setCapability("automationName",kiosk_paras.automationName); 
        capabilities.setCapability("appPackage", kiosk_paras.appPackage);
        capabilities.setCapability("appActivity",kiosk_paras.appActivity);
        capabilities.setCapability("app",commonOperater.getAPKPath(kiosk_paras.appName));
        capabilities.setCapability("noReset",kiosk_paras.noReset);
		return capabilities;
		
	}
	
}
