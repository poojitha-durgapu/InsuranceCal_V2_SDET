package SeleniumExc;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumExc2 {
	String enginePerformStr = "Engine Performance [kW]";
	String listPriceStr = "List Price [$]";
	String licensePlateStr = "License Plate Number";
	String annualMileageStr = "Annual Mileage [mi]";
	String expFillInsurantDTitleStr = "Fill Insurant Data";
	String fillProductDTitleStr = "Fill Product Data";
	String choosePriceTitleStr = "Choose Price Option";
	String dateOfManStr = "Date of Manufacture";
	String gender = "Female";
	String cylCapStr = "Cylinder Capacity [ccm]";
	String rightHandYesStr = "Yes";
	String rightHnadNoStr = "No";
	String payloadStr = "Payload [kg]";
	String weightStr = "Total Weight [kg]";
    String hobbies = "Speeding;Cliff Diving;Skydiving";
    String optionalProducts = "Euro Protection";
    String sendQuotPageTitleStr = "Send Quotation";
	
	@Test
	public void VehicleTesting() throws Exception {
		WebDriverManager.chromedriver().setup();  
		WebDriver driver = new ChromeDriver(); 
		driver.get("http://demo.automationtalks.com/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
//		Fill vehicle Data
		WebElement makeOption = driver.findElement(By.id("make"));
		selectOption(makeOption,"Audi");
		WebElement modelOption = driver.findElement(By.id("model"));
		selectOption(modelOption,"Motorcycle");
		WebElement cylinderCapacityEle = driver.findElement(By.xpath(inputField(cylCapStr)));
		sendingKeys(cylinderCapacityEle,"1200");
		WebElement enginePerformEle = driver.findElement(By.xpath(inputField(enginePerformStr)));
		sendingKeys(enginePerformEle,"1300");
		WebElement dateOfManEle = driver.findElement(By.xpath(inputField(dateOfManStr)));
		sendingKeys(dateOfManEle,"03/22/1886");
		WebElement NoOfSeatsOption = driver.findElement(By.id("numberofseats"));
		selectOption(NoOfSeatsOption,"4");
		WebElement rightHandDriveEle = driver.findElement(By.xpath(radioButton(rightHandYesStr)));
		clickFunction(rightHandDriveEle);
		WebElement NoOfSeatsOption1 = driver.findElement(By.id("numberofseatsmotorcycle"));
		selectOption(NoOfSeatsOption1,"2");
		WebElement FuelOption = driver.findElement(By.id("fuel"));
		selectOption(FuelOption,"Electric Power");
		WebElement payloadEle = driver.findElement(By.xpath(inputField(payloadStr)));
		sendingKeys(payloadEle,"87");
		WebElement weightEle = driver.findElement(By.xpath(inputField(weightStr)));
		sendingKeys(weightEle,"4000");
		WebElement listPriceEle = driver.findElement(By.xpath(inputField(listPriceStr)));
		sendingKeys(listPriceEle,"15000");
		WebElement licensePlateEle = driver.findElement(By.xpath(inputField(licensePlateStr)));
		sendingKeys(licensePlateEle,"15000");
		WebElement annualMileageEle = driver.findElement(By.xpath(inputField(annualMileageStr)));
		sendingKeys(annualMileageEle,"15000");
//		next
	    driver.findElement(By.id("nextenterinsurantdata")).click();
		String fillInsuranceDataPageTitle =driver.getTitle();
        SoftAssert softAssertObj = new SoftAssert();
		softAssertObj.assertEquals(fillInsuranceDataPageTitle, expFillInsurantDTitleStr,"Sorry! Title is not matching");
        //	Fill Insurant Data
		WebElement firstNameEle = driver.findElement(By.xpath(inputField("First Name")));	
		sendingKeys(firstNameEle,"Poojitha");
		WebElement lastNameEle = driver.findElement(By.xpath(inputField("Last Name")));	
		sendingKeys(lastNameEle,"Durgapu");
		WebElement dobEle = driver.findElement(By.xpath(inputField("Date of Birth")));	
		sendingKeys(dobEle,"11/10/1993");
		WebElement genderEle = driver.findElement(By.xpath(radioButton("Female")));
		clickFunction(genderEle);
		WebElement streetEle = driver.findElement(By.xpath(inputField("Street Address")));
		sendingKeys(streetEle,"DoorNo 10,street123");
		WebElement countryOption = driver.findElement(By.id("country"));
		selectOption(countryOption,"United States");
		WebElement zipCodeEle = driver.findElement(By.xpath(inputField("Zip Code")));
        sendingKeys(zipCodeEle,"19018");
        WebElement cityEle = driver.findElement(By.xpath(inputField("City")));
        sendingKeys(cityEle,"Philly");
        WebElement occupationEle = driver.findElement(By.id("occupation"));
        selectOption(occupationEle,"Employee");
        String[] hobbyArray = hobbies.split(";");
        for(String str:hobbyArray) {
        	driver.findElement(By.xpath("//label[text()=' " + str+ "']")).click();
        }
////        file uploading
//        driver.findElement(By.id("open")).click();
//        String filePath = "//Users//poojitha//Desktop//1574364225799.pdf";
//        StringSelection strSel = new StringSelection(filePath);
////copying to clipboard
//		Toolkit toolkit = Toolkit.getDefaultToolkit();
//		Clipboard clipboard = toolkit.getSystemClipboard();
//		clipboard.setContents(strSel, null);
////		for copying(command +v) and pressing eneter
//		Robot rb = new Robot();
//		rb.keyPress(KeyEvent.VK_META); //press command
//		rb.keyPress(KeyEvent.VK_V); //press l
//		Thread.sleep(1000);
//		rb.keyRelease(KeyEvent.VK_META); //release command
//		rb.keyRelease(KeyEvent.VK_V); //release l
//		rb.keyPress(KeyEvent.VK_ENTER);
//		rb.keyRelease(KeyEvent.VK_ENTER);
//		Thread.sleep(4000);
        WebElement websiteEle = driver.findElement(By.xpath(inputField("Website")));
        sendingKeys(websiteEle,"www.google.com");
//        next
		driver.findElement(By.id("nextenterproductdata")).click();
		String fillProdDataPageTitle =driver.getTitle();
        SoftAssert softAssertObj1 = new SoftAssert();
		softAssertObj1.assertEquals(fillProdDataPageTitle, fillProductDTitleStr,"Sorry! Title is not matching");
		
		//fill product dATA
		WebElement startDateEle = driver.findElement(By.xpath(inputField("Start Date")));
        sendingKeys(startDateEle,"05/12/2020");
        WebElement insuSumOption = driver.findElement(By.id("insurancesum"));
		selectOption(insuSumOption,"3.000.000,00");
		WebElement meritRatingEle = driver.findElement(By.id("meritrating"));
	    selectOption(meritRatingEle,"Bonus 2");
	    WebElement damageInsEle = driver.findElement(By.id("damageinsurance"));
	    selectOption(damageInsEle,"Full Coverage");
	    String[] optProdArray = optionalProducts.split(";");
        for(String str:optProdArray) {
        	driver.findElement(By.xpath("//label[text()='" + str+ "']")).click();
        }
        WebElement courtesyCarEle = driver.findElement(By.id("courtesycar"));
	    selectOption(courtesyCarEle,"Yes");
//	    next
	    driver.findElement(By.id("nextselectpriceoption")).click();
		String choosePricePageTitle =driver.getTitle();
        SoftAssert softAssertObj2 = new SoftAssert();
		softAssertObj2.assertEquals(choosePricePageTitle, choosePriceTitleStr,"Sorry! Title is not matching");
		//Choose price option
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='priceTable']/tbody/tr"));
		System.out.println("Rows Count "+ rows.size());
		List<WebElement> columns = driver.findElements(By.xpath("//table[@id='priceTable']/tbody/tr[1]/td"));
		System.out.println("Columns Count "+ columns.size());
		//reading data from table
		//example get the Claims Discount (%) from gold
		String claimDisOFGold = driver.findElement(By.xpath("//table[@id='priceTable']/tbody/tr[3]/td[3]")).getText();
		System.out.println("Claims Discount (%) from gold is :"+ claimDisOFGold);
		WebElement selectPlatinium = driver.findElement(By.xpath("//table[@id='priceTable']/tfoot//th[@colspan ='4']/label/input[@id='selectplatinum']//following-sibling::span"));
		clickFunction(selectPlatinium);
//		next
		driver.findElement(By.id("nextsendquote")).click();
		String sendQuotationPageTitle =driver.getTitle();
        SoftAssert softAssertObj3 = new SoftAssert();
		softAssertObj3.assertEquals(sendQuotationPageTitle, sendQuotPageTitleStr,"Sorry! Title is not matching");
		WebElement mailEle = driver.findElement(By.xpath(inputField("E-Mail")));
		sendingKeys(mailEle,"poojitha@gmail.com");
		WebElement phoneEle = driver.findElement(By.xpath(inputField("Phone")));
		sendingKeys(phoneEle,"9775753612");
		WebElement userNameEle = driver.findElement(By.xpath(inputField("Username")));
		sendingKeys(userNameEle,"Poojitha");
		WebElement passwrdEle = driver.findElement(By.xpath(inputField("Password")));
		sendingKeys(passwrdEle,"Selenium123");
		WebElement confirmPasswrdEle = driver.findElement(By.xpath(inputField("Confirm Password")));
		sendingKeys(confirmPasswrdEle,"Selenium123");
		WebElement commentsEle = driver.findElement(By.xpath("//label/following-sibling::textarea"));
		sendingKeys(commentsEle,"hdvfaghjegdsvfgehguy");
//		next
		driver.findElement(By.id("sendemail")).click();
		driver.close();
}
	private void selectOption(WebElement el, String value) {
		Select selectObj = new Select(el);
		selectObj.selectByVisibleText(value);
	}
	private String inputField(String labelText) {
		return "//label[text()='"+labelText+"']/following-sibling::input";
	}
	private void sendingKeys(WebElement el, String value) {
		el.sendKeys(value);
	}
	private String radioButton(String labelText) {
		return "//label[text()='"+labelText+"']";
	}
	private void clickFunction(WebElement el) {
		el.click();
	}
}
