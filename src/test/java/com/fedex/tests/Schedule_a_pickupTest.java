package com.fedex.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fedex.actions.DriverManager;
import com.fedex.pages.LandingPage;
import com.fedex.pages.ShippingPage;

public class Schedule_a_pickupTest extends DriverManager{
	
	ShippingPage shipping;
	LandingPage landingPage;
	public WebDriver driver;
	@BeforeTest
	public void startApplication() throws IOException
	{
		init_Driver();
		getApplicationUrl();		
	}

	@Test
	public void schedulePickup()
	{
		landingPage = new LandingPage(getDriver());
		if(landingPage.getPopupSize()>0)
		{
			landingPage.AlertPopup().click();
		}
		landingPage.acceptCookies().click();
		shipping = new ShippingPage(getDriver());
		shipping.Shippinglink().click();
		waitToLoad(4);
		shipping.ScheduleManagePickupslink().click();
		waitToLoad(4);
		ScrollInToView(shipping.TrackingNumber());
		shipping.TrackingNumber().sendKeys("202070213812");
		shipping.NumberOfPackages().sendKeys("1");
		shipping.Name().sendKeys("Fathima");
		shipping.Email().sendKeys("fathimahussain22@gmail.com");
		shipping.CompanyName().sendKeys("Wizards");
		shipping.PhoneNumber().sendKeys("0645786055");
		shipping.Address1().sendKeys("William boothlan 190");
		shipping.City().sendKeys("AMSTELVEEN");
		shipping.PostalCaode().sendKeys("1185NW");
		ScrollInToView(shipping.InstructionsForTheDriver());
		shipping.InstructionsForTheDriver().sendKeys("Handle with care");
		waitToLoad(2);
		shipping.PrivacyPolicy().click();
		waitToLoad(2);
		shipping.Submit().click();
		waitToLoad(10);
		String expectedMsg = "Your pickup request has been sent. You'll receive a confirmation shortly.";
		ScrollInToView(shipping.SuccessMessage());
		AssertJUnit.assertEquals(shipping.SuccessMessage().getText(), expectedMsg);
		System.out.println(shipping.SuccessMessage().getText());
		ScrollUp();
	}
	@AfterMethod
	@AfterTest
	public void tearDown()
	{
		getDriver().quit();
	}
}
