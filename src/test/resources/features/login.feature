Feature: Login

    @LoginValid
    Scenario: Successful login with valid credentials
        Given User has navigated on the login page
        When User type "bendahara" in the username field
        And User type "admin123" in the password field
        And User press the login button
        Then User is navigated to the dashboard page

    @LoginInvalid
    Scenario: Unsuccessful login with invalid username
        Given User has navigated on the login page
        When User type "firman" in the username field
        And User type "admin123" in the password field
        And User press the login button
        Then User should be able to see "Incorrect username or password, please try again!" notification message

    @LoginInvalid
    Scenario: Unsuccessful login with incorrect password
        Given User has navigated on the login page
        When User type "bendahara" in the username field
        And User type "admin135" in the password field
        And User press the login button
        Then User should be able to see "Incorrect username or password, please try again!" notification message
