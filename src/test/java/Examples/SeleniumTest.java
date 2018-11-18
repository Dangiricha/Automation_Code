package Examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumTest {
	
	
	
	@Test
	public void TestMethod(){
		WebDriver driver;
		System.out.println("*****Remender****"+6%4);
		System.setProperty("webdriver.chrome.driver", "/Users/Riaan/Documents/selenium-java-3/chromedriver");
		
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com");
		
		
	}

}
