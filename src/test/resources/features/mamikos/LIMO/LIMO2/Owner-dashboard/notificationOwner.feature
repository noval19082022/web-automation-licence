@regression @bellnotification @LIMO2 @DONEMIGRATINGTONEWBOARD

Feature: See all notification from owner
	#Scenario: Bell Notification - See all notification clicked
  @TEST_LIMO-3600 @Automated @Web @listing-monetization @notifikasi-owner
  Scenario: [Owner Dashboard][Notification] See all notification from owner
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod | password  |
      | 086412300123 | 0          | qwerty123 |
    When owner open notification icon
    And owner wants to see all notification
    Then user redirected to "ownerpage/notification"
