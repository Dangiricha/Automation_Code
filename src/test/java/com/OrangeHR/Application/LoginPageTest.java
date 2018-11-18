package com.OrangeHR.Application;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.orangeHR.Page.AdminPage;
import com.orangeHR.Page.AssignLeavepage;
import com.orangeHR.Page.DashboardPage;
import com.orangeHR.Page.DirectoryPage;
import com.orangeHR.Page.LoginPage;
import com.orangeHR.base.TestBase;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	DashboardPage dashpage;
	DirectoryPage dirPage;
	AdminPage adminPage;
	AssignLeavepage aasignPage;
	public LoginPageTest(){
		super();
	}
	
	@BeforeTest
	public void SetUp(){
		Intialization();
	 loginPage = new LoginPage();
		}
	
	@Test(priority=1)
	public void ValidateLoginPageTitle(){
	String title= loginPage.validateLoginPage();	
	Assert.assertEquals(title, "OrangeHRM");
	}
	
	@Test(priority=2)
	public void validateLoginFUnction(){
		dashpage = loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));
	}
	
	@Test(priority=3)
	public void welcomeMessage(){
		String message = dashpage.validateDashpage();
		System.out.println("The welcome message on dashBoard is  "+ message);
	}
	@Test(priority=4)
	public void clickDirTab(){
		dirPage = dashpage.ClickDirectoryTab();
		
	}
	
	@Test(priority=5)
	public void searchFunction(){
		
		dirPage.ValidateSearchFunction("Linda Lein Anderson", "HR Manager", "All");
		if (dirPage.rs.contains("Linda Lein Anderson")&&dirPage.rs.contains("HR Manager") ){
		Assert.assertTrue(true, "the search is displaying the correct record");
		}
		else {
			Assert.fail("No Record found");
		}}
	
	@Test(priority=6)
		public void clickonReset(){
			dirPage.clickReset();
		}
	@Test(priority=7)
	public void navToAdminPage(){
		adminPage = dirPage.ClickAdminTab();
		}
	@Test(priority=8)
	public void searchEmpRecord(){
		adminPage.SearchEmp("hannah.flores", "ESS", "Hannah Flores", "Enabled");
		}
	
	@Test(priority=9)
	public void clickOnSearchedRecord(){
		adminPage.clickRecord();
	}
	@Test(priority =10)
	public void resetRec() throws InterruptedException{
		adminPage.resetRecord();
	}
	
	@Test(priority =11)
	public void goToAssignPage() throws InterruptedException{
		aasignPage =	adminPage.clickAssigntab();
	}
	@AfterTest
	public void TearDown(){
		driver.quit();
	}

}
