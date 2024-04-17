@regression @LIMO4 @contentMamiprime

  Feature: check content mamiprime at landing page

    @FAQMamiprimecontent
    Scenario: Check content FAQ at mamiprime
      Given user go to mamikos homepage
      * user login as owner:
        | phone stag | phone prod  | password   |
        | 0890910001 | 0890910001  | qwerty123  |
      * owner accsess mamiprime landing page
      * owner can see FAQ section
      When user click question "Apa itu layanan MamiPrime?"
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