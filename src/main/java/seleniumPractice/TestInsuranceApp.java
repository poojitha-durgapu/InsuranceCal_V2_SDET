package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestInsuranceApp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();  //setup driver executables
		WebDriver driver = new ChromeDriver(); // launch chrome driver
		driver.get("http://demo.automationtalks.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		
		driver.findElement(By.id("nav_truck")).click();
		Thread.sleep(5000);
		
		driver.navigate().back();
		Thread.sleep(5000);
		
		driver.navigate().forward();
		Thread.sleep(5000);
	
		
		
		
	}

}
