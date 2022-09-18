package com.fedex.loginTests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fedex.actions.DriverManager;
import com.fedex.pages.LandingPage;
import com.fedex.pages.LoginPage;

public class LoginTest extends DriverManager {
	
	
	LandingPage landingPage;
	LoginPage loginPage;
	
	@BeforeTest
	public void startApplication() throws IOException
	{
		init_Driver();
		getApplicationUrl();
	}
	
	@Test
	public void fedexLogin() throws InterruptedException
	{
		landingPage = new LandingPage(getDriver());
		if(landingPage.getPopupSize()>0)
		{
			landingPage.AlertPopup().click();
		}
		landingPage.acceptCookies().click();
		landingPage.SignIn().click();
		landingPage.Login().click();
		Thread.sleep(5000);
	    loginPage = new LoginPage(getDriver());
		loginPage.Username().sendKeys("fathimahussain22@gmail.com");
		loginPage.Password().sendKeys("Test@123");
		loginPage.LoginButton().click();
		
	}
	

}
