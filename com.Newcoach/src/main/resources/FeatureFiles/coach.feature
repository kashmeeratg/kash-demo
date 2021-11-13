#Author: Kashmeera
Feature: Testing Coach Homepage

@Ignore
  Scenario: Validation of home page
    Given user is on home page
    Then validate if coach icon is displayed;
    Then validate if user button is displayed

@Ignore
  Scenario: Validattion of signin page
    Given user is on home page
    Then validate if coach icon is displayed;
    When user clicks on user button
    Then validate signin page is displayed

@smoke
  Scenario Outline: Validation of cutomer page
    Given user is on home page
    Then validate if coach icon is displayed;
    When user clicks on user button
    Then validate signin page is displayed
    When user enter <username> and <password>
    Then validate user is on customer page

    Examples: 
      | username             | password   |
      | arunbabu79@gmail.com | Darsh@1979 |
