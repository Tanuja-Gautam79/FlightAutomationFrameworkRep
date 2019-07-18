Feature: Search one-way flight

Narrative:

As a user I should be able to search one-way domestic filght in order to verify search funtionality.

Scenario Outline: Verify user is able to search one-way flight

Given user navigates to site
When user search for one-way filght "<source>" to "<destination>"
And user select Re e-deal value and add to trip
Then verify subtotal value

Examples:
|source|destination|
|Sydney|Melbourne|
|Sydney|Brisbane|
|Sydney|Armidale|
|Sydney|Perth|