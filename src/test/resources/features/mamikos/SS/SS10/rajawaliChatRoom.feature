@rajawalichatRoom @SS10
Feature: Rajawali Chat Room

  Background: Login admin and navigates to Rajawali chat
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod          | password  |
      | qaeautomation3@mamikos.com | laksana@mamikos.com | qwerty123 |
    And user go to Rajawali Chat Room
    And user click on the Group Chat

  @TEST_SS-3347
  Scenario: Check if User can click on Kost Name in Rajawali Chat Room
    And user click on Kos Name from chat list
    Then user able to see Kos Name
    When admin set active page to 1
    Then user will directed to Kos Detail in new tab

  @TEST_SS-3358 @rajawali-chat @toAutomate @web
  Scenario: [Rajawali Chat][Search]Search by Kos/Tenant
    When admin select filter "kos/tenant"
    And admin fill search chat with "bakwan"
    Then admin can see result data

  @TEST_SS-3359 @rajawali-chat @toAutomate @web
  Scenario: [Rajawali Chat][Search]Search by Kos
    When admin select filter "kos/tenant"
    And admin fill search chat with "kost zahira papua"
    Then admin can see result data

  @rajawali-chat @toAutomate @web
  Scenario: [Rajawali Chat][Search]Search by Tenant
    When admin select filter "tenant"
    And admin fill search chat with "bakwan"
    And admin filter "Important" on chat list
    Then admin can see result data

  @TEST_SS-5741
  Scenario: [Bangkerupux][Rajawali Chat Room] BSE marked important chat
    When admin click "mark important" on chat list
    Then admin can see mark important on list

  @TEST_SS-5742
  Scenario: [Bangkerupux][Rajawali Chat Room] BSE unmarked important chat
    When admin filter "Important" on chat list
    Then admin can see mark important on list
    And admin filter "Important" on chat list
    And admin click "unmark important" on chat list

  @TEST_SS-5743
  Scenario: [Bangkerupux][Rajawali Chat Room] BSE filter Important Chat - Only choose important filter
    When admin filter "Important" on chat list
    Then admin can see mark important on list

  @TEST_SS-5744
  Scenario: [Bangkerupux][Rajawali Chat Room] BSE filter Important Chat - Choose important and unread filter
    When admin filter "Important" on chat list
    Then admin can see result data
    When admin filter "Important" on chat list
    Then admin can see mark important on list
    Then admin can see unread counter on list with "1"
