@DENEME
Feature: Purchase Foreign Currency
  Background:
    Given the user is on the login page
    When the user enters the driver information
    Then go to Pay Bills page

  @PURCHASETC1
  Scenario: Available currencies
    And the user accesses the "Purchase Foreign Currency" cash tab
    Then following currencies should be available
      |Australia (dollar)    |
      |Canada (dollar)       |
      |Switzerland (franc)   |
      |China (yuan)          |
      |Denmark (krone)       |
      |Eurozone (euro)       |
      |Great Britain (pound) |
      |Japan (yen)           |
      |Mexico (peso)         |
      |Norway (krone)        |
      |New Zealand (dollar)  |
      |Singapore (dollar)    |


  @PURCHASETC2
  Scenario: Error message for not selecting currency

    And the user accesses the "Purchase Foreign Currency" cash tab
    When user tries to calculate cost without selecting a currency
    Then error message should be displayed

  @PURCHASETC3
  Scenario: Error message for not entering value

    And the user accesses the "Purchase Foreign Currency" cash tab
    When user tries to calculate cost without entering a value
    Then error message should be displayed