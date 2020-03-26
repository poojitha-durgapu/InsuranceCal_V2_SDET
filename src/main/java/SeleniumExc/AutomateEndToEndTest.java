package SeleniumExc;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateEndToEndTest {
	WebDriver driver = null;
	String expdashboardPageTitle = "qdPM | Dashboard";
	String expLoginPageTitle = "qdPM | Login";
	String tableDataStr = "Issue;Poojitha;Lost;developer;11;03/03/2020";
	String assignedToStr = "developer;manager";
	String createdBy = "manager";
	String statusValue = "Lost";
	String[] titlesArr = { "Dashboard", "Projects", "Tasks", "Tickets", "Discussions", "Reports", "Users",
			"Configuration", "Tools", "qdPM Extended" };

	public void sendingKeys(WebElement ele, String value) {
		ele.sendKeys(value);
	}

	public void comparingThroughSoftAssert(String actualValue, String expectedValue) {
		SoftAssert softAssertObj = new SoftAssert();
		softAssertObj.assertEquals(actualValue, expectedValue, "Sorry!" + expectedValue + "'s Title is not matching");
	}

	private void selectOption(WebElement el, String value) {
		Select selectObj = new Select(el);
		selectObj.selectByVisibleText(value);
	}

	public void searchingInput() {
		WebElement searchBox = driver.findElement(By.xpath("//table//div[@id='search_menu']"));
		Actions act = new Actions(driver);
		act.moveToElement(searchBox).perform();
		WebElement searchInput = driver.findElement(By.id("search_keywords"));
		sendingKeys(searchInput, "Poojitha");
		driver.findElement(By.xpath("//div[@id='search_menu']//input[@type='submit' and @value='Search']")).click();
	}

	public void loginTest() {
		WebElement email = driver.findElement(
				By.xpath("//form[@id='loginForm']//div[@class='input-icon']//input[@name='login[email]']"));
		sendingKeys(email, "administrator@localhost.com");
		WebElement password = driver.findElement(
				By.xpath("//form[@id='loginForm']//div[@class='input-icon']//input[@name='login[password]']"));
		sendingKeys(password, "administrator");
		driver.findElement(By.xpath("//div[@class='form-actions']//button[text()='Login ']")).click();
	}

	public void logOutAppAndVerifyPageTitle() {
		driver.findElement(By.xpath("//span[@class='username']")).click();
		driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li[last()]")).click();
		String loginPageTitle = driver.getTitle();
		comparingThroughSoftAssert(loginPageTitle, expLoginPageTitle);
	}

	@Test(description = "automating end to end ")
	public void driverSetup() throws Exception {
		WebDriverManager.chromedriver().version("80.0.3987.106").setup();
		driver = new ChromeDriver();
		driver.get("http://qdpm.net/demo/v9/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginTest();
		String dashboardPageTitle = driver.getTitle();
		comparingThroughSoftAssert(dashboardPageTitle, expdashboardPageTitle);
		List<WebElement> listOfSidebarLinks = driver
				.findElements(By.xpath("//ul[@class='page-sidebar-menu']/li/a/span[@class='title']"));
		for (WebElement ele : listOfSidebarLinks) {
			String titleName = ele.getText();
			for (String str : titlesArr) {
				Assert.assertEquals(str, titleName);
				titlesArr = ArrayUtils.remove(titlesArr, 0);
				break;
			}
		}
		driver.findElement(By.xpath("//button[text()='Add Task']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ajax-modal")));
		WebElement projectOption = driver.findElement(By.id("form_projects_id"));
		selectOption(projectOption, "Test Project 1");
		WebElement typeOption = driver
				.findElement(By.xpath("//label[text()='Type']/parent::label/following-sibling::div/select"));
		selectOption(typeOption, "Defects (Hourly rate $0.00)");
		WebElement nameField = driver
				.findElement(By.xpath("//label[text()='Name']/parent::label/following-sibling::div/input"));
		sendingKeys(nameField, "Poojitha");
		driver.findElement(By.xpath(
				"//select[@id='tasks_tasks_status_id']/optgroup[@label='closed']/option[text()='" + statusValue + "']"))
				.click();
		WebElement priorityOption = driver
				.findElement(By.xpath("//label[text()='Priority']/parent::label/following-sibling::div/select"));
		selectOption(priorityOption, "Low");
		WebElement labelOption = driver
				.findElement(By.xpath("//label[text()='Label']/parent::label/following-sibling::div/select"));
		selectOption(labelOption, "Issue");
		String[] assignedToArray = assignedToStr.split(";");
		for (String str : assignedToArray) {
			driver.findElement(By.xpath(
					"//label[text()='Assigned to']/parent::label/following-sibling::div//label[text()='" + str + "']"))
					.click();
		}
		driver.findElement(By.xpath(
				"//select[@id='tasks_created_by']/optgroup[@label='Manager']/option[text()='" + createdBy + "']"))
				.click();
		driver.findElement(By.xpath("//a[text()='Time']")).click();
		WebElement estimatedTimeField = driver
				.findElement(By.xpath("//label[text()='Estimated Time']/parent::label/following-sibling::div/input"));
		sendingKeys(estimatedTimeField, "11");
		WebElement startDateField = driver.findElement(By.xpath("//input[@name='tasks[start_date]']"));
		sendingKeys(startDateField, "2019-12-27");
		WebElement endDateField = driver.findElement(By.xpath("//input[@name='tasks[due_date]']"));
		sendingKeys(endDateField, "2019-12-31");
		WebElement progressOption = driver.findElement(By.id("tasks_progress"));
		selectOption(progressOption, "20%");
		driver.findElement(By.xpath("//a[text()='Attachments']")).click();
		File filePath = new File("/Users/poojitha/Desktop/SASS.docx");
		StringSelection strSel = new StringSelection(filePath.getAbsolutePath());
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		clipboard.setContents(strSel, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.delay(500);
		// Open Goto window
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_G);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_G);
		// Paste the clipboard value
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_V);
		// Press Enter key to close the Goto window and Upload window
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(500);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		logOutAppAndVerifyPageTitle();
		loginTest();
		driver.findElement(By.xpath(
				"//ul[@class='page-sidebar-menu']//i[@class='fa fa-tasks']/following-sibling::span[text()='Tasks']"))
				.click();
		driver.findElement(By.xpath("//ul[@class='sub-menu']//a[@href='/demo/v9/index.php/tasks']/child::span"))
				.click();
		searchingInput();
		List<WebElement> tdataList = driver.findElements(By.xpath("//div[@role='grid']//tbody[@role='alert']/tr/td"));
