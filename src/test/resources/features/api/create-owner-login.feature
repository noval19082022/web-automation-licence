Feature: Create Owner Login Authentication

  @cobacreateauthowner
  Scenario: Owner Login Authentication
    Given playwright create owner login auth:
      | phone stag | password |
      | 08900000000021 | c087feaa0a18a108d0d3997cf86c886e |