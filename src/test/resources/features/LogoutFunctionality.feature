Feature: Logout Functionality
  As a user of the movies app website
  I want to be able to log out to my account
  So that I should redirect to movies app login page
  Scenario:  Successful Logout
    Given I am on the login page for logout
    When I enter valid username and password for logout
    And  I click on login button for logout
    When I click on account page
    And  I click on logout button
    Then I should be redirect to login page
