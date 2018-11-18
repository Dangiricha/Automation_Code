package com.orangeHR.Page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangeHR.base.TestBase;
import com.orangeHR.utils.TestUtil;

public class DashboardPage extends TestBase {

	
	@FindBy(id= "welcome")
	WebElement name;
	@FindBy(id="menu_directory_viewDirectory")
	WebElement directoryTab;
	
	public DashboardPage()
	{
	PageFactory.initElements(driver, this);	
	}
	
	public String validateDashpage(){
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_WAIT, TimeUnit.SECONDS);
	return name.getText();
	
	}
	public DirectoryPage ClickDirectoryTab(){
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_WAIT, TimeUnit.SECONDS);
		directoryTab.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_WAIT, TimeUnit.SECONDS);
		return new DirectoryPage();
	}
	
}
