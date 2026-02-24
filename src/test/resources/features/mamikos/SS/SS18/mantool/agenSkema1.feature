@regression @essentialTest2 @SS16 @mantool

Feature: Agen Skema 1

  @TEST_SS-583 @continue
  Scenario: Login using Agen Skema 1
    Given admin navigate to mantool
    When admin login agen mantool
      | No Handphone stag | password  |
      | 083214140880      | qwerty123 |
    Then should redirect to onboarding page
    And agen name is "Akun Skema Satu"
      #check profile
    When admin click profile picture
    Then should contains menu
      | Onboarding |
      | Keluar     |

  @TEST_SS-591
  Scenario: Breadcrumb agen Skema 1
    Then onboarding page breadcrumb title is "Onboarding Agen Akuisisi"
    When admin click in breadcrumb "Mitra Agen"
    Then admin should redirect to mantool
    When admin go to onboarding page
    When admin click in breadcrumb "Mamikos"
    Then admin should redirect to mamikos

  @TEST_SS-605 @continue
  Scenario: Onboarding Section Skema 1
    Given admin navigate to mantool
    When admin login agen mantool
      | No Handphone stag | password  |
      | 083214140880      | qwerty123 |
    Then should redirect to onboarding page
    Then onboarding title is "Selamat Akun Skema Satu"
    And onboarding description are
      | Anda telah bergabung sebagai Agen Akuisisi Mamikos. Silakan ikuti beberapa langkah berikut ini untuk mulai. |
      | Silakan tunjukkan  Surat Keterangan  ini ketika mengunjungi pemilik kos.                                    |
      | Semoga sukses!                                                                                              |

  @TEST_SS-587 @continue
  Scenario: View Surat Keterangan
    When agen open surat keterangan
    Then surat keterangan pdf open in new tab
    And admin close unused browser tab

  @TEST_SS-575 @continue
  Scenario: Agen Steps Skema 1
    Then progress title is "Langkah Awal Agen Akuisisi"
      #Verify step 1
    Then step 1 title is "Download Aplikasi Mamidata"
    And step 1 description are
      | Aplikasi khusus untuk mitra agen akuisisi Mamikos, dengan keamanan terjamin. |
      | Data Login Anda:                                                             |
      | Username: 083214140880                                                       |
      | PIN: 140880                                                                  |
    And step 1 have button "Download App"
    When agen click button "Download App"
    Then agen should redirect to "https://drive.google.com/file/d/12WEcsoDfNOLkWwuJAvXFC5ksKMyHqLzd/view" in new tab
    And admin close unused browser tab
      #Verify step 2
    Then step 2 title is "Download Aplikasi Geotag"
    And step 2 description are
      | Aplikasi untuk mendapatkan koordinat titik latitude / longitude lokasi kos.            |
      | Masukkan koordinat titik dari aplikasi ini saat mendaftarkan kos di aplikasi Mamidata. |
    And step 2 have button "Download Geotag"
    When agen click button "Download Geotag"
    Then agen should redirect to "https://play.google.com/store/apps/details?id=com.gpsmapcamera.geotagginglocationonphoto" in new tab
    And admin close unused browser tab
      #Verify step 3
    Then step 3 title is "Download Buku Panduan"
    And step 3 description are
      | Buku panduan untuk mitra agen Mamikos.                                        |
      | Pelajari info lebih lanjut tentang alur kerja, pemberian komisi, dan lainnya. |
    And step 3 have button "Download PDF"
    When agen click button "Download PDF"
    Then agen should redirect to "https://drive.google.com/file/d/17IvDIcgTIrEoVwAzhmccGAmSpTqRI-1m/view" in new tab
    And admin close unused browser tab
      #Verify step 4
    Then step 4 title is "Gabung ke Chat Group"
    And step 4 description are
      | Group di aplikasi chat untuk semua agen akuisisi Mamikos                       |
      | Dapatkan info terbaru dari admin, pencapaian target, dan ikuti rapat mingguan. |
    And step 4 have button "Link Chat Group"
    When agen click button "Link Chat Group"
    Then agen should redirect to "https://chat.whatsapp.com/CztWIMT7Vhr8Mrr3vCt4ME" in new tab
    And admin close unused browser tab
      #Verify step 5
    Then step 5 title is "Kunjungi Website Agen Akuisisi"
    And step 5 description are
      | Situs yang dibuat untuk agen Mamikos yang telah aktif.                                                                                 |
      | Dapatkan informasi, lihat video panduan kerja, unduh materi promosi, info reward,  voucher yang bisa ditawarkan ke calon pemilik, dll. |
    And step 5 have button "Website Agen Akuisisi"
    When agen click button "Website Agen Akuisisi"
    Then agen should redirect to "https://sites.google.com/mamiteam.com/onboardingagenakuisisi/home" in new tab
    And admin close unused browser tab

  @TEST_SS-573 @continue
  Scenario: Progress agen skema 1
      #step 1
    When admin tick step 1
    Then steps show progress "1 / 5"
    And admin can't untick step 1
      #step 2
    When admin tick step 2
    Then steps show progress "2 / 5"
    And admin can't untick step 2
      #step 3
    When admin tick step 3
    Then steps show progress "3 / 5"
    And admin can't untick step 3
      #step 4
    When admin tick step 4
    Then steps show progress "4 / 5"
    And admin can't untick step 4
      #step 5
    When admin tick step 5
    Then steps show progress "5 / 5"
    And admin can't untick step 5
      #refresh
    When admin refresh page 0
    Then steps show progress "0 / 5"

  @TEST_SS-582
  Scenario: Reset step progress onboarding after relogin
    When admin tick step 1
    And admin tick step 2
    And admin tick step 4
    Then steps show progress "3 / 5"
    When admin logout mantool
    And admin login agen mantool
      | No Handphone stag | password  |
      | 083214140880      | qwerty123 |
    Then steps show progress "0 / 5"