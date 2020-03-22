package SeleniumExc;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicTable {
	String searchName = "R. Davidson";
	WebDriver driver = null;
	@Test 
	public void dynTableTesting() throws Exception {
		WebDriverManager.chromedriver().setup();  
		driver = new ChromeDriver();
		
		driver.get("http://demo.automationtalks.com/SE-ESY/www.AutomationTalks.com/test/table-sort-search-demo.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//static data
		//finding age of A. Ramos
		String ageOfRamos = driver.findElement(By.xpath("//table[@id='example']//tbody//td[text()= 'A. Ramos']/following-sibling::td[3]")).getText();	
		System.out.println(ageOfRamos);
		
		//Dynamic searching based on nextButton
		boolean searchFlag = true;
		String classNameOfNextBtn = driver.findElement(By.id("example_next")).getAttribute("class");

		while(!classNameOfNextBtn.contains("disabled")) {
			List<WebElement> rows = driver.findElements(By.xpath("//table[@id='example']//tbody/tr"));
			int rowCount = rows.size();

			for (int i=1; i<rowCount+1; i++) {
				List<WebElement> tdata = driver.findElements(By.xpath("//table[@id='example']//tbody/tr["+i+"]/td"));
				String eachRowName= tdata.get(0).getText();

				if (eachRowName.equals(searchName)) {
					String ageOFSearchedName = tdata.get(3).getText();

		    		System.out.println("Age of "+searchName+" is :"+ageOFSearchedName);
		    		searchFlag = false;
		    		break;
				} else {
					System.out.println("not matching");
				}
			}
			if (searchFlag) {
				driver.findElement(By.id("example_next")).click();
				classNameOfNextBtn = driver.findElement(By.id("example_next")).getAttribute("class");
			} else {
				break;
			}
		}
	}
	@AfterClass
	public void quitDriver() throws Exception {
		Thread.sleep(3000);
		driver.close();
	}
}