package com.orion.automation.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



public class Helper {
static WebDriver driver;
	public static void frame(int index) {
		driver.switchTo().frame(index);
	}
	
	public static void Actions(WebElement locator) {
	Actions action = new Actions(driver);
	action.moveToElement(locator).build().perform();

}
}