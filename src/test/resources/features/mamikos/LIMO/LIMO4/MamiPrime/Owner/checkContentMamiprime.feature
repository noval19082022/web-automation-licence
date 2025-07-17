@regression @LIMO @contentMamiprime
Feature: Check Content Mamiprime At Landing Page

  @TEST_LIMO-3535 @continue @WEB @AUTOMATED
  Scenario: Check content at mamiprime landing page
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0890910001 | 0890910001 | qwerty123 |
    And owner access mamiprime landing page
    Then user will see text "Buat Kos Makin Populer dengan MamiPrime" on landing page mamiprime
    And user will see text "Layanan yang memaksimalkan jangkauan iklan kos di MAmikos agar bisnis Anda makin optimal." on landing page mamiprime
    #benefit section
    And user will see text "Manfaat MamiPrime" on landing page mamiprime
    And user will see image on benefit section
    And user will see text "Tampil Menonjol di Tempat Pilihan" on landing page mamiprime
    And user will see text "Dapat Badge Khusus" on landing page mamiprime
    And user will see text "Iklan kos Anda makin mencolok dengan ditambahkan badge ketika tayang." on landing page mamiprime
    And user will see text "Atur Penayangan Kos" on landing page mamiprime
    And user will see text "Tentukan periode dan tempat tayang yang sesuai dengan kebutuhan Anda." on landing page mamiprime
    #product section
    And user will see text "Beragam Tempat Penayangan Iklan" on landing page mamiprime
    And user will see image on product description section
    And user will see text "Kata Kunci" on landing page mamiprime
    And user will see text "Kos Anda tampil di bagian teratas pada hasil pencarian dengan kata kunci terkait daerah kos tersebut. Pendaftaran terbatas!" on landing page mamiprime
    #testimoni section
    And user will see text "Kata Pemakai MamiPrime" on landing page mamiprime
    And user will see text "Totok Untung Tugasto" on landing page mamiprime
    And user will see text "Kost Wisma Torina Cikarang Pusat" on landing page mamiprime
    And user will see text "“1 Bulan Pakai Mamikos Prime, 30 Kamar Langsung Terisi!”" on landing page mamiprime
    And user will see text "Kevin Antonio Ketaren" on landing page mamiprime
    And user will see text "Kost Daloka Tipe A Kukusan Beji" on landing page mamiprime
    And user will see text "“Sering Tampil di Daftar Pencarian, Jadi Lebih Banyak yang Menghubungi & Survey”" on landing page mamiprime
    #contact section
    And user will see text "Ingin tahu lebih jauh?" on landing page mamiprime
    And user will see text "Silakan hubungi kami via WhatsApp." on landing page mamiprime
    And user will see CS Button on contact section

  @TEST_LIMO-3534 @FAQMamiprimecontent @WEB @AUTOMATED
  Scenario: Check content FAQ at mamiprime
    When owner can see FAQ section
    And user click question "Apa itu layanan MamiPrime?"
    Then user verify answer text "MamiPrime adalah layanan di mana Anda dapat menayangkan iklan kos tempat-tempat strategis dalam platform Mamikos, contohnya di paling atas pada hasil pencarian dengan kata kunci daerah Anda. Iklan kos Anda menjadi semakin mudah ditemukan dan dilihat oleh banyak orang."
    When user click question "Apakah harga dan promo MamiPrime yang ditawarkan berlaku selamanya?"
    Then user verify answer text "Tidak. Harga dan promo bisa berubah kapanpun tanpa pemberitahuan. Oleh sebab itu, Anda sangat dianjurkan untuk segera bertransaksi sebelum terjadi kenaikan harga maupun perubahan promo."
    When user click question "Apakah saya bisa memilih tempat di mana kos MamiPrime saya akan tayang?"
    Then user verify answer text "Untuk saat ini, tempat yang tersedia di layanan MamiPrime adalah pada kata kunci. Namun, tempat-tempat penayangan lainnya akan hadir sebentar lagi. Ditunggu, ya!"
    When user click question "Berapa lama masa berlangganan Paket Mamikos Prime?"
    Then user verify answer text "Ada beberapa opsi periode berlangganan MamiPrime, yakni 7 hari, 14 hari, 30 hari, dan 60 hari."
    When user click question "Bagaimana cara agar penayangan iklan saya membawa hasil yang maksimal?"
    Then user verify answer text "Dengan memakai MamiPrime, kos Anda akan lebih mudah ditemukan oleh calon penyewa. Nah, untuk memaksimalkan daya tarik kos Anda, Anda juga bisa menggunakan layanan MamiFoto untuk foto dan video kos yang profesional, dan MamiTour untuk membuat tur kos virtual."
    When user click question "Bagaimana cara membeli MamiPrime?"
    Then user verify answer text "Klik Beli Paket di halaman ini. Lalu Anda dapat memilih iklan kos yang ingin ditayangkan memakai MamiPrime dan lama penayangannya. Setelah itu, Anda tinggal menyelesaikan pembayaran. Lihat detailnya di sini."
    When user click question "Apakah pembelian MamiPrime berlaku untuk semua properti saya?"
    Then user verify answer text "Pembelian satu MamiPrime hanya berlaku untuk satu iklan kos saja. Selain itu, MamiPrime saat ini hanya dapat digunakan untuk properti berupa kos saja sedangkan untuk apartemen belum berlaku."
    When user click question "Apakah paket MamiPrime jumlahnya tidak terbatas?"
    Then user verify answer text "Tidak. Jumlah paket MamiPrime terbatas di setiap kata kuncinya untuk menjaga nilai eksklusif dari manfaat MamiPrime. Oleh sebab itu, Anda sangat dianjurkan segera memesan MamiPrime untuk kos Anda sebelum didahului oleh pemilik kos lain di daerah yang sama."
    When user click question "Apa yang terjadi jika kos saya sudah penuh sebelum masa aktif MamiPrime berakhir?"
    Then user verify answer text "Keuntungan dari MamiPrime tidak akan berlaku lagi jika kos Anda sudah penuh sebelum masa aktif berakhir. Lihat info selengkapnya di sini."