@SS12
Feature: Breadcrumb Kost Detail

  @SS12 @DOM-5273 @TEST_SS-3150
  Scenario Outline:[Kost Detail] Checking Breadcrumb on Kost Detail
    Given user visit page <path url>
    Then user verify content of breadcrumb is <breadcrumb path bakpia4>
    Examples:
      | breadcrumb path bakpia4                                                                            | path url                                                                                                                                                   |
      | "Home > Kuncara Kos8"                                                                              | "/room/kost-yogyakarta-kost-putra-eksklusif-kuncara-kos8?redirection_source=list%20kos%20result"                                                           |
      | "Home > Kost Semarang > Kost Putra Dorgiocavall Bulusan Semarang"                                  | "/room/kost-semarang-kost-putra-eksklusif-kost-putra-dorgiocavall-bulusan-semarang?redirection_source=list%20kos%20result"                                 |
      | "Home > Kost Wisma Putri Ardovina Perum Korpri Bulusan Tembalang Semarang"                         | "/room/kost-kost-putri-murah-kost-wisma-putri-ardovina-perum-korpri-bulusan-tembalang-semarang-1?redirection_source=list%20kos%20result"                   |
      | "Home > Kost Semarang > Kost Banyumanik Semarang > Kost Putri Gladys 2 Tipe C Banyumanik Semarang" | "/room/kost-semarang-kost-putri-eksklusif-kost-putri-gladys-2-tipe-c-banyumanik-semarang-1?redirection_source=list%20kos%20result"                         |
      | "Home > Kost Semarang > Kost Tembalang Semarang > Kost Griya Dervi Tembalang Semarang"             | "/room/kost-semarang-kost-putri-eksklusif-kost-griya-dervi-tembalang-semarang--1?redirection_source=list%20kos%20result"                                   |
      | "Home > Kost Jogja > Kost Jetis Yogyakarta > Kos Kosan Bagus Banget Yogyakarta"                    | "/room/kost-yogyakarta-kost-putri-eksklusif-kos-kosan-bagus-banget-1?redirection_source=list%20kos%20result"                                               |
      | "Home > Kost Jogja > Kost Gondokusuman Yogyakarta > Kos Emas Dua"                                  | "/room/kost-yogyakarta-kost-putri-eksklusif-kos-emas-dua-1?redirection_source=list%20kos%20result"                                                         |
      | "Home > Kost Ternate Maluku Utara >  > Kost Singgahsini Lavender Anggrek Tipe A Halmahera Utara"   | "/room/kost-kabupaten-halmahera-utara-kost-campur-murah-kost-singgahsini-lavender-anggrek-tipe-a-halmahera-utara-1?redirection_source=list%20kos%20result" |