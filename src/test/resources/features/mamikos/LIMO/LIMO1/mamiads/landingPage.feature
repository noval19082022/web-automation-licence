@regression @LIMO1
Feature: MamiAds Landing Page


  @TEST_LIMO-282
  Scenario: [Web][MamiAds][Landing Page] Check landing page mamiAds
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod | password |
      | 085951394565 | 0          | qwerty123 |
    And user go to mamikos homepage
    And user click "Promosikan Iklan Anda"
    And owner will see that the text "Tempatkan iklan properti Anda di posisi yang lebih tinggi dari iklan lainnya." is displayed
    And owner see button coba sekarang at header
    And owner will see that the text "Keuntungan Menggunakan MamiAds" is displayed
    And owner will see that the text "Berbagai fasilitas MamiAds untuk Anda" is displayed
    And owner will see that the text "Kata Pengguna MamiAds" is displayed
    And owner will see that the text "Simak kesan dari para pemilik kos setelah menggunakan MamiAds." is displayed
    And owner will see that the text "Gunakan MamiAds" is displayed
    And owner will see that the text "dengan 3 langkah mudah" is displayed
    And owner will see that the text "Tanya Jawab" is displayed
    And owner will see that the text "Pertanyaan yang sering ditanyakan" is displayed
    And user click question "Bagaimana cara menaikkan Iklan menggunakan MamiAds?"
    Then user verify answer text "Untuk dapat menggunakan fitur MamiAds untuk menaikkan iklan, Anda cukup membeli Saldo MamiAds dan menganggarkannya ke iklan Anda."
    When user click question "Apa itu Saldo MamiAds?"
    Then user verify answer text "Saldo MamiAds adalah saldo yang digunakan untuk mengiklankan kos Anda agar dapat menjangkau lebih banyak pencari kos."
    When user click question "Dari mana saya dapat mengakses MamiAds?"
    Then user verify answer text "Anda dapat mengakses MamiAds lewat website maupun aplikasi Mamikos."
    When user click "Coba Sekarang"
    Then user redirected to mamiads page