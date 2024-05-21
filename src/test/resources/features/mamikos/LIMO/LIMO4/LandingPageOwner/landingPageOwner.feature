@LIMO4 @regression @landingpageowner
Feature: Landing Page Owner

  @TEST_LIMO-5535 @continue
    Scenario: [Landing Page Owner][Header] Owner can see header when open landing page owner
      Given user go to mamikos homepage
      When user click "Pelajari Lebih Lanjut"
      Then user can see title "Yuk, Segera Daftarkan Kos Anda di Mamikos" on Landing Page Owner
      And user can see information "Mudah dan cepat temukan penyewa, bisnis properti kos Anda makin berkembang." on Landing Page Owner
      And user can see image header on Landing Page Owner
      When user click "Daftarkan Kos" on Landing Page Owner
      And owner set active page to 1
      Then user will see "Daftar Akun Pemilik Kos" on Register Owner page
      And owner close page number 1
      And owner set active page to 0

  @TEST_LIMO-5536 @continue
    Scenario: [Landing Page Owner][USP] Owner can see USP section when open landing page owner
      When user scroll to section USP
      Then user can see title "Mudahnya kelola kos di mamikos.com" on Landing Page Owner
      And user can see information "Berbagai keunggulan kelola properti di Mamikos untuk kemajuan bisnis kos Anda." on Landing Page Owner
      #pict 1
      And user can see information "Mudah Jangkau Jutaan Calon Penyewa" on Landing Page Owner
      And user can see information "Pemasaran kos online semakin mudah dan terhubung dengan jutaan pencari kos seluruh Indonesia di Mamikos." on Landing Page Owner
      #pict 2
      And user can see information "Mudah Pantau Performa Properti Anda" on Landing Page Owner
      And user can see information "Perkembangan pemasaran dan penyewaan kos tercatat akurat di laporan statistik dan tagihan." on Landing Page Owner
      #pict 3
      And user can see information "Perluas Wawasan Bisnis Kos Lewat Komunitas" on Landing Page Owner
      And user can see information "Dapatkan berbagai tips seputar usaha kos, dan saling berbagi pengalaman di komunitas Mitra Mamikos." on Landing Page Owner
      #pict 4
      And user can see information "Mudah Kelola Tagihan Penyewa" on Landing Page Owner
      And user can see information "Tak perlu pusing mengurus kontrak, tagihan, dan bukti pembayaran. Semua tercatat akurat di sistem Mamikos." on Landing Page Owner

  @TEST_LIMO-5540 @continue
    Scenario: [Landing Page Owner] Owner can see "Maju Bersama" section when open landing page owner
      When user scroll and see section "Maju Bersama Layanan Mamikos"
      Then user can see information "Dengan berbagai produk dan layanan, Anda bisa kelola kos secara mandiri atau menyerahkan pengelolaannya ke Mamikos." on Landing Page Owner
      #tab 1
      When user click "Kelola kos mandiri"
      And user click on "Pemasaran Kos Tepat Sasaran" and see list with subtitle "Beragam fitur pemasaran yang terjangkau dan sesuai kebutuhan Anda." on Landing Page Owner
      And user click on "Kelola Properti Online" and see list with subtitle "Dengan sewakan kos secara online, Anda bebas kelola properti kapan saja, di mana saja, dan dengan gawai apa saja." on Landing Page Owner
      And user click on "Pengajuan dan Penagihan Sewa Mudah" and see list with subtitle "Terima atau tolak booking, hingga penagihan uang sewa makin mudah hanya di ujung jari Anda saja." on Landing Page Owner
      And user click on "Tambah Daya Tarik ke Calon Penyewa" and see list with subtitle "Dengan fitur dan teknologi terbaru, visualisasi kos makin interaktif, makin menarik perhatian calon penyewa." on Landing Page Owner
#      #tab 2
      When user click "Dikelola Mamikos"
      Then user can see information "Sebagai bagian dari Mamikos, Singgahsini dan Apik secara profesional dan optimal memanfaatkan sistem, produk, dan layanan Mamikos untuk pengelolaan kos Anda." on Landing Page Owner
      And user can see information "Layanan Singgahsini dan Apik mencakup standarisasi properti dan operasional, pemasaran, hingga penyewaan." on Landing Page Owner
      And user can see information "Anda tinggal menikmati keuntungannya setiap bulan dan pantau melalui Laporan Performa." on Landing Page Owner
      When user scroll and click "Lihat Singgahsini" button
      And tenant set active page to 1
      Then user should redirect to link "https://singgahsini.id/"

  @TEST_LIMO-5541
  Scenario: [Landing Page Owner] Owner can see "FAQ" section when open landing page owner
    Given user go to mamikos homepage
    And user click "Pelajari Lebih Lanjut"
    When user scroll and see section "Tanya & Jawab"
    Then user can see title "Makin yakin bergabung dengan Mamikos" on Landing Page Owner
    When user see question "Bagaimana cara daftarkan kos?" on Landing Page Owner
    Then user verify answer text at LP owner "Untuk dapat mendaftarkan kos di Mamikos, Anda perlu memiliki \"Akun Pemilik Kos\" terlebih dahulu."
    When user see question "Apakah mendaftarkan kos di Mamikos gratis?" on Landing Page Owner
    Then user verify answer text at LP owner "Untuk mendaftarkan akun dan properti kos Anda, tidak ada biaya sedikit pun (grat"
    When user see question "Apakah saya dapat menggunakan lebih dari 1 produk di Mamikos?" on Landing Page Owner
    Then user verify answer text at LP owner "Ya, untuk membantu kelola properti Anda di Mamikos, Anda dapat memakai lebih dari"
    When user see question "Apakah saya dapat mengakses layanan Mamikos dengan lebih dari 1 perangkat?" on Landing Page Owner
    Then user verify answer text at LP owner "Ya. Mengelola kos online dengan Mamikos menjadi mudah karena dapat diakses di mana saja"
    When user see question "Apakah beda kos yang dikelola sendiri di Mamikos dengan kos yang dikelola Mamikos?" on Landing Page Owner
    Then user verify answer text at LP owner "Dengan mengelola sendiri kos Anda di Mamikos, Anda dapat membuat sendiri listing"

  @TEST_LIMO-5542
  Scenario: [Landing Page Owner] Owner can see "Pusat Bantuan" and footer section when open landing page owner
    Given user go to mamikos homepage
    And user click "Pelajari Lebih Lanjut"
    When user scroll to pusat bantuan
    Then user can see title "Kami siap membantu Anda" and sub title "Mari gabung bersama puluhan ribu pemilik kos lain, kelola kos online di Mamikos." at section pusat bantuan
    When user want to accsess Pusat Bantuan
    And owner set active page to 1
    Then user should redirect to link "https://help.mamikos.com/category/pemilik/akun-pemilik"
    And owner close page number 1
    And owner set active page to 0
    And user can see footer mamikos
