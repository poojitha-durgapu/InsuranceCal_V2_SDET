package SeleniumExc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateRegister {

	@Test
	public void RegisterConfirmCheck() {
		WebDriverManager.chromedriver().setup();  
		WebDriver driver = new ChromeDriver(); 
		driver.get("http://services.smartbear.com/samples/TestComplete14/smartstore/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@class=\"menubar-link\"]//span[text()='Log in']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.xpath("//input[@id='gender-male']")).click();
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("John");
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Hauge");
		driver.findElement(By.xpath("//select[@name='DateOfBirthDay']/option[text() = '13']")).click();
		driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']/option[text() = 'August']")).click();
		driver.findElement(By.xpath("//select[@name='DateOfBirthYear']/option[text() = '1989']")).click();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("john.hauge8@gmail.com");
		driver.findElement(By.xpath("//input[@id='Username']")).sendKeys("John888");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("john1234");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("john1234");
		driver.findElement(By.xpath("//input[@id='Company']")).sendKeys("Company1");
		driver.findElement(By.xpath("//input[@name='Newsletter']")).click();
		driver.findElement(By.xpath("//button[@type='submit' and @name='register-button']")).click();
		String RegistrationMsg = driver.findElement(By.xpath("//p[@class='section-body']")).getText();
		SoftAssert softAssertObj = new SoftAssert();
		softAssertObj.assertEquals(RegistrationMsg, "Your registration completed","Sorry! Registration msg is not matching");
		driver.findElement(By.linkText("Continue")).click();
		driver.close();
	}

}
