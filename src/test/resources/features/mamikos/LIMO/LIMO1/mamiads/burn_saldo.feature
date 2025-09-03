@LIMO5 @burnSaldoMamiads
Feature: Mamiads Burn Saldo

  Scenario: Inject To Set Saldo Mamiads on admin page
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin visit page "/admin/request/kost/99454727"
    And admin bangkrupux adjust mamiads with intial value "7500" usage "" and alocated "0"

  @TEST_LIMO-1507
  Scenario Outline: [MamjAds][Naikkan iklan]: Activate mamiads iklan
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 089876543  | 0          | qwerty123 |
    And user navigates to mamiads dashboard
    And owner clicks on coba sekarang button
    And user click ubah on "burn mamiads Purwokerto Timur Banyumas"
    When user set anggaran harian to "random 5k"
    And owner click Simpan Pengaturan on ubah anggaran
    And user click Ya,Ganti button
    And user click "<currentToggle>" toggle the "<adsName>"
    And user click "<actionButton>" button on pop up switch toggle iklan
    Examples:
      | adsName                                | currentToggle | actionButton |
      | burn mamiads Purwokerto Timur Banyumas | off           | Aktifkan     |

  Scenario: Burn Saldo more than 3 times (Expected will count 3 times)
    Given user go to mamikos homepage
    When user click on search kos
    And user want to search kost list by place on "Purwokerto" from homepage
    And user select first kost on the search result to burn saldo 5 times

  @TEST_LIMO-1508
  Scenario Outline: [MamiAds][Naikkan Iklan] Switch OFF ads while saldo burn > 0 from maximal budget
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 089876543  | 0          | qwerty123 |
    And user navigates to mamiads dashboard
    And owner clicks on coba sekarang button
    Then user cek status toggle iklan "<adsName>" is "<currentPosisiIklan>"
    And user verify the toggle iklan "<adsName>" is "<currentToggle>"
    And user verify the wording iklan "<adsName>" is "<currentStatusDesc>"
    And user verify the wording anggaran of iklan "<adsName>" contains "<currentAnggaranDesc>"
    When user click "<currentToggle>" toggle the "<adsName>"
    Then user verify the pop up switch "<currentToggle>" toggle iklan "<adsName>" is displayed
    When user click "<actionButton>" button on pop up switch toggle iklan
    Then user verify the toast "<messageToast>"
    And user cek status toggle iklan "<adsName>" is "<expectedPosisiIklan>"
    And user verify the toggle iklan "<adsName>" is "<expectedToggle>"
    And user verify the wording iklan "<adsName>" is "<expectedStatusDesc>"
    And user verify the wording anggaran of iklan "<adsName>" contains "<expectedAnggaranDesc>"
    Examples:
      | adsName                                | currentPosisiIklan | currentToggle | currentStatusDesc                                    | currentAnggaranDesc                 | actionButton    | messageToast              | expectedPosisiIklan | expectedToggle | expectedStatusDesc              | expectedAnggaranDesc           |
      | burn mamiads Purwokerto Timur Banyumas | naik               | on            | Posisi iklan telah naik di hasil pencarian properti. | Hari ini Rp1.500 sudah dipakai dari | Ya, Nonaktifkan | Iklan berhenti dinaikkan. | tidak-naik          | off            | Klik tombol untuk naikkan iklan | Hari ini Rp1.500 sudah dipakai |