package com.fedex.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fedex.actions.DriverManager;
import com.fedex.pages.LandingPage;
import com.fedex.pages.ShippingPage;

public class ShippingRatesTest extends DriverManager{
	
	ShippingPage shipping;
	LandingPage landingPage;
	
	@BeforeTest
	public void startApplication() throws IOException
	{
		init_Driver();
		getApplicationUrl();		
	}	
	@Test
	public void CalculateFedExShippingRates() throws InterruptedException
	{
		landingPage = new LandingPage(getDriver());
		if(landingPage.getPopupSize()>0)
		{
			landingPage.AlertPopup().click();
		}
		landingPage.acceptCookies().click();
		shipping = new ShippingPage(getDriver());
		shipping.Shippinglink().click();
		shipping.getRatesAndTransitTimes().click();
		Thread.sleep(5000);
		shipping.selectFromGoogleAddress("Amsterdam");
		Thread.sleep(5000);
		shipping.selectToGoogleAddress("Hyderabad");
		//Scroll Page 
		//ScrollPage();
		shipping.selectPackageFromDropdown(" FedEx 10kg Box ");
		shipping.packageWeight().sendKeys("10");
		shipping.selectShipDateDropdown("Tuesday, 20 September 2022");
		shipping.ShowRates().click();
		Thread.sleep(5000);
		
	}
	
	@AfterMethod
	@AfterTest
	public void tearDown()
	{
		getDriver().quit();
	}

}
