Feature: Sign Up
  Description: The purpose of this feature is to test Sign Up flows.

  Scenario Outline: Merchant Signs-up successfully and logs in
    Given user is on landing page
    When user clicks on sign up button
    And user clicks on merchant sign up button
    And user submits "<merchant>" sign up mailing details
    And user enters "<merchant>" basic company information
    And user click on continue button
    And user clicks on confirm on verify url pop-up
    Then user should be redirected to merchant login page
    And user should be shown a toaster message "Please verify your email and login to your account"
    And user verifies the email address
    And user should be able to logs in  with "<merchant>" credential

    Examples:
      | merchant |
      | Abhijit  |
      | Avishek  |
