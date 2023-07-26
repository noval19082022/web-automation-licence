@newowner-dashboard @regression @LIMO2 @listing-monetization @ownerDashboardGP
Feature: Owner Dashboard GP

  @TEST_LIMO-1723
  Scenario: See info untuk anda while MARS NON GP with have unreplied chat and quota
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password |
      | 082233545515 | 0          | 12345678 |
    Then owner click "1 calon penyewa menunggu balasan chat. Yuk balas biar cepat di-booking."
    * user will see that the text "Sisa kuota mingguan" is displayed
    * user will see that the text "1 chat room" is displayed

  @TEST_LIMO-1725 @continue
  Scenario: See info untuk anda while MARS NON GP with have unreplied chat and doesnt have quota
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password |
      | 088112233452 | 0          | qwerty123 |
    Then user will see that the text "Kuota chat habis. 1 pencari kos menunggu balasan, pakai GoldPlus agar bisa balas chat. " is displayed
    * user will see that the text "Sewa jasa foto & video profesional dari Mami Foto dan tingkatkan daya tarik kosan Anda!" is displayed
    * user will see that the text "Voucher diskon s/d 15% untuk MamiAds di halaman pembayaran! " is displayed
  @checkRedirectionInfoUntukAndaDoesntHaveQuota @continue
  Scenario: check redirection info untuk anda while MARS NON GP with have unreplied chat and doesnt have quota
    When owner click "Kuota chat habis. 1 pencari kos menunggu balasan, pakai GoldPlus agar bisa balas chat. "
    Then user should redirect to link "https://owner-jambu.kerupux.com/goldplus/submission/packages"
    And owner navigates to "/"
    When owner click "Sewa jasa foto & video profesional dari Mami Foto dan tingkatkan daya tarik kosan Anda!"
    Then user should redirect to link "https://owner-jambu.kerupux.com/mamifoto"
    And owner navigates to "/"
    When owner click "Voucher diskon s/d 15% untuk MamiAds di halaman pembayaran! "
    Then user should redirect to link "https://owner-jambu.kerupux.com/mamiads/balance"
    And owner should successfully log out

  @TEST_LIMO-1724 @continue
  Scenario: See info untuk anda while MARS NON GP with doesnt have unreplied chat and doesnt have quota
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password |
      | 088112233453 | 0          | qwerty123 |
    Then user will see that the text "GoldPlus 2 diskon 15% hanya dengan voucher di halaman pembayaran! " is displayed
    * user will see that the text "Sewa jasa foto & video profesional dari Mami Foto dan tingkatkan daya tarik kosan Anda!" is displayed
    * user will see that the text "Voucher diskon s/d 15% untuk MamiAds di halaman pembayaran! " is displayed
  @checkRedirectionInfoUntukAndaDoesntHaveQuota @continue
  Scenario: check redirection info untuk anda while MARS NON GP with have unreplied chat and doesnt have quota
    When owner click "GoldPlus 2 diskon 15% hanya dengan voucher di halaman pembayaran! "
    Then user should redirect to link "https://owner-jambu.kerupux.com/goldplus/submission/periode/gp2"
    And owner navigates to "/"
    When owner click "Sewa jasa foto & video profesional dari Mami Foto dan tingkatkan daya tarik kosan Anda!"
    Then user should redirect to link "https://owner-jambu.kerupux.com/mamifoto"
    And owner navigates to "/"
    When owner click "Voucher diskon s/d 15% untuk MamiAds di halaman pembayaran! "
    Then user should redirect to link "https://owner-jambu.kerupux.com/mamiads/balance"

