package com.fedex.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	
	public WebDriver driver;
	protected Properties properties;
	public WebDriverWait wait;
	
	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();// running any browsers pararlley
	public WebDriver init_Driver() throws IOException
	{
		properties = new Properties();
		String filePath = System.getProperty("user.dir")+"/configurations/fedex.properties";
		FileInputStream fis = new FileInputStream(filePath);
		properties.load(fis);
		String browser = properties.getProperty("browser");
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
		else if(browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
		}
		else
		{
			System.out.println("Please pass the correct browset vlaue: "+browser);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
		return getDriver();

	}
	
	public void getApplicationUrl()
	{
		getDriver().get(properties.getProperty("AppUrl"));
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	
	public static synchronized WebDriver getDriver()
	{
		return tlDriver.get();
	}
	
	public void waitForElementToClickable(WebElement element)
	{
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));						
	}
	public void waitForvisibilityOf(WebElement element)
	{
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));						
	}
	//Scroll Page 
	
	public void ScrollPage()
	{
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("window.scrollBy(0, 700)");
	}
	//Scroll Into View 
	public void ScrollInToView(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	//Scroll Up
	public void ScrollUp()
	{
		JavascriptExecutor jse = (JavascriptExecutor)getDriver();
		jse.executeScript("window.scrollBy(0,-250)");
	}
	
	public void waitToLoad(int seconds)
	{
		try {
			Thread.sleep(1000*seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
