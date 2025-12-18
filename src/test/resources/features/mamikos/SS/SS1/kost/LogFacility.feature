@SS11 @regression @kost @log-facility

  Feature: Log Facility

    @TEST_SS-10119
    Scenario: Log add facility by Owner
      #add facility from owner dashboard
      When user navigate to mamikos
      And user login as owner:
        | phone stag    | password    |
        | 083932118871  | mamikos290  |
      And owner dismiss FTUE goldplus
      And owner navigates to property saya kos
      And owner search kost "Kost Hujan Dong Kasihan Bantul" on property saya page
      And user click Lihat Selengkapnya button for edit
      And user clicks on edit data kos button
      And user click button edit "Fasilitas" kos
      And user check facilities under "Fasilitas Umum"
        | Air Jernih  |
        | CCTV        |
      And user check facilities under "Fasilitas Kamar"
        | Kipas Angin  |
      And user check facilities under "Fasilitas Kamar Mandi"
        | Kloset Duduk  |
      And user check facilities under "Parkir"
        | Parkir Mobil  |
      And user click button edit finished
      Then user see success add data kos pop up with text "Data Kos Telah Diperbarui"
      When user click done in success page pop up of edit kos

    Scenario: Check log facility
      When admin go to mamikos bangkrupux admin
      And admin login to bangkrupux:
        | email stag                   | email prod                   | password  |
        | automationpman01@mamikos.com | automationpman01@mamikos.com | qwerty123 |
      And admin navigates to "/admin/room/tag-change-log?room_id=1000044309"
      Then admin can see log facility "Fasilitas Umum"
        | Old Data                                | New Data                                                  | Updated by      |
        | Dapur, Kompor, Kulkas, Dispenser, WiFi  | WiFi, Dapur, Kulkas, Dispenser, Kompor, Air Jernih, CCTV  | Owner (Nurjono) |
      And admin can see log facility "Fasilitas Kamar"
        | Old Data   | New Data                | Updated by      |
        | AC, Kasur  | Kasur, AC, Kipas Angin  | Owner (Nurjono) |
      And admin can see log facility "Fasilitas Parkir"
        | Old Data               | New Data                             | Updated by      |
        | Parkir Motor & Sepeda  | Parkir Mobil, Parkir Motor & Sepeda  | Owner (Nurjono) |
      And admin can see log facility "Fasilitas Kamar Mandi"
        | Old Data           | New Data                         | Updated by      |
        | Bak mandi, Gayung  | Kloset Duduk, Bak mandi, Gayung  | Owner (Nurjono) |

    @TEST_SS-10121
    Scenario: Log delete facility by Owner
        #delete facility from owner dashboard
        When user navigate to mamikos
        And user login as owner:
          | phone stag    | password    |
          | 083932118871  | mamikos290  |
        And owner dismiss FTUE goldplus
        And owner navigates to property saya kos
        And owner search kost "Kost Hujan Dong Kasihan Bantul" on property saya page
        And user click Lihat Selengkapnya button for edit
        And user clicks on edit data kos button
        And user click button edit "Fasilitas" kos
        And user uncheck facilities under "Fasilitas Umum"
          | Air Jernih  |
          | CCTV        |
        And user uncheck facilities under "Fasilitas Kamar"
          | Kipas Angin  |
        And user uncheck facilities under "Fasilitas Kamar Mandi"
          | Kloset Duduk  |
        And user uncheck facilities under "Parkir"
          | Parkir Mobil  |
        And user click button edit finished
        Then user see success add data kos pop up with text "Data Kos Telah Diperbarui"
        When user click done in success page pop up of edit kos

    Scenario: check log facility
        When admin go to mamikos bangkrupux admin
        And admin login to bangkrupux:
          | email stag                   | email prod                   | password  |
          | automationpman01@mamikos.com | automationpman01@mamikos.com | qwerty123 |
        And admin navigates to "/admin/room/tag-change-log?room_id=1000044309"
        Then admin can see log facility "Fasilitas Umum"
          | Old Data                                                  | New Data                                | Updated by      |
          | Dapur, Kompor, Kulkas, Dispenser, WiFi  | WiFi, Dapur, Kulkas, Dispenser, Kompor, Air Jernih, CCTV  | Owner (Nurjono) |
        And admin can see log facility "Fasilitas Kamar"
          | Old Data                | New Data   | Updated by      |
          | AC, Kasur | Kasur, AC, Kipas Angin  | Owner (Nurjono) |
        And admin can see log facility "Fasilitas Parkir"
          | Old Data                            | New Data               | Updated by      |
          | Parkir Motor & Sepeda | Parkir Mobil, Parkir Motor & Sepeda  | Owner (Nurjono) |
        And admin can see log facility "Fasilitas Kamar Mandi"
          | Old Data                        | New Data           | Updated by      |
          | Bak mandi, Gayung | Kloset Duduk, Bak mandi, Gayung  | Owner (Nurjono) |

      @TEST_SS-10120
      Scenario: Log add facility by admin
        Given admin go to mamikos bangkrupux admin
        And admin login to bangkrupux:
          | email stag                   | email prod                   | password  |
          | automationpman01@mamikos.com | automationpman01@mamikos.com | qwerty123 |
        And admin navigates to "/admin/kost/1000044307/edit"
        When admin add facility in "Fasilitas Umum"
          | Kulkas  |
        And admin add facility in "*Fasilitas Kamar"
          | TV  |
        And admin add facility in "Fasilitas Kamar Mandi"
          | Kloset jongkok  |
        And admin add facility in "Fasilitas Parkir"
          | Parkir Motor  |
        And admin add facility in "Fasilitas Lainnya"
          | ATM / Bank  |
        And admin add facility in "Peraturan Kos"
          | Akses 24 Jam  |
        And admin save edit kost
        Then admin should see success toast message "Success!"

