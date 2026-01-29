@SS14 @essentialTest
Feature: Chat and Chat Optimization

        @TEST_SS-3290
        Scenario: [Dweb][Kost Detail][Chat] Chat details when chat room not exists
            Given user go to mamikos homepage
             When user login as owner:
                  | phone stag   | phone prod   | password  |
                  | 083838716086 | 087880495933 | qwerty123 |
              And user click chat button in top bar owner home page
             Then user see chat empty image
              And user see text "Tidak ada percakapan saat ini." in empty chat description
              And user see indicator "Chat kosong" in bottom of empty chat page

        @TEST_SS-3291
        Scenario: [Dweb][Kost Detail][Chat] Show login pop up when click chat button without login
            Given user go to mamikos homepage
             When tenant redirect to kost details:
                  | kost path stag                                                                          | kost path prod                                      |
                  | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dom-automation-plm-tipe-a-kretek-bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
              And user dismiss FTUE booking benefit
              And user click chat in kos detail
             Then user login from kost detail via phone number:
                  | phone stag   | phone prod   | password  |
                  | 081223344570 | 083176408442 | qwerty123 |

        @continue @TEST_SS-3293
        Scenario: [Dweb][Kost Detail][Chat] Show all selectable questions before chat
            Given user go to mamikos homepage
             When user login as tenant via phone number:
                  | phone stag   | phone prod   | password  |
                  | 081223344570 | 083176408442 | qwerty123 |
              And tenant redirect to kost details:
                  | kost path stag                                                                        | kost path prod                     |
                  | kost-kabupaten-halmahera-utara-kost-campur-murah-kost-kuning-tobelo-halmahera-utara-2 | Kost Kuning Tobelo Halmahera Utara |
              And user dismiss FTUE booking benefit
              And user click chat in kos detail
             Then user see phone number field and selectable question options :
                  | Apakah boleh bawa hewan peliharaan?          |
                  | Masih ada kamar?                             |
                  | Saya butuh cepat nih. Bisa booking sekarang? |
                  | Ada diskon untuk kos ini?                    |
                  | Saya ingin survei dulu                       |
                  | Alamat kos di mana?                          |
                  | Kamar bisa diisi lebih dari 1 orang?         |
                  | Cara menghubungi pemilik?                    |
                  | Boleh tanya-tanya dulu?                      |
                  | Bisa pasutri?                                |
                  | Boleh bawa hewan?                            |
                  | Bisa sewa harian?                            |
                  | Ada fasilitas parkir?                        |
                  | Apakah singgahsini boleh dikontrakan?        |

        @TEST_SS-3292
        Scenario: [Dweb][Kost Detail][Chat] Redirect to booking form page when contact kos with instant booking
              And user select question "Saya butuh cepat nih. Bisa booking sekarang?"
              Then send button become "Ajukan Sewa"
              And tenant click button ajukan sewa from chat popup
             Then it will redirect to Booking page

        @TEST_SS-3289
        Scenario: [Dweb][Kost Detail][Chat] Tenant can send message to Owner
             When user go to mamikos homepage
              And user login as tenant via phone number:
                  | phone stag   | phone prod   | password  |
                  | 081223344570 | 083176408442 | qwerty123 |
              And tenant redirect to kost details:
                  | kost path stag                                                                          | kost path prod                             |
                  | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dom-automation-plm-tipe-a-kretek-bantul | Kost Automation Mix Tobelo Halmahera Utara |
              And user dismiss FTUE booking benefit
              And user click chat in kos detail
              And tenant enter text "Boleh minta nomor yang bisa dihubungi?" in chat page
             Then chat room appear with latest message "Boleh minta nomor yang bisa dihubungi?"

        @TEST_SS-3283
        Scenario: [Dweb][Kost Detail][Chat] Owner can send message to Tenant
            Given user go to mamikos homepage
             When user login as owner:
                  | phone stag  | phone prod   | password  |
                  | 08888812912 | 083132824758 | qwerty123 |
              And user click chat button in top bar owner home page
              And search chat in chatlist "Coop Chat Automation"
              And user dismiss FTUE TBC
             Then chat room appear with latest message "Boleh minta nomor yang bisa dihubungi?"
             When owner enter text "My phone is 00000000001" in chat page
             Then chat room appear with latest message "My phone is 00000000001"

        @TEST_SS-3282
        Scenario: [Dweb][Kost Detail][Chat]Check functionality of booking button disable
            Given user go to mamikos homepage
             When user login as tenant via phone number:
                  | phone stag   | phone prod   | password  |
                  | 081223344570 | 083176408442 | qwerty123 |
              And tenant redirect to kost details:
                  | kost path stag                                                                                         | kost path prod                                             |
                  | kost-kabupaten-cilacap-kost-putri-eksklusif-kos-bx-automation-bbk-non-available-cilacap-tengah-cilacap | Kos BX Automation BBK Non Available Tobelo Halmahera Utara |
              And user click chat in kos detail
             Then user sees the Booking button disable
#
        @TEST_SS-3269
        Scenario: [Dweb][Kost Detail][Chat] Check functionality of booking button active
            Given user go to mamikos homepage
             When user login as tenant via phone number:
                  | phone stag | phone prod   | password  |
                  | 0888881477 | 083176408442 | qwerty123 |
              And tenant redirect to kost details:
                  | kost path stag                                                                                      | kost path prod                                         |
                  | kost-kabupaten-cilacap-kost-putra-eksklusif-kos-bx-automation-bbk-available-cilacap-selatan-cilacap | Kos BX Automation BBK Available Tobelo Halmahera Utara |
              And tenant booking kost
             Then tenant should success booking kost
              And tenant navigate to riwayat and draf booking
              And tenant cancel all need confirmation booking request

        @cancelBooking @TEST_COOP-5440
        Scenario: Cancel Booking if Tenant Have Booking
             When user cancel booking

        @TEST_SS-3260
        Scenario Outline: [Dweb][Kost Detail][Chat] Check functionality Lihat detail button on BBK and Non BBK
            Given user go to mamikos homepage
             When user login as tenant via phone number:
                  | phone stag  | phone prod   | password  |
                  | 08999222999 | 083176408442 | qwerty123 |
              And tenant redirect to kost details:
                  | kost path stag | kost path prod                             |
                  | <property>     | Kost Automation Mix Tobelo Halmahera Utara |
              And user click chat in kos detail
              And user clicks the Lihat Iklan button and redirect to detail property
        Examples:
                  | property                                                                                               |
                  | kost-kabupaten-cilacap-kost-putra-eksklusif-kos-bx-automation-non-bbk-cilacap-selatan-cilacap          |
                  | kost-kabupaten-cilacap-kost-putri-eksklusif-kos-bx-automation-bbk-non-available-cilacap-tengah-cilacap |

        @TEST_SS-3259
        Scenario: [Dweb][Apartemen Detail][Chat] Check roomcard on apartemen should not display
            Given user go to mamikos homepage
             When user login as tenant via phone number:
                  | phone stag  | phone prod   | password  |
                  | 08999111912 | 083176408442 | qwerty123 |
              And user go to apartment details from apartment landing list number 1
              And tenant set active page to 1
              And user click on hubungi pengelola button
             Then chat room appear with latest message "test"
