Feature: OpenLending Linkedin Page Validation
  Scenario: User validates Open Lending Linkedin Page Title
    Given User goes to google
    And User searches the "Open Lending" on google
    When User clicks the "Open Lending Careers and Current Employee Profiles" Page
    Then User Validates the "Say YES to more automotive loans." on Linkedin
    And User logins to Linkedin
    ##User doesn't have to login to validate the text , I logged in after validating the text