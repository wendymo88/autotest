package com.kiosk.testCase;

import java.net.MalformedURLException;
import org.testng.annotations.*;

import com.method.commonOperater;

import junit.framework.TestCase;

public class kiosk_start   extends TestCase {
	
	
	
	
	@Test
	public void test() throws MalformedURLException  {
	
		commonOperater.initEnv(kiosk_paras.getCaps());
		System.out.println("--------start ok----------");
	
	}
	
	

	

}
