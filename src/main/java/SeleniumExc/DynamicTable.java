package SeleniumExc;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicTable {
	String searchName = "R. Davidson";
	@Test 
	public void dynTableTesting() throws Exception {
		WebDriverManager.chromedriver().setup();  
		WebDriver driver = new ChromeDriver(); 
		driver.get("http://demo.automationtalks.com/SE-ESY/www.AutomationTalks.com/test/table-sort-search-demo.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//finding age of A. Ramos
		String ageOfRamos = driver.findElement(By.xpath("//table[@id='example']//tbody//td[text()= 'A. Ramos']/following-sibling::td[3]")).getText();	
		System.out.println(ageOfRamos);
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='example']//tbody/tr"));
    	
//    	enabled
    	WebElement nextButton = driver.findElement(By.xpath("//a[not(contains(@class,'disabled')) and text()='Next']"));
		System.out.println(nextButton);
			//the element is present
		while(nextButton!=null) {
			List<WebElement> dataForRow = driver.findElements(By.xpath("//table[@id='example']//tbody/tr/td[1]"));
			System.out.println(nextButton!=null);
			for(WebElement ele : dataForRow) {
//		if(nextButton!=null) {
			if(ele.getText().equals(searchName)) {
	    		String ageOFDavidson = driver.findElement(By.xpath("//table[@id='example']//tbody//td[text()='"+searchName+"']/following-sibling::td[3]")).getText();
	    		System.out.println(ageOFDavidson);
			}else {
				driver.findElement(By.id("example_next")).click();
				
			}
			continue;
		 }
		}
	
//		
//    	for(WebElement ele : dataForRow) {
//    			WebElement nextButton1 = driver.findElement(By.xpath("//a[contains(@class,'disabled') and text()='Next']"));
//    			System.out.println(nextButton1);
////    			to check element is present
//    			while(nextButton==null) {
//	    		if(ele.getText().equals(searchName)) {
//		    		String ageOFDavidson = driver.findElement(By.xpath("//table[@id='example']//tbody//td[text()='"+searchName+"']/following-sibling::td[3]")).getText();
//		    		System.out.println(ageOFDavidson);
//		    		
//		    	}else {
//		    		System.out.println("Not Found");
//		    		driver.findElement(By.id("example_next")).click();
//		    		
//		    	}
//	    	}
//	    	
//	    }

	}
}
