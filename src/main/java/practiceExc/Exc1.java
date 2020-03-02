package practiceExc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exc1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();  
		WebDriver driver = new ChromeDriver(); 
		
		driver.get("http://newtours.demoaut.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		String ExpectedTitle = "Welcome: Mercury Tours";
		String driverUrl = "http://newtours.demoaut.com/index.php";
        String ActualTitle = driver.getTitle();
        String CurrentUrl = driver.getCurrentUrl();
        System.out.println(CurrentUrl);
        
        if(ExpectedTitle.equalsIgnoreCase(ActualTitle) && driverUrl.equals(CurrentUrl)) {
            System.out.println("Page Titles and Current Urls of chrome are correct");
        } else {
            System.out.println("Page Titles and Current Urls of chromeare wrong");
        }
        driver.close();	
        
        WebDriverManager.firefoxdriver().setup();
		WebDriver driver1 = new FirefoxDriver(); 
		driver1.get("http://newtours.demoaut.com/index.php");
		driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
        String ActualTitle1 = driver1.getTitle();
        String CurrentUrl1 = driver1.getCurrentUrl();
        if(ExpectedTitle.equalsIgnoreCase(ActualTitle1) && driverUrl.equals(CurrentUrl1)) {
            System.out.println("Page Titles and Current Urls of firefox are correct");
        } else {
            System.out.println("Page Titles and Current Urls of firefox are wrong");
        }
        driver1.close();	
	}

}
