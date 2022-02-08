Feature: Add new payee under pay bills
  Scenario Outline: Add a new payee

    Given the user is on the login page
    When the user enters the driver information
    Then go to Pay Bills page
    And Add New Payee tab
    And creates new payee using following information with "<name>" "<adress>" "<account>" "<details>"

    Then message The new payee The Law Offices of Hyde, Price & Scharks was successfully created. should be displayed
    Examples:
      | name | adress | account | details |
      | The Law Offices of Hyde, Price & Scharks| 100 Same st, Anytown, USA, 10001 | Checking | XYZ account|