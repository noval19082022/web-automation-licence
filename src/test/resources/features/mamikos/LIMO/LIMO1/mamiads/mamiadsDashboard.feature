@regression @LIMO1
Feature: MamiAds Dashboard

  @TEST_LIMO-314
  Scenario: empty state if owner each filter while owner didn't have property
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod | password  |
      | 0895365623388 | 0          | qwerty123 |
    And user navigates to mamiads dashboard
    And owner clicks on coba sekarang button
    Then user can see filter iklan saya is "Semua Iklan"
    And user will see that the text "Anda Belum Punya Properti" is displayed
    And user will see that the text " Daftarkan dulu properti Anda di Mamikos untuk bisa memakai MamiAds. " is displayed
    When owner choose filter iklan saya to "Iklan Aktif"
    Then user will see that the text "Anda Belum Punya Properti" is displayed
    And user will see that the text " Daftarkan dulu properti Anda di Mamikos untuk bisa memakai MamiAds. " is displayed
    When owner choose filter iklan saya to "Iklan Nonaktif"
    Then user will see that the text "Anda Belum Punya Properti" is displayed
    And user will see that the text " Daftarkan dulu properti Anda di Mamikos untuk bisa memakai MamiAds. " is displayed

  @TEST_LIMO-320 @TEST_LIMO-313 @LIMO1-staging
  Scenario Outline: Switch ON OFF ads while saldo burn = 0
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod | password  |
      | 083176408449  | 0          | qwerty123 |
    And user navigates to mamiads dashboard
    And owner clicks on coba sekarang button
    Then user cek status toggle iklan "<adsName>" is "<currentPosisiIklan>"
    And user verify the toggle iklan "<adsName>" is "<currentToggle>"

#    @MA-5814 @MA-5815 @MA-5763 Wording status desc and anggaran desc
    And user verify the wording iklan "<adsName>" is "<currentStatusDesc>"
    And user verify the wording anggaran of iklan "<adsName>" is "<currentAnggaranDesc>"
    When user click "<currentToggle>" toggle the "<adsName>"
    Then user verify the pop up switch "<currentToggle>" toggle iklan "<adsName>" is displayed
    When user click "<actionButton>" button on pop up switch toggle iklan
    Then user verify the toast "<messageToast>"
    And user cek status toggle iklan "<adsName>" is "<expectedPosisiIklan>"
    And user verify the toggle iklan "<adsName>" is "<expectedToggle>"
    And user verify the wording iklan "<adsName>" is "<expectedStatusDesc>"
    And user verify the wording anggaran of iklan "<adsName>" is "<expectedAnggaranDesc>"

    Examples:
      | adsName             | currentPosisiIklan | currentToggle | currentStatusDesc                                    | currentAnggaranDesc                                            | actionButton    | messageToast              | expectedPosisiIklan | expectedToggle | expectedStatusDesc                                   | expectedAnggaranDesc                                           |
      | kos jipyo           | tidak-naik         | off           | Klik tombol untuk naikkan iklan                      | Tipe Anggaran: Saldo Maksimal                                  | Aktifkan        | Iklan berhasil dinaikkan  | naik                | on             | Posisi iklan telah naik di hasil pencarian properti. | Hari ini terpakai Rp0                                          |
      | Kos Upik 449 Tipe A | tidak-naik         | off           | Klik tombol untuk naikkan iklan                      | Tipe Anggaran: Rp15.000 per-hari                               | Aktifkan        | Iklan berhasil dinaikkan  | naik                | on             | Posisi iklan telah naik di hasil pencarian properti. | Hari ini Rp0 sudah dipakai dari batas pemakaian saldo Rp15.000 |
      | kos jipyo           | naik               | on            | Posisi iklan telah naik di hasil pencarian properti. | Hari ini terpakai Rp0                                          | Ya, Nonaktifkan | Iklan berhenti dinaikkan. | tidak-naik          | off            | Klik tombol untuk naikkan iklan                      | Tipe Anggaran: Saldo Maksimal                                  |
      | Kos Upik 449 Tipe A | naik               | on            | Posisi iklan telah naik di hasil pencarian properti. | Hari ini Rp0 sudah dipakai dari batas pemakaian saldo Rp15.000 | Ya, Nonaktifkan | Iklan berhenti dinaikkan. | tidak-naik          | off            | Klik tombol untuk naikkan iklan                      | Tipe Anggaran: Rp15.000 per-hari                               |