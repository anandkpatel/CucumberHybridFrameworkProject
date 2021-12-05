Feature: Capsule CRM Login functionality

  Scenario: Login page title
    Given user is on login page
    When user gets the title of the page
    Then page title should be "Login - My Store"

  Scenario: Forgot Password link
    Given user is on login page
    Then forgot your password link should be displayed

  Scenario Outline: Login with correct credentials
    Given user is on login page
    When user enters username "<username>"
    And user enters password "<password>"
    And user clicks on Login button
    Then user gets the title of the page
    And page title should be "My account - My Store"

    Examples:
    |username           |password      |
    |akp98259@gmail.com |akp98259@A    |
    |test123@gmail.com  |test@123      |

