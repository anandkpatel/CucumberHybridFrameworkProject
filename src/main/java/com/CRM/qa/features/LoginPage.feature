Feature: Capsule CRM Login functionality

  Scenario: Login page title
    Given user is on login page
    When user gets the title of the page
    Then page title should be "Login - My Store"

  Scenario: Forgot Password link
    Given user is on login page
    Then forgot your password link should be displayed

  Scenario: Login with correct credentials
    Given user is on login page
    When user enters username "akp98259@gmail.com"
    And user enters password "akp98259@A"
    And user clicks on Login button
    Then user gets the title of the page
    And page title should be "My account - My Store"

