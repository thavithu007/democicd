@tag
Feature: Purchase order from Ecommerce Website

Background:
Given  Launch the Ecommerce Application

@Regression
Scenario Outline: Purchase the order
Given Log in with email <email> and password <password>
When Add product <productName> to the cart
And checkout product <countryName> and submit order
Then Verify "Thankyou for the order." confirmation message is displayed

Examples:
|email               |password   |productName|countryName|
|thavithu15@gmail.com|10011998Ad@|ZARA COAT 3|ind        |


