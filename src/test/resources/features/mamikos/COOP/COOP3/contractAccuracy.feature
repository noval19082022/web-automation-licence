@COOP3 @contractAccuracyDbet
Feature: Contract Accuracy DBET - PMS

  @TEST_SS-5469
  Scenario: [PMS][Room Allotment][Add DBET] User check required of kategori kontrak field
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to room allotment page "Kost Singgahsini Rumah Bata Bantul"
    And admin create contract tenant dbet
    And admin selected type room
    And admin choose dbet category with "BSE - BSE Workaround"
    Then admin can see contract id is disabled
    When admin choose dbet category with "Billing - Ubah Jatuh Tempo"
    Then admin can see contract id is enabled

  @TEST_SS-5440
  Scenario Outline: [PMS][Room Allotment][Add DBET] User check permission to fill of Contract ID field based on Kategori Kontrak field
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to room allotment page "Kost Singgahsini Rumah Bata Bantul"
    And admin create contract tenant dbet
    And admin selected type room
    And admin choose dbet category with "BSE - BSE Workaround"
    Then admin can see contract id is disabled
    And admin choose dbet category with "<text>"
    Then admin can see contract id is enabled
    Examples:
      | text                        |
      | Billing - Ubah Jatuh Tempo  |
      | Billing - Ubah Durasi Sewa  |
      | Billing - Incident          |
      | Billing - Pindah Tipe Kamar |
      | Pindah Properti             |

  @TEST_SS-5439
  Scenario Outline: [PMS][Room Allotment][Add DBET] User check value dropdown kategori kontrak
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to room allotment page "Kost Singgahsini Rumah Bata Bantul"
    And admin create contract tenant dbet
    And admin selected type room
    And user click dropdown kategori kontrak DBET field
    Then user validate this "<option>" is shown in kategori kontrak DBET field
    Examples:
      | option                      |
      | BSE - BSE Workaround        |
      | Billing - Ubah Jatuh Tempo  |
      | Billing - Ubah Durasi Sewa  |
      | Billing - Incident          |
      | Billing - Pindah Tipe Kamar |
      | Pindah Properti             |

  @TEST_SS-5450
  Scenario Outline: [PMS][Room Allotment][Tambah Penyewa] Check field Notes
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to room allotment page "Kost Singgahsini Rumah Bata Bantul"
    And admin create contract tenant dbet
    And admin selected type room
    And admin choose dbet category with "BSE - BSE Workaround"
    Then admin can see and type in field "<Catatan>" atleast 5 char and <= 300 character limit
    Examples:
      | Catatan                                                                                                                                                                                                                                                                                                      |
      | Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also thee |

  @TEST_SS-5441
  Scenario: [PMS][Room Allotment][Tambah Penyewa] User create DBET tenant using active contract ID
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to room allotment page "Kost Singgahsini Rumah Bata Bantul"
    And admin create contract tenant dbet
    And admin selected type room
    And admin choose dbet category with "Billing - Ubah Jatuh Tempo"
    And admin input contract id with "72660"
    Then admin can see "Hanya bisa memasukkan Contract ID yang sudah diakhiri." on contract id
