@singgahsini @regression @pman @pman-prod

  Feature: Verify Each Section Content

    @TEST_SS-629
    Scenario: Verify Content of Introduction Sections
      Given user navigates to singgahsini.id
      When user click header menu "Tentang Kami"
      Then page auto scroll to section "Tentang Kami"
      And tentang kami section title is "Solusi Profesional Tepercaya"
      And tentang kami section subtitle is "Singgahsini & APIK telah dipercayakan untuk mengelola lebih dari 20.000 kamar kos di Jabodetabek, Jawa, dan Bali, menjadikan kami manajemen kos profesional terbesar di Indonesia."

    @TEST_SS-770
    Scenario: Verify Content of Benefits Sections
      Given user navigates to singgahsini.id
      When user click header menu "Keuntungan"
      Then page auto scroll to section "Keuntungan"
      And keuntungan section title is "Keuntungan Bergabung dengan Singgahsini & APIK"
      And keuntungan section contains 3 items
        | Title                   | Subtitle                                                                                          |
        | Daya Saing Maksimal     | Rekomendasi harga kompetitif hasil analisis data dengan Property Analysis Machine.                |
        | Pendapatan Lebih Tinggi | Optimalkan potensi pendapatan kos melalui program sewa harian dengan Online Travel Agent (OTA).   |
        | Pemangkasan Operasional | Manajemen kos profesional termasuk pengelolaan, pengecekan, dan perbaikan kos yang lebih efisien. |

    @TEST_SS-632
    Scenario: Verify Content of Owner Testimonial
      Given user navigates to singgahsini.id
      When user scroll to section "Testimonial"
      Then testimonial section title is "Kata Pemilik Kos"
      And testimonial section contains 3 testimoni
        | testimoni                                                                                                                                                                                                                                                                                                                     | owner name        | kost name                                                                     |
        | “Bagi saya, kini tingkat okupansi kost sudah mencapai 80% - 90%. Singgahsini sangat akomodatif dan responsif terhadap perbaikan perbaikan yang saya usulkan sehingga penghuni kost juga merasa puas. Dalam hak pembayaran pun selalu berjalan dengan lancar dan tepat waktu dan laporannya pun lengkap dan dapat dipercaya”.  | Endy Dwi Tjahjono | Pemilik Kost Singgahsini Wisma Seruni Wonocolo Surabaya                       |
        | “Urusan melatih staff operator, membuat peraturan kos, melakukan pemasaran, menangani komplain dan kerusakan, menagih sewa kamar bulanan, hingga pengawasan rutin kos Singgahsini Infinite Residence seluruhnya ditangani secara professional oleh Singgahsini”.                                                              | Tje Lie Ellie     | Pemilik Kost Singgahsini Infinite Residence Mampang Prapatan Jakarta Selatan  |
        | “Saya memilih kerja sama dengan Mamikos karena saya sering mendengar mamikos dari internet dan saya merasa branding nya bagus. Saya merasa cukup puas setelah bergabung dengan singgah sini, karena saya tidak perlu repot untuk menghandle kost saya”.                                                                       | Erni              | Pemilik Kost Singgahsini Wisma KS23 Setiabudi Jakarta Selatan                 |

    @TEST_SS-761
    Scenario: Verify Content of FAQ
      Given user navigates to singgahsini.id
      When user click header menu "Tanya Jawab"
      Then page auto scroll to section "Tanya Jawab"
      And tanya jawab section title is "Tanya Jawab Seputar Singgahsini dan APIK"
      And tanya jawab section contains 4 question
        | Apa bedanya Singgahsini dengan APIK?                            |
        | Di kota mana saja Singgahsini dan APIK tersedia?                |
        | Bagaimana proses untuk bergabung dengan Singgahsini atau APIK?  |
        | Bagaimana model kerja samanya?                                  |
      And "first" FAQ answer are
        | Singgahsini dan APIK adalah dua brand kos yang berbeda dari Manajemen Kos Singgahsini & APIK. Kedua brand ini telah didesain untuk memenuhi kebutuhan pasar yang beragam, termasuk perbedaan dalam hal harga, fasilitas yang tersedia, dan lainnya. Meskipun demikian, baik Singgahsini maupun APIK tetap mendapatkan layanan manajemen kos yang menguntungkan bagi pemilik.  |
        | Tim kami akan memilih brand yang paling cocok untuk Anda, sesuai dengan hasil evaluasi, rekomendasi, serta kebutuhan bisnis kos Anda saat ini.                                                                                                                                                                                                                                |
      And "second" FAQ answer are
        | Saat ini Singgahsini & APIK tersedia di beberapa kota yaitu: DKI Jakarta, Tangerang, DIY dan Bandung.                                                                                                                                         |
        | Apabila Anda tertarik namun berada di luar kota tersebut, Anda tetap dapat mengisi form pendaftaran. Permintaan yang tinggi di suatu kota akan menjadi bahan pertimbangan kami untuk membuka layanan Singgahsini & APIK di kota-kota lainnya. |
      And "third" FAQ answer are
        | Isi form pendaftaran Singgahsini dan APIK                                                             |
        | Tim kami akan menghubungi Anda untuk survei maksimal 3x24 jam (hari kerja) setelah Anda mengisi form  |
        | Kami akan memberikan penawaran yang disesuaikan dengan properti kos                                   |
        | Setelah kontrak kerja sama telah disetujui, Anda resmi bergabung dengan Singgahsini atau APIK         |
      And "fourth" FAQ answer are
        | Jika Anda bergabung di Singgahsini atau pun APIK, ada beberapa model kerja sama yang dapat dilakukan tergantung dari hasil evaluasi properti kos Anda, yaitu: model Bagi Hasil, Minimal Jaminan Pendapatan, atau Jaminan Pendapatan Penuh.  |