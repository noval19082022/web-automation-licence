@DOM4 @essentialTest
Feature: Kost List and Map

  @TEST_SS-3209 @Automated @DOM4 @Web @discovery-platform @filter @kos-card-top-fac @listing-kos
  Scenario: [Dweb][Listing Kos][Kost Listing]Check top facilities in kos card
    Given user go to mamikos homepage
    When user want to search kost list by place on "Pogung lor" from homepage
    Then user sees the facilities on kos card are "K. Mandi Dalam" or "WiFi" or "Akses 24 Jam"

  @TEST_SS-3223 @Automated @DOM4 @Web @desc-map-cluster @discovery-platform @filter @listing-kos @map-cluster
  Scenario: [Dweb][Listing Kos][Map]Check description or legend of map cluster
    Given user go to mamikos homepage
    When user want to search kost list by place on "UGM" from homepage
    Then user can check the legend of map price cluster
      | 33        |
      | Rp750rb   |
      | Rp1,85jt  |
      | Rp2,455jt |
    * user can check the legend of map description cluster
      | Lebih dari 1 kos: |
      | Kos Campur:       |
      | Kos Putra:        |
      | Kos Putri:        |
    * user can check the legend of map information cluster
      | Angka menunjukkan jumlah kos yang ada di titik tersebut.   |
      | Harga berwarna ungu menandakan sebuah kos campur.          |
      | Harga berwarna biru menandakan sebuah kos putra.           |
      | Harga berwarna merah muda menandakan ada sebuah kos putri. |
    #user close the legendmap
    When user want to close the legend map
    Then user will see the pop up closed

  @TEST_SS-3210
  Scenario Outline: [Main Search][Search Popular Area] Check result of search on popular area
    Given user go to mamikos homepage
    And user type for keyword "<city>"
    Then user validate the suggestion result contains "<city>"
    Examples:
      | city            |
      | Jakarta         |
      | Jakarta Selatan |
      | Surabaya        |
      | Jakarta Pusat   |
      | Bandung         |
      | Yogyakarta      |
      | Tebet           |
      | UGM             |
      | Malang          |
      | Bali            |
      | Semarang        |

