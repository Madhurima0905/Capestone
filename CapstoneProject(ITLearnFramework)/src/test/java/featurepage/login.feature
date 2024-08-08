@all
Feature: User Login
@valid
  Scenario: Successful login with valid credentials
    Given User is on the login page
    When User enters valid username and password
    Then User clicks on the login button
  
    
@invalid
 Scenario: Unsuccessful login with invalid credentials
    Given User is on the login page
    When User enters invalid username and password
  	Then User clicks on the login button