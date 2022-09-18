package com.fedex.tests;

import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fedex.actions.DriverManager;
import com.fedex.pages.AccountPage;
import com.fedex.pages.LandingPage;

public class OpenAccountTest extends DriverManager
{
	
    LandingPage landingPage;
	AccountPage accountPage;
	public WebDriver driver;
	@BeforeTest
	public void startApplication() throws IOException
	{
		init_Driver();
		getApplicationUrl();		
	}
	
	@Test
	public void OpenAnAccount()
	{
		landingPage = new LandingPage(getDriver());
		if(landingPage.getPopupSize()>0)
		{
			landingPage.AlertPopup().click();
		}
		landingPage.acceptCookies().click();
		accountPage = new AccountPage(getDriver());
		waitToLoad(3);
		accountPage.Accountlink().click();
		accountPage.OpenanAccount().click();
		waitToLoad(3);
		accountPage.OpenAccountButton().click();
		waitToLoad(3);
		accountPage.FirstName().sendKeys("Ramesh");
		accountPage.LastName().sendKeys("Korla");
		accountPage.selectCountry("Netherlands");
		accountPage.Address().sendKeys("William boothlan 190");
		waitToLoad(5);
		accountPage.PostalCode().sendKeys("1185 NW");
		accountPage.City().sendKeys("AMSTELVEEN");
		accountPage.PhoneNumber().sendKeys("0645786055");
		accountPage.email().sendKeys("ramesh.korla3@gmail.com");
		accountPage.EnterLoginDetailsButton().click();
		waitToLoad(5);
		accountPage.Password().sendKeys("Vectra@123");
		accountPage.confirmPassword().sendKeys("Vectra@123");
		waitToLoad(3);
		accountPage.acceptPrivacyPolicyAndTermsAndConditions().click();
		waitToLoad(2);
		accountPage.acceptMarketingEmails().click();
		waitToLoad(2);
		accountPage.clickOnCreateMyUserId();
	}

   
}
