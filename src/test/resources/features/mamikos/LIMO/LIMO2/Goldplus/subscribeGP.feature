@regression @goldPlus @subcribeGp @allEntryPoint @LIMO2 @listing-monetization
Feature: Subscribe GP from all entry point

  @TEST_LIMO-2501
  Scenario Outline: Check subscribe GP from entry point info untuk anda
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password   |
      | <ownerPhone> | <password> |
    And user click info untuk anda "<infoUntukAnda>"
    Then user verify "<expectedDisplay>" is appear
    Examples:
      | ownerPhone     | password  | infoUntukAnda                                                                          | expectedDisplay            |
      | 081905128517   | qwerty123 | Kuota chat habis. 2 pencari kos menunggu balasan, pakai GoldPlus agar bisa balas chat. | list of Goldplus package   |
      | 088112233451   | qwerty123 | 1 calon penyewa menunggu balasan chat. Yuk balas biar cepat di-booking.                | Daftar GoldPlus            |
      | 08167382940592 | qwerty123 | GoldPlus 2 diskon 15% hanya dengan voucher di halaman pembayaran!                      | Pilih Periode Berlangganan |
      | 088112233453   | qwerty123 | GoldPlus 2 diskon 15% hanya dengan voucher di halaman pembayaran!                      | Pilih Periode Berlangganan |

  @TEST_LIMO-2502 @otherEntryPointExceptInfoUntukAnda @continue
  Scenario: Check subscribe GP from entry point chatlist
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 081905128517 | qwerty123 |
    And owner click "Daftar GoldPlus" button on chatlist
    Then user redirected to "/goldplus/submission/packages?redirection_source=mars_gp_chatlist"

  @TEST_LIMO-2354 @otherEntryPointExceptInfoUntukAnda @subscribeFromChatrooms @continue
  Scenario: Check subscribe GP from entry point chatrooms
    Given owner navigates to owner dashboard
    When owner click "Daftar GoldPlus" button on chatrooms "Raney Upik Bertiga"
    Then user redirected to "/goldplus/submission/packages?redirection_source=mars_gp_chatroom"

  @TEST_LIMO-2504 @otherEntryPointExceptInfoUntukAnda @subscribeFromAturPromo @continue
  Scenario: Check subscribe GP from entry point Atur Promo
    Given owner navigates to property saya kos
    When owner search kost "Kos Premium Automation 517" on property saya page
    And owner atur promo owner
    Then user verify list of Goldplus package is appear

  @TEST_LIMO-2354 @otherEntryPointExceptInfoUntukAnda @subscribeFromBC @continue
  Scenario: Check subscibe GP from entry point BC
    Given owner navigates to "/broadcast-chat"
    Then verify button on broadcast page
    And owner will see that the text "Fitur ini khusus pengguna GoldPlus 2" is displayed
    When owner click "Beli Paket" on broadcast chat page
    Then payment owner success using ovo as payment method

  @otherEntryPointExceptInfoUntukAnda @resetAccount
  Scenario: delete or reset data GP
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And user wants to reset Goldplus for owner with phone number "081905128517"