package seleniumPractice;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest_DemoWebShop {

	
		@Test
		public void loginTestCheck() {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize(); 
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
			
			driver.get("http://demowebshop.tricentis.com/"); 
			
			driver.findElement(By.linkText("Log in")).click();
			
			
			driver.findElement(By.id("Email")).sendKeys("john.kenn@gmail.com");
			driver.findElement(By.name("Password")).sendKeys("john1234");
			
			driver.findElement(By.xpath("//input[@type='submit' and @value = 'Log in']")).click();
			
			
			String accountName = driver.findElement(By.xpath("//div[@class='header-links']//a[@href='/customer/info']")).getText();
			
//			if(accountName.equals("john.kenn@gmail.com")) {
//				System.out.println("Test Case passed");
//			} else {
//				System.out.println("Test case failed");
//			}
		
			//Hard Assert
//			Assert.assertEquals(accountName, "john.kenn@gmail.com", "Account Names are not matching");


			//SoftAssert
			SoftAssert softObj= new SoftAssert();
			softObj.assertEquals(accountName, "dem3@dem3.com1", "Account Names are not matching");
			driver.close();
		}
	}