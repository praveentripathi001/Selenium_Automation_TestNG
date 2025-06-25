@all
Feature: User Login
Registered user should be able to login to access the account details.

@smoke @test
Scenario: Login with Valid credentials
Given user navigates to Login page
When User enters valid email address "praveen.tripathi@test.com"
And Enters valid password "Test@1234"
And Clicks on Login button
Then User should login successfully

Scenario: Login with invalid credentials
Given user navigates to Login page
When User enters an invalid email address "amotooricap953533@gmail.com"
And Enters invalid password "123453454"
And Clicks on Login button
Then User should get a proper warning message

Scenario: Login with valid email address and invalid password
Given user navigates to Login page
When User enters valid email address "amotooricap9@gmail.com"
And Enters valid password "123453454"
And Clicks on Login button
Then User should get a proper warning message

Scenario: Login with invalid email address and valid password
Given user navigates to Login page
When User enters an invalid email address "amotooricap953533@gmail.com"
And Enters valid password "12345"
And Clicks on Login button
Then User should get a proper warning message

Scenario: Login without providing any credentials
Given user navigates to Login page
When user do not enter any credential
And Clicks on Login button
Then User should get a proper warning message




