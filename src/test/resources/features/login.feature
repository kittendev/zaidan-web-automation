Feature: Login

Scenario: Check login is successful with valid credentials
    Given User has navigated on the login page
    When User type "bendahara" in the username field
    And User type "admin123" in the password field
    And User press teh login button
    Then User is navigated to the dashboard page
