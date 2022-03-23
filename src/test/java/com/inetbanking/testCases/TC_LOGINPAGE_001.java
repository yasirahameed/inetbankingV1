package com.inetbanking.testCases;


import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.loginPage;

public class TC_LOGINPAGE_001 extends BaseClass {
	
	@Test
	public void loginTest() throws IOException
	{
					
		loginPage lp=new loginPage(driver);
		lp.setUserName(username);
		lp.setPassword(pwd);
		
		lp.clickSubmit();
		log.debug("Sample DEBUG message");
        log.error("Sample ERROR message");
        log.info("Sample INFO message");
        log.warn("Sample WARN message");
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			
			Assert.assertTrue(true);
			
		}
		else
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			log.info("Login Test failed");
		}
	}
}
