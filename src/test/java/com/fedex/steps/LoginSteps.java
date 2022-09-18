package com.fedex.steps;

import java.io.IOException;

import com.fedex.actions.DriverManager;
import com.fedex.pages.LandingPage;
import com.fedex.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends DriverManager{
	
	@Given("User launch the Fedex application url")
	public void user_launch_the_fedex_application_url() throws IOException {
		init_Driver();
		getApplicationUrl();	
	}

	@Given("Clicks on SignIn link")
	public void clicks_on_sign_in_link() {
		LandingPage landingPage = new LandingPage(getDriver());
		if(landingPage.getPopupSize()>0)
		{
			landingPage.AlertPopup().click();
		}
		landingPage.acceptCookies().click();
		landingPage.SignIn().click();
		landingPage.Login().click();
	}

	@When("User enters the {string} and {string}")
	public void user_enters_the_and(String username, String password) {
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.Username().sendKeys(username);
		loginPage.Password().sendKeys(password);
	}

	@When("Clicks on the LoginButton")
	public void clicks_on_the_login_button() {
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.LoginButton().click();
	}

	@Then("Navigate to dashboard")
	public void navigate_to_dashboard() {
		System.out.println("Display the Dashboard Page");
		waitToLoad(3);
		getDriver().quit();
	}
	

}
