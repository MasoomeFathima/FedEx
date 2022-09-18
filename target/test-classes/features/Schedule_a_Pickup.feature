Feature: Schedule a Pickup

Scenario: verify the functionality of Schedule a Pickup

Given User launch the fedex url 
And clicks on Shipping link and selects the ScheduleandManagePickup option
When User enters the schedule pickup information
And clicks on submit information
Then verify the submit information success message "Your pickup request has been sent. You'll receive a confirmation shortly."