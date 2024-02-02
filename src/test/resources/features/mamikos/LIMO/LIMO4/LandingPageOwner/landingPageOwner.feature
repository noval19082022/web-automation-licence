@LIMO4 @regression @landingpageowner
Feature: Landing Page Owner

  @TEST_LIMO-5535
    Scenario: [Landing Page Owner][Header] Owner can see header when open landing page owner
      Given user go to mamikos homepage
      When user click "Pelajari Lebih Lanjut"
      Then user can see title "Yuk, Segera Daftarkan Kos Anda di Mamikos" on Landing Page Owner
      And user can see information "Mudah dan cepat temukan penyewa, bisnis properti kos Anda makin berkembang." on Landing Page Owner
      And user can see image header on Landing Page Owner
      When user click "Daftarkan Kos" on Landing Page Owner
      And owner set active page to 1
      Then user will see "Daftar Akun Pemilik Kos" on Register Owner page

  @TEST_LIMO-5536
    Scenario: [Landing Page Owner][USP] Owner can see USP section when open landing page owner
      Given user go to mamikos homepage
      When user click "Pelajari Lebih Lanjut"
      And user scroll to section USP
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

  @TEST_LIMO-5540
    Scenario: [Landing Page Owner] Owner can see "Maju Bersama" section when open landing page owner
      Given user go to mamikos homepage
      When user click "Pelajari Lebih Lanjut"
      And user scroll and see section "Maju Bersama Layanan Mamikos"
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
      Then user redirected to "https://singgahsini.id/"