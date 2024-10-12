package testRunner;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import seleniumKeyword.SeleniumKeywords;
import utilities.PropReader;

public class TestngRunner {

    public static Properties props;
    public static WebDriver driver;
    public SeleniumKeywords seleniumKeywords;

    @BeforeSuite
    public void beforeSuite() throws IOException {
        PropReader propReader = new PropReader();
        String projectPath = System.getProperty("user.dir");
        props = propReader.readPropertyFile(projectPath + "\\src\\test\\resources\\config\\config.properties");
        seleniumKeywords = new SeleniumKeywords();
    }

    @BeforeClass
    public void beforeTest() {
        driver = seleniumKeywords.launchBrowser(props.getProperty("BROWSER"));
    }

    @BeforeMethod
    public void openURl() {
        seleniumKeywords.navigateTo(driver, props.getProperty("URL"));
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            seleniumKeywords.takeScreenShot(driver);
        }
    }

    @AfterClass
    public void afterTest() {
        driver.quit();
    }
}
