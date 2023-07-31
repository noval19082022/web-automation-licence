@regression @goldPlus @subcribeGp @allEntryPoint @LIMO2 @listing-monetization
Feature: Subscribe GP from all entry point

  @TEST_LIMO-2501 @subcribeFromInfoUntukAnda @continue
  Scenario Outline: Check subscribe GP from entry point info untuk anda
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password   |
      | <ownerPhone> | <password> |
    And user click info untuk anda "<infoUntukAnda>"
    Then user verify "<expectedDisplay>" is appear

    @subscribeFromChatList @continue
#    Scenario: Check subscribe GP from entry point chatlist
    When owner navigates to owner dashboard
    And owner click "Daftar GoldPlus" button on chatlist
    Then user redirected to "/goldplus/submission/packages?redirection_source=mars_gp_chatlist"

    @subscribeFromChatrooms @continue
#    Scenario: Check subscribe GP from entry point chatrooms
    When owner navigates to owner dashboard
    And owner click "Daftar GoldPlus" button on chatrooms "Raney Upik Bertiga"
    Then user redirected to "/goldplus/submission/packages?redirection_source=mars_gp_chatroom"

    @subscribeFromAturPromo @continue
#    Scenario: Check subscribe GP from entry point Atur Promo
    When owner navigates to property saya kos
    And owner search kost "Kos Premium Automation 517" on property saya page
    And owner atur promo owner
    Then user verify list of Goldplus package is appear

    @subscribeFromBroadcastChat @continue
    When owner navigates to "/broadcast-chat"
    And verify button on broadcast page
    And owner will see that the text "Fitur ini khusus pengguna GoldPlus 2" is displayed
    Examples:
      | ownerPhone   | password  | infoUntukAnda | expectedDisplay |
      | 081905128517 | qwerty123 | Kuota chat habis. 2 pencari kos menunggu balasan, pakai GoldPlus agar bisa balas | list of Goldplus package |
      | 088112233451 | qwerty123 | 1 calon penyewa menunggu balasan chat. Yuk balas biar cepat di-booking. | Daftar GoldPlus |