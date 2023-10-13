@rajawalichatRoom @BBM8
Feature: Rajawali Chat Room

  Background: Login admin and navigates to Rajawali chat
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                   | email prod              |password   |
      | qaeautomation3@mamikos.com   | laksana@mamikos.com     |qwerty123  |
    And user go to Rajawali Chat Room
    And user click on the Group Chat

  @TEST_COOP-850
  Scenario: Check if User can click on Kost Name in Rajawali Chat Room
    And user click on Kos Name from chat list
    Then user able to see Kos Name
    When admin set active page to 1
    Then user will directed to Kos Detail in new tab

  @TEST_COOP-918 @rajawali-chat @toAutomate @web
  Scenario: [Rajawali Chat][Search]Search by Kos/Tenant
    When admin select filter "kos/tenant"
    And admin fill search chat with "upik"
    Then admin can see result data

  @TEST_COOP-927 @rajawali-chat @toAutomate @web
  Scenario: [Rajawali Chat][Search]Search by Kos
    When admin select filter "kos/tenant"
    And admin fill search chat with "Kos Emas Dua"
    Then admin can see result data

  @TEST_COOP-924 @rajawali-chat @toAutomate @web
  Scenario: [Rajawali Chat][Search]Search by Tenant
    When admin select filter "tenant"
    And admin fill search chat with "upik"
    Then admin can see result data