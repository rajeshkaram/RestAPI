package com.orion.automation.applicationpages;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import com.orion.automation.testbase.Testbase;
import com.orion.automation.utility.Utility;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Test;

public class primusbankloginpage extends Testbase


{
	@FindBy(xpath =("//*[@id='txtuId']"))
	WebElement username;
	
@FindBy(xpath=("//*[@id='txtPword']"))
	WebElement password;

@FindBy(xpath=("//*[@id='login']"))
	WebElement loginButton;

public primusbankloginpage(WebDriver driver){

    this.driver = driver;

    //This initElements method will create all WebElements
    
	
    PageFactory.initElements(driver, this);

}   

	public void orion(String userid, String passid)
	{
		
	 Utility.waitForWebElement(driver, username, 20).sendKeys(userid);
	 Utility.waitForWebElement(driver, password, 20).sendKeys(passid);
	 Utility.waitForWebElement(driver, loginButton, 20).click();
	}
	
	
}