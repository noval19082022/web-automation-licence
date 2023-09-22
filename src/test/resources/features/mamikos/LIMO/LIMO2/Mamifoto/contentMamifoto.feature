@LIMO2 @Mamifoto @ContentMamifoto

Feature: Check content Mamifoto

  @continue @TEST_LIMO-4632 @declarative @listing-monetization @reviewed @Automated @web @playWright
  Scenario: [WEB][MamiFoto] Check content Mamifoto at landing page
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod | password |
      | 082233545511 | 0          | 12345678 |
    When owner click menu sidebar Mamifoto
    Then owner can see mamifoto page
    And owner will see that the text "Listing Kos Tampil Memikat dengan MamiFoto" is displayed
    And owner will see that the text "Paket foto dan video profesional yang mampu meningkatkan daya tarik properti Anda. Kos makin menarik, bisnis pun makin naik." is displayed
    And owner will see that the text "Manfaat MamiFoto untuk Anda" is displayed
    And owner will see that the text "Pengambilan Foto Berkualitas" is displayed
    And owner will see that the text "Foto dan video yang dihasilkan menggambarkan kondisi properti Anda dengan baik." is displayed
    And owner will see that the text "Hasil Diupload Tim Mamikos" is displayed
    And owner will see that the text "Foto dan video yang ditayangkan adalah yang telah diseleksi dan disesuaikan untuk bisnis Anda." is displayed
    And owner will see that the text "Peningkatan Kinerja Listing" is displayed
    And owner will see that the text "Pemilik kos yang memasang foto profesional berkesempatan dapat kenaikan jumlah klik dan sewa." is displayed
    And owner will see that the text "Proses Menggunakan MamiFoto" is displayed
    And owner will see that the text "Pesan MamiFoto" is displayed
    And owner will see that the text "Ambil paket yang sesuai dengan kebutuhan Anda." is displayed
    And owner will see that the text "Buat Janji dengan Fotografer" is displayed
    And owner will see that the text "Kami akan menghubungi untuk menentukan jadwal foto di properti Anda." is displayed
    And owner will see that the text "Foto dan Video di-upload Mamikos" is displayed
    And owner will see that the text "Setelah sesi foto, hasil akan tayang di listing Anda dalam waktu maks 2 minggu." is displayed
    And owner will see that the text "Persiapan Kos Sebelum Difoto" is displayed
    And owner will see that the text "Sembari menunggu fotografer datang, yuk simak apa saja yang harus Anda persiapkan sebelum sesi foto dimulai." is displayed

  @panduanMamifotoContent
  Scenario: [WEB][MamiFoto] Check content Mamifoto at panduan page
    When owner click Baca Panduan button
      #point Kamar Tidur
    Then owner will see that the text "Kamar Tidur" is displayed
    And owner will see that the text "Rapikan tempat tidur." is displayed
    And owner will see that the text "Rapikan, bersihkan, barang-barang dan kabel yang ada." is displayed
    And owner will see that the text "Pastikan sudah menyediakan seluruh fasilitas kamar di tempatnya dan menyingkirkan barang-barang yang tidak diperlukan." is displayed
    And owner will see that the text "Apabila ada jendela, buka korden dan rapikan." is displayed
    And owner will see that the text "Lap jendela/kaca agar terlihat bersih." is displayed
    And owner will see that the text "Pemakaian sprei polos lebih menarik untuk tenant." is displayed
    And owner will see that the text "Pengecatan ulang kamar yang sudah lama akan menjadi jauh lebih menarik." is displayed
      #point Kamar Mandi
    Then owner will see that the text "Kamar Mandi" is displayed
    And owner will see that the text "Bersihkan kamar mandi." is displayed
    And owner will see that the text "Lap jendela dan kaca agar terlihat bersih." is displayed
    And owner will see that the text "Tempatkan peralatan kamar mandi dengan rapi agar terlihat menarik." is displayed
    And owner will see that the text "Pastikan kamar mandi dalam kondisi kering saat fotografer datang." is displayed
     #point detail
    And owner will see that the text "Apabila kamar kos memiliki fasilitas unggulan yang perlu ditonjolkan, maka persiapkan dengan baik dan posisikan di tempat yang diinginkan owner." is displayed
    And owner will see that the text "Infokan detail ini kepada tim fotografer." is displayed

      #check at tab Panduan area dan fasilitas
    When owner click tab panduan area
      #Tampak Depan Kost
    And owner will see that the text "Tampak Depan Kos" is displayed
    And owner will see that the text "Pastikan tidak ada sampah atau barang lainnya yang tidak diinginkan di depan kos supaya terlihat rapi dan menarik." is displayed
    And owner will see that the text "Rapikan area tampak depan sebaik mungkin." is displayed
          #Lorong dan Taman
    And owner will see that the text "Lorong dan Taman" is displayed
    And owner will see that the text "Rapikan lorong kos, seperti letak tong sampah, tas laundry, sepatu anak kos, dsb." is displayed
    And owner will see that the text "Rapikan area taman." is displayed
    And owner will see that the text "Pastikan tidak ada sampah, dan barang-barang lainnya yang menumpuk dan tidak diinginkan." is displayed
      #Detail
    And owner will see that the text "Detail" is displayed
    And owner will see that the text "Bersihkan dan rapikan dapur umum." is displayed
    And owner will see that the text "Rapikan parkiran kos sebaik mungkin." is displayed
    And owner will see that the text "Rapikan ruang tunggu." is displayed
    And owner will see that the text "Rapikan dan bersihkan ruang laundry." is displayed
    And owner will see that the text "Rapikan dan bersihkan area lainnya." is displayed
    And owner will see that the text "Lap kaca/jendela agar terlihat bersih." is displayed
    And owner will see that the text " Pastikan tidak ada sampah dan barang-barang lainnya yang menumpuk dan tidak diinginkan." is displayed