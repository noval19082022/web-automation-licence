Feature: Kost List and Map

  @TEST_DOM-1842 @Automated @DOM4 @Web @discovery-platform @filter @kos-card-top-fac @listing-kos @localhost
  Scenario: [Dweb][Listing Kos][Kost Listing]Check top facilities in kos card
    Given user go to mamikos homepage
    When user want to search kost on "Pogung lor" from homepage
    Then user sees the facilities on kos card are "K. Mandi Dalam" or "WiFi" or "Akses 24 Jam"

#  @TEST_DOM-1835 @Automated @DOM4 @Web @desc-map-cluster @discovery-platform @filter @listing-kos @map-cluster
#	Scenario: [Dweb][Listing Kos][Map]Check description or legend of map cluster
#		Given user navigates to "mamikos /"
#		And user maximize the screen size
#		When user clicks search bar
#		And user search for keyword "UGM"
#		Then user check the legend of map price cluster
#		  | 33        |
#		  | Rp750rb   |
#		  | Rp1,85jt  |
#		  | Rp2,455jt |
#		And user check the legend of map description cluster
#		  | Lebih dari 1 kos: |
#		  | Kos Campur:       |
#		  | Kos Putra:        |
#		  | Kos Putri:        |
#		And user check the legend of map information cluster
#		  | Angka menunjukkan jumlah kos yang ada di titik tersebut.   |
#		  | Harga berwarna ungu menandakan sebuah kos campur.          |
#		  | Harga berwarna biru menandakan sebuah kos putra.           |
#		  | Harga berwarna merah muda menandakan ada sebuah kos putri. |
#		When user close the legend map
#		Then user see the pop up closed