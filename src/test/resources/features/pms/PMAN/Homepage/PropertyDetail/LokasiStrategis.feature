@pman2 @pms @detail-kos @lokasi-strategis

  Feature: Lokasi Strategis

    @continue @TEST_PMAN-861
    Scenario: Add New Lokasi Strategis
      Given admin go to pms singgahsini
      When admin login pms :
        | email             | password      |
        | pman@mamiteam.com | pmanM4m1t34m  |
      And admin go to detail property "Khusus Automation"
      And admin go to detail kos tab
      And admin ubah data property
      And admin add lokasi strategis
        | 100 meter ke jalan raya         |
        | 200 meter ke pom bensin         |
        | 300 meter ke pusat perbelanjaan |
      And admin back to detail kos "3143"
      Then lokasi strategis should be list in detail kos
        | 100 meter ke jalan raya         |
        | 200 meter ke pom bensin         |
        | 300 meter ke pusat perbelanjaan |

    @continue @TEST_PMAN-643
    Scenario: Max 10 lokasi strategis can be add
      When admin ubah data property
      And add 10 lokasi strategis
      Then tambah lokasi strategis button should be disabled

    @continue @TEST_PMAN-641
    Scenario: Lokasi strategis max char 255
      When admin edit "4" lokasi strategis ">255 char"
      Then error message max character lokasi strategis appear
      And admin delete lokasi strategis "4"

    @continue @TEST_PMAN-870
    Scenario: Edit Lokasi Strategis
      When admin edit "1" lokasi strategis "150 meter ke jalan utama"
      And admin back to detail kos "3143"
      Then lokasi strategis should be list in detail kos
        | 150 meter ke jalan utama        |
        | 200 meter ke pom bensin         |
        | 300 meter ke pusat perbelanjaan |

    @continue @TEST_PMAN-866
    Scenario: Delete Lokasi Strategis
      When admin ubah data property
      And admin delete lokasi strategis "2"
      And admin back to detail kos "3143"
      Then lokasi strategis should be list in detail kos
        | 150 meter ke jalan utama        |
        | 300 meter ke pusat perbelanjaan |

    @TEST_PMAN-634
    Scenario: Empty Lokasi Strategis
      When admin ubah data property
      And admin delete lokasi strategis "1"
      Then delete button should be disabled
      When admin clear lokasi strategis "1"
      And admin back to detail kos "3143"
      Then lokasi strategis should be empty