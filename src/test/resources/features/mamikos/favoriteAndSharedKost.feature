Feature: Favorite and Share kost

  @automated @discovery-platform @favorite @web
  Scenario: [Dweb][Favorite] Tenant - Check Redirection without login
    Given tenant navigate to favorite page
    Then user see login pop up in favorite page