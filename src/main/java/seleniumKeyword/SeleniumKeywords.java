package seleniumKeyword;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumKeywords {

	// Launch the browser
	public WebDriver launchBrowser(String browserName) {
		WebDriver driver = null;
		if(browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("IE")) {
			driver = new EdgeDriver();
		}
		return driver;
	}

	// Navigate to the url
	public void navigateTo(WebDriver driver,String URL) {
		driver.get(URL);
	}

	// Navigate to the previous page of current url
	public void navigateToPreviousPage(WebDriver driver) throws Exception {
		driver.navigate().back();
	}

	// Method to wait for the element until it is available
	public void waitForElementToBeClickable(WebDriver driver,By by) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
   	    wait.until(ExpectedConditions.elementToBeClickable(by));
   	}

	// Method to wait for the element until it is visible or available in DOM
	public void waitForElementToBeVisible(WebDriver driver,By by) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
   	    wait.until(ExpectedConditions.visibilityOfElementLocated(by));
   	}

	// Take screenshot
	public void takeScreenShot(WebDriver driver) {
		try {
        	File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	String projectFolder=System.getProperty("user.dir");
        	String dateName = new SimpleDateFormat("yyyyMMddhhmmssSS").format(new Date());
        	String destination = projectFolder+"\\screenshot\\"+dateName+".jpg";
        	FileUtils.copyFile(src, new File(destination));
		} catch (IOException e) {
			System.out.println("Error in taking Screen shots");
		}
	}
}
