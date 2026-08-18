#get X random people
#store those people to DB
#take 1 random person from DB
#go to google.com
#enter that person's first and last name to search

Feature: Allo phones

  Scenario: Search phones and check first 3 goods

    Given I open Allo website
    When I search for iPhone
    Then I check first 3 goods