package com.orangeHR.Page;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.orangeHR.base.TestBase;
import com.orangeHR.utils.TestUtil;

public class DirectoryPage extends TestBase {
	
	public static String rs;
	
	
	@FindBy(id="searchDirectory_emp_name_empName")
	WebElement enterName;
	
	@FindBy(id="searchBtn")
	WebElement searchButton;
	
	@FindBy(id="searchDirectory_job_title")
	WebElement enterJobTitle;
	
	@FindBy (id= "searchDirectory_location")
	WebElement searchlocation;
	
	@FindBy( id= "resetBtn")
	WebElement reset;
	
	@FindBy(id="resultTable")
WebElement result;	
	
	@FindBy(id= "menu_admin_viewAdminModule")
	WebElement adminTab;
	
	public DirectoryPage()
	{
	PageFactory.initElements(driver, this);	
	}
	
	public void ValidateSearchFunction(String name, String jobTitle, String  loc){
		enterName.sendKeys(name);
		Select select = new Select(enterJobTitle);
		select.selectByVisibleText(jobTitle);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_WAIT, TimeUnit.SECONDS);
		//searchlocation.click();
		Select select2 = new Select(searchlocation);
		select2.selectByVisibleText(loc);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_WAIT, TimeUnit.SECONDS);
		searchButton.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_WAIT, TimeUnit.SECONDS);
		
	 rs = result.getText();
	System.out.println(rs);	
	
	}
	public void clickReset(){
		reset.click();
	}
	public AdminPage ClickAdminTab(){
	
			adminTab.click();
			String txt = adminTab.getText();
			System.out.println(txt);
			return new AdminPage();
			
	}
	
//	WebDriver driver;
//	By directoryTab =By.id("menu_directory_viewDirectory");
//	By enterName = By.id("searchDirectory_emp_name_empName");
//	By searchButton = By.cssSelector("[name='_search']");
//	
//	public DirectoryPage(WebDriver driver)
//	{
//		this.driver = driver;
//		
//	}
//	
//	public void clickOnDirectoryTab(){
//		driver.findElement(directoryTab).click();
//	}
//
//	public void EnterName(String name){
//		driver.findElement(enterName).sendKeys(name);
//	}
//
//	public void clickOnSearchButton(){
//		driver.findElement(searchButton).click();;
//	}


}
