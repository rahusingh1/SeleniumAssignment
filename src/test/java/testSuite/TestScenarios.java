package testSuite;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import objectRepository.Homepage;
import objectRepository.ListPage;
import seleniumKeyword.SeleniumKeywords;
import testRunner.TestngRunner;

public class TestScenarios extends TestngRunner {

    @Test(priority=0, groups= {"smoke"})
    public static void verifyHomePageTitle() {

        String expectedTitle = "Bus Ticket Booking Online made Easy, Secure with Top Bus Operators - redBus";
        String actualTitle = driver.getTitle();

        try {
            Assert.assertEquals(actualTitle, expectedTitle);
            System.out.println("Home page title is correct");
        } catch (Exception e) {
            System.out.println("Home page title is incorrect");
        }
    }
    
    @Test(priority=1, groups= {"smoke"})
    public static void verifyGovtBuses() {
    	
    	SeleniumKeywords seleniumKeywords = new SeleniumKeywords();
    	
        String expectedString = "GOVERNMENT BUSES";
        
        seleniumKeywords.waitForElementToBeVisible(driver, Homepage.GovtBusHeading);
        WebElement GovtBusesHead = driver.findElement(Homepage.GovtBusHeading);
        GovtBusesHead.click();
        String actualString = GovtBusesHead.getText();
        System.out.println(actualString);

        try {
            Assert.assertEquals(expectedString, actualString);
            System.out.println("Found Govt buses option");
        } catch (Exception e) {
            System.out.println("Govt buses option not found");
        }
    }

    @Test(priority=2, groups= {"regression"})
    public static void verifySearchBuses() {

    	SeleniumKeywords seleniumKeywords = new SeleniumKeywords();

        WebElement origin = driver.findElement(Homepage.source);
        origin.sendKeys("New Delhi");

        seleniumKeywords.waitForElementToBeVisible(driver, Homepage.selectSource);
        WebElement selectOrigin = driver.findElement(Homepage.selectSource);
        selectOrigin.click();

        WebElement destination = driver.findElement(Homepage.dest);
        destination.sendKeys("Haridwar");

        seleniumKeywords.waitForElementToBeVisible(driver, Homepage.selectDest);
        WebElement selectdesti = driver.findElement(Homepage.selectDest);
        selectdesti.click();

        WebElement date = driver.findElement(Homepage.dateField);
        date.click();
        System.out.println("clicked");


//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//
//        WebElement monthYr = driver.findElement(Homepage.mY);
//        String MYVal = monthYr.getText();
//        System.out.println(MYVal);
//
//        String month = MYVal.split(" ")[0].trim();
//        String year = MYVal.split(" ")[1].trim();
//
//        System.out.println("month: "+month +", year: "+year);

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//        while(!(month.equals("June") && year.equals("2024"))) {
//        	WebElement nav = driver.findElement(Homepage.mYNavigator);
//            nav.click();
//            System.out.println("nav clicked");
//        }

        WebElement selectDate = driver.findElement(Homepage.date);
        selectDate.click();
        System.out.println("date selected");

        WebElement searchButton = driver.findElement(Homepage.SearchButton);
        searchButton.click();
        System.out.println("searchButton clicked");

        seleniumKeywords.waitForElementToBeVisible(driver, ListPage.BusFound);

        WebElement busFound = driver.findElement(ListPage.BusFound);



        String actualValue = busFound.getText();

        String expectedValue = "Buses found";

        try {
            Assert.assertTrue(actualValue .contains(expectedValue));
            System.out.println("Buses found successfully");
        } catch (Exception e) {
            System.out.println("Buses not found");
        }
    }
}
