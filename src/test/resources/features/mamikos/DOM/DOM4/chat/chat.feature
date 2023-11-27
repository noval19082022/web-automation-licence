@DOM40
Feature: Chat and Chat Optimization

  @TEST_DOM-1737
  Scenario: [Dweb][Kost Detail][Chat] Chat details when chat room not exists
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     |  phone prod     | password     |
      | 083838716086   |  087880495933  | qwerty123    |
    And user click chat button in top bar owner home page
    Then user see chat empty image
    And user see text "Tidak ada percakapan saat ini." in empty chat description
    And user see indicator "Chat kosong" in bottom of empty chat page

  @TEST_DOM-1738
  Scenario: [Dweb][Kost Detail][Chat] Show login pop up when click chat button without login
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag                              | kost name prod                                      |
      | Kos Dom Automation PLM Tipe A Kretek Bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    And user click chat in kos detail
    Then user login from kost detail via phone number:
      | phone stag    | phone prod    | password     |
      | 081223344550  | 083176408442  | qwerty123    |

  @continue @TEST_DOM-1736
  Scenario: [Dweb][Kost Detail][Chat] Show all selectable questions before chat
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 081223344550  | 083176408442  | qwerty123    |
    And tenant search kost then go to kost details:
      | kost name stag                              | kost name prod                                      |
      | Kos Dom Automation PLM Tipe A Kretek Bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    And user click chat in kos detail
    Then user see phone number field and selectable question options :
      | Saya butuh cepat nih. Bisa booking sekarang? |
      | Apakah ini testing question?                 |
      | Ada diskon untuk kos ini?                    |
      | Masih ada kamar?                             |
      | Alamat kos di mana?                          |
      | Cara menghubungi pemilik?                    |
      | Boleh tanya-tanya dulu?                      |
      | Bisa pasutri?                                |
      | Boleh bawa hewan?                            |
      | Bisa sewa harian?                            |

  @TEST_DOM-1735
  Scenario: [Dweb][Kost Detail][Chat] Redirect to booking form page when contact kos with instant booking
    When send button become "Ajukan Sewa"
    And user select question "Saya butuh cepat nih. Bisa booking sekarang?"
    And tenant click button ajukan sewa from chat popup
    Then it will redirect to Booking page

  @TEST_DOM-1734
  Scenario: [Dweb][Kost Detail][Chat] Tenant can send message to Owner
    When user go to mamikos homepage
    And user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 081223344550  | 083176408442  | qwerty123    |
    And tenant search kost then go to kost details:
      | kost name stag          | kost name prod                             |
      | Kose Mamiset Automation | Kost Automation Mix Tobelo Halmahera Utara |
    And user click chat in kos detail
    And user select question "Cara menghubungi pemilik?"
    And user click send chat from popup
    And chat room appear with latest message "Chatroom ini telah terhubung dengan pemilik kost, Anda dapat mengajukan pertanyaan dan berkomunikasi dengan pemilik iklan secara real time atau hubungi"
    And tenant enter text "Boleh minta nomor yang bisa dihubungi?" in chat page
    Then chat room appear with latest message "Boleh minta nomor yang bisa dihubungi?"

  @TEST_DOM-1734
  Scenario: [Dweb][Kost Detail][Chat] Owner can send message to Tenant
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     |  phone prod     | password      |
      | 083176408311   |  083132824758   | qwerty123 |
    And user click chat button in top bar owner home page
    And search chat in chatlist "Raney Arora"
    Then chat room appear with latest message "Boleh minta nomor yang bisa dihubungi?"
    When owner enter text "My phone is 00000000001" in chat page
    Then chat room appear with latest message "My phone is 00000000001"

  @continue @TEST_DOM-1742
  Scenario: [Dweb][Kost Detail][Chat]Check functionality of booking button disable
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 081223344550  | 083176408442  | qwerty123    |
    And tenant search kost then go to kost details:
      | kost name stag                                             | kost name prod                                             |
      | Kos BX Automation BBK Non Available Cilacap Tengah Cilacap | Kos BX Automation BBK Non Available Tobelo Halmahera Utara |
    And user click chat in kos detail
    And user select question "Boleh tanya-tanya dulu?"
    And user click send chat from popup
    Then chat room appear with latest message "Boleh dong. Silakan tanya apapun. Chat ini dibaca langsung oleh pemilik kos."
    And user sees the Booking button disable

  @continue @TEST_DOM-1733
  Scenario Outline: [Dweb][Kost Detail][Chat]Check autoreply text after select question <name>
    Given user go to mamikos homepage
    When user search for Kost with name "<property>" and selects matching result
    And user click chat in kos detail
    And user select question "<question>"
    And user click send chat from popup
    Then chat room appear with latest message "<autoreply text>"
    Examples:
      | name                     | property                                    | question                  | autoreply text                                                                                                                                          |
      | Ada diskon               | Kos Dom Automation PLM Tipe A Kretek Bantul | Ada diskon untuk kos ini? | Diskon yang berlaku saat ini:                                                                                                                           |
      | Masih ada kamar          | Kos Dom Automation PLM Tipe A Kretek Bantul | Masih ada kamar?          | Ada. Di kos ini masih ada 6 kamar kosong, sesuai update dari pemilik pada                                                                               |
      | Tanya-tanya dulu         | Kos Dom Automation PLM Tipe A Kretek Bantul | Boleh tanya-tanya dulu?   | Boleh dong. Silakan tanya apapun. Chat ini dibaca langsung oleh pemilik kos.                                                                            |
      | Cara menghubungi pemilik | Kos Dom Automation PLM Tipe A Kretek Bantul | Cara menghubungi pemilik? | Chatroom ini telah terhubung dengan pemilik kost, Anda dapat mengajukan pertanyaan dan berkomunikasi dengan pemilik iklan secara real time atau hubungi |
      | Alamat kos di mana       | Kos Dom Automation PLM Tipe A Kretek Bantul | Alamat kos di mana?       | beralamat di                                                                                               											 |
      | Bisa pasutri             | Kost BG Automation                          | Bisa pasutri?             | Pasutri bisa menyewa kos ini.                                                                                                                           |
      | Tidak bisa pasutri       | Kos Dom Automation PLM Tipe A Kretek Bantul | Bisa pasutri?             | Pasutri tidak bisa menyewa kos ini.                                                                                                                     |
      | Boleh bawa hewan         | Kost BG Automation                          | Boleh bawa hewan?         | Kamu boleh membawa hewan ke kos ini.                                                                                                                    |
      | Tidak boleh bawa hewan   | Kos Dom Automation PLM Tipe A Kretek Bantul | Boleh bawa hewan?         | Kamu tidak boleh membawa hewan ke kos ini.                                                                                                              |

  @continue @TEST_DOM-1741
  Scenario: [Dweb][Kost Detail][Chat] Check functionality of booking button active
    Given user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                                          | kost name prod                                         |
      | Kos BX Automation BBK Available Cilacap Selatan Cilacap | Kos BX Automation BBK Available Tobelo Halmahera Utara |
    And tenant booking kost
    Then tenant should success booking kost

  @cancelBooking
  Scenario: Cancel Booking if Tenant Have Booking
    When user cancel booking

  @TEST_DOM-1740
  Scenario Outline: [Dweb][Kost Detail][Chat] Check functionality Lihat detail button on BBK and Non BBK
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 081223344550  | 083176408442  | qwerty123    |
    And user search for Kost with name "<property>" and selects matching result
    And user click chat in kos detail
    And user select question "Boleh tanya-tanya dulu?"
    And user click send chat from popup
    Then chat room appear with latest message "Boleh dong. Silakan tanya apapun. Chat ini dibaca langsung oleh pemilik kos."
    And user clicks the Lihat Iklan button and redirect to detail property
    Examples:
      | property                                                   |
      | Kos BX Automation Non BBK Cilacap Selatan Cilacap          |
      | Kos BX Automation BBK Non Available Cilacap Tengah Cilacap |

  @TEST_DOM-1739
  Scenario: [Dweb][Apartemen Detail][Chat] Check roomcard on apartemen should not display
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 081223344550  | 083176408442  | qwerty123    |
    And user go to apartment details from apartment landing list number 1
    And tenant set active page to 1
    And user click on hubungi pengelola button
    And user select question "Boleh tahu alamat lengkap apartemen ini?"
    And user click send chat from popup
    Then chat room appear with latest message "Hai, terima kasih sudah berminat pada apartemen ini. Alamat lengkapnya adalah"
