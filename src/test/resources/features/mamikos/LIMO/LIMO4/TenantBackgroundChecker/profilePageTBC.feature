@LIMO4 @regression
Feature: Profile Tenant Background Checker

  @TEST_LIMO-4993
    Scenario: [Web][Tenant Background Checker][Profil Tenant] Check back on tenant profile page
      Given user go to mamikos homepage
      When user login as owner:
       | phone stag    | phone prod    | password     |
       | 0891111020203 | 0891111020203 | mamikosqa123 |
      And user click chat button in top bar owner home page
      And owner open TBC Lihat Profil at chatroom "Staging Tbc Test"
      When owner click back button on TBC page
      Then user redirected to owner dashboard

  @TEST_LIMO-4968
    Scenario: [Web][Chat Room][Tenant Background Checker] Check entry point when owner only have apartement
      Given user go to mamikos homepage
      When user login as owner:
        | phone stag   | phone prod   | password  |
        | 083355251016 | 083355251016 | qwerty123 |
      And user click chat button in top bar owner home page
      And owner doesn't have GP open TBC Lihat Profil at chatroom "Narendra Putra"
      When owner click button "Beli Paket" on TBC page
      Then owner should see anda belum memiliki kos aktif pop up

  @TEST_LIMO-4889
    Scenario: [Web][Tenant Background Checker][Profil Tenant] Check condition when owner not GP
      Given user go to mamikos homepage
      When user login as owner:
        | phone stag   | phone prod   | password  |
        | 083355251030 | 083355251030 | qwerty123 |
      And user click chat button in top bar owner home page
      And owner Non GP open TBC Lihat Profil at chatroom "Narendra Putra"
      When owner click button "Beli Paket" on TBC page
      Then owner redirect to select package GP2 page