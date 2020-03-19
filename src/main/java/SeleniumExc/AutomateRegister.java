package SeleniumExc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateRegister {

	@Test(enabled = true)
	public void RegisterConfirmCheck() {
		WebDriverManager.chromedriver().setup();  
		WebDriver driver = new ChromeDriver(); 
		driver.get("http://services.smartbear.com/samples/TestComplete14/smartstore/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//Clicking on login and then Register
		driver.findElement(By.xpath("//a[@class=\"menubar-link\"]//span[text()='Log in']")).click();
		driver.findElement(By.linkText("Register")).click();
//		driver.findElement(By.xpath("//input[@id='gender-male']")).click();
		String gender = "Male";
		driver.findElement(By.xpath("//label[text()='"+gender+"']")).click();
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("John");
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Hauge");
		//Select boxes for DATE of BIRTH
		WebElement birthDay = driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
		WebElement birthMonth = driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
		WebElement birthYear = driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
		selectionMethod(birthDay,"13");
		selectionMethod(birthMonth,"August");
		selectionMethod(birthYear,"1989");
	
//		driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']/option[text() = 'August']")).click();
//		driver.findElement(By.xpath("//select[@name='DateOfBirthYear']/option[text() = '1989']")).click();
		String emailStr = "Email";
		String usernameStr = "UserName";
		driver.findElement(By.xpath("//label[text()='"+emailStr+"']/following-sibling::div/input")).sendKeys("john.hauge9@gmail.com");
		driver.findElement(By.xpath("//label[text()='"+usernameStr+"']/following-sibling::div/input")).sendKeys("John999");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("john1234");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("john1234");
		driver.findElement(By.xpath("//input[@id='Company']")).sendKeys("Company1");
		//click on CheckBox
		driver.findElement(By.xpath("//input[@name='Newsletter']")).click();
		driver.findElement(By.xpath("//button[@type='submit' and @name='register-button']")).click();
		String RegistrationMsg = driver.findElement(By.xpath("//p[@class='section-body']")).getText();
		SoftAssert softAssertObj = new SoftAssert();
		softAssertObj.assertEquals(RegistrationMsg, "Your registration completed","Sorry! Registration msg is not matching");
		driver.findElement(By.linkText("Continue")).click();
		driver.close();
//		Alert al = driver.switchTo().alert();
	}

	private void selectionMethod(WebElement el, String value) {
		Select selectObj = new Select(el);
		selectObj.selectByVisibleText(value);
	}

}
