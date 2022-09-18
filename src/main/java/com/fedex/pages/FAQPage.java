package com.fedex.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FAQPage {
	
	public WebDriver driver;
	
	public FAQPage(WebDriver driver)
	{
		this.driver = driver;
	}

	By Supportlink = By.xpath("(//a[@class='fxg-link fxg-dropdown-js  fxg-keyboard'])[3]");
	By FAQs = By.xpath("//a[@aria-label='FAQs']");
	By search = By.cssSelector("input[id='q']");
	By searchButton = By.cssSelector("button[id='search-magnifier-icon']");
	
	By searchlinks = By.xpath("//div[@class='coveo-results-column']//div//div//a");
	
	public WebElement Supportlink()
	{
		return driver.findElement(Supportlink);
	}
	public WebElement FAQs()
	{
		return driver.findElement(FAQs);
	}
	public WebElement search()
	{
		return driver.findElement(search);
	}
	public WebElement searchButton()
	{
		return driver.findElement(searchButton);
	}
	public WebElement searchlinks()
	{
		return driver.findElement(searchlinks);
	}
	
	public void SearchList()
	{
		List<WebElement>listlinks=driver.findElements(searchlinks);
		int count = listlinks.size();
		for(int i=0;i<count; i++)
		{
			String searchlinkList = listlinks.get(i).getText();
			System.out.println(searchlinkList);
			System.out.println("============================ XXX =================================");
		}
	}
	
	
}
