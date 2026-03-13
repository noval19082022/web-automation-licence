@LIMO1 @Mamifoto @ContentMamifoto @DONEMIGRATINGTONEWBOARD
Feature: Check content Mamifoto

  @continue @TEST_LIMO-3565 @declarative @listing-monetization @reviewed @Automated @web @playWright
  Scenario: [WEB][MamiFoto] Check content Mamifoto at landing page
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod | password |
      | 082233545511 | 0          | 12345678 |
    When owner click Mamifoto button
    Then owner can see mamifoto page
    And owner will see title and detail title "Listing Kos Tampil Memikat dengan MamiFoto" on panduan panduan persiapan foto or video
    And owner will see title and detail title "Paket foto dan video profesional yang mampu meningkatkan daya tarik properti Anda. Kos makin menarik, bisnis pun makin naik." on panduan panduan persiapan foto or video
    And owner will see title and detail title "Manfaat MamiFoto untuk Anda" on panduan panduan persiapan foto or video
    And owner will see title and detail title "Pengambilan Foto Berkualitas" on panduan panduan persiapan foto or video
    And owner will see title and detail title "Foto dan video yang dihasilkan menggambarkan kondisi properti Anda dengan baik." on panduan panduan persiapan foto or video
    And owner will see title and detail title "Hasil Diupload Tim Mamikos" on panduan panduan persiapan foto or video
    And owner will see title and detail title "Foto dan video yang ditayangkan adalah yang telah diseleksi dan disesuaikan untuk bisnis Anda." on panduan panduan persiapan foto or video
    And owner will see title and detail title "Peningkatan Kinerja Listing" on panduan panduan persiapan foto or video
    And owner will see title and detail title "Pemilik kos yang memasang foto profesional berkesempatan dapat kenaikan jumlah klik dan sewa." on panduan panduan persiapan foto or video
    And owner will see title and detail title "Proses Menggunakan MamiFoto" on panduan panduan persiapan foto or video
    And owner will see title and detail title "Pesan MamiFoto" on panduan panduan persiapan foto or video
    And owner will see title and detail title "Ambil paket yang sesuai dengan kebutuhan Anda." on panduan panduan persiapan foto or video
    And owner will see title and detail title "Buat Janji dengan Fotografer" on panduan panduan persiapan foto or video
    And owner will see title and detail title "Kami akan menghubungi untuk menentukan jadwal foto di properti Anda." on panduan panduan persiapan foto or video
    And owner will see title and detail title "Foto dan Video di-upload Mamikos" on panduan panduan persiapan foto or video
    And owner will see title and detail title "Setelah sesi foto, hasil akan tayang di listing Anda dalam waktu maks 2 minggu." on panduan panduan persiapan foto or video
    And owner will see title and detail title "Persiapan Kos Sebelum Difoto" on panduan panduan persiapan foto or video
    And owner will see title and detail title "Sembari menunggu fotografer datang, yuk simak apa saja yang harus Anda persiapkan sebelum sesi foto dimulai." on panduan panduan persiapan foto or video

  @panduanMamifotoContent @continue @TEST_LIMO-3566
  Scenario: [WEB][MamiFoto] Check content Mamifoto at panduan page
    When owner click Baca Panduan button
    #point Kamar Tidur
    Then owner will see title and detail title "Kamar Tidur" on panduan panduan persiapan foto or video
    And owner will see title and detail title "Rapikan tempat tidur." on panduan panduan persiapan foto or video
    And owner will see title and detail title "Rapikan, bersihkan, barang-barang dan kabel yang ada." on panduan panduan persiapan foto or video
    And owner will see title and detail title "Pastikan sudah menyediakan seluruh fasilitas kamar di tempatnya dan menyingkirkan barang-barang yang tidak diperlukan." on panduan panduan persiapan foto or video
    And owner will see title and detail title "Apabila ada jendela, buka korden dan rapikan." on panduan panduan persiapan foto or video
    And owner will see title and detail title "Lap jendela/kaca agar terlihat bersih." on panduan panduan persiapan foto or video
    And owner will see title and detail title "Pemakaian sprei polos lebih menarik untuk tenant." on panduan panduan persiapan foto or video
    And owner will see title and detail title "Pengecatan ulang kamar yang sudah lama akan menjadi jauh lebih menarik." on panduan panduan persiapan foto or video
    #point Kamar Mandi
    And owner will see title and detail title "Bersihkan kamar mandi." on panduan panduan persiapan foto or video
    And owner will see title and detail title "Lap jendela dan kaca agar terlihat bersih." on panduan panduan persiapan foto or video
    And owner will see title and detail title "Tempatkan peralatan kamar mandi dengan rapi agar terlihat menarik." on panduan panduan persiapan foto or video
    And owner will see title and detail title "Pastikan kamar mandi dalam kondisi kering saat fotografer datang." on panduan panduan persiapan foto or video
    #point detail
    And owner will see title and detail title "Apabila kamar kos memiliki fasilitas unggulan yang perlu ditonjolkan, maka persiapkan dengan baik dan posisikan di tempat yang diinginkan owner." on panduan panduan persiapan foto or video
    And owner will see title and detail title "Infokan detail ini kepada tim fotografer." on panduan panduan persiapan foto or video

    #check at tab Panduan area dan fasilitas
    When owner click tab panduan area
    #Tampak Depan Kost
    Then owner will see title and detail title "Tampak Depan Kos" on panduan panduan persiapan foto or video
    And owner will see title and detail title "Pastikan tidak ada sampah atau barang lainnya yang tidak diinginkan di depan kos supaya terlihat rapi dan menarik." on panduan panduan persiapan foto or video
    And owner will see title and detail title "Rapikan area tampak depan sebaik mungkin." on panduan panduan persiapan foto or video
    #Lorong dan Taman
    And owner will see title and detail title "Lorong dan Taman" on panduan panduan persiapan foto or video
    And owner will see title and detail title "Rapikan lorong kos, seperti letak tong sampah, tas laundry, sepatu anak kos, dsb." on panduan panduan persiapan foto or video
    And owner will see title and detail title "Rapikan area taman." on panduan panduan persiapan foto or video
    And owner will see title and detail title "Pastikan tidak ada sampah, dan barang-barang lainnya yang menumpuk dan tidak diinginkan." on panduan panduan persiapan foto or video
    #Detail
    And owner will see title and detail title "Bersihkan dan rapikan dapur umum." on panduan panduan persiapan foto or video
    And owner will see title and detail title "Rapikan parkiran kos sebaik mungkin." on panduan panduan persiapan foto or video
    And owner will see title and detail title "Rapikan ruang tunggu." on panduan panduan persiapan foto or video
    And owner will see title and detail title "Rapikan dan bersihkan ruang laundry." on panduan panduan persiapan foto or video
    And owner will see title and detail title "Rapikan dan bersihkan area lainnya." on panduan panduan persiapan foto or video
    And owner will see title and detail title "Lap kaca/jendela agar terlihat bersih." on panduan panduan persiapan foto or video
    And owner will see title and detail title " Pastikan tidak ada sampah dan barang-barang lainnya yang menumpuk dan tidak diinginkan." on panduan panduan persiapan foto or video

  @FAQMamifotoContent @TEST_LIMO-3567
  Scenario: [WEB][MamiFoto] Check content Mamifoto FAQ
    Given owner close pop up panduan
    When user click question "Jenis foto apa saja yang akan saya dapat?"
    Then user verify answer text "Tergantung dari jenis paket yang dipilih, Anda bisa mendapatkan foto landscape fasilitas kamar dan bangunan properti Anda, video kos dan foto 360 derajat."
    When user click question "Apa yang harus disiapkan sebelum sesi foto?"
    Then user verify answer text "Rapikan kamar kos, kamar mandi dan fasilitas kos lainnya sehingga menarik dan enak dipandang. Anda bisa baca tipsnya di sini."
    When user click question "Bisakah saya memilih fotografer?"
    Then user verify answer text "Untuk saat ini Mamikos yang akan memilihkan fotografer untuk Anda sesuai ketersediaan dan kecocokan jadwal. Namun jangan khawatir, semua fotografer dari Mamikos memiliki standar kualitas yang setara bagusnya."
    When user click question "Apakah foto dan video menampilkan semua tipe kamar di properti saya?"
    Then user verify answer text "Pengiriman dan penayangan foto & video tergantung pada tipe kamar yang terdaftar di Mamikos. Untuk keterangan lebih lanjut, klik di sini."
    When user click question "Di mana saja MamiFoto tersedia?"
    Then user verify answer text "Untuk MamiFoto A: Jadetabek, Bogor Kota, Bandung, Jatinangor, Cimahi, Yogyakarta, Solo, Semarang, Sidoarjo. Untuk MamiFoto B: Jadetabek, Bogor kota, Yogyakarta."
    When user click question "Kapan hasil foto akan ditayangkan?"
    Then user verify answer text "Hasil foto dan video akan ditayangkan di listing Mamikos Anda serta dikirim ke email Anda setelah Anda memilih hasil foto dalam waktu maksimum 7 hari kerja untuk paket MamiFoto A dan maksimum 14 hari kerja untuk MamiFoto B."
    When user click question "Bisakah saya mengubah/menambah foto sendiri?"
    Then user verify answer text "Ya, Anda bisa mengubah maupun menambahkan foto sendiri meski Anda telah menggunakan MamiFoto. Klik di sini untuk lihat cara mengubah dan menambahkan foto kos."