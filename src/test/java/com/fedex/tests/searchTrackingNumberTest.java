package com.fedex.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fedex.actions.DriverManager;
import com.fedex.pages.ContactUsPage;
import com.fedex.pages.LandingPage;

public class searchTrackingNumberTest extends DriverManager {
	
	LandingPage landingPage;
	public WebDriver driver;
	@BeforeTest
	public void startApplication() throws IOException
	{
		init_Driver();
		getApplicationUrl();		
	}
	
	@Test
	public void searchTrackingNumber()
	{
		landingPage = new LandingPage(getDriver());
		if(landingPage.getPopupSize()>0)
		{
			landingPage.AlertPopup().click();
		}
		landingPage.acceptCookies().click();
		waitToLoad(5);
		landingPage.trackingNumber().sendKeys("20207021381215");
		landingPage.trackingNumber().sendKeys(Keys.TAB);
		waitToLoad(2);
		landingPage.clickOnTrackSubmit();
		waitToLoad(5);
		
	}
	
	@AfterMethod
	@AfterTest
	public void tearDown()
	{
		getDriver().quit();
	}

}
