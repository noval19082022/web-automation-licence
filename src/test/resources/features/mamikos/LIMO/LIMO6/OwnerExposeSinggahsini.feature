@LIMO6
Feature: Owner Expose Singgahsini

  @TEST_SS-9797
  Scenario: [Web][Owner Dashboard][Singgahsini ID]Check Info untuk anda section and redirection when login owner p2 but don't have active kost
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 089604239002 | 089604239002 | qwerty123 |
    Then owner should see expose singgahini link
    When owner click on expose singgahsini link
    Then owner should redirect to singgahsini.id from Info Untuk Anda

  @TEST_SS-9798
  Scenario: [Web][Owner Dashboard][Singgahsini ID]Check Info untuk anda section and redirection when login owner p2
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 089604239001 | 089604239002 | qwerty123 |
    Then owner should see expose singgahini link
    When owner click on expose singgahsini link
    Then owner should redirect to singgahsini.id from Info Untuk Anda

  @TEST-SS-9803
  Scenario: [Web][Owner Dashboard][Kos Menu]Check CTA singgahsini id on Kost List when owner have kost p2 with "Aktif" status and have area prio
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 082088301090 | mamikos290|
    And owner dismiss FTUE goldplus
    And owner navigates to property saya kos
    Then owner should see CTA button Expose Singgahsini
    When owner click CTA button Expose Singgahsini
    Then owner should redirect to singgahsini.id from Kos

  @TEST_SS-9805
  Scenario: [Web][Owner Dashboard][Kos Menu]Check CTA singgahsini id on Kost List when owner have kost p2 with "Aktif" and "Diperiksa Admin" status and all have area prio
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 082088301091 | mamikos290|
    And owner dismiss FTUE goldplus
    And owner navigates to property saya kos
    Then owner should see CTA button Expose Singgahsini
    When owner click CTA button Expose Singgahsini
    Then owner should redirect to singgahsini.id from Kos

  @TEST_SS-9807
  Scenario: [Web][Owner Dashboard][Kos Menu]Check CTA singgahsini id on Kost List when owner have kost p2 with "Aktif" and "Diperiksa Admin" status and one of listing has match area prio
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 082088301092 | mamikos290|
    And owner dismiss FTUE goldplus
    And owner navigates to property saya kos
    Then owner should see CTA button Expose Singgahsini
    When owner click CTA button Expose Singgahsini
    Then owner should redirect to singgahsini.id from Kos

  @TEST_SS-9801
  Scenario: [Web][Owner Dashboard][Kos Menu]Check CTA singgahsini id on Kost List when owner have kost p2 with "Diperiksa admin" status  and have Area Prio
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 082088301093 | mamikos290|
    And owner dismiss FTUE goldplus
    And owner navigates to property saya kos
    Then owner should see CTA button Expose Singgahsini
    When owner click CTA button Expose Singgahsini
    Then owner should redirect to singgahsini.id from Kos

  @TEST_SS-9817 @continue @PopupCTA
  Scenario: Owner sees Singgahsini popup when changing draft property location to area prio
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password   |
      | 082088301094 | mamikos290 |
    And owner resets draft property location back to "Kretek"
    And owner edits draft property location to area prio "Tamantirto"
    Then Expose Singgahsini popup is displayed with:
      | message | Kos Anda dapat kesempatan untuk dikelola secara profesional! |
      | button  | Pelajari lebih lanjut                                         |
      | button  | Lewati dulu                                                   |

  @TEST_SS-9818 @PopupCTA
  Scenario: Owner redirects to Singgahsini.id when clicking "Pelajari lebih lanjut" on popup
    When owner clicks "Pelajari lebih lanjut" on the popup
    Then owner is redirected to Singgahsini.id with source "kos saya pop up singgahsini"

  @TEST_SS-9802
  Scenario: [Web][Owner Singgahsini ID][Kos Menu ]Check CTA singgahsini id on Kost List when owner have kost p2 with "Diperiksa admin" status  and don't have Area Prio
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password   |
      | 082088301096 | mamikos290 |
    Then owner can't see button CTA expose singgahsini

  @TEST_SS-9804
  Scenario: [Web][Owner Singgahsini ID][Kos Menu ]Check CTA singgahsini id on Kost List when owner have kost p2 with "Aktif" status and don't have area prio
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password   |
      | 082088301097 | mamikos290 |
    Then owner can't see button CTA expose singgahsini