package com.orangeHR.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.orangeHR.utils.TestUtil;

public class TestBase {
public	static WebDriver driver;
public	 static Properties prop;
	
	public TestBase(){
		try{
		prop = new Properties();
		
		//File src = new File("./config.properties");
		FileInputStream fis = new  FileInputStream("/Users/Riaan/Documents/workspaces/SeleniumProject/src/main/java/com/orangeHR/config/config.properties");
		
		prop.load(fis);
		}catch(FileNotFoundException e){
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
		public static void Intialization(){
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "/Users/Riaan/Documents/selenium-java-3/chromedriver");
			driver = new ChromeDriver();
		}else if (browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "/Users/Riaan/Documents/selenium-java-3/geckodriver");
			driver = new FirefoxDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_WAIT, TimeUnit.SECONDS);
		
		
		driver.get(prop.getProperty("url"));
	}
	
	
	

}
