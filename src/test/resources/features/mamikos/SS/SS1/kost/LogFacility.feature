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
      #check log facility
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
        #check log facility
        When admin go to mamikos bangkrupux admin
        And admin login to bangkrupux:
          | email stag                   | email prod                   | password  |
          | automationpman01@mamikos.com | automationpman01@mamikos.com | qwerty123 |
        And admin navigates to "/admin/room/tag-change-log?room_id=1000044309"
        Then admin can see log facility "Fasilitas Umum"
          | Old Data                                                  | New Data                                | Updated by      |
          | Dapur, Kompor, Kulkas, Dispenser, WiFi, Air Jernih, CCTV  | WiFi, Dapur, Kulkas, Dispenser, Kompor  | Owner (Nurjono) |
        And admin can see log facility "Fasilitas Kamar"
          | Old Data                | New Data   | Updated by      |
          | AC, Kasur, Kipas Angin  | Kasur, AC  | Owner (Nurjono) |
        And admin can see log facility "Fasilitas Parkir"
          | Old Data                            | New Data               | Updated by      |
          | Parkir Motor & Sepeda, Parkir Mobil | Parkir Motor & Sepeda  | Owner (Nurjono) |
        And admin can see log facility "Fasilitas Kamar Mandi"
          | Old Data                        | New Data           | Updated by      |
          | Bak mandi, Gayung, Kloset Duduk | Bak mandi, Gayung  | Owner (Nurjono) |