package objectRepository;

import org.openqa.selenium.By;

public interface Homepage {
	
	//Locators	
	By source= By.xpath("//input[@id=\"src\"]");
	By selectSource= By.cssSelector("li[class='sc-iwsKbI jTMXri cursorPointing'] text[class='placeHolderMainText']");
	By dest= By.xpath("//input[@id=\"dest\"]");
	By selectDest= By.xpath("//div[@class='sc-gZMcBi hviMLb']//text[@class='placeHolderMainText'][normalize-space()='Haridwar']");
	By dateField= By.xpath("//div[@id=\"onwardCal\"]");
	
	By mY= By.cssSelector("div[class='DayNavigator__CalendarHeader-qj8jdz-1 fxvMrr'] div:nth-child(2)");
	By mYNavigator= By.cssSelector("div[class='DayNavigator__CalendarHeader-qj8jdz-1 fxvMrr'] div:nth-child(3)");	
	By date= By.xpath("//span[normalize-space()='25']");
	
	By SearchButton= By.xpath("//button[@id='search_button']");
}
