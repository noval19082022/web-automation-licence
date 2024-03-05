@regression @pman2 @pms @bseFilter

  Feature: BSE Filter

#    @TEST_PMAN-4477 @continue
#    Scenario: Filter by BSE
#      Given admin go to pms singgahsini
#      When admin login pms :
#        | email             | password      |
#        | pman@mamiteam.com | pmanM4m1t34m  |
#      And admin clicks on Filter button
#      And admin filter by BSE "Maya BSE"
#      And admin clicks Terapkan button
#      Then the system is displaying property with BSE "Maya BSE"

    @a
    Scenario: Multiple Filter BSE, Kota, and Produk
      Given admin go to pms singgahsini
      When admin login pms :
        | email             | password      |
        | pman@mamiteam.com | pmanM4m1t34m  |
      When admin clicks on Filter button
      And admin filter by BSE "Maya BSE"
      And admin selects Kota "Halmahera Utara"
      And admin selects Produk "Apik"
      And admin clicks Terapkan button
      Then the system is displaying property with BSE "Maya BSE"
      And the system is displaying kota "Kabupaten Halmahera Utara"
      And the system is displaying produk "Apik"