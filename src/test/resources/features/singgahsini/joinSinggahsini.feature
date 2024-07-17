@singgahsini @regression @pman @pman-prod

  Feature: Join Singgahsini

    @TEST_SS-623 @continue
    Scenario: Verify Title and Description
      Given user navigates to singgahsini.id
      When user open register form
      Then user should redirect to "/daftar"
      And page contains title "Selamat datang!"
      And page contains subtitle "Ingin tahu lebih lanjut dan daftar Singgahsini atau Apik? Silakan isi data diri dan kos yang ingin didaftarkan. Tim kami akan menghubungi Anda."

    @TEST_SS-630
    Scenario: Error message when empty
      When user submit form daftar singgahsini
      Then nama lengkap field should show error validation "Masukkan nama lengkap Anda terlebih dahulu."
      And no handphone field should show error validation "Masukkan no. HP Anda terlebih dahulu."
      And nama kos field should show error validation "Masukkan nama kos Anda terlebih dahulu."
      And total kamar field should show error validation "Masukkan total kamar kos Anda terlebih dahulu."
      And kabupaten kota field should show error validation "Anda belum memasukkan kabupaten / kota kos Anda."
      And alamat lengkap field should show error validation "Anda belum memasukkan alamat kos Anda."

    @TEST_SS-648 @continue
    Scenario: Min 3 character validation in Full Name
      Given user navigates to singgahsini.id
      When user open register form
      And user fill nama lengkap "a"
      Then nama lengkap field should show error validation "Nama lengkap minimal mengandung 3 karakter."

    @TEST_SS-656
    Scenario: Max 50 character validation in Full Name
      When user fill nama lengkap "50 char"
      Then nama lengkap field should show error validation "Nama lengkap tidak boleh lebih dari 50 karakter."

    @TEST_SS-653 @continue
    Scenario: Only input 1 character in phone number
      Given user navigates to singgahsini.id
      When user open register form
      And user fill no handphone "8"
      Then no handphone field should show error validation "Harus terdiri dari 9-15 angka."

    @TEST_SS-646
    Scenario: Input more than 15 character in phone number
      When user fill no handphone "0844232468682024"
      Then no handphone field should show error validation "Harus terdiri dari 9-15 angka."

    @TEST_SS-644 @continue
    Scenario: Min 3 character validation in Kost Name
      Given user navigates to singgahsini.id
      When user open register form
      And user fill kos name "a"
      Then nama kos field should show error validation "Nama kos minimal mengandung 3 karakter."

    @TEST_SS-613
    Scenario: Max 30 character validation in Kost Name
      When user fill kos name ">30 char"
      Then nama kos field should show error validation "Nama kos tidak boleh lebih dari 30 karakter."

    @TEST_SS-602
    Scenario: Min 3 characters validation in Address
      Given user navigates to singgahsini.id
      When user open register form
      And user fill alamat "a"
      Then alamat lengkap field should show error validation "Alamat lengkap Kos minimal mengandung 3 karakter."

    @TEST_SS-607
    Scenario: Invalid city validation
      Given user navigates to singgahsini.id
      When user open register form
      And user search kota "sumeru"
      Then kota not found message should be display

    @TEST_SS-609 @continue
    Scenario: Stay in Registration Form
      Given user navigates to singgahsini.id
      When user open register form
      And user click kembali button
      But user choose "Lanjut Isi" in confirmation pop up
      Then user should stay in "/daftar"

    @TEST_SS-601
    Scenario: Back to Homepage
      When user click kembali button
      And user choose "Keluar" in confirmation pop up
      Then user should be redirect to singgahsini.id

    @TEST_SS-620
    Scenario: Fill form register Singgahsini
      Given user navigates to singgahsini.id
      When user open register form
      And user submit daftar singgahsini
        | Nama Lengkap        | No Handphone  | Kos Name            | Total Kamar | Kota   | Kecamatan  | Kelurahan     | Alamat                |
        | Automation Testing  | 088820203113  | Kost Tes Automation | 5           | Bantul | Kretek     | Parangtritis  | Jl Jembatan Kretek 1  |
      Then system show pop up success register
      When user confirm pop up
      Then user should be redirect to singgahsini.id
