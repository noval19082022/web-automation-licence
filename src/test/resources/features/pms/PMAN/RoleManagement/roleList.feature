@pman2 @role-management

  Feature: Role List

    @TEST_PMAN-3683
    Scenario: Role list display
      Given admin go to pms singgahsini
      And admin login pms :
        | email             | password      |
        | pman@mamiteam.com | pmanM4m1t34m  |
      When admin go to role management menu
      Then role list should contains column
        | Nama Role         |
        | Jumlah Permission |
        | Jumlah Member     |
        | Action            |
      And list contains max 20 role per page
      And contains button "Tambah Role"
      And contains button "Member"
      And action button contains action to
        | Edit        |
        | Atur Member |
        | Hapus       |