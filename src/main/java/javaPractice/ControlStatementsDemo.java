package javaPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ControlStatementsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		String browser = "FF";
		if(browser.equals("chrome")) {
			driver = new FirefoxDriver();
			
		}else if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}else {
			System.out.println("nbdshh");
			System.exit(0);
		}
//		switch(browser) {
//		
//		
//		}
	}

}
