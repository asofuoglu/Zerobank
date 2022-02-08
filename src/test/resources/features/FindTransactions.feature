Feature: Find Transactions in Account Activity
  Background:
    Given the user is on the login page
    When the user enters the driver information
    And  go to Account Activity page

    Scenario: Search date range
      And the user accesses the Find Transactions tab
      When the user enters date range from "2012-09-01" to "2012-09-06"
      And clicks search
      Then results table should only show transactions dates between "2012-09-01" to "2012-09-06"
      And the results should be sorted by most recent date
      Then the user enters date range from "2012-09-02" to "2012-09-06"
      And the	results	table	should	only not	contain	transactions dated	"2012-09-01"


  Scenario: Search description
    And the user accesses the Find Transactions tab
    When the user enters description "OFFLINE"
    And clicks search
    Then results table should only show descriptions containing "OFFLINE"

  Scenario: Search description2
    And the user accesses the Find Transactions tab
    When the user enters description "ONLINE"
    And clicks search
    Then results table should only show descriptions containing "ONLINE"

  Scenario: Search description case insensitive
    And the user accesses the Find Transactions tab
    When the user enters description "ONLINE"
    And clicks search
    Then results table should only show descriptions containing “ONLINE”
    When the user enters description "online"
    Then verify it gives error

  Scenario: Type
    And the user accesses the Find Transactions tab
    And clicks search
    Then results table should show at least one result under Deposit
    Then results table should show at least one result under Withdrawal

  Scenario: Type2
    And the user accesses the Find Transactions tab
    When user selects type "Deposit"
    Then results table should show at least one result under Deposit
    But results table should show no result under Withdrawal

  Scenario: Type3
    And the user accesses the Find Transactions tab
    When user selects type "Withdrawal"
    Then results table should show at least one result under Withdrawal
    But results table should show no result under Deposit