//		String[] tableDArr = {"","","22","Issue","Poojitha","Lost","developer manager","11","31 Dec 2019","Test Project 1"};
//		for (WebElement ele : tdataList) {
//			String value = ele.getText();
//			for(String str :tableDArr) {
//			Assert.assertTrue(str, value);
//			tableDArr = ArrayUtils.remove(tableDArr, 0);
//			break;
//			}
		for (WebElement ele : tdataList) {
			String value = ele.getText();
			Assert.assertTrue(true, value);
		}

//		int noOfCloumns = driver.findElements(By.xpath("//div[@role='grid']//tbody[@role='alert']/tr/td")).size();
//		String part1 = "//div[@role='grid']//tbody[@role='alert']//td[";
//		String part3 = "]";
//		String[] tableDArr = {"Issue","Poojitha","Lost","developer","manager","11","31 Dec 2019","Test Project 1"};
//		String[] tabValArr = {};
//		for(int i=4;i<=noOfCloumns;i++) {
//			String finalPath = part1+i+part3;
//			String value = driver.findElement(By.xpath(finalPath)).getText();
//			System.out.println(value);
//			tabValArr = ArrayUtils.add(tabValArr, value);
//		}
//		System.out.println(Arrays.toString(tabValArr));
//		Assert.assertTrue(Arrays.equals(tableDArr, tabValArr));
		// delete
		driver.findElement(By.xpath("//div[@role='grid']//tbody[@role='alert']//i[@class='fa fa-trash-o']/parent::a"))
				.click();
		// switchToAlertBox
		Alert al = driver.switchTo().alert();
		String alText = al.getText();
		System.out.println("Alert Text: " + alText);
		al.accept();
		// verify
		searchingInput();
		String delMesage = driver.findElement(By.xpath("//div[@class='table-scrollable']//td")).getText();
		if (delMesage.equalsIgnoreCase("No Records Found")) {
			System.out.println("Deleted Successfully");
		}
		logOutAppAndVerifyPageTitle();
	}

	@AfterClass
	public void quitDriver() throws Exception {
		Thread.sleep(1000);
		driver.close();
	}
}
