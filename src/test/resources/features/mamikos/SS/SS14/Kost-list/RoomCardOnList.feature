@SS12
Feature: Room card on Kost List

  @continue @TEST_SS-3207
  Scenario: pre-condition dismiss probut pop up on list
    Given user visit page "/cari/halte-harmoni-central/all/bulanan/0-15000000"
    Then user dismiss probut pop up on kost list

  @continue @TEST_SS-3208
  Scenario Outline: Checking element on room card /cari /kost
    Given user visit page "<url>"
    When user want to see more kost list
    Then user verify all room card element is not null
    Examples:
      | url                                           |
      | /cari/unpad-jatinangor/all/bulanan/0-15000000 |
      | /cari/stan-jakarta/all/bulanan/0-15000000     |
      | /cari/unair/all/bulanan/0-15000000            |
      | /cari/ub/all/bulanan/0-15000000               |
      | /cari/ui/all/bulanan/0-15000000               |
      | /cari/itb/all/bulanan/0-15000000              |
      | /cari/undip/all/bulanan/0-15000000            |
      | /cari/ugm/all/bulanan/0-15000000              |
      | /cari/uny/all/bulanan/0-15000000              |
      | /cari/umy/all/bulanan/0-15000000              |
      | /cari/yogyakarta/all/bulanan/0-15000000       |
      | /cari/jakarta/all/bulanan/0-15000000          |
      | /cari/jakarta-selatan/all/bulanan/0-15000000  |
      | /cari/semarang/all/bulanan/0-15000000         |
      | /cari/bandung/all/bulanan/0-15000000          |
      | /kost/kost-dekat-ugm-murah                    |
      | /kost/kost-dekat-ui-depok-murah               |
      | /kost/kost-dekat-stan-jakarta-murah           |
      | /kost/kost-dekat-ub-malang-murah              |
      | /kost/kost-dekat-unair-surabaya-murah         |
#      | /kost/kost-jogja-murah                        |
      | /kost/kost-jakarta-murah                      |
      | /kost/kost-bandung-murah                      |
      | /kost/kost-surabaya-murah                     |
      | /kost/kost-malang-murah                       |
      | /kost/kost-medan-murah                        |