#@listing-monetization @regression @LIMO1 @mamipoinOwnerEntryPoint @mamipoinOwner @mamiPointBlacklistWhitelist
Feature: Mamipoint Blacklist and Whitelist Admin (Already migrate

<<<<<<<< HEAD:src/test/resources/features/mamikos/LIMO/LIMO-New-Era/LIMO1/Point-Management/mamipoint_blacklist_whitelist_admin.feature
  @TEST_LIMO-3298 @Automated @Web @listing-monetization @mamipoin-owner @continue
========
#  @TEST_LIMO-1133 @Automated @Web @listing-monetization @mamipoin-owner @continue https://mamiteam-qa3.atlassian.net/browse/LIMO-3298
>>>>>>>> f4026dea (Xray LIMO 1 Feature: Mamipoint Blacklist and Whitelist Admin):src/test/resources/features/mamikos/LIMO/LIMO1/pointManagement/mamipoinBlacklistWhitelistAdmin.feature
  Scenario: [Admin] Change Whitelist to Blacklist
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    Then admin successfully "blacklisted" user named "Ramos Pembina Komsel1" with status "Whitelist"

<<<<<<<< HEAD:src/test/resources/features/mamikos/LIMO/LIMO-New-Era/LIMO1/Point-Management/mamipoint_blacklist_whitelist_admin.feature
  @TEST_LIMO-3299 @Automated @Web @listing-monetization @mamipoin-owner @continue
========
#  @TEST_LIMO-1134 @Automated @Web @listing-monetization @mamipoin-owner @continue https://mamiteam-qa3.atlassian.net/browse/LIMO-3299
>>>>>>>> f4026dea (Xray LIMO 1 Feature: Mamipoint Blacklist and Whitelist Admin):src/test/resources/features/mamikos/LIMO/LIMO1/pointManagement/mamipoinBlacklistWhitelistAdmin.feature
  Scenario: [Admin] Change Blacklist to Whitelist
    Then admin successfully "whitelisted" user named "Ramos Pembina Komsel1" with status "Blacklist"
    Then admin successfully "blacklisted" user named "Rega Dian Watts" with status "Whitelist"

<<<<<<<< HEAD:src/test/resources/features/mamikos/LIMO/LIMO-New-Era/LIMO1/Point-Management/mamipoint_blacklist_whitelist_admin.feature
  @TEST_LIMO-3300 @Automated @Web @listing-monetization @mamipoin-owner
========
#  @TEST_LIMO-2013 @Automated @Web @listing-monetization @mamipoin-owner https://mamiteam-qa3.atlassian.net/browse/LIMO-3300
>>>>>>>> f4026dea (Xray LIMO 1 Feature: Mamipoint Blacklist and Whitelist Admin):src/test/resources/features/mamikos/LIMO/LIMO1/pointManagement/mamipoinBlacklistWhitelistAdmin.feature
  Scenario: [Admin] Change Blacklist to Whitelist
    Then admin successfully "whitelisted" user named "Rega Dian Watts" with status "Blacklist"