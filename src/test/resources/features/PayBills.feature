Feature: Pay Bills page functions
  Background:
    Given the user is on the login page
    When the user enters the driver information
    Then go to Pay Bills page

  Scenario: Pay Bills page should have the title Zero – Pay Bill
    And Pay Bills page should have the title Zero – Pay Bill

  Scenario: After successful Pay operation, The payment was successfully submitted. should be displayed
    And  make successful Pay operation "100", "2021-11-23" and verify message

  Scenario: make a payment without entering the amount or date,Please fill out this field message! should be displayed.
    And  make a payment without entering the date  "100"

