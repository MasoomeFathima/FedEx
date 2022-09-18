@Login
Feature: FedEx Login functionality

Scenario Outline: Verify the login function

Given User launch the Fedex application url
And Clicks on SignIn link
When User enters the "<username>" and "<password>"
And Clicks on the LoginButton
Then Navigate to dashboard

Examples: 
|username|password|
|fathimahussain22@gmail.com|Test@123|
|fathimahussain@gmail.com|Test@123|
