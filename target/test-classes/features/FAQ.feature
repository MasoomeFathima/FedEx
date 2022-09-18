Feature: Frequently Asking Questions 

Scenario: Verify the functionality of FAQ

Given User launch the fedex url 
And Click on the Supportlink and select as FAQ
When User enter the text in faq search field and clicks on submit
Then navigate to results page and collect the links to display in console
