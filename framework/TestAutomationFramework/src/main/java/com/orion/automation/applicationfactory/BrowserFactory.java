package com.orion.automation.applicationfactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;



public class BrowserFactory {

static WebDriver driver;
	
	public static WebDriver getBrowser(String browser,String appUrl)
	{
		if (browser.equalsIgnoreCase("Chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Driverss\\chromedriver.exe");
			
			driver=new ChromeDriver();
			System.out.println("Chrome Started");
			
		} else if (browser.equalsIgnoreCase("IE")) 
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\.exe");
			driver=new InternetExplorerDriver();
			System.out.println("IE Started");
		} 
		else if (browser.equalsIgnoreCase("Firefox")) 
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\firefox.exe");
			driver=new FirefoxDriver();
			System.out.println("Firefox Started");
		} else 
		
		{
			System.out.println("Sorry seems we dont support this driver/Browser..");
		}

		System.out.println("Test is getting executed by threads and threads id is "+Thread.currentThread().getId());
		System.out.println("Application is loading and URL is "+appUrl);
		driver.get(appUrl);
		driver.manage().window().maximize();
		
		System.out.println("Title is "+driver.getTitle());
		
		return driver;

	}
	
	
	public static void frame(int index) {
		driver.switchTo().frame(index);
		
	}
	public static void frame(String name) {
		driver.switchTo().frame(name);
		
	}
	
	public static void setDateUsingJavaScriptInCalendar(WebDriver driver, String value, WebElement calLocator)
	{
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		String script= "arguments[0].setAttribute('value','"+value+"');";
		jse.executeScript(script, calLocator);
		
		
		WebElement departCal= driver.findElement(By.xpath("//img[@title='Date selector']"));
		BrowserFactory.setDateUsingJavaScriptInCalendar(driver, "25/12/2018",departCal);
	}

	public static void selectUsingVisibleText(WebElement element, String visibleText){
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
		
		
	}
	
	public static void SwitchToAnotherWindow(WebDriver driver,int window_number){

	     List<String> windowlist = null;

	    Set<String> windows = driver.getWindowHandles();

	    windowlist = new ArrayList<String>(windows);

	   String currentWindow = driver.getWindowHandle();

	 if (!currentWindow.equalsIgnoreCase(windowlist.get(window_number - 1))) 
	    {
	        driver.switchTo().window(windowlist.get(window_number - 1));
	     }

	}
	
	
	public static void radiobutton(String recieveemail){
		WebElement radio=driver.findElement(By.xpath(recieveemail));
		radio.click();
	}
	public static void checkbox(String element){
		WebElement checkbox=driver.findElement(By.xpath(element));
		checkbox.click();
	}
	
	public static void closeBrowser(WebDriver driver)
	{
		driver.quit();
		System.out.println("Browser Closed");
	}
	
	
}