#        Scenario: check log facility
        When admin navigates to "/admin/room/tag-change-log?room_id=1000044307"
        Then admin can see log facility "Fasilitas Umum"
          | Old Data                                                             | New Data                                                                                   | Updated by              |
          | Air Jernih, WiFi, TV, Kompor, Dapur, Dispenser, Dilarang bawa hewan  | WiFi, Dapur, Kulkas, Dispenser, TV, Akses 24 Jam, Kompor, Air Jernih, Dilarang bawa hewan  | Admin (Automation Pman) |
        And admin can see log facility "Fasilitas Lainnya"
          | Old Data         | New Data                     | Updated by              |
          | Kampus / Sekolah | ATM / Bank, Kampus / Sekolah | Admin (Automation Pman) |
        And admin can see log facility "Fasilitas Parkir"
          | Old Data                            | New Data                                           | Updated by              |
          | Parkir Mobil, Parkir Motor & Sepeda | Parkir Mobil, Parkir Motor, Parkir Motor & Sepeda	 | Admin (Automation Pman) |
        And admin can see log facility "Fasilitas Kamar"
          | Old Data                                                         | New Data                                                             | Updated by              |
          | Kasur, AC, Lemari / Storage, Meja, Kursi, Tidak boleh bawa anak	 | Kasur, Lemari / Storage, TV , AC, Meja, Kursi, Tidak boleh bawa anak	| Admin (Automation Pman) |
        And admin can see log facility "Fasilitas Kamar Mandi"
          | Old Data                                | New Data                                                | Updated by                      |
          | Gayung, Bak mandi, Ember mandi, Shower  | Shower, Kloset jongkok, Bak mandi, Ember mandi, Gayung  | Admin (Automation Pman) |


    @TEST_SS-10176
      Scenario: Log delete facility by admin
      Given admin go to mamikos bangkrupux admin
        And admin login to bangkrupux:
          | email stag                   | email prod                   | password  |
          | automationpman01@mamikos.com | automationpman01@mamikos.com | qwerty123 |
        And admin navigates to "/admin/kost/1000044307/edit"
        When admin remove facility in "Fasilitas Umum"
          | Kulkas  |
        And admin remove facility in "*Fasilitas Kamar"
          | TV  |
        And admin remove facility in "Fasilitas Kamar Mandi"
          | Kloset jongkok  |
        And admin remove facility in "Fasilitas Parkir"
          | Parkir Motor  |
        And admin remove facility in "Fasilitas Lainnya"
          | ATM / Bank  |
        And admin remove facility in "Peraturan Kos"
          | Akses 24 Jam  |
        And admin save edit kost
        Then admin should see success toast message "Success!"

#        Scenario: check log facility
        When admin navigates to "/admin/room/tag-change-log?room_id=1000044307"
        Then admin can see log facility "Fasilitas Umum"
          | Old Data                                                                                    | New Data                                                              | Updated by              |
          | Air Jernih, WiFi, TV, Kompor, Dapur, Dispenser, Dilarang bawa hewan, Kulkas, Akses 24 Jam  | WiFi, Dapur, Dispenser, TV, Kompor, Air Jernih, Dilarang bawa hewan  | Admin (Automation Pman) |
        And admin can see log facility "Fasilitas Lainnya"
          | Old Data                     | New Data         | Updated by              |
          | Kampus / Sekolah, ATM / Bank | Kampus / Sekolah | Admin (Automation Pman) |
        And admin can see log facility "Fasilitas Parkir"
          | Old Data                                           | New Data                            | Updated by              |
          | Parkir Mobil, Parkir Motor & Sepeda, Parkir Motor  | Parkir Mobil, Parkir Motor & Sepeda | Admin (Automation Pman) |
        And admin can see log facility "Fasilitas Kamar"
          | Old Data                                                            | New Data                                                         | Updated by              |
          | Kasur, AC, Lemari / Storage, Meja, Kursi, Tidak boleh bawa anak, TV  | Kasur, Lemari / Storage, AC, Meja, Kursi, Tidak boleh bawa anak | Admin (Automation Pman) |
        And admin can see log facility "Fasilitas Kamar Mandi"
          | Old Data                                                | New Data                                | Updated by              |
          | Gayung, Bak mandi, Ember mandi, Shower, Kloset jongkok  | Shower, Bak mandi, Ember mandi, Gayung  | Admin (Automation Pman) |