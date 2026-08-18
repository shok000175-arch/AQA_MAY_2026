#get X random people
#store those people to DB
#take 1 random person from DB
#go to google.com
#enter that person's first and last name to search

  Feature: All in one test

    Scenario: retrieve and search for random people
      Given I request 3 random people from random user service
      Given I store those people in DB
      When I pick one random person from DB
      When I load google page
      When I accept cookies if present
      Then I set search input to random persons name