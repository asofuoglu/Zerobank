
Feature: Users should be able to login
  Background:
    Given the user is on the login page

  Scenario: Login with valid credentials
    When the user enters the driver information
    Then Account summary page should be displayed.

  Scenario: Login with invalid credentials
    When the user enters invalid "user_name12" and "password123"
    Then Alert error is seen

  Scenario:  Users with blank username or password should not be able to login
    When the user enters invalid " " and "password"
    Then Alert error is seen

