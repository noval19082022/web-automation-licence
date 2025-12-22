@SS10 @resolvedChat

  Feature: Resolve Chat

    @TEST_SS-10276 @continue @context1 @context2
    Scenario: Chat becomes ongoing when tenant sends manual message
      Given admin set browser context to "context1"
      And bring page to front
      And admin go to mamikos bangkrupux admin
      When admin login to bangkrupux:
        | email stag                 | email prod          | password  |
        | qaeautomation3@mamikos.com | laksana@mamikos.com | qwerty123 |
      And user go to Rajawali Chat Room
      And user open chat room "CS Maya"
      And admin fill search chat with "Sutijan"
      Then resolved button is disable
      #tenant chat manual
      Given tenant set browser context to "context2"
      And bring page to front
      When user go to mamikos homepage
      And user login as tenant via phone number:
        | phone stag   | phone prod   | password  |
        | 084299093387 | -            | mamikos290|
      And tenant redirect to kost details:
        | kost path stag                                                                             | kost path prod                             |
        | kost-kabupaten-bantul-kost-campur-eksklusif-kost-singgahsini-luxe-harmoni-tipe-a-bantul-2 | Kost Automation Mix Tobelo Halmahera Utara |
      And user dismiss FTUE booking benefit
      And user click chat in kos detail
      And tenant close chat review
      And tenant enter text "Chat manual dari Automation by Tenant" in chat page
      #check resolve button in admin
      Given admin set browser context to "context1"
      And bring page to front
      Then resolved button is enable

    @TEST_SS-10280
    Scenario: Thank you message from BSE resolve does NOT trigger ongoing status
      When admin resolve chat
      Then sent closing chat "Baik, chat ini kami akhiri ya kak. Jika ada pertanyaan lain silakan chat kembali kapan saja. Mohon bantuannya untuk mengisi penilaian layanan ini. Terima kasih. 🙏"
      And resolved button is disable

    @TEST_SS-10277
    Scenario: Chat becomes ongoing when BSE agent sends manual message
      Given admin go to mamikos bangkrupux admin
      When admin login to bangkrupux:
        | email stag                 | email prod          | password  |
        | qaeautomation3@mamikos.com | laksana@mamikos.com | qwerty123 |
      And user go to Rajawali Chat Room
      And user open chat room "CS Maya"
      And admin fill search chat with "Sutijan"
      Then resolved button is disable
      #admin chat manual
      When admin chat "Chat manual dari Automation by BSE"
      Then resolved button is enable
      #resolve chat
      When admin resolve chat
      Then resolved button is disable