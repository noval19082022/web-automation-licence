@LIMO2 @GpspNewOwner
Feature: GPSP Exposure on OD


#  081597877123/qwerty123
  @TEST_LIMO-9299
  Scenario: [Owner][GPSP][OD] Display correct GP card variant for each segment
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod | password  |
      | 081597877123 | 0          | qwerty123 |
    Then owner will see that the text "Khusus Pengguna Baru" is displayed
#
#    Given an owner is in segment "<segment>"
#    And the owner's first listing was verified
#    And the owner has received <chat_count> chats in the last 30 days
#    And the owner has "<gp_status>" GP status
#    When the owner accesses the Owner Dashboard
#    Then the GP entry point should display:
#      | Component      | Expected Value   |
#      | Card Type      | <card_type>      |
#      | Ribbon Text    | <ribbon_text>    |
#      | Ribbon Visible | <ribbon_visible> |
#      | Price Display  | <price>          |
#      | Crossed Price  | <crossed_price>  |
#      | Discount Badge | <discount>       |
#      | Countdown      | <countdown>      |
#      | CTA Text       | <cta_text>       |
#      | Click Target   | <click_target>   |
#    Examples:
#      | segment               | days_ago | chat_count | gp_status | card_type  | ribbon_text              | ribbon_visible | price    | crossed_price | discount | countdown    | cta_text        | click_target |
#      | gpsp_new_owner_low    | 5        | 10         | never     | New User   | Khusus Pengguna Baru     | Yes            | Rp 79rb  | Rp 149rb      | 47%      | 25 hari lagi | Daftar          | onboarding   |
#      | gpsp_new_owner_medium | 29       | 0          | never     | New User   | Khusus Pengguna Baru     | Yes            | Rp 79rb  | Rp 149rb      | 47%      | 1 hari lagi  | Daftar          | onboarding   |
#      | gpsp_new_owner_high   | 0.5      | 50         | never     | New User   | Khusus Pengguna Baru     | Yes            | Rp 79rb  | Rp 149rb      | 47%      | 29 hari lagi | Daftar          | onboarding   |
#      | low1                  | 60       | 20         | never     | Loyal User | Buat Anda Pengguna Setia | Yes            | Rp 79rb  | Rp 149rb      | 47%      | Not shown    | Daftar          | onboarding   |
#      | medium2               | 90       | 5          | ever      | Loyal User | Buat Anda Pengguna Setia | Yes            | Rp 79rb  | Rp 149rb      | 47%      | Not shown    | Daftar          | pilih_paket  |
#      | low5                  | 100      | 30         | never     | Standard   | None                     | No             | Standard | Standard      | Standard | Not shown    | Daftar GoldPlus | onboarding   |
#      | medium4               | 45       | 15         | ever      | Standard   | None                     | No             | Standard | Standard      | Standard | Not shown    | Daftar GoldPlus | pilih_paket  |