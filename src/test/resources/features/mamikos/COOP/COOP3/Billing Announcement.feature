@COOP3 @billingAnnouncement
Feature: Billing Announcement

  @SS-5002 @continue
  Scenario: [Billing tracker][Announcement]Check annountment for BSE
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password     |
      | pman@mamiteam.com | pmanM4m1t34m |
    And admin go to billing tracker
    And admin click on expand billing announcement
    And admin choose bse name with "Maya"
    And admin click on "Tambah" button
    And admin input announcement with "Hallo Maya jangan sampai lupa untuk bikin announcement"
    And admin can see announcement toast "Announcement berhasil tersimpan."
    Then admin can see announcement toast "Hallo Maya jangan sampai lupa untuk bikin announcement"

  @SS-5041 @continue
  Scenario: [Billing tracker][Announcement]Check validation on modals
    When admin click on "Ubah" button
    And admin input announcement with "Semua tenant dengan BSE bella harus membayar dengan tepat waktu, dan BSE bella harus mengingatkan sehari sebelum jatuh tempo danharap diberitahu kepada tenant jika tenant telat membayar akan kena denda sebesar Rp.10.000 tiap hari jangan sampai hari ini lupa dan telat membayar ya. ingatkan kepada semua"

  @SS-5042 @continue
  Scenario: [Billing tracker][Announcement]Edit announcement
    When admin click on "Ubah" button
    And admin input announcement with "Edit Maya jangan sampai lupa untuk bikin announcement"
    And admin can see announcement toast "Announcement berhasil tersimpan."
    Then admin can see announcement toast "Edit Maya jangan sampai lupa untuk bikin announcement"

  @SS-5043
  Scenario: [Billing tracker][Announcement]Delete announcement
    When admin click on "Ubah" button
    And admin input announcement with " "
    And admin can see announcement toast "Announcement berhasil tersimpan."
    And admin can see blank announcement with "Belum ada announcement untuk akun BSE ini"