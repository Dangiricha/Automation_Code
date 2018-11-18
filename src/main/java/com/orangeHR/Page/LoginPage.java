package com.orangeHR.Page;

import java.io.File;
import java.io.FileInputStream;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangeHR.base.TestBase;
import com.orangeHR.utils.TestUtil;

public class LoginPage  extends TestBase{
	
	@FindBy(id ="txtUsername" )
	WebElement username;
	
	@FindBy(id ="txtPassword" )
	WebElement password;
	
	@FindBy(css ="[name='Submit']" )
	WebElement loginButton;
	
	
	
	
		//By username =By.id("txtUsername");
		//By password= By.id("txtPassword");
		//By loginButton = By.cssSelector("[name='Submit']");
	
		
		public LoginPage()
		{
		PageFactory.initElements(driver, this);	
		}
		
		
		public String validateLoginPage(){
			return driver.getTitle();
		}
//	public void typeUserName(String uid){
//		driver.findElement(username).sendKeys(prop.getProperty("url"));
//	}
//
//	public void typePassword(String pass){
//		driver.findElement(password).sendKeys(pass);
//	}
//
//	public void clickOnLoginButton(){
//		driver.findElement(loginButton).click();;
	//}
		
		public DashboardPage login (String un, String pswd){
			username.sendKeys(un);	
			password.sendKeys(pswd);
			loginButton.click();
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_WAIT, TimeUnit.SECONDS);
			return new DashboardPage();
		}
	}



