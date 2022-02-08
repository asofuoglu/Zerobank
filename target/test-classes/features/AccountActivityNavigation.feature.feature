Feature: Account activity functions
  Background:
    Given the user is on the login page
    When the user enters the driver information


  Scenario: Account Activity page should have the title Zero – Account activity.
    And  go to Account Activity page
    Then Account Activity page should have the title Zero – Account activity.

  Scenario: Account drop down default option should be Savings
   And go to Account Activity page
    And Account drop down default option should be Savings
    Then Account drop down should have the following options..
      |Savings     |
      |Checking    |
      |Savings     |
      |Loan        |
      |Credit Card |
      |Brokerage   |

  Scenario: Transactions table should have column names
    And go to Account Activity page
    Then Transactions table should have column names..
      |Date       |
      |Description|
      |Deposit    |
      |Withdrawal |

  Scenario: Loan account redirect
    And the user clicks on "Loan" link on the Account Summary page
    And Account Activity page should have the title Zero – Account activity.
    And Account drop down should have "Loan" selected

  Scenario: Savings account redirect
    And the user clicks on "Savings" link on the Account Summary page
    And Account Activity page should have the title Zero – Account activity.
    And Account drop down should have "Savings" selected

  Scenario:Brokerage account redirect
    And the user clicks on "Brokerage" link on the Account Summary page
    And Account Activity page should have the title Zero – Account activity.
    And Account drop down should have "Brokerage" selected

  Scenario: Checking account redirect
    And the user clicks on "Checking" link on the Account Summary page
    And Account Activity page should have the title Zero – Account activity.
    And Account drop down should have "Checking" selected

  Scenario: Credit Card account redirect
    And the user clicks on "Credit Card" link on the Account Summary page
    And Account Activity page should have the title Zero – Account activity.
    And Account drop down should have "Credit Card" selected

