package com.fedex.steps;

import java.io.IOException;

import org.testng.Assert;

import com.fedex.actions.DriverManager;
import com.fedex.pages.LandingPage;
import com.fedex.pages.ShippingPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ScheduleManagePickupSteps extends DriverManager{
	
	@Given("User launch the fedex application")
	public void user_launch_the_fedex_application() throws IOException {
		init_Driver();
		getApplicationUrl();   
	}

	@Given("clicks on Shipping link and selects the ScheduleandManagePickup option")
	public void clicks_on_shipping_link_and_selects_the_scheduleand_manage_pickup_option() {
		LandingPage landingPage = new LandingPage(getDriver());
		if(landingPage.getPopupSize()>0)
		{
			landingPage.AlertPopup().click();
		}
		landingPage.acceptCookies().click();
		ShippingPage shipPage = new ShippingPage(getDriver());
				shipPage.Shippinglink().click();
		shipPage.ScheduleManagePickupslink().click();
	}

	@When("User enters the schedule pickup information")
	public void user_enters_the_schedule_pickup_information() {
		ShippingPage shipPage = new ShippingPage(getDriver());
		waitToLoad(4);
		ScrollInToView(shipPage.TrackingNumber());
		shipPage.TrackingNumber().sendKeys("202070213812");
		shipPage.NumberOfPackages().sendKeys("1");
		shipPage.Name().sendKeys("Fathima");
		shipPage.Email().sendKeys("fathimahussain22@gmail.com");
		shipPage.CompanyName().sendKeys("Wizards");
		shipPage.PhoneNumber().sendKeys("0645786055");
		shipPage.Address1().sendKeys("William boothlan 190");
		shipPage.City().sendKeys("AMSTELVEEN");
		shipPage.PostalCaode().sendKeys("1185NW");
		ScrollInToView(shipPage.InstructionsForTheDriver());
		shipPage.InstructionsForTheDriver().sendKeys("Handle with care");
		waitToLoad(2);
		shipPage.PrivacyPolicy().click();
		waitToLoad(2);
	}

	@When("clicks on submit information")
	public void clicks_on_submit_information() {
		ShippingPage shipPage = new ShippingPage(getDriver());
		shipPage.Submit().click();
		waitToLoad(10);
	}

	@Then("verify the submit information success message {string}")
	public void verify_the_submit_information_success_message(String expectedMsg) {
		ShippingPage shipPage = new ShippingPage(getDriver());
		ScrollInToView(shipPage.SuccessMessage());
		Assert.assertEquals(shipPage.SuccessMessage().getText(), expectedMsg);
		System.out.println(shipPage.SuccessMessage().getText());
		ScrollUp();
	}

}
