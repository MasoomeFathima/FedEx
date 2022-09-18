package com.fedex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUsPage {
	
	public WebDriver driver;
	
	public ContactUsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By ContactUsMenulink = By.xpath("(//a[@class='fxg-link fxg-dropdown-js  fxg-keyboard'])[3]");
	By ContactUs = By.cssSelector("a[title='Contact Us']");
	By TypeHere = By.xpath("//*[@id='nina-fedex']/div/div[3]/div[2]/div[1]/textarea");
	By SubmitButton = By.xpath("//*[@id='nina-fedex']/div/div[3]/div[2]/div[2]");
	
	public WebElement ContactUsMenulink()
	{
		return driver.findElement(ContactUsMenulink);
	}
	
	public WebElement ContactUs()
	{
		return driver.findElement(ContactUs);
	}
	
	public WebElement TypeHere()
	{
		return driver.findElement(TypeHere);
	}
	
	public WebElement SubmitButton()
	{
		return driver.findElement(SubmitButton);
	}
	
	public void clickOnSubmit()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", SubmitButton());
	}

}
