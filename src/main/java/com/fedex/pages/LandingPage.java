package com.fedex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LandingPage {
	
	public WebDriver driver;
	Actions action;
	//Constructor
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
	By SignIn = By.xpath("//a[@id='fxg-dropdown-signIn']");
	
	public WebElement SignIn()
	{
		return driver.findElement(SignIn);
	}
	
	By Login = By.xpath("//a[@title='Log In']");
	
	public WebElement Login()
	{
		return driver.findElement(Login);
	}
	
	By acceptCookies = By.xpath("//div[@class='fxg-cookie-consent__actions']//button[2]");
	
	public WebElement acceptCookies()
	{
		return driver.findElement(acceptCookies);
	}
	
    By AlertPopup = By.cssSelector("a[title='close']");
	
	public WebElement AlertPopup()
	{
		return driver.findElement(AlertPopup);
	}
	
	public int getPopupSize()
	{
		return driver.findElements(AlertPopup).size();
	}
	// Tracking Search
	By trackingNumber = By.xpath("//input[@id='trackingnumber']");
	By trackSubmit = By.xpath("//*[@id='btnSingleTrack']");
	
	By errorMessage = By.xpath("div[class='notification__message text-left']");
	
	public WebElement trackingNumber()
	{
		return driver.findElement(trackingNumber);
	}
	
	public WebElement trackSubmit()
	{
		return driver.findElement(trackSubmit);
	}
	
	public void clickOnTrackSubmit()
	{
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		jse.executeScript("arguments[0].click();", trackSubmit());
		 action = new Actions(driver);
		 action.moveToElement(trackSubmit()).doubleClick().build().perform();
	}
	
	public WebElement errorMessage()
	{
		return driver.findElement(errorMessage);
	}

}
