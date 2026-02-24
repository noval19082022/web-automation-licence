@regression @SS16 @harvest @checkProperty

Feature: Check Property Mamikos

  @TEST_SS-754 @continue
  Scenario: Admin Check Property in "Kost Pillar 1 & 2" by "Nama Properti" keyword
      #Search Property in Pillar 1
    Given admin go to mamikos cek properti
    When admin search property in search bar "Mars White" by Nama Properti
    Then property is displayed with name "Kost Apik Mars White Halmahera Utara"
    And the address is displayed "jl pattimura nomor 111, Kecamatan Tobelo Utara, Kabupaten Halmahera Utara, Maluku Utara"
      #Search Property in Pillar 2
    When admin clear keyword in search bar
    And admin search property in search bar "Jaguar" by Nama Properti
    Then property is displayed with name "Kost Jaguar Tipe A Tobelo Utara Halmahera Utara"
    And the address is displayed "Kecamatan Tobelo Utara, Kabupaten Halmahera Utara, Maluku Utara, Kecamatan Tobelo Utara, Kabupaten Halmahera Utara, Maluku Utara"

  @TEST_SS-600 @continue
  Scenario: Admin Check Property in "Kost Pillar 1 & 2" by "Nomor HP Pemilik" keyword
      #Search Property in Pillar 1
    When admin clear keyword in search bar
    And admin search property in search bar "0890000000347" by Nomor HP Pemilik
    Then property is displayed with name "Kost Apik Mars White Halmahera Utara"
    And the address is displayed "jl pattimura nomor 111, Kecamatan Tobelo Utara, Kabupaten Halmahera Utara, Maluku Utara"
      #Search Property in Pillar 2
    When admin clear keyword in search bar
    And admin search property in search bar "0890000003509" by Nomor HP Pemilik
    Then property is displayed with name "Kost Jaguar Tipe A Tobelo Utara Halmahera Utara"
    And the address is displayed "Kecamatan Tobelo Utara, Kabupaten Halmahera Utara, Maluku Utara, Kecamatan Tobelo Utara, Kabupaten Halmahera Utara, Maluku Utara"

  @TEST_SS-610
  Scenario: Admin Open Property and Check Property
    When admin opens property
    And admin clicks on next image
    Then property title in pop up is displayed "Kost Jaguar Tipe A Tobelo Utara Halmahera Utara"