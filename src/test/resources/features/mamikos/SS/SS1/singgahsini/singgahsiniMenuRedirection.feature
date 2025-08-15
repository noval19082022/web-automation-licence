@regression @SS1 @singgahsini

Feature: Singgahsini Menu Redirection

  @TEST_SS-638
  Scenario: Header Menu Redirection
    Given user navigates to singgahsini.id
      #Navbar Menu Tentang Kami
    When user click header menu "Tentang Kami"
    Then page auto scroll to section "Tentang Kami"
      #Navbar Menu Keuntungan
    When user click header menu "Keuntungan"
    Then page auto scroll to section "Keuntungan"
      #Navbar Menu Tanya Jawab
    When user click header menu "Tanya Jawab"
    Then page auto scroll to section "Tanya Jawab"

  @TEST_SS-759
  Scenario: Footer Menu Redirection
    Given user navigates to singgahsini.id
      #Footer Menu Tentang Kami
    When user click footer menu "Tentang Kami"
    Then page auto scroll to section "Tentang Kami"
      #Footer Menu Keuntungan
    When user click footer menu "Keuntungan"
    Then page auto scroll to section "Keuntungan"
      #Footer Menu Tanya Jawab
    When user click footer menu "Tanya Jawab"
    Then page auto scroll to section "Tanya Jawab"

  @TEST_SS-763
  Scenario: Footer Social Media Redirection
    Given user navigates to singgahsini.id
      #Tiktok
    When user click social media link "Tiktok"
    Then new tab open redirect to "Tiktok"
      #Instagram
    When user click social media link "Instagram"
    Then new tab open redirect to "Instagram"
      #Youtube
    When user click social media link "Youtube"
    Then new tab open redirect to "Youtube"