package seleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstSeleniumTest {

    //Execution starts from main method
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        //2. Navigate to AUT
        driver.get("http://demo.automationtalks.com/");

        //3. Verify Page Title
        String ExpectedPageTitle = "Fill Vehicle Data";
        //ActualPageTitle???
        String ActualPageTitle = driver.getTitle();
        
        System.out.println(ActualPageTitle); //syso
        
        if(ExpectedPageTitle.equalsIgnoreCase(ActualPageTitle)) {
            System.out.println("Test Case Passed");
        } else {
            System.out.println("Test Case Failed");
        }

        //4. Close Browser
        driver.close();
    }
}
 