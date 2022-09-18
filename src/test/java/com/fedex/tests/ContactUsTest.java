package com.fedex.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fedex.actions.DriverManager;
import com.fedex.pages.AccountPage;
import com.fedex.pages.ContactUsPage;
import com.fedex.pages.LandingPage;

public class ContactUsTest extends DriverManager {
	
	LandingPage landingPage;
	ContactUsPage contactusPage;
	public WebDriver driver;
	@BeforeTest
	public void startApplication() throws IOException
	{
		init_Driver();
		getApplicationUrl();		
	}
	
	@Test
	public void ContactUs()
	{
		landingPage = new LandingPage(getDriver());
		if(landingPage.getPopupSize()>0)
		{
			landingPage.AlertPopup().click();
		}
		landingPage.acceptCookies().click();
		waitToLoad(3);
		contactusPage = new ContactUsPage(getDriver());
		contactusPage.ContactUsMenulink().click();
		contactusPage.ContactUs().click();
		waitToLoad(3);
		contactusPage.TypeHere().click();
		contactusPage.TypeHere().sendKeys("Hi FedEx Assistant Please help me on my Queries");
		contactusPage.clickOnSubmit();
		waitToLoad(3);
	}
	
	@AfterMethod
	@AfterTest
	public void tearDown()
	{
		getDriver().quit();
	}

}
