package com.inetbanking.testCases;

import com.inetbanking.utilities.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.*;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass 
{
	
	ReadConfig readconfig = new ReadConfig();
	
public String baseURL=readconfig.getApplicationURL();
public String username=readconfig.getUsername();
public String pwd=readconfig.getPassword();

public static WebDriver driver;
//Logger logger = LogManager.getLogger(BaseClass.class);
//
public static Logger log = LogManager.getLogger(BaseClass.class);

@Parameters("browser")
@BeforeClass
public void setup(String br)
{
	 
	if(br.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		driver=new ChromeDriver();
		log.info("opening chrome");
	}
	else if(br.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
		driver = new FirefoxDriver();
	}
	else if(br.equals("ie"))
	{
		System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
		driver = new InternetExplorerDriver();
	}
	
	else if(br.equals("edge"))
	{
		System.setProperty("webdriver.edge.driver",readconfig.getEdgePath());
		driver = new EdgeDriver();
	}
	driver.get(baseURL);
}

@AfterClass
public void tearDown()
{
driver.quit();	
}

public void captureScreen(WebDriver driver, String tname) throws IOException
{
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
	FileUtils.copyFile(source, target);
	System.out.println("Screenshot taken");
}

public String randomestring()
{
	String generatedstring=RandomStringUtils.randomAlphabetic(8);
	return(generatedstring);
}

public static String randomeNum() {
	String generatedString2 = RandomStringUtils.randomNumeric(4);
	return (generatedString2);
}


}
