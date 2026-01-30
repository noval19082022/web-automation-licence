@LIMO3 @pprsnongp @pprsowner
Feature: PPRS - Check statistic section for owner non GP

  @TEST_LIMO-805 @TEST_LIMO-806 @TEST_LIMO-807 @continue
  Scenario: [WEB][PPRS] Display Recommendation Card on Owner Dashboard When Room is Available and segment is Low
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | password  |
      | 0898765430 | qwerty123 |
    When owner navigates to property saya kos
    And owner search kost "Kost bapak kos baik Ngaglik Sleman" on property saya page
    And user click Lihat Selengkapnya button for edit
    And owner click "Update Harga"
    And user input monthly price with "200000"
    And user clicks update price button
    Then user see pop up success update price "Harga berhasil diupdate"

    And owner accsess statistic page
    Then user will see that the text "Langganan GoldPlus 1 bisa menaikkan jumlah chat hingga 3 kali lipat. Yuk, coba!" is displayed
    And owner swipe next on pprs statistik
    Then user will see that the text "Pakai GoldPlus 2, Anda bisa melihat info calon penyewa yang chat Anda." is displayed

  @TEST_LIMO-811 @TEST_LIMO-810 @TEST_LIMO-809
  Scenario: [WEB][PPRS] Display Recommendation Card on Owner Dashboard When Room is Available and segment is medium/high
    Given owner navigates to property saya kos
    And owner search kost "Kost bapak kos baik Ngaglik Sleman" on property saya page
    And user click Lihat Selengkapnya button for edit
    And owner click "Update Harga"
    And user input monthly price with "20000000"
    And user clicks update price button
    Then user see pop up success update price "Harga berhasil diupdate"

    And owner accsess statistic page
    Then user will see that the text "Langganan GoldPlus 2 bisa menaikkan jumlah chat hingga 3 kali lipat. Yuk, coba!" is displayed
    And owner swipe next on pprs statistik
    Then user will see that the text "Tayang teratas sesuai kata kunci di Mamikos, iklan jadi mudah ditemukan!" is displayed
    And owner swipe next on pprs statistik
    Then user will see that the text "Pakai GoldPlus 2, Anda bisa melihat info calon penyewa yang chat Anda." is displayed
