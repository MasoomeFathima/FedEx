package com.fedex.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fedex.actions.DriverManager;
import com.fedex.pages.ContactUsPage;
import com.fedex.pages.FAQPage;
import com.fedex.pages.LandingPage;

public class FAQsTest extends DriverManager{


	public WebDriver driver;
	@BeforeTest
	public void startApplication() throws IOException
	{
		init_Driver();
		getApplicationUrl();		
	}
	
	@Test
	public void FrequentlyAskedQuestions()
	{
		LandingPage landingPage = new LandingPage(getDriver());
		if(landingPage.getPopupSize()>0)
		{
			landingPage.AlertPopup().click();
		}
		landingPage.acceptCookies().click();
		FAQPage faqPage = new FAQPage(getDriver());
		faqPage.Supportlink().click();
		faqPage.FAQs().click();
		waitToLoad(4);
		faqPage.search().sendKeys("duties and taxes");
		faqPage.searchButton().click();
		waitToLoad(4);
		faqPage.SearchList();		
	}
	
	@AfterMethod
	@AfterTest
	public void tearDown()
	{
		getDriver().quit();
	}
	
}
