Feature: Capsule CRM Login functionality

  Scenario: Login with Valid Credentials
    Given User should be on Login page
    Then user click on Login button
    And User Enters Domain name "akp98259"
    And User enters Username as "akp98259" and Password as "4K8P8GJ6" and click on Submit button
    Then User should be on Home page and title should be "Dashboard | na CRM"


