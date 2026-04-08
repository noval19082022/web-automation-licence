@LIMO3 @pprsgp @pprsowner
Feature: PPRS - Check statistic section for owner GP-1 or GP-2

  @TEST_LIMO-840 @TEST_LIMO-841 @TEST_LIMO-837
  Scenario: [WEB][PPRS] Display Recommendation Card on Owner Dashboard When Room is Full and GP1 is Already Active
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | password  |
      | 0898765431 | qwerty123 |
    And owner dismiss pop-up if appears
    And owner accsess statistic page
    Then user will see that the text "Hore, kos ini penuh!" is displayed
    And owner swipe next on pprs statistik
    Then user will see that the text "Lihat Profil Penyewa" is displayed
    Then user will see that the text "Mau dapat info tentang calon penyewa yang chat Anda? Upgrade ke GoldPlus 2." is displayed
    And user click on "Lihat Profil Penyewa"
    Then user should redirect to link that contains "/tenant/checker"


  @TEST_LIMO-838 @TEST_LIMO-839 @TEST_LIMO-836
  Scenario: [WEB][PPRS] Display Recommendation Card on Owner Dashboard When Room is Full and GP2 is Already Active
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | password  |
      | 0898765432 | qwerty123 |
    And owner dismiss pop-up if appears
    And owner accsess statistic page
    Then user will see that the text "Hore, kos ini penuh!" is displayed
    And owner swipe next on pprs statistik
    Then user will see that the text "Cek Properti Sekitar" is displayed
    Then user will see that the text "Penasaran sama kos sebelah? Bandingkan kos Anda dengan kompetitor di sekitar." is displayed
    And user click on "Cek Properti Sekitar"
    Then user should redirect to link that contains "/cek-properti-sekitar?backToDashboard=true"
