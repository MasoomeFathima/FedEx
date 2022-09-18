package com.fedex.steps;

import java.io.IOException;

import com.fedex.actions.DriverManager;
import com.fedex.pages.FAQPage;
import com.fedex.pages.LandingPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FAQSteps extends DriverManager {
	
	@Given("User launch the fedex url")
	public void user_launch_the_fedex_url() throws IOException {
		init_Driver();
		getApplicationUrl();   
	}
	
	@Given("Click on the Supportlink and select as FAQ")
	public void click_on_the_supportlink_and_select_as_faq() {
		LandingPage landingPage = new LandingPage(getDriver());
		if(landingPage.getPopupSize()>0)
		{
			landingPage.AlertPopup().click();
		}
		landingPage.acceptCookies().click();
		FAQPage faqPage = new FAQPage(getDriver());
		faqPage.Supportlink().click();
		faqPage.FAQs().click();			
	}

	@When("User enter the text in faq search field and clicks on submit")
	public void user_enter_the_text_in_faq_search_field_and_clicks_on_submit() {
		FAQPage faqPage = new FAQPage(getDriver());
		waitToLoad(4);
		faqPage.search().sendKeys("duties and taxes");
		faqPage.searchButton().click();
		waitToLoad(4);
	}

	@Then("navigate to results page and collect the links to display in console")
	public void navigate_to_results_page_and_collect_the_links_to_display_in_console() {
		FAQPage faqPage = new FAQPage(getDriver());
		faqPage.SearchList();	
	}


}
