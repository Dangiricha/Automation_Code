package com.orangeHR.Page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.orangeHR.base.TestBase;
import com.orangeHR.utils.TestUtil;

public class AdminPage extends TestBase{
	
	@FindBy(id= "searchSystemUser_userName")
	WebElement sysUserName;
	
	@FindBy(name= "searchSystemUser[userType]")
	WebElement sysUserRole;
	
	@FindBy(name= "searchSystemUser[employeeName][empName]")
	WebElement empName;
	
	@FindBy(name= "searchSystemUser[status]")
	WebElement status;
	
	//_search  _reset
	@FindBy(name= "_search")
	WebElement btnSearch;
	
	@FindBy(name= "_reset")
	WebElement btnReset;
	
	
 @FindBy(id="ohrmList_chkSelectRecord_3")
 WebElement searchedRecord;
	
 @FindBy (id= "btnAdd")
 WebElement addButton;
 
 @FindBy (id= "menu_leave_viewLeaveModule")
 WebElement leavetab;
 
 @FindBy (id= "menu_leave_assignLeave")
 WebElement assignLeavetab;
 
	public AdminPage()
	{
	PageFactory.initElements(driver, this);	
	}
	
	public void SearchEmp(String usname, String usRole, String ename, String s ){
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_WAIT, TimeUnit.SECONDS);
		sysUserName.sendKeys(usname);
		Select select1 = new Select(sysUserRole);
		select1.selectByVisibleText(usRole);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_WAIT, TimeUnit.SECONDS);
		empName.sendKeys(ename);
		
		Select select2 = new Select(status);
		select2.selectByVisibleText(s);
		btnSearch.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_WAIT, TimeUnit.SECONDS);
	}
	
	public void clickRecord(){
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_WAIT, TimeUnit.SECONDS);
		searchedRecord.click();
	}
	
	public void resetRecord() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_WAIT, TimeUnit.SECONDS);
		if(!btnReset.isSelected()){
			btnReset.click();
			Thread.sleep(2000);
			addButton.click();
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_WAIT, TimeUnit.SECONDS);
		}
		
	}
	
	public AssignLeavepage clickAssigntab() throws InterruptedException{
		Actions action = new Actions(driver);
		action.moveToElement(leavetab).build().perform();
		Thread.sleep(3000);
		assignLeavetab.click();
		return new AssignLeavepage();
	}
}
