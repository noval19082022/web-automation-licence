@regression @kostReviewTenantNotSubmitted @BBM8

Feature: Kost Review Not Submitted Display

  @TEST_COOP-2917 @continue
  Scenario: Kost Review Tenant
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321203 | 0890867321203 | mamikosqa123 |
    And tenant navigate to riwayat kos page

  @TEST_COOP-2924 @continue
  Scenario: Riwayat Kos - The review menu page
    Then there will be a review menu with the title "Bagaimana pengalaman ngekosmu?"

  @TEST_COOP-2917 @continue
  Scenario: Riwayat Kos - The review menu redirection to review page
    When user click review kost
    Then user will see review page and user click close on review page

  @TEST_COOP-2555 @continue
  Scenario: Kos Saya - The review menu page
    When tenant navigate to kost saya page
    Then there will be a kost saya with the title "Bagaimana pengalaman ngekosmu? Menyenangkan atau ada yang perlu ditingkatkan? Yuk, tulis review kamu."

  @TEST_COOP-2921 @TEST_COOP-2906 @continue
  Scenario: Kos Saya - The review menu redirection to review page
    When tenant navigate to riwayat kos page
    And user click review kost
    Then user will see review form

  @TEST_COOP-2918 @continue
  Scenario: Kos Saya (Ajukan Berhenti Sewa) - The review menu page
    When tenant navigate to kontrak kost saya
    And user click ajukan berhenti sewa on kontrak saya page
    Then there will be a ajukan sewa with the title "Bagaimana pengalaman ngekosmu? Menyenangkan atau ada yang perlu ditingkatkan? Yuk, tulis review kamu."

  @TEST_COOP-2917 @continue
  Scenario: Kos Saya (Ajukan Berhenti Sewa) - The review menu redirection to review page
    When user click title ajukan sewa
    Then user will see review form

  @TEST_COOP-2544 @continue
  Scenario: Review Page
    Then user see at review page contains:
      | Review Page        |
      | Kebersihan*        |
      | Keamanan*          |
      | Kenyamanan*        |
      | Fasilitas Kamar*   |
      | Fasilitas Umum*    |
      | Kesesuaian Harga*  |

  @TEST_COOP-2922 @continue
  Scenario: Kos Saya (Ajukan Berhenti Sewa) - Ajukan Berhenti Sewa button is disabled if the tenant hasn't submitted a review yet
    Then user see ajukan berhenti sewa button is disabled