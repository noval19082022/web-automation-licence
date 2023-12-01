@regression @LIMO1 @TEST_LIMO-3662
Feature: FAQ Mamitour

  @continue
  Scenario: [Web][Mamitour] Tanya Jawab Mamitour
    Given user go to mamikos homepage
    When user login as owner:
    | phone stag    | phone prod    | password     |
    | 0826666666633 | 0826666666633 | qwerty123    |
    And user access mamitour from owner dashboard
    And user click "Apa itu MamiTour?"
    Then user will see that the text "MamiTour adalah jasa virtual tour atau tur virtual dari Mamikos untuk simulasi keliling properti kos. Pengguna bisa berjalan dari satu ruang ke ruang lain di kos Anda secara online seperti berjalan di dunia nyata dan melihat sekeliling dengan sudut pandang 360°." is displayed
    When user click "Apa itu MamiTour?"
    Then user should not be able to see the text "MamiTour adalah jasa virtual tour atau tur virtual dari Mamikos untuk simulasi keliling properti kos. Pengguna bisa berjalan dari satu ruang ke ruang lain di kos Anda secara online seperti berjalan di dunia nyata dan melihat sekeliling dengan sudut pandang 360°."
    When user click "Apa yang harus disiapkan sebelum sesi pengambilan gambar?"
    Then user will see that the text "Rapikan kamar kos, kamar mandi dan fasilitas kos lainnya sehingga menarik dan enak dipandang. Anda bisa baca tipsnya di sini." is displayed
    When user click "Apa yang harus disiapkan sebelum sesi pengambilan gambar?"
    Then user should not be able to see the text "Rapikan kamar kos, kamar mandi dan fasilitas kos lainnya sehingga menarik dan enak dipandang. Anda bisa baca tipsnya di sini."
    When user click "Bisakah saya menambah jumlah kamar/lantai yang dimasukkan ke dalam virtual tour?"
    Then user will see that the text "Anda bisa memesan tambahan kamar maupun lantai dengan biaya tambahan yang berlaku. Anda tinggal cantumkan permintaan tambahan Anda saat melakukan pemesanan." is displayed
    When user click "Bisakah saya menambah jumlah kamar/lantai yang dimasukkan ke dalam virtual tour?"
    Then user should not be able to see the text "Anda bisa memesan tambahan kamar maupun lantai dengan biaya tambahan yang berlaku. Anda tinggal cantumkan permintaan tambahan Anda saat melakukan pemesanan."
    When user click "Di mana saja MamiTour tersedia?"
    Then user will see that the text "MamiTour tersedia di Jadetabek, Kota Bandung, Jatinangor, Cimahi, Yogyakarta, Surabaya, dan Sidoarjo." is displayed
    When user click "Di mana saja MamiTour tersedia?"
    Then user should not be able to see the text "MamiTour tersedia di Jadetabek, Kota Bandung, Jatinangor, Cimahi, Yogyakarta, Surabaya, dan Sidoarjo."
    When user click "Di mana dan kapan MamiTour akan ditayangkan setelah pengambilan gambar?"
    Then user will see that the text "MamiTour akan ditayangkan di halaman detail kos Anda setelah sesi pengambilan gambar selesai dalam waktu maksimum 14 hari kerja." is displayed
    When user click "Di mana dan kapan MamiTour akan ditayangkan setelah pengambilan gambar?"
    Then user should not be able to see the text "MamiTour akan ditayangkan di halaman detail kos Anda setelah sesi pengambilan gambar selesai dalam waktu maksimum 14 hari kerja."
    When user click "Bagaimana ketentuan urutan lantai untuk pengambilan gambar?"
    Then user will see that the text "Standar MamiTour yakni 2 lantai berurutan dari atas tanah, dengan jalan masuk ke bangunan kos. Jika Anda memiliki tambahan lantai, Anda dapat menambahnya saat pembayaran." is displayed
    When user click "Bagaimana ketentuan urutan lantai untuk pengambilan gambar?"
    Then user should not be able to see the text "Standar MamiTour yakni 2 lantai berurutan dari atas tanah, dengan jalan masuk ke bangunan kos. Jika Anda memiliki tambahan lantai, Anda dapat menambahnya saat pembayaran."

  Scenario: [Web][Mamitour] Pusat Bantuan Mamitour
    When user click on pusat bantuan mamitour
    And owner set active page to 1
    Then user redirected to pusat bantuan mamitour page