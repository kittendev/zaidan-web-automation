Feature: Login

Scenario: Check login is successful with valid credentials
    Given User has navigated on the login page
    When User type "bendahara" in the username field
    And User type "admin123" in the password field
    And User press teh login button
    Then User is navigated to the dashboard page

Scenario: Check login is unsuccessful with invalid credentials because username not registered
    Given User has navigated on the login page
    When User type "indra" in the username field
    And User type "admin123" in the password field
    And User press teh login button
    Then User should be able to see "Incorrect username or password, please try again!" notification message

Scenario: Check login is unsuccessful with invalid credentials because password incorrect
    Given User has navigated on the login page
    When User type "bendahara" in the username field
    And User type "admin135" in the password field
    And User press teh login button
    Then User should be able to see "Incorrect username or password, please try again!" notification message
