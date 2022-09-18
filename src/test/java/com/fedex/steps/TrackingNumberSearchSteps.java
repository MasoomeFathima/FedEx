package com.fedex.steps;

import java.io.IOException;

import org.openqa.selenium.Keys;

import com.fedex.actions.DriverManager;
import com.fedex.pages.LandingPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TrackingNumberSearchSteps extends DriverManager{
	
	@Given("User is on the landingPage")
	public void user_on_the_landingPage() throws IOException {
		init_Driver();
		getApplicationUrl();	
	}
	
	@When("User enters track number in search field")
	public void user_enters_track_number_in_search_field() {
		LandingPage landingPage = new LandingPage(getDriver());
		if(landingPage.getPopupSize()>0)
		{
			landingPage.AlertPopup().click();
		}
		landingPage.acceptCookies().click();
		waitToLoad(5);
		landingPage.trackingNumber().sendKeys("20207021381215");
		landingPage.trackingNumber().sendKeys(Keys.TAB);
	}

	@When("Clicks on Submit Tracking number")
	public void clicks_on_submit_track() {
		LandingPage landingPage = new LandingPage(getDriver());
		waitToLoad(2);
		landingPage.clickOnTrackSubmit();
	}

	@Then("navigate to search results page")
	public void navigate_to_search_results_page() {
	   System.out.println("Naviage to the results page");
	   System.out.println(getDriver().getTitle());
	}

}
