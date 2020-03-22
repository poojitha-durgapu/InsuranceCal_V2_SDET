package SeleniumExc;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateEndToEndTest {
	WebDriver driver = null;
	String expdashboardPageTitle = "qdPM | Dashboard";
	String expProjectsOption = "Projects";
	String expTasksOption = "Tasks";
	String expTicketsOption = "Tickets";
	String expDiscussionsOption = "Discussions";
	String expReportsOption = "Reports";
	String expUsersOption = "Users";
	String expConfigurationsOption = "Configuration";
	String expToolsOption = "Tools";
	String expqdPMExtendedOption = "qdPM Extended";
	String assignedToStr = "developer;manager";
	String createdBy = "manager";
	String statusValue = "Lost";
	String expLoginPageTitle = "qdPM | Login";
	String hello = "Issue;Poojitha;Lost;developer;11;03/03/2020";
	
	public void sendingKeys(WebElement ele, String value) {
		ele.sendKeys(value);
	}
	public void comparingThroughAssert(String actualValue, String expectedValue) {
		 SoftAssert softAssertObj = new SoftAssert();
		 softAssertObj.assertEquals(actualValue, expectedValue,"Sorry!"+expectedValue+"'s Title is not matching");
	}
	private void selectOption(WebElement el, String value) {
		Select selectObj = new Select(el);
		selectObj.selectByVisibleText(value);
	}
   //Step 1	
	public void driverSetup() {
		WebDriverManager.chromedriver().setup();  
		driver = new ChromeDriver(); 
		driver.get("http://qdpm.net/demo/v9/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
   //Step 2	
	@Test(description = "login with credentials",priority = 1)
	public void loginTest() {
		driverSetup();
		WebElement email = driver.findElement(By.name("login[email]"));
		sendingKeys(email,"administrator@localhost.com");
		WebElement password =driver.findElement(By.name("login[password]"));
		sendingKeys(password,"administrator");
		driver.findElement(By.xpath("//div[@class='form-actions']//button[text()='Login ']")).click();
	}
   //Step 3
	@Test(description = "verifying dashboard title",priority = 2)
	public void verifyDashboardTitle() {
		String dashboardPageTitle =driver.getTitle();
        SoftAssert softAssertObj = new SoftAssert();
		softAssertObj.assertEquals(dashboardPageTitle, expdashboardPageTitle,"Sorry! Dashboard Page Title is not matching");
	}
	//Step 4
	@Test(description = "verifying all options",priority = 3)
	public void verifyAllOptions() {
		String projectOption = driver.findElement(By.xpath("//a[@href='/demo/v9/index.php/projects']/span[@class='title']")).getText();
		comparingThroughAssert(projectOption,expProjectsOption);
		String taskOption = driver.findElement(By.xpath("//a[@href='/demo/v9/index.php/tasks']/span[@class='title']")).getText();
		comparingThroughAssert(taskOption,expTasksOption);
		String ticketOption = driver.findElement(By.xpath("//a[@href='/demo/v9/index.php/tickets']/span[@class='title']")).getText();
		comparingThroughAssert(ticketOption,expTicketsOption);
		String discussionOption = driver.findElement(By.xpath("//a[@href='/demo/v9/index.php/discussions']/span[@class='title']")).getText();
		comparingThroughAssert(discussionOption,expDiscussionsOption);
		String reportOption = driver.findElement(By.xpath("//a[@href='/demo/v9/index.php/projectsReports']/span[@class='title']")).getText();
		comparingThroughAssert(reportOption,expReportsOption);
		String userOption = driver.findElement(By.xpath("//a[@href='/demo/v9/index.php/users']/span[@class='title']")).getText();
		comparingThroughAssert(userOption,expUsersOption);
		String configurationOption = driver.findElement(By.xpath("//a[@href='/demo/v9/index.php/configuration']/span[@class='title']")).getText();
		comparingThroughAssert(configurationOption,expConfigurationsOption);
		String toolOption = driver.findElement(By.xpath("//a[@href='/demo/v9/index.php/tools/backup']/span[@class='title']")).getText();
		comparingThroughAssert(toolOption,expToolsOption);
		String pqdPMExtendedOption = driver.findElement(By.xpath("//a[@href='http://qdpm-ex.com/']/span[@class='title']")).getText();
		comparingThroughAssert(pqdPMExtendedOption,expqdPMExtendedOption);
		
	}
	//Step 5,6,7
	@Test(description = "Add task button,Selecting Test Project1 and entering data",priority = 4)
	public void addTaskAndGeneralTab() {
		driver.findElement(By.xpath("//button[text()='Add Task']")).click();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ajax-modal")));
		WebElement projectOption = driver.findElement(By.id("form_projects_id"));
		selectOption(projectOption,"Test Project 1");
		WebElement typeOption = driver.findElement(By.xpath("//label[text()='Type']/parent::label/following-sibling::div/select"));
		selectOption(typeOption,"Defects (Hourly rate $0.00)");
		WebElement nameField = driver.findElement(By.xpath("//label[text()='Name']/parent::label/following-sibling::div/input"));
		sendingKeys(nameField,"Poojitha");
		driver.findElement(By.xpath("//select[@id='tasks_tasks_status_id']/optgroup[@label='closed']/option[text()='"+statusValue+"']")).click();
		WebElement priorityOption = driver.findElement(By.xpath("//label[text()='Priority']/parent::label/following-sibling::div/select"));
		selectOption(priorityOption,"Low");
		WebElement labelOption = driver.findElement(By.xpath("//label[text()='Label']/parent::label/following-sibling::div/select"));
		selectOption(labelOption,"Issue");
		String[] assignedToArray = assignedToStr.split(";");
		for(String str: assignedToArray) {
			driver.findElement(By.xpath("//label[text()='Assigned to']/parent::label/following-sibling::div//label[text()='"+str+"']")).click();
		}
		driver.findElement(By.xpath("//select[@id='tasks_created_by']/optgroup[@label='Manager']/option[text()='"+createdBy+"']")).click();
	}
	//Step 8
	@Test(description = "Switching to Time tab and entering Data",dependsOnMethods= "addTaskAndGeneralTab",priority = 5)
	public void timeTabData() {
		driver.findElement(By.xpath("//a[text()='Time']")).click();
		WebElement estimatedTimeField = driver.findElement(By.xpath("//label[text()='Estimated Time']/parent::label/following-sibling::div/input"));
		sendingKeys(estimatedTimeField,"11");
		WebElement startDateField = driver.findElement(By.xpath("//input[@name='tasks[start_date]']"));
		sendingKeys(startDateField,"2019-12-27");
		WebElement endDateField = driver.findElement(By.xpath("//input[@name='tasks[due_date]']"));
		sendingKeys(endDateField,"2019-12-31");
		WebElement progressOption = driver.findElement(By.id("tasks_progress"));
		selectOption(progressOption,"20%");
//		driver.findElement(By.xpath("//div[@id='form_container']")).click();
		
	}
	//Step 9
	@Test(description = "Switching to Attachments tab and entering Data",priority = 6)
	public void attachmentsTabDataAndSave() {
//		driver.findElement(By.xpath("//a[text()='Attachments']")).click();
//		WebElement addAttchments = driver.findElement(By.xpath("//div[@id='uploadifive-uploadify_file_upload']//input[2]"));
//		String file = "/Users/poojitha/Desktop/SASS.docx";
//		sendingKeys(addAttchments,file);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
//		try {
//
//			driver.findElement(By.xpath("//button[text()='Save']")).click();
//
//		} catch (UnhandledAlertException f) {
//
//		    try {
//
//		        Alert alert = driver.switchTo().alert();
//
//		        String alertText = alert.getText();
//
//		        System.out.println("Alert data: " + alertText);
//
//		        alert.accept();
//
//		    } catch (NoAlertPresentException e) {
//
//		        e.printStackTrace();
//
//		    }
//
//		}
		
	}
//	Step 10,11
	@Test(description = "logging Off",priority = 7,dependsOnMethods="attachmentsTabDataAndSave")
	public void logOutAppAndVerifyPageTitle() {
		driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li[last()]")).click();
		String loginPageTitle =driver.getTitle();
		comparingThroughAssert(loginPageTitle,expLoginPageTitle);	
	}
//	Step 12,13,14,15
	@Test(description = "loggin Again",priority = 8)
	public void logInAgainAndClickTasks() {
		loginTest();
		driver.findElement(By.xpath("//ul[@class='page-sidebar-menu']//i[@class='fa fa-tasks']/following-sibling::span[text()='Tasks']")).click();
		driver.findElement(By.xpath("//ul[@class='sub-menu']//a[@href='/demo/v9/index.php/tasks']/child::span")).click();
		WebElement searchBox = driver.findElement(By.id("search_menu"));
		Actions act = new Actions(driver);
		act.moveToElement(searchBox).perform();
		WebElement searchInput = driver.findElement(By.id("search_keywords"));
		sendingKeys(searchInput,"Poojitha");
		driver.findElement(By.xpath("//form[@action='/demo/v9/index.php/tasks']//input[@value='Search']")).click();
	}
	//Step 16
	@Test(description="verify the data from table",priority = 9)
	public void verifyTableData() {
		int noOfCloumns = driver.findElements(By.xpath("//table[@id='itmes_listing_1706794']//tbody/tr/td")).size();
		String part1 = "//table[@id='itmes_listing_1706794']//tbody[@role='alert']//td[";
		String part3 = "]";
		for(int i=4;i<noOfCloumns;i++) {
			String finalPath = part1+i+part3;
			String value = driver.findElement(By.xpath(finalPath)).getText();
			System.out.println(value);
		}
		
//		List<WebElement> data = driver.findElements(By.xpath("//table[@id='itmes_listing_1706794']//tbody/tr/td"));
//		String[] valuesInTableArray = hello.split(";");
//		for(int i =4; i<10;i++) {
//			String valueInTable= driver.findElement(By.xpath("//table[@id='itmes_listing_1706794']//tbody[@role='alert']//td["+i+"]")).getText();
//			comparingThroughAssert(valueInTable,"Issue");
//		}
//		String labelInTable = driver.findElement(By.xpath("//table[@id='itmes_listing_1706794']//tbody[@role='alert']//td[4]")).getText();
//		comparingThroughAssert(labelInTable,"Issue");
//		String nameInTable = driver.findElement(By.xpath("//table[@id='itmes_listing_1706794']//tbody[@role='alert']//td[5]")).getText();
//		comparingThroughAssert(nameInTable,"Poojitha");
//		String statusTable = driver.findElement(By.xpath("//table[@id='itmes_listing_1706794']//tbody[@role='alert']//td[6]")).getText();
//		comparingThroughAssert(nameInTable,"Poojitha");
		
	}
	

	
		
//	@AfterClass
//	public void quitDriver() throws InterruptedException{
//		Thread.sleep(3000);
//		driver.close();
//	}
	
}
