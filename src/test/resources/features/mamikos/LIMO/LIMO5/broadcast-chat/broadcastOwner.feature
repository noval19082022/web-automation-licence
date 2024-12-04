@listing-monetization @regression @LIMO5 @broadcastChat
Feature: Broadcast Chat Owner

    #Pre-condition: *
	#
	#* User login with owner already activated list
	#* User already finish onboarding slide Broadcast Chat
	#{{ User GP2 click Broadcast Chat Entry Point From Fitur Promosi Page}}
  @TEST_LIMO-3614 @Broadcast-chat @GP2 @automated @listing-monetization @web
  Scenario Outline: [Broadcast Chat Owner][Chat][Fitur Promosi Page][User GP 2]click Broadcast Chat entry point in Kelola Page
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod  | password |
      | <phoneStag> | <phoneProd> | <pass>   |
    And owner goes to broadcast chat
    Then user redirected to "/broadcast-chat"
    Examples:
      | phoneStag   | phoneProd | pass      |
      | 08713399866 | 0         | qwerty123 |
#  Scenario: [Broadcast Chat Owner][Chat][Fitur Promosi Page]User GP 2 has an active recurring invoice click menu Broadcast Chat (TEST_LIMO-1209)
      | 08335004143 | 0         | qwerty123 |

	#User No Kost Active click Broadcast Chat Entry Point From Fitur Promosi Page
  @TEST_LIMO-3615 @Broadcast-chat @automated @listing-monetization @web @continue
  Scenario: [Broadcast Chat Owner][Chat][Fitur Promosi Page] User doesnt have kost active then accsess menu broadcast chat
    Given user go to mamikos homepage
    Given user login as owner:
      | phone stag | phone prod | password |
      | 0866000011 | 0          | 12345678 |
    When owner navigates to broadcast chat page
    Then user verify pop up message "Anda belum memiliki kos aktif" is appear
    When owner click on Tambah Kos button on no kos active pop-up broadcast chat owner
    Then user redirected to "kos/create"

  @TEST_LIMO-3616
  Scenario: [Broadcast Chat Owner][Chat]User non GP without active kost, click Broadcast Chat entry point in Kelola Page
    When owner navigates to broadcast chat page
    Then user verify pop up message "Anda belum memiliki kos aktif" is appear
    When user clicks on the close button
    Then owner should not be able to see anda belum memiliki kos aktif pop-up broadcast chat owner

  @TEST_LIMO-3617 @Broadcast-chat @GP2 @automated @listing-monetization @web
  Scenario: [Broadcast Chat Owner][Chat]User non GP without active kost;click Broadcast Chat entry point in Chat Page
    Given user go to mamikos homepage
    Given user login as owner:
      | phone stag   | phone prod | password  |
      | 086412300123 | 0          | qwerty123 |
    When user click chat button in top bar owner home page
    And user click on the broadcast message icon in the chat page
    Then user verify pop up message "Anda belum memiliki kos aktif" is appear
    When owner click on Tambah Kos button on no kos active pop-up broadcast chat owner
    Then user redirected to "kos/create"
    When owner navigates to owner dashboard
    And user click chat button in top bar owner home page
    And user click on the broadcast message icon in the chat page
    Then user verify pop up message "Anda belum memiliki kos aktif" is appear
    When user clicks on the close button
    Then owner should not be able to see anda belum memiliki kos aktif pop-up broadcast chat owner

	#{{User GP1 click Broadcast Chat Entry Point From Fitur Promosi Page}}
  @TEST_LIMO-3618 @Broadcast-chat @GP1 @automated @listing-monetization @web
  Scenario: [Broadcast Chat Owner][Chat][Fitur Promosi Page] User GP 1 click menu Broadcast Chat
    Given user go to mamikos homepage
    Given user login as owner:
      | phone stag   | phone prod | password  |
      | 087133998156 | 0          | qwerty123 |
    When owner navigates to broadcast chat page
    Then owner with active package should be able to see the broadcast chat page

	#User reguler click Broadcast Chat Entry Point From Fitur Promosi page
  @TEST_LIMO-3619 @Broadcast-chat @automated @listing-monetization @web
  Scenario: [Broadcast Chat Owner][Fitur Promosi] User non GP with active kos, click menu Broadcast Chat
    Given user go to mamikos homepage
    Given user login as owner:
      | phone stag    | phone prod | password    |
      | 0895332021442 | 0          | digantilagi |
    When owner goes to broadcast chat
    Then owner non gp should be able to see the broadcast chat page for non gp owner

    #{{User click Broadcast Chat Entry Point From Chat Page}}
  @TEST_LIMO-3620 @Broadcast-chat @GP2 @automated @listing-monetization @web
  Scenario: [Broadcast Chat Owner][Chat][User GP 2]click Broadcast Chat entry point in Chat Page
    Given user go to mamikos homepage
    Given user login as owner:
      | phone stag  | phone prod | password  |
      | 08713399866 | 0          | qwerty123 |
    When user click chat button in top bar owner home page
    And user click broadcast chat entry point
    Then user redirected to "/broadcast-chat?redirection_source=Halaman%20Chat"

  @TEST_LIMO-3621 @Broadcast-chat @GP2 @automated @listing-monetization @web
  Scenario: [Broadcast Chat][Rincian Pesan]user want to see detail of status terkirim
    Given user go to mamikos homepage
    Given user login as owner:
      | phone stag  | phone prod | password  |
      | 08713399866 | 0          | qwerty123 |
    When owner navigates to broadcast chat page
    And owner refresh page 0
    And owner click on lihat rincian button broadcast chat
    Then owner will see that the text "Pesan Terkirim" is displayed

  @TEST_LIMO-3622 @Broadcast-chat @GP2 @automated @listing-monetization @web @continue
  Scenario: [Broadcast Chat][Rincian Pesan]user want to click button baca selengkapnya && user can see alert kost don't have recipient
    Given user go to mamikos homepage
    Given user login as owner:
      | phone stag  | phone prod | password  |
      | 08713399866 | 0          | qwerty123 |
    When owner navigates to broadcast chat page
    And owner clicks on Baca selengkapnya button
    And owner set active page to 1
    Then user redirected to "berapa-kali-saya-bisa-mengirimkan-broadcast-chat"

  @TEST_LIMO-3623
  Scenario:[Broadcast Chat][Create Broadcast chat]User want to send broadcast chat for kost without have a recipient
    When owner set active page to 0
    And owner add broadcast chat for kost "Kos Fathul Khair Mamitest Jangan Diboking Dichat Difav Gondomanan Yogyakarta"
    And owner clicks Kos "Kos Fathul Khair Mamitest Jangan Diboking Dichat Difav Gondomanan Yogyakarta" and Pilih Kos button
    Then owner can see toast with content text is "Kos belum memiliki calon penerima"

  @TEST_LIMO-3624  @Broadcast-chat @GP2 @automated @listing-monetization @web
  Scenario: [Broadcast Chat][Fitur Promosi][Bantuan & Tips]User click Bantuan & Tips at Chat Page
    Given user go to mamikos homepage
    Given user login as owner:
      | phone stag  | phone prod | password  |
      | 08713399866 | 0          | qwerty123 |
    When owner navigates to broadcast chat page
    When owner goes to Tambah Broadcast Chat Bantuan & Tips Page
    And owner set active page to 1
    Then user redirected to "/fitur-dan-layanan-lain/broadcast-chat"

  @TEST_LIMO-3625 @Broadcast-chat @GP2 @automated @listing-monetization @web @continue
  Scenario: [Broadcast Chat][Select Kost]User Search kost
    Given user go to mamikos homepage
    Given user login as owner:
      | phone stag  | phone prod | password  |
      | 08713399866 | 0          | qwerty123 |
    When owner navigates to broadcast chat page
    And owner add broadcast chat for kost "Kos Fathul Khair Mamitest Jangan Diboking Dichat Difav Gondomanan Yogyakarta"

  @TEST_LIMO-3626 @continue
  Scenario: [Broadcast Chat][Select Kost]User search kost name with valid name
    Then owner can sees displaying search result is "Kos Fathul Khair Mamitest Jangan Diboking Dichat Difav Gondomanan Yogyakarta"
#
  @TEST_LIMO-3627 @continue
  Scenario: [Broadcast Chat][Select Kost]User Search kost with condition full room
    And owner add broadcast chat for kost "Kos Fathul Khair Tipe Gehu Jetis Yogyakarta"
    When user enter text "Kos Fathul Khair Tipe Gehu Jetis Yogyakarta" on Broadcast list kos
    Then user verify kost card is disable

  @TEST_LIMO-3628
  Scenario: [Broadcast Chat][Select Kost]User search kost name with invalid name
    When owner add broadcast chat for kost "kost asal ga nemu"
    Then owner can see empty kos list condition

  @TEST_LIMO-3629 @Broadcast-chat @GP2 @automated @listing-monetization @web
  Scenario: [Broadcast Chat][Select Kost] User clear search bar after result tidak ditemukan
    Given user go to mamikos homepage
    Given user login as owner:
      | phone stag  | phone prod | password  |
      | 08713399866 | 0          | qwerty123 |
    When owner navigates to broadcast chat page
    When owner add broadcast chat for kost "kost asal ga nemu"
    And user clicks on the close icon next to the search bar to reset it
    Then the list of Kos should be displayed

  @TEST_LIMO-3634 @Broadcast-chat @GP2 @automated @listing-monetization @web
  Scenario Outline: [Broadcast Chat][Create Broadcast chat]User want to input phone number/email/link on template message is editable
    Given user go to mamikos homepage
    Given user login as owner:
      | phone stag  | phone prod | password  |
      | 08713399866 | 0          | qwerty123 |
    When owner navigates to broadcast chat page
    And owner add broadcast chat for kost "Kos Fathul Khair Jetis Yogyakarta"
    And owner clicks Kos "Kos Fathul Khair Jetis Yogyakarta" and Pilih Kos button
    And owner Masukan Pesan and choose row number 1 from the broadcast chat dashboard
    And user input message on Broadcast Chat "<Messages>"
    And user click "Preview Pesan" button
    Then user should see the message "Mohon untuk tidak mengisi nomor handphone/email/link" displayed under text field
    Examples:
      | Messages                                     |
      | Kirim email ke mamattheend@mail.com          |
      | save no wa 08335005252                       |
      | foto kamar dan layanan ada di bit.ly/33xyYVH |

  @TEST_LIMO-3635 @Broadcast-chat @GP2 @automated @listing-monetization @web
  Scenario: [Broadcast Chat][Create Broadcast chat]User want to edit template message more than 320 char
    Given user go to mamikos homepage
    Given user login as owner:
      | phone stag  | phone prod | password  |
      | 08713399866 | 0          | qwerty123 |

    When owner navigates to broadcast chat page
    And owner add broadcast chat for kost "Kos Fathul Khair Jetis Yogyakarta"
    And owner clicks Kos "Kos Fathul Khair Jetis Yogyakarta" and Pilih Kos button
    And owner Masukan Pesan and choose row number 1 from the broadcast chat dashboard
    And user input multiple lanes message on Broadcast Chat:
    """
    Mamikos memanfaatkan teknologi untuk berkembang dari aplikasi cari kos menjadi aplikasi yang memudahkan calon anak kos untuk booking properti kos
    dan juga melakukan pembayaran kos.
    Saat ini kami memiliki lebih dari 2 juta kamar kos yang tersebar di lebih dari 140 kota di seluruh Indonesia.
    Mamikos juga menyediakan layanan manajemen properti, bernama Singgahsini dan Apik,
    untuk menjawab kebutuhan calon penghuni yang menginginkan kos eksklusif atau kos murah.  |
    """
    Then counter text area message show "320 / 320"

  @TEST_LIMO-3636 @Broadcast-chat @GP2 @automated @listing-monetization @web
  Scenario: [Broadcast Chat][Create Broadcast chat]user want to back from preview message menu
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag  | phone prod | password  |
      | 08713399866 | 0          | qwerty123 |
    When owner navigates to broadcast chat page
    And owner add broadcast chat for kost "Kos Fathul Khair Jetis Yogyakarta"
    And owner clicks Kos "Kos Fathul Khair Jetis Yogyakarta" and Pilih Kos button
    And owner Masukan Pesan and choose row number 1 from the broadcast chat dashboard
    And user input message on Broadcast Chat "Kopi Kapal Api dan Udud Jarcok Filter"
    And user click "Preview Pesan" button
    Then user see "Kopi Kapal Api dan Udud Jarcok Filter" on Preview Broadcast Message

    #Pre-condition: *
	#
	#* User login with owner total chat = 0
#  @TEST_LIMO-3637 @Broadcast-chat @GP2 @automated @listing-monetization @web
#  Scenario: [Broadcast Chat Owner][Chat]User(Any kind of user) visit chat page in a new session
#    Given user go to mamikos homepage
#    Given user login as owner:
#      | phone stag  | phone prod | password  |
#      | 08713399866 | 0          | qwerty123 |
#    When user click chat button in top bar owner home page
#    Then user see tooltip broadcast chat
#    When user click icon close at tooltip
#    Then broadcast chat tooltip should not be visible

  @TEST_LIMO-3638 @Broadcast-chat @GP2 @automated @listing-monetization @web @continue
  Scenario: [Broadcast Chat Owner][Chat] User already submit request GP 2 but not paid yet click Broadcast Chat entry point in Chat Page
    Given user go to mamikos homepage
    Given user login as owner:
      | phone stag  | phone prod | password  |
      | 08646547892 | 0          | fathul123 |
    When user wants to subscribe Goldplus 2
    And owner navigates to owner dashboard
    And user click chat button in top bar owner home page
    And user click on the broadcast message icon in the chat page
    Then user will see that the text "Anda bisa menggunakan Fitur Broadcast Chat setelah proses pembelian paket selesai." is displayed
    When user click on lihat invoice button
    Then user will see that the text "Detail Tagihan" is displayed

  @continue
  Scenario: Delete or reset data GP
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And user wants to reset Goldplus for owner with phone number "08646547892"

  @TEST_LIMO-1180 @Broadcast-chat @GP2 @automated @listing-monetization @web @continue
  Scenario: [Broadcast Chat Owner][Chat] User already submit request GP 2 but not paid yet;click Broadcast Chat entry point in Kelola Page
    When user wants to subscribe Goldplus 2
    When owner navigates to broadcast chat page
    Then user will see that the text "Anda bisa menggunakan Fitur Broadcast Chat setelah proses pembelian paket selesai." is displayed
    When user click "Lihat Invoice"
    Then user will see that the text "Detail Tagihan" is displayed

  @continue
  Scenario: Delete or reset data GP
    Given admin go to mamikos mamipay admin
    And user wants to reset Goldplus for owner with phone number "08646547892"

  @TEST_LIMO-1178 @TEST_LIMO-1175 @Broadcast-chat @GP2 @automated @listing-monetization @web @continue
  Scenario: [Broadcast Chat Owner][Chat] User already submit request GP 1 but not paid yet, click Broadcast Chat entry point in Chat Page
    When user wants to subscribe Goldplus 1
    And owner navigates to owner dashboard
    And user click chat button in top bar owner home page
    And user click on the broadcast message icon in the chat page
    When user click "Lihat Detail Paket"
    Then user will see that the text "Detail Paket" is displayed
    Then owner can sees button "Lihat Detail Paket" and button "Ajukan Ganti Paket" is visible

  @TEST_LIMO-1175 @continue
  Scenario: [Broadcast Chat Owner][Chat] User already submit request GP 1 but not paid yet, click Broadcast Chat entry point in Kelola Page
    When owner navigates to broadcast chat page
    Then owner can sees button "Lihat Detail Paket" and button "Ajukan Ganti Paket" is visible

  Scenario: Delete or reset data GP
    Given admin go to mamikos mamipay admin
    And user wants to reset Goldplus for owner with phone number "08646547892"

  @TEST_LIMO-1158 @Broadcast-chat @GP2 @automated @listing-monetization @web
  Scenario: [Broadcast Chat][View Receiver]user want to see receiver
    Given user go to mamikos homepage
    Given user login as owner:
      | phone stag  | phone prod | password  |
      | 08713399866 | 0          | qwerty123 |
    When owner navigates to broadcast chat page
    When owner add broadcast chat for kost "Kos Fathul Khair Jetis Yogyakarta"
    And owner clicks Kos "Kos Fathul Khair Jetis Yogyakarta" and Pilih Kos button
    And user click "Lihat Penerima"
    Then Lihat penerima page is displayed