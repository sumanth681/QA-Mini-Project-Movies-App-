Feature: Login Functionality
  As a user of the movies app website
  I want to be able to log in to my account
  So that I can access personalized features and watch movies

  Scenario:  Successful Login
    Given I am on login Page
    When I enter valid username and password
    And I click on login button
    Then  I should be redirect to home page

