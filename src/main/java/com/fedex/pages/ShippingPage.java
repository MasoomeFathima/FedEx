package com.fedex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ShippingPage {
	
    public WebDriver driver;
	Actions actions;
	
	public ShippingPage(WebDriver driver)
	{
		this.driver =driver;
	}
	
	By ShippingLink = By.xpath("(//ul[@class='fxg-dropdown__list']//li)[1]");
	
	By getRates = By.xpath("//a[@title='Get Rates & Transit Times']");
	
     By FromAddress = By.xpath("//input[@id='fromGoogleAddress']");
     By ToAddress = By.xpath("//input[@id='toGoogleAddress']");
     
     By packageDrp = By.xpath("//select[@id='package-details__package-type']");
     By packageWeight = By.xpath("//*[@id='package-details__weight-0']");
     
     By DimessionLength = By.xpath("//*[@class='fdx-c-form-group__input ng-pristine ng-valid ng-touched']");
     By DimessionWeight = By.xpath("(//*[@class='fdx-c-form-group__input ng-untouched ng-pristine ng-valid'])[1]");
     By Dimessionheight = By.xpath("(//*[@class='fdx-c-form-group__input ng-untouched ng-pristine ng-valid'])[2]");
     
     By packageShipDate = By.xpath("//select[@id='packageShipDate']");
     
     By ShowRates = By.xpath("//button[@id='e2ePackageDetailsSubmitButtonRates']");
	
	public WebElement Shippinglink()
	{
		return driver.findElement(ShippingLink);
	}
	
	public WebElement getRatesAndTransitTimes()
	{
		return driver.findElement(getRates);
	}

	public WebElement fromAddress()
	{
		return driver.findElement(FromAddress);
	}
	
	public WebElement toAddress()
	{
		return driver.findElement(ToAddress);
	}
	// Select dropdown function
	public WebElement PacakgeDropdown()
	{
		return driver.findElement(packageDrp);
	}
	// Package Selection 
	public void selectPackageFromDropdown(String text)
	{
		Select packagedrp = new Select(PacakgeDropdown());
		packagedrp.selectByVisibleText(text);
	}
	public void selectFromGoogleAddress(String address) throws InterruptedException
	{
//		actions = new Actions(driver);
//		fromAddress().clear();
//		actions.moveToElement(fromAddress()).click().sendKeys(address).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		fromAddress().clear();
		fromAddress().sendKeys(address);
		Thread.sleep(2000);
		fromAddress().sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		fromAddress().sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		
		  
	}
	
	public void selectToGoogleAddress(String address) throws InterruptedException
	{
//		actions = new Actions(driver);
//		actions.moveToElement(toAddress()).click().sendKeys(address).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		toAddress().clear();
		toAddress().sendKeys(address);
		Thread.sleep(2000);
		toAddress().sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		toAddress().sendKeys(Keys.ENTER);
		Thread.sleep(4000);
	}
	
	// Package Weight
	public WebElement packageWeight()
	{
		return driver.findElement(packageWeight);
	}
	
	public WebElement DimessionLength()
	{
		return driver.findElement(DimessionLength);
	}
	
	public WebElement DimessionWeight()
	{
		return driver.findElement(DimessionWeight);
	}
	public WebElement Dimessionheight()
	{
		return driver.findElement(Dimessionheight);
	}
	
	public WebElement ShowRates()
	{
		return driver.findElement(ShowRates);
	}
	
	public WebElement packageShipDate()
	{
		return driver.findElement(packageShipDate);
	}
	// Select for ShipDate
	public void selectShipDateDropdown(String text)
	{
		Select packagedrp = new Select(packageShipDate());
		packagedrp.selectByVisibleText(text);
	}
	/********************* Shipping Schedule **************************/
	
	By ScheduleManagePickups = By.xpath("//a[@title='Schedule & Manage Pickups']");
	By TrackingNumber = By.cssSelector("input[id='tracking-number']");
	By NumberOfPackages = By.cssSelector("input[id='number-of-packages']");
	By Name = By.name("name");
	By Email = By.xpath("//input[@id='e-mail']");
	By CompanyName = By.xpath("//input[@id='company-name']");
	By PhoneNumber = By.xpath("//input[@id='phone-number']");
	By Address1 = By.xpath("//input[@id='address-line-1']");
	By City = By.xpath("//input[@id='city']");
	By PostalCaode = By.xpath("//input[@id='postal-code']");
	By InstructionsForTheDriver = By.xpath("//*[@id='instructions']");
	By PrivacyPolicy = By.xpath("//label[@for='privacy_policy_checkbox_single']");
	By Submit = By.xpath("(//button[@class='fxg-button fxg-button--submit fxg-button--orange js-cms-form-submit'])[1]");
	
	By SuccessMessage = By.xpath("//div[@class='is-success fxg-form__notification-text']");
	
	public WebElement ScheduleManagePickupslink()
	{
		return driver.findElement(ScheduleManagePickups);
	}
	public WebElement TrackingNumber()
	{
		return driver.findElement(TrackingNumber);
	}
	public WebElement NumberOfPackages()
	{
		return driver.findElement(NumberOfPackages);
	}
	public WebElement Name()
	{
		return driver.findElement(Name);
	}
	public WebElement Email()
	{
		return driver.findElement(Email);
	}
	public WebElement CompanyName()
	{
		return driver.findElement(CompanyName);
	}
	public WebElement PhoneNumber()
	{
		return driver.findElement(PhoneNumber);
	}
	public WebElement Address1()
	{
		return driver.findElement(Address1);
	}
	
	public WebElement City()
	{
		return driver.findElement(City);
	}
	
	public WebElement PostalCaode()
	{
		return driver.findElement(PostalCaode);
	}
	
	public WebElement InstructionsForTheDriver()
	{
		return driver.findElement(InstructionsForTheDriver);
	}
	public WebElement PrivacyPolicy()
	{
		return driver.findElement(PrivacyPolicy);
	}
	
	public WebElement Submit()
	{
		return driver.findElement(Submit);
	}
	
	public WebElement SuccessMessage()
	{
		return driver.findElement(SuccessMessage);
	}
	
}
