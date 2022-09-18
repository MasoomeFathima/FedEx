package com.fedex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}

	By Username = By.xpath("//input[@id='userId']");
	By Password = By.xpath("//input[@id='password']");
	
	By LoginButton = By.xpath("//button[@id='login-btn']");
	
	public WebElement Username()
	{
		return driver.findElement(Username);
	}
	
	public WebElement Password()
	{
		return driver.findElement(Password);
	}
	
	public WebElement LoginButton()
	{
		return driver.findElement(LoginButton);
	}
}
