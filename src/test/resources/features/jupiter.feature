@JupitorToys
Feature: To enable user to shop using Jupiter toys website

  Background:
    Given user launches the jupiter toys website
    And user lands in home page

  @Testcase1 @Regression
  Scenario Outline: To validate submitted the user feedback information
    When user navigates to Contact page
    And user submits feedback with below mandatory information
      | Forename | <name>    |
      | Email    | <email>   |
      | Message  | <message> |
    Then user validates successful submission

    Examples:
      | name    | email            | message                         |
      | Tester1 | tester1@test.com | Hope I make it to next round :) |
      | Tester2 | tester2@test.com | Hope I make it to next round :) |
      | Tester3 | tester3@test.com | Hope I make it to next round :) |
      | Tester4 | tester4@test.com | Hope I make it to next round :) |
      | Tester5 | tester5@test.com | Success! Script is stable!! :)  |


  @Testcase2 @Regression
  Example:  To validate the items in the cart
    When user navigates to shop page
    * user adds the below items in cart
      | Fluffy Bunny | 2 |
      | Funny Cow    | 1 |
    And navigates to cart page
    Then user verifies added items in the cart


  @Testcase3 @Regression
  Example:  To validate sub total of the items in the cart
    When user navigates to shop page
    And user adds the below items in cart
      | Stuffed Frog   | 2 |
      | Fluffy Bunny   | 5 |
      | Valentine Bear | 3 |
    And navigates to cart page
    Then user validates the subtotal of the added items in cart






