@SS8 @resolvedChat

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

    @TEST_SS-10290 @context1 @context2
    Scenario: Resolved chat is reactivated by tenant message
      #tenant chat manual
      Given tenant set browser context to "context1"
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
      Given admin set browser context to "context2"
      And bring page to front
      And admin go to mamikos bangkrupux admin
      When admin login to bangkrupux:
        | email stag                 | email prod          | password  |
        | qaeautomation3@mamikos.com | laksana@mamikos.com | qwerty123 |
      And user go to Rajawali Chat Room
      And user open chat room "CS Maya"
      And admin fill search chat with "Sutijan"
      Then resolved button is enable
      #resolve chat
      When admin resolve chat
      Then resolved button is disable

    @TEST_SS-10291
    Scenario: Resolved chat is reactivated by BSE agent message
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

    @TEST_SS-10295 @continue
    Scenario: Unresolved tab counter updates when chat becomes ongoing
      Given admin go to mamikos bangkrupux admin
      When admin login to bangkrupux:
        | email stag                 | email prod          | password  |
        | qaeautomation3@mamikos.com | laksana@mamikos.com | qwerty123 |
      And user go to Rajawali Chat Room
      And user open chat room "CS Maya"
      And admin fill search chat with "Sutijan"
      Then resolved button is disable
      #make chat ongoing
      When admin chat "Chat manual dari Automation by BSE"
      Then resolved button is enable
      #Assert unresolved counter
      And unresolved counter increase by 1

    @TEST_SS-10296
    Scenario: Unresolved tab counter updates when chat is resolved
      #resolve chat
      When admin resolve chat
      Then resolved button is disable
      #Assert unresolved counter
      And unresolved counter is not visible

    #TENANT SIDE #
    @TEST_SS-10177 @continue @context1 @context2
    Scenario: Check display rating modal when user is inside chatroom when bse resolved chat
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
      When admin resolve chat
      #check pop up rating chat in tenant
      When tenant set browser context to "context2"
      And bring page to front
      Then rating chat pop up appear
      When tenant skip rating chat
      Then tenant can see chat from BSE with "Baik, chat ini kami akhiri ya kak. Jika ada pertanyaan lain silakan chat kembali kapan saja. Mohon bantuannya untuk mengisi penilaian layanan ini. Terima kasih. 🙏"

    @TEST_SS-10182 @continue
    Scenario: Hide rating chip when chat is reactivated
      When tenant enter text "Chat manual dari Automation by Tenant" in chat page
      Then chip button "Nilai Layanan" should disappear

    @TEST_SS-10181 @continue
    Scenario: Skip rating and show persistent chip
      #resolved chat
      When admin set browser context to "context1"
      And bring page to front
      Then resolved button is enable
      When admin resolve chat
      #Skip rating chat
      When tenant set browser context to "context2"
      And bring page to front
      Then rating chat pop up appear
      When tenant skip rating chat
      Then chip button "Nilai Layanan" is appear

    @TEST_SS-10178 @continue
    Scenario: Tenant check display feedback text field
      When tenant click Nilai Layanan chip button
      #kejelasan jawaban
      And tenant input rating kejelasan jawaban 1 star
      Then show kejelasan jawaban description "Tidak jelas"
      When tenant input rating kejelasan jawaban 2 star
      Then show kejelasan jawaban description "Kurang jelas"
      When tenant input rating kejelasan jawaban 3 star
      Then show kejelasan jawaban description "Cukup jelas"
      When tenant input rating kejelasan jawaban 4 star
      Then show kejelasan jawaban description "Jelas"
      When tenant input rating kejelasan jawaban 5 star
      Then show kejelasan jawaban description "Sangat jelas"
      #kecepatan balas
      When tenant input rating kecepatan balas 1 star
      Then show kecepatan balas description "Sangat lambat"
      When tenant input rating kecepatan balas 2 star
      Then show kecepatan balas description "Kurang cepat"
      When tenant input rating kecepatan balas 3 star
      Then show kecepatan balas description "Cukup cepat"
      When tenant input rating kecepatan balas 4 star
      Then show kecepatan balas description "Cepat"
      When tenant input rating kecepatan balas 5 star
      Then show kecepatan balas description "Sangat cepat"

    @TEST_SS-10179 @continue
    Scenario: Check display when tenant input low rating (1 & 2 star)
      When tenant input rating kejelasan jawaban 1 star
      And tenant input rating kecepatan balas 1 star
      Then tenant can see feedback field
      When tenant input rating kejelasan jawaban 2 star
      And tenant input rating kecepatan balas 2 star
      Then tenant can see feedback field

    @TEST_SS-10180 @continue
    Scenario: Check display when tenant input medium rating (2 star)
      When tenant input rating kejelasan jawaban 3 star
      And tenant input rating kecepatan balas 3 star
      Then tenant can't see feedback field

    @TEST_SS-10185 @continue
    Scenario: Submit rating without feedback text
      When tenant input rating kejelasan jawaban 2 star
      And tenant input rating kecepatan balas 2 star
      And tenant submit rating
      Then success submit rating pop up appear

    @TEST_SS-10184
    Scenario: Submit rating with high rating
      #tenant send chat to reactivate
      When tenant enter text "Chat manual dari Automation by Tenant" in chat page
      #admin resolve chat
      When admin set browser context to "context1"
      And bring page to front
      When admin resolve chat
      #tenant submit rating with high rating
      When tenant set browser context to "context2"
      And bring page to front
      Then rating chat pop up appear
      When tenant input rating kejelasan jawaban 3 star
      And tenant input rating kecepatan balas 3 star
      And tenant submit rating
      Then success submit rating pop up appear

    @TEST_SS-10278 @continue @context1 @context2
    Scenario: Chat pretext message trigger ongoing status
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
      When admin send jawab cepat template "Masih ada kamar?"
      Then resolved button is enable

    @TEST_SS-10294 @continue
    Scenario: Unresolved tab displays only ongoing chats
      When admin filter "Unresolved" on chat list
      And admin fill search chat with "Sutijan"
      Then resolved button is enable

    @TEST_SS-10285 @continue @context2
    Scenario: BSE agent successfully resolves an ongoing chat
      #admin resolve chat
      When admin resolve chat
      Then resolved button is disable
      #tenant verify preset chat
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
      Then tenant can see chat from BSE with "Baik, chat ini kami akhiri ya kak. Jika ada pertanyaan lain silakan chat kembali kapan saja. Mohon bantuannya untuk mengisi penilaian layanan ini. Terima kasih. 🙏"

    @TEST_SS-10186 @continue
    Scenario: Submit rating with feedback text
      #tenant reactivate chat
      When tenant enter text "Chat manual dari Automation by Tenant" in chat page
      #admin resolve chat
      When admin set browser context to "context1"
      And bring page to front
      Then resolved button is enable
      When admin resolve chat
      #tenant submit rating with feedback
      When tenant set browser context to "context2"
      And bring page to front
      Then rating chat pop up appear
      When tenant input rating kejelasan jawaban 1 star
      And tenant input rating kecepatan balas 1 star
      And tenant input feedback "Automation Test Resolved Chat"
      And tenant submit rating
      Then success submit rating pop up appear