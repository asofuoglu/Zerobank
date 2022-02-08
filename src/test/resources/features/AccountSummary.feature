Feature: Account summary functions
  Background:
    Given the user is on the login page
    When the user enters the driver information

  Scenario: Account summary page should have the title Zero – Account summary
    Then title should be Zero – Account summary

  Scenario: Account summary page should have to following account types..
    Then  Accounts types must be expected
      |Cash Accounts        |
      |Investment Accounts  |
      |Credit Accounts      |
      |Loan Accounts        |

  Scenario: Credit Accounts table must have columns..
    Then  Verify Credit Accounts table must have columns
      |Account    |
      |Credit Card|
      |Balance    |