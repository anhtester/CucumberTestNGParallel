Feature: Manage Project

  Scenario: User can add a project
    Given the user login to system
    When user open the project page
    And user click add project button
    Then the add project dialog displays
    When user enter data on form information
    And click save button
    Then the project just added on Project page