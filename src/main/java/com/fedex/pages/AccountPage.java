package com.fedex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AccountPage {
	
	public WebDriver driver;
	
	public AccountPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By Accountlink = By.xpath("(//a[@class='fxg-link fxg-dropdown-js  fxg-keyboard'])[4]");
	By OpenanAccount = By.cssSelector("a[title='Open an Account']");
	By OpenAccountButton = By.cssSelector("a[class='fxg-button fxg-button--orange fxg-mobile--hide fxg-align-left']");
	
	By PageTitle = By.xpath("//*[@class='ng-star-inserted']//h1");
	
	public WebElement Accountlink()
	{
		return driver.findElement(Accountlink);
	}
	
	public WebElement OpenanAccount()
	{
		return driver.findElement(OpenanAccount);
	}
	
	public WebElement OpenAccountButton()
	{
		return driver.findElement(OpenAccountButton);
	}

	// 
	public WebElement PageTitle()
	{
		return driver.findElement(PageTitle);
	}
	
	public String getPageTitle()
	{
		String title=PageTitle().getText();
		return title;
	}
	
	By FirstName = By.xpath("//*[@id='first-name']");
	By LastName = By.xpath("//*[@id='last-name']");
	By Country = By.xpath("//select[@id='country']");
	By Address = By.xpath("//*[@id='address']");
	By PostalCode = By.xpath("//*[@id='postal-code']");
	By City = By.xpath("//*[@id='city']");
	By PhoneNumber = By.cssSelector("input[id='phone']");
	By email = By.xpath("//*[@id='email']");
	By EnterLoginDetails = By.xpath("//button[@data-test-id='contactFormSubmitButton']");
	
	
	public WebElement FirstName()
	{
		return driver.findElement(FirstName);
	}
	
	public WebElement LastName()
	{
		return driver.findElement(LastName);
	}
	
	public WebElement Country()
	{
		return driver.findElement(Country);
	}
	public void selectCountry(String country)
	{
		Select countryDrp = new Select(Country());
		countryDrp.selectByVisibleText(country);
	}
	
	public WebElement Address()
	{
		return driver.findElement(Address);
	}
	
	public WebElement PostalCode()
	{
		return driver.findElement(PostalCode);
	}
	
	public WebElement City()
	{
		return driver.findElement(City);
	}
	
	public WebElement PhoneNumber()
	{
		return driver.findElement(PhoneNumber);
	}
	
	public WebElement email()
	{
		return driver.findElement(email);
	}
	
	public WebElement EnterLoginDetailsButton()
	{
		return driver.findElement(EnterLoginDetails);
	}
	// Credentials
	By Password = By.cssSelector("input[id='password']");
	By confirmPassword = By.cssSelector("input[id='confirmPassword']");
	By acceptPrivacyPolicyAndTermsAndConditions = By.cssSelector("label[id='acceptPrivacyPolicyAndTermsAndConditions-label']");
	By acceptMarketingEmails = By.cssSelector("label[id='acceptMarketingEmails-label']");
	By createMyUserId = By.cssSelector("button[data-test-id='signupFormSubmitButton']");
	
	public WebElement Password()
	{
		return driver.findElement(Password);
	}
	public WebElement confirmPassword()
	{
		return driver.findElement(confirmPassword);
	}
	public WebElement acceptPrivacyPolicyAndTermsAndConditions()
	{
		return driver.findElement(acceptPrivacyPolicyAndTermsAndConditions);
	}
	public WebElement acceptMarketingEmails()
	{
		return driver.findElement(acceptMarketingEmails);
	}
	public WebElement createMyUserIdButton()
	{
		return driver.findElement(createMyUserId);
	}
	
	public void clickOnCreateMyUserId()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", createMyUserIdButton());
	}
}
