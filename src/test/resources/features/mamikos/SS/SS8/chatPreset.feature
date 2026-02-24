@SS7@chatPreset
Feature: Chat Preset

  @TEST_SS-6049 @continue
  Scenario: [Chat preset][Auto reply][Chat Room] Check question and answer Ada diskon untuk kos ini for Kost P1 doesn't have discount
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod    | password  |
      | 081300000001 | 0890000000314 | qwerty123 |
    And user click on chat button in top bar tenant home page
    And user click "Kost Singgahsini Cemara Pinus Tipe A Bantul"
    Then user can see chat preset question "Ada diskon untuk kos ini?"
    And user select chat preset question "Ada diskon untuk kos ini?"
    Then chat room appear with latest message "Yah, mohon maaf. Belum ada diskon yang tersedia untuk kos ini."

  @TEST_SS-6048 @continue
  Scenario: [Chat preset][Auto reply][Chat Room] Check question and answer Ada diskon untuk kos ini for Kost P1 have discount
    When user go to mamikos homepage
    And user click on chat button in top bar tenant home page
    And user click "Kost Singgahsini Griya Warungboto Tipe A Yogyakarta"
    Then user can see chat preset question "Ada diskon untuk kos ini?"
    And user select chat preset question "Ada diskon untuk kos ini?"
    Then chat room appear with latest message "Ada dong. Diskon yang tersedia: Promo listrik. Potongan listrik Rp20.000 dibulan pertaman. Periode promo 20 Oct 2024 s/d 31 Jul 2028."

  @TEST_SS-6050 @continue
  Scenario: [Chat preset][Auto reply][Chat Room] Check question Boleh Pasutri on chat preset and check the answer for kost P1 and have pasutri
    When user go to mamikos homepage
    And user click on chat button in top bar tenant home page
    And user click "Kost Singgahsini Agnes Tabelo Tipe A Halmahera"
    Then user can see chat preset question "Bisa pasutri?"
    And user select chat preset question "Bisa pasutri?"
    Then chat room appear with latest message "Kos ini bisa disewa pasutri ya, kak."

  @TEST_SS-5892 @continue
  Scenario: [Chat preset][Auto reply][Chat Room] check the answer ada fasilitas parkir for kost P1 have parkir mobil and parkir motor
    When user go to mamikos homepage
    And user click on chat button in top bar tenant home page
    And user click "Kost Apik Kost Apik Harpalyke Haya Grey Tobelo Halmahera Utara"
    Then user can see chat preset question "Ada fasilitas parkir?"
    And user select chat preset question "Ada fasilitas parkir?"
    Then chat room appear with latest message "Ada fasilitas parkir motor dan mobil ya, kak. Biaya tambahan: Parkir Mobil Rp10.000/Bulan. Parkir Motor Rp5.000/Bulan. Untuk ketersediaannya, kami akan periksa kembali dan update infonya kepada kakak maksimal 1x24 jam. Mohon menunggu, ya."

  @TEST_SS-5893
  Scenario: [Chat preset][Auto reply][Chat Room] check the answer ada fasilitas parkir for kost P1 doesnt have parkir
    When user go to mamikos homepage
    And user click on chat button in top bar tenant home page
    And user click "Kost Apik Serayu Utara Tipe A Kretek"
    Then user can see chat preset question "Ada fasilitas parkir?"
    And user select chat preset question "Ada fasilitas parkir?"
    Then chat room appear with latest message "Mohon menunggu maksimal 1x24 jam untuk informasi ter-update disampaikan oleh pengelola kos ya, kak."

  @TEST_SS-6051 @continue
  Scenario: [Chat preset][Auto reply][Chat Room] Check question Boleh Pasutri on chat preset and check the answer for kost P1 and doesn't have pasutri
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod    | password  |
      | 081300000002 | 0890000000314 | qwerty123 |
    And user click on chat button in top bar tenant home page
    And user click "Kost Apik Cheap Door Mawar Maluku Utara"
    Then user can see chat preset question "Bisa pasutri?"
    And user select chat preset question "Bisa pasutri?"
    Then chat room appear with latest message "Kos ini tidak bisa disewa pasutri ya, kak. Apakah kakak sedang mencari kos yang bisa pasutri?"

  @TEST_SS-6052 @continue
  Scenario: [Chat preset][Auto reply][Chat Room] Check question Boleh bawa hewan on chat preset and check the answer for kost P1 and kost have tagging bawa hewan
    When user go to mamikos homepage
    And user click on chat button in top bar tenant home page
    And user click "Kost Singgahsini Cemara Pinus Tipe A Bantul"
    Then user can see chat preset question "Boleh bawa hewan?"
    And user select chat preset question "Boleh bawa hewan?"
    Then chat room appear with latest message "Penyewa boleh membawa hewan di kos ini ya, kak."

  @TEST_SS-6053 @continue
  Scenario: [Chat preset][Auto reply][Chat Room] Check question Boleh bawa hewan on chat preset and check the answer for kost P1 and kost dont have tagging bawa hewan
    When user go to mamikos homepage
    And user click on chat button in top bar tenant home page
    And user click "Kost Apik Cheap Door Mawar Maluku Utara"
    Then user can see chat preset question "Boleh bawa hewan?"
    And user select chat preset question "Boleh bawa hewan?"
    Then chat room appear with latest message "Penyewa tidak boleh bawa hewan peliharaan di kos ini ya, kak. Apakah kakak sedang mencari kos yang bisa bawa hewan peliharaan?"

  @TEST_SS-5890 @continue
  Scenario: [Chat preset][Auto reply][Chat Room] Check question Ada Parkir on chat preset and check the answer for kost P1 and have add fee Biaya parkir mobil
    When user go to mamikos homepage
    And user click on chat button in top bar tenant home page
    And user click "Kost Fahmi Singgahsini Campur Indralaya Utara Ogan Ilir"
    Then user can see chat preset question "Ada fasilitas parkir?"
    And user select chat preset question "Ada fasilitas parkir?"
    Then chat room appear with latest message "Ada fasilitas parkir mobil ya, kak. Biaya tambahan: Parkir Mobil Rp10.000/Bulan.Untuk ketersediaannya, kami akan periksa kembali dan update infonya kepada kakak maksimal 1x24 jam. Mohon menunggu, ya."

  @TEST_SS-5891
  Scenario: [Chat preset][Auto reply][Chat Room] Check question Ada Parkir Motor on chat preset and check the answer for kost P1
    When user go to mamikos homepage
    And user click on chat button in top bar tenant home page
    And user click "Kost Apik Bohemian Tipe A Cilacap Tengah"
    Then user can see chat preset question "Ada fasilitas parkir?"
    And user select chat preset question "Ada fasilitas parkir?"
    Then chat room appear with latest message "Ada fasilitas parkir motor ya, kak. Biaya tambahan: Parkir Motor Rp10.000/Minggu.Untuk ketersediaannya, kami akan periksa kembali dan update infonya kepada kakak maksimal 1x24 jam. Mohon menunggu, ya."

  @TEST_SS-5858 @continue
  Scenario: [Chat][Auto Reply] Auto reply question for condition "Tidak bisa sekamar berdua"
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod    | password  |
      | 081300000003 | 0890000000314 | qwerty123 |
    And user click on chat button in top bar tenant home page
    And user click "Kost Singgahsini Gita Tipe A Halmahera Utara"
    Then user can see chat preset question "Kamar bisa diisi lebih dari 1 orang?"
    And user select chat preset question "Kamar bisa diisi lebih dari 1 orang?"
    Then chat room appear with latest message "Mohon menunggu maksimal 1x24 jam untuk informasi ter-update disampaikan oleh pengelola kos ya, kak."

  @TEST_SS-5859 @continue
  Scenario: [Chat][Auto Reply] Auto reply question for condition "Bisa Sekamar Berdua"
    When user go to mamikos homepage
    And user click on chat button in top bar tenant home page
    And user click "Kost Singgahsini Sanrio Kitty Halmahera Utara"
    Then user can see chat preset question "Kamar bisa diisi lebih dari 1 orang?"
    And user select chat preset question "Kamar bisa diisi lebih dari 1 orang?"
    Then chat room appear with latest message "Tipe kamar ini bisa diisi maks. 2 orang/ kamar ya, kak. Biaya tambahan: Sekamar Berdua Rp100.000/Bulan."

  @TEST_SS-5861 @continue
  Scenario: [Chat][Auto Reply] Auto reply question for condition "Sekamar bertiga"
    When user go to mamikos homepage
    And user click on chat button in top bar tenant home page
    And user click "Kost Singgahsini Sanrio Kitty Halmahera Utara"
    Then user can see chat preset question "Kamar bisa diisi lebih dari 1 orang?"
    And user select chat preset question "Kamar bisa diisi lebih dari 1 orang?"
    Then chat room appear with latest message "Tipe kamar ini bisa diisi maks. 2 orang/ kamar ya, kak. Biaya tambahan: Sekamar Berdua Rp100.000/Bulan."

  @TEST_SS-5860
  Scenario: [Chat][Auto Reply] Add criteria question "SekamarLebihDariDuaOrang"
    When user go to mamikos homepage
    And user click on chat button in top bar tenant home page
    And user click "Kost Singgahsini Sanrio Kitty Halmahera Utara"
    Then user can see chat preset question "Kamar bisa diisi lebih dari 1 orang?"

  @TEST_SS-6322 @continue
  Scenario: [Chat][Auto Reply] Auto reply question for condition "Boleh tanya-tanya dulu?"
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod   | password  |
      | 08999222999 | 083176408442 | qwerty123 |
    And tenant redirect to kost details:
      | kost path stag                                                                            | kost path prod                              |
      | kost-kabupaten-bantul-kost-campur-eksklusif-kost-singgahsini-cemara-pinus-tipe-a-bantul-2 | Kost Singgahsini Cemara Pinus Tipe A Bantul |
    And user dismiss FTUE booking benefit
    And user click chat in kos detail
    Then user can see chat preset question "Boleh tanya-tanya dulu?"
    And user select chat preset question "Boleh tanya-tanya dulu?"
    Then chat room appear with latest message "Boleh dong. Silakan tanya apapun. Chat ini dibaca langsung oleh pemilik kos."

  @TEST_SS-5950 @continue
  Scenario: [Chat Menu][Chat Room] Redirection back button to chat page
    When user go to mamikos homepage
    And user click on chat button in top bar tenant home page
    And user click "Kost Singgahsini Cemara Pinus Tipe A Bantul"
    And user click back button chatroom
    Then user can see Chat list title

  @TEST_SS-5951 @continue
  Scenario: [Tanya Pemilik][Chat Room] Redirection back button to detail listing page
    When tenant redirect to kost details:
      | kost path stag                                                | kost path prod                              |
      | kost-sleman-kost-campur-murah-kost-apik-desta-tipe-a-tamvan-2 | Kost Singgahsini Cemara Pinus Tipe A Bantul |
    And user dismiss promo ngebut pop up
    And user click chat in kos detail
    And user click back button chatroom
    Then user can see apik badge kos

  @TEST_SS-5952
  Scenario: [Tanya Pemilik][Chat Room] Redirection to existing chat
    When tenant redirect to kost details:
      | kost path stag                                                | kost path prod                              |
      | kost-sleman-kost-campur-murah-kost-apik-desta-tipe-a-tamvan-2 | Kost Singgahsini Cemara Pinus Tipe A Bantul |
    And user dismiss promo ngebut pop up
    And user click chat in kos detail
    Then user can see chat preset question "Halo, ada kos yang masih kosong?"