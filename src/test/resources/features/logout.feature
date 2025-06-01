Feature: Logout

    Scenario: User logs out successfully
        Given User is logged in with valid credentials
        When User clicks on the logout button
        And User confirms logout
        Then User should be redirected to the login page with "Pengelolaan Dana Pendidikan Sekolah Zaidan Educare" header