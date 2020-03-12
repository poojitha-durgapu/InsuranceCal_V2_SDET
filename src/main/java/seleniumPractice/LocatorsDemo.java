package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        driver.get("http://demo.automationtalks.com/");
	        driver.manage().window().maximize();
	        WebElement cylCap = driver.findElement(By.id("cylindercapacity"));
	        cylCap.sendKeys("333");
	}

}
