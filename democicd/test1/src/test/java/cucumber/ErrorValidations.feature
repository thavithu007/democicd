@tag
Feature: Error Validations 

Background:
Given  Launch the Ecommerce Application

@ErrorValidation
Scenario Outline: Purchase the order
Given  Launch the Ecommerce Application
Given Log in with email <email> and password <password>
Then Verify "Incorrect email or password." error message is displayed.
Examples:
|email               |password   |
|thavithu15@gmail.com|10011998dAd@|