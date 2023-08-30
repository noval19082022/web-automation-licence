@listing-monetization @regression @LIMO2
Feature: Broadcast Chat Owner

  #Pre-condition: *
	#
	#* User login with owner already activated list
	#* User already finish onboarding slide Broadcast Chat

  Background: Login Page Mamikos
    Given user go to mamikos homepage

	#{{ User GP2 click Broadcast Chat Entry Point From Fitur Promosi Page}}
  @TEST_LIMO-1211 @TEST_LIMO-1209 @Broadcast-chat @GP2 @automated @listing-monetization @web
  Scenario Outline: [Broadcast Chat Owner][Chat][Fitur Promosi Page][User GP 2]click Broadcast Chat entry point in Kelola Page
    Given user login as owner:
      | phone stag  | phone prod  | password |
      | <phoneStag> | <phoneProd> | <pass>   |
    When user click "Fitur Promosi"
    And user click "Broadcast Chat"
    Then user redirected to "/broadcast-chat"
    Examples:
      | phoneStag   | phoneProd | pass      |
      | 08713399866 | 0         | qwerty123 |
#  Scenario: [Broadcast Chat Owner][Chat][Fitur Promosi Page]User GP 2 has an active recurring invoice click menu Broadcast Chat (TEST_LIMO-1209)
      | 08335004143 | 0         | qwerty123 |

	#User No Kost Active click Broadcast Chat Entry Point From Fitur Promosi Page
  @TEST_LIMO-1530 @TEST_LIMO-1198 @Broadcast-chat @automated @listing-monetization @web
  Scenario: [Broadcast Chat Owner][Chat][Fitur Promosi Page]User doesnt have kost active then accsess menu broadcast chat
    Given user login as owner:
      | phone stag | phone prod | password |
      | 0866000011 | 0          | 12345678 |
    When user click "Fitur Promosi"
    And user click "Broadcast Chat"
    Then user verify pop up message "Anda belum memiliki kos aktif" is appear
    When user click "Tambah Kos" button
    Then user redirected to "kos/create"

#  Scenario: [Broadcast Chat Owner][Chat]User non GP without active kost;click Broadcast Chat entry point in Kelola Page TEST_LIMO-1198
    When owner navigates to "/broadcast-chat"
    Then user verify pop up message "Anda belum memiliki kos aktif" is appear
    When user clicks on the close button
    Then owner should not be able to see the text "Anda belum memiliki kos aktif"

  @TEST_LIMO-1195 @Broadcast-chat @GP2 @automated @listing-monetization @web
  Scenario: [Broadcast Chat Owner][Chat]User non GP without active kost;click Broadcast Chat entry point in Chat Page
    Given user login as owner:
      | phone stag   | phone prod | password  |
      | 086412300123 | 0          | qwerty123 |
    When user click chat button in top bar owner home page
    And user click on the broadcast message icon in the chat page
    Then user verify pop up message "Anda belum memiliki kos aktif" is appear
    When user click "Tambah Kos" button
    Then user redirected to "kos/create"
    When owner navigates to "/"
    And user click chat button in top bar owner home page
    And user click on the broadcast message icon in the chat page
    Then user verify pop up message "Anda belum memiliki kos aktif" is appear
    When user clicks on the close button
    Then owner should not be able to see the text "Anda belum memiliki kos aktif"

	#{{User GP1 click Broadcast Chat Entry Point From Fitur Promosi Page}}
  @TEST_LIMO-1212 @Broadcast-chat @GP1 @automated @listing-monetization @web
  Scenario: [Broadcast Chat Owner][Chat][Fitur Promosi Page]User GP 1 click menu Broadcast Chat
    Given user login as owner:
      | phone stag   | phone prod | password  |
      | 087133998156 | 0          | qwerty123 |
    When user click "Fitur Promosi"
    And user click "Broadcast Chat"
    Then Check if the button with label "Lihat Detail Paket" is visible on the "Broadcast Chat" page.
    And Check if the button with label "Ajukan Ganti Paket" is visible on the "Broadcast Chat" page.

	#User reguler click Broadcast Chat Entry Point From Fitur Promosi page
  @TEST_LIMO-1210 @TEST_LIMO-1172 @Broadcast-chat @automated @listing-monetization @web
  Scenario: [Broadcast Chat Owner][Fitur Promosi]User non GP with active kost click menu Broadcast Chat
    Given user login as owner:
      | phone stag    | phone prod | password    |
      | 0895332021442 | 0          | digantilagi |
    When user click "Fitur Promosi"
    And user click "Broadcast Chat"
    Then Check if the button with label "Lihat Detail Paket" is visible on the "Broadcast Chat" page.
    And Check if the button with label "Beli Paket" is visible on the "Broadcast Chat" page.
    And owner will see that the text "Fitur ini khusus pengguna GoldPlus 2" is displayed

#  Scenario: [Broadcast Chat Owner][Chat] User non GP with active kost;click Broadcast Chat entry point in Kelola Page TEST_LIMO-1172
    When user click "Beli Paket" button
    And user click "Pilih" button
    Then user redirected to "goldplus/submission/packages/gp2"
    When user see intercept closed and user stay in Kelola Page
    And owner navigates to "/broadcast-chat"
    Then Check if the button with label "Lihat Detail Paket" is visible on the "Broadcast Chat" page.
    And Check if the button with label "Beli Paket" is visible on the "Broadcast Chat" page.
    And owner will see that the text "Fitur ini khusus pengguna GoldPlus 2" is displayed

    #{{User click Broadcast Chat Entry Point From Chat Page}}
  @TEST_LIMO-1208 @Broadcast-chat @GP2 @automated @listing-monetization @web
  Scenario: [Broadcast Chat Owner][Chat][User GP 2]click Broadcast Chat entry point in Chat Page
    Given user login as owner:
      | phone stag  | phone prod | password  |
      | 08713399866 | 0          | qwerty123 |
    When user click chat button in top bar owner home page
    And user click broadcast chat entry point
    Then user redirected to "/broadcast-chat?redirection_source=Halaman%20Chat"

  @TEST_LIMO-1207 @Broadcast-chat @GP2 @automated @listing-monetization @web
  Scenario: [Broadcast Chat][Rincian Pesan]user want to see detail of status terkirim
    Given user login as owner:
      | phone stag  | phone prod | password  |
      | 08713399866 | 0          | qwerty123 |
    When owner navigates to "/broadcast-chat"
    And user click "Lihat Rincian"
    Then owner will see that the text "Pesan Terkirim" is displayed

  @TEST_LIMO-1205 @Broadcast-chat @GP2 @automated @listing-monetization @web
  Scenario: [Broadcast Chat][Rincian Pesan]user want to click button baca selengkapnya && user can see alert kost dont have receipent
    Given user login as owner:
      | phone stag  | phone prod | password  |
      | 08713399866 | 0          | qwerty123 |
    When owner navigates to "/broadcast-chat"
    And user click "Baca selengkapnya"
    And owner set active page to 1
    Then user redirected to "berapa-kali-saya-bisa-mengirimkan-broadcast-chat"

#  Scenario:[Broadcast Chat][Create Broadcast chat]User want to send broadcast chat for kost without have a recipient
    When owner set active page to 0
    And owner click "Tambah Broadcast Chat"
    And user enter text "Kos Fathul Khair Tipe bala bala Jetis Yogyakarta" on Broadcast list kos
    And user click "Kos Fathul Khair Tipe bala bala Jetis Yogyakarta"
    And user click "Pilih Kos" button
    Then owner will see that the text "Kos belum memiliki calon penerima" is displayed

  @TEST_LIMO-1202  @Broadcast-chat @GP2 @automated @listing-monetization @web
  Scenario: [Broadcast Chat][Fitur Promosi][Bantuan & Tips]User click Bantuan & Tips at Chat Page
    Given user login as owner:
      | phone stag  | phone prod | password  |
      | 08713399866 | 0          | qwerty123 |
    When owner navigates to "/broadcast-chat"
    And owner click "Tambah Broadcast Chat"
    And owner click "Bantuan & Tips"
    And owner set active page to 1
    Then user redirected to "/fitur-dan-layanan-lain/broadcast-chat"

  @TEST_LIMO-1203 @TEST_LIMO-1192 @TEST_LIMO-1191 @TEST_LIMO-1187 @Broadcast-chat @GP2 @automated @listing-monetization @web
  Scenario: [Broadcast Chat][Select Kost]User Search kost
    Given user login as owner:
      | phone stag  | phone prod | password  |
      | 08713399866 | 0          | qwerty123 |
    When owner navigates to "/broadcast-chat"
    And owner click "Tambah Broadcast Chat"

#  Scenario: [Broadcast Chat][Select Kost]User search kost name with valid name TEST_LIMO-1191
    And user enter text "Kos Fathul Khair Tipe bala bala" on Broadcast list kos
    Then owner will see that the text "Kos Fathul Khair Tipe bala bala Jetis Yogyakarta" is displayed

#  Scenario: [Broadcast Chat][Select Kost]User Search kost with condition full room TEST_LIMO-1203
    When user enter text "Kos Fathul Khair Tipe Gehu Jetis Yogyakarta" on Broadcast list kos
    Then user verify kost card is disable

#  Scenario: [Broadcast Chat][Select Kost]User search kost name with invalid name TEST_LIMO-1192
    When user enter text "kost asal ga nemu" on Broadcast list kos
    Then owner will see that the text "Properti Tidak Ditemukan" is displayed

  @TEST_LIMO-1187 @Broadcast-chat @GP2 @automated @listing-monetization @web
  Scenario: [Broadcast Chat][Select Kost]User clear search bar after result tidak ditemukan TEST_LIMO-1187
    Given user login as owner:
      | phone stag  | phone prod | password  |
      | 08713399866 | 0          | qwerty123 |
    When owner navigates to "/broadcast-chat"
    And owner click "Tambah Broadcast Chat"
    And user enter text "kost asal ga nemu" on Broadcast list kos
    And user clicks on the close icon next to the search bar to reset it
    Then the list of Kosts should be displayed

  @TEST_LIMO-1201 @Broadcast-chat @GP2 @automated @listing-monetization @web
  Scenario: [Broadcast Chat][View Receiver]user want to back from page view receiver
    Given user login as owner:
      | phone stag  | phone prod | password  |
      | 08713399866 | 0          | qwerty123 |
    When owner navigates to "/broadcast-chat"
    And owner click "Tambah Broadcast Chat"
    And user enter text "Kos Fathul Khair Jetis Yogyakarta" on Broadcast list kos
    And user click "Kos Fathul Khair Jetis Yogyakarta"
    And user click "Pilih Kos" button
    And user click "Masukan Pesan"
    And user selects message row number 1 on the broadcast chat dashboard
    And user click "Pilih Pesan"
    And user click back arrow button on BC page
    And user click "Tidak Jadi"
    And user click back arrow button on BC page
    And user click "Keluar" button
    Then user redirected to "/broadcast-chat/kos"

  @TEST_LIMO-1189 @TEST_LIMO-1185 @TEST_LIMO-1186 @Broadcast-chat @GP2 @automated @listing-monetization @web
  Scenario: [Broadcast Chat][Select Message]User change message template on the list
    Given user login as owner:
      | phone stag  | phone prod | password  |
      | 08713399866 | 0          | qwerty123 |
    When owner navigates to "/broadcast-chat"
    And owner click "Tambah Broadcast Chat"
    And user enter text "Kos Fathul Khair Jetis Yogyakarta" on Broadcast list kos
    And user click "Kos Fathul Khair Jetis Yogyakarta"
    And user click "Pilih Kos" button
    And user click "Masukan Pesan"

#  Scenario: [Broadcast Chat][Select Message]User select 1st message template on the list TEST_LIMO-1185
    And user selects message row number 1 on the broadcast chat dashboard
    And user click "Pilih Pesan"
    Then the selected message should be visible on the details page of the broadcast:
	 """
	 Halo, +Calon Penyewa
        +Calon Penyewa akan disesuaikan dengan nama penyewa yang terdaftar di Mamikos.
        , ada kos bagus nih untuk kamu. Yuk lihat dan booking! Banyak keunggulannya seperti:
	 """
#  Scenario: [Broadcast Chat][Select Message]User select 2nd message template on the list TEST_LIMO-1186
    When user clicked ubah button to modify template broadcast message
    And user selects message row number 2 on the broadcast chat dashboard
    And user click "Pilih Pesan"
    Then the selected message should be visible on the details page of the broadcast:
	 """
	 +Calon Penyewa
        +Calon Penyewa akan disesuaikan dengan nama penyewa yang terdaftar di Mamikos.
	, nikmati promo Mamikos untuk booking kos! Cek kosnya dan langsung booking. Jangan sampai terlewatkan, ya.
	"""
    Then user verify input broadcast message is not visible

  @TEST_LIMO-1157 @Broadcast-chat @GP2 @automated @listing-monetization @web
  Scenario Outline: [Broadcast Chat][Create Broadcast chat]User want to input phone number/email/link on template message is editable
    Given user login as owner:
      | phone stag  | phone prod | password  |
      | 08713399866 | 0          | qwerty123 |
    When user click "Fitur Promosi"
    And user click "Broadcast Chat"
    And owner click "Tambah Broadcast Chat"
    And user enter text "Kos Fathul Khair Jetis Yogyakarta" on Broadcast list kos
    And user click "Kos Fathul Khair Jetis Yogyakarta"
    And user click "Pilih Kos" button
    And user click "Masukan Pesan"
    And user selects message row number 1 on the broadcast chat dashboard
    And user click "Pilih Pesan"
    And user input message on Broadcast Chat "<Messages>"
    And user click "Preview Pesan" button
    Then user should see the message "Mohon untuk tidak mengisi nomor handphone/email/link" displayed under text field
    Examples:
      | Messages                                     |
      | Kirim email ke mamattheend@mail.com          |
      | save no wa 08335005252                       |
      | foto kamar dan layanan ada di bit.ly/33xyYVH |

  @TEST_LIMO-1164 @Broadcast-chat @GP2 @automated @listing-monetization @web
  Scenario: [Broadcast Chat][Create Broadcast chat]User want to edit template message more than 320 char
    Given user login as owner:
      | phone stag  | phone prod | password  |
      | 08713399866 | 0          | qwerty123 |
    When owner navigates to "/broadcast-chat"
    And owner click "Tambah Broadcast Chat"
    And user enter text "Kos Fathul Khair Jetis Yogyakarta" on Broadcast list kos
    And user click "Kos Fathul Khair Jetis Yogyakarta"
    And user click "Pilih Kos" button
    And user click "Masukan Pesan"
    And user selects message row number 1 on the broadcast chat dashboard
    And user click "Pilih Pesan"
    And user input multiple lanes message on Broadcast Chat:
    """
    Mamikos memanfaatkan teknologi untuk berkembang dari aplikasi cari kos menjadi aplikasi yang memudahkan calon anak kos untuk booking properti kos
    dan juga melakukan pembayaran kos.
    Saat ini kami memiliki lebih dari 2 juta kamar kos yang tersebar di lebih dari 140 kota di seluruh Indonesia.
    Mamikos juga menyediakan layanan manajemen properti, bernama Singgahsini dan Apik,
    untuk menjawab kebutuhan calon penghuni yang menginginkan kos eksklusif atau kos murah.  |
    """
    Then counter text area message show "320 / 320"

  @TEST_LIMO-1145 @Broadcast-chat @GP2 @automated @listing-monetization @web
  Scenario: [Broadcast Chat][Create Broadcast chat]user want to back from preview message menu
    Given user login as owner:
      | phone stag  | phone prod | password  |
      | 08713399866 | 0          | qwerty123 |
    When user click "Fitur Promosi"
    And user click "Broadcast Chat"
    And owner click "Tambah Broadcast Chat"
    And user enter text "Kos Fathul Khair Jetis Yogyakarta" on Broadcast list kos
    And user click "Kos Fathul Khair Jetis Yogyakarta"
    And user click "Pilih Kos" button
    And user click "Masukan Pesan"
    And user selects message row number 1 on the broadcast chat dashboard
    And user click "Pilih Pesan"
    And user input message on Broadcast Chat "Kopi Kapal Api dan Udud Jarcok Filter"
    And user click "Preview Pesan" button
    Then user see "Kopi Kapal Api dan Udud Jarcok Filter" on Preview Broadcast Message

    #Pre-condition: *
	#
	#* User login with owner total chat = 0
  @TEST_LIMO-1197 @Broadcast-chat @GP2 @automated @listing-monetization @web
  Scenario: [Broadcast Chat Owner][Chat]User(Any kind of user) visit chat page in a new session
    Given user login as owner:
      | phone stag  | phone prod | password  |
      | 08713399866 | 0          | qwerty123 |
    When user click chat button in top bar owner home page
    Then user see tooltip broadcast chat
    When user click icon close at tooltip
    Then broadcast chat tooltip should not be visible

  @TEST_LIMO-1182 @Broadcast-chat @GP2 @automated @listing-monetization @web
  Scenario: [Broadcast Chat Owner][Chat] User already submit request GP 2 but not paid yet;click Broadcast Chat entry point in Chat Page
    Given user login as owner:
      | phone stag  | phone prod | password  |
      | 08646547892 | 0          | fathul123 |
    When user wants to subscribe Goldplus 2
    And owner navigates to "/"
    And user click chat button in top bar owner home page
    And user click on the broadcast message icon in the chat page
    Then user will see that the text "Anda bisa menggunakan Fitur Broadcast Chat setelah proses pembelian paket selesai." is displayed
    When user click "Lihat Invoice"
    Then user will see that the text "Detail Tagihan" is displayed

	#scenario delete or reset data GP
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And user wants to reset Goldplus for owner with phone number "08646547892"

  @TEST_LIMO-1180 @Broadcast-chat @GP2 @automated @listing-monetization @web
  Scenario: [Broadcast Chat Owner][Chat]User already submit request GP 2 but not paid yet;click Broadcast Chat entry point in Kelola Page
    Given user login as owner:
      | phone stag  | phone prod | password  |
      | 08646547892 | 0          | fathul123 |
    When user wants to subscribe Goldplus 2
    And owner navigates to "/broadcast-chat"
    Then user will see that the text "Anda bisa menggunakan Fitur Broadcast Chat setelah proses pembelian paket selesai." is displayed
    When user click "Lihat Invoice"
    Then user will see that the text "Detail Tagihan" is displayed

    	#scenario delete or reset data GP
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And user wants to reset Goldplus for owner with phone number "08646547892"

  @TEST_LIMO-1178 @TEST_LIMO-1175 @Broadcast-chat @GP2 @automated @listing-monetization @web
  Scenario: [Broadcast Chat Owner][Chat]User already submit request GP 1 but not paid yet;click Broadcast Chat entry point in Chat Page
    Given user login as owner:
      | phone stag  | phone prod | password  |
      | 08646547892 | 0          | fathul123 |
    When user wants to subscribe Goldplus 1
    And owner navigates to "/"
    And user click chat button in top bar owner home page
    And user click on the broadcast message icon in the chat page
    Then Check if the button with label "Lihat Detail Paket" is visible on the "Broadcast Chat" page.
    And Check if the button with label "Ajukan Ganti Paket" is visible on the "Broadcast Chat" page.

#  Scenario: [Broadcast Chat Owner][Chat]User already submit request GP 1 but not paid yet;click Broadcast Chat entry point in Kelola Page TEST_LIMO-1175
    When owner navigates to "/broadcast-chat"
    Then Check if the button with label "Lihat Detail Paket" is visible on the "Broadcast Chat" page.
    And Check if the button with label "Ajukan Ganti Paket" is visible on the "Broadcast Chat" page.

  Scenario: delete or reset data GP
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And user wants to reset Goldplus for owner with phone number "08646547892"

  @TEST_LIMO-1158 @Broadcast-chat @GP2 @automated @listing-monetization @web
  Scenario: [Broadcast Chat][View Receiver]user want to see receiver
    Given user login as owner:
      | phone stag  | phone prod | password  |
      | 08713399866 | 0          | qwerty123 |
    When owner navigates to "/broadcast-chat"
    And owner click "Tambah Broadcast Chat"
    And user enter text "Kos Fathul Khair Jetis Yogyakarta" on Broadcast list kos
    And user click "Kos Fathul Khair Jetis Yogyakarta"
    And user click "Pilih Kos" button
    And user click "Lihat Penerima"
    Then Lihat penerima page is displayed