package com.fedex.steps;

import java.io.IOException;

import com.fedex.actions.DriverManager;
import com.fedex.pages.ContactUsPage;
import com.fedex.pages.LandingPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsSteps extends DriverManager{
	
	
	@Given("User launch the Fedex application")
	public void user_launch_the_fedex_application() throws IOException {
		init_Driver();
		getApplicationUrl();	
	}

	@Given("Clicks on the Support link and select ContactUs Option")
	public void clicks_on_the_support_link_and_select_contact_us_option() {
		LandingPage landingPage = new LandingPage(getDriver());
		if(landingPage.getPopupSize()>0)
		{
			landingPage.AlertPopup().click();
		}
		landingPage.acceptCookies().click();
		waitToLoad(3);
		ContactUsPage contactusPage = new ContactUsPage(getDriver());
		contactusPage.ContactUsMenulink().click();
		contactusPage.ContactUs().click();
	}

	@When("enters the message in TypeHere")
	public void enters_the_message_in_type_here() {
		ContactUsPage contactusPage = new ContactUsPage(getDriver());
		waitToLoad(3);
		contactusPage.TypeHere().click();
		contactusPage.TypeHere().sendKeys("Hi FedEx Assistant Please help me on my Queries");
	}

	@Then("Clicks on the Submit message")
	public void clicks_on_the_submit_message() {
		ContactUsPage contactusPage = new ContactUsPage(getDriver());
		contactusPage.clickOnSubmit();
		waitToLoad(3);
		getDriver().quit();
	}


}
