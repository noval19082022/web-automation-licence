@LIMO7 @regression

@TEST_SS-3776 @TEST_SS-3777 @TEST_SS-3825 @TEST_SS-3832 @TEST_SS-3833 @TEST_SS-3836 @TEST_SS-3840 @TEST_SS-3841
@TEST_SS-3856 @TEST_SS-3857 @TEST_SS-3814 @TEST_SS-3817 @TEST_SS-3640 @TEST_SS-3848 @TEST_SS-3849 @TEST_SS-3860
@TEST_SS-3861
Feature: Apply Voucher For Tenant Profession, Domain, and Email Rule

  @continue
  Scenario: Tenant Edit Profession To Mahasiswa
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321217 | 0890867321217 | mamikosqa123 |
    And tenant navigates to edit profile
    And user choose profession "Mahasiswa"
    And user fills "Universitas Lampung" in search dropdown pillih universitas
    And user click simpan button
    Then tenant success update profile

  @continue
  Scenario: Invoice Mahasiswa and Voucher Applicable for Mahasiswa
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VAFORMAHASISWA    | VAFORMAHASISWA    |
    Then tenant can see voucher is applied

  @continue
  Scenario: Invoice Mahasiswa and Voucher Not Applicable for Mahasiswa
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VNAFORMAHASISWA   | VNAFORMAHASISWA   |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."

  @continue
  Scenario: Invoice Mahasiswa and Voucher Applicable for Karyawan
    When tenant set active page to 1
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | VAFORKARYAWAN     | VAFORKARYAWAN     |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."

  @continue
  Scenario: Scenario: Invoice Mahasiswa and Voucher Not Applicable for Karyawan
    When tenant set active page to 1
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | VNAFORKARYAWAN    | VNAFORKARYAWAN    |
    Then tenant can see voucher is applied

  @continue
  Scenario: Invoice Mahasiswa and Voucher Applicable for Tenant University
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VAFORUNIV         | VAFORUNIV         |
    Then tenant can see voucher is applied

  @continue
  Scenario: Invoice Mahasiswa and Voucher Not Applicable for Tenant University
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VNAFORUNIV        | VNAFORUNIV        |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."

  @continue
  Scenario: Invoice Mahasiswa and Voucher Applicable for Other Tenant University
    When tenant set active page to 1
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | VAFOROTHERUNIV    | VAFOROTHERUNIV    |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."

  @continue
  Scenario: Invoice Mahasiswa and Voucher Not Applicable for Other Tenant University
    When tenant set active page to 1
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | VNAFOROTHERUNIV   | VNAFOROTHERUNIV   |
    Then tenant can see voucher is applied

  @continue
  Scenario: Tenant Edit Profession To Karyawan
    When tenant set active page to 1
    And tenant navigates to edit profile
    And user choose profession "Karyawan"
    And user click dropdown pilih instansi "Bukit Asam Tbk"
    And user click simpan button
    Then tenant success update profile

  @continue
  Scenario: Invoice Karyawan and Voucher Applicable for Karyawan
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VAFORKARYAWAN     | VAFORKARYAWAN     |
    Then tenant can see voucher is applied

  @continue
  Scenario: Invoice Karyawan and Voucher Not Applicable for Karyawan
    When tenant set active page to 2
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VNAFORKARYAWAN    | VNAFORKARYAWAN    |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."

  @continue
  Scenario: Invoice Karyawan and Voucher Applicable for Mahasiswa
    When tenant set active page to 2
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | VAFORMAHASISWA    | VAFORMAHASISWA    |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."

  @continue
  Scenario: Invoice Karyawan and Voucher Not Applicable for Mahasiswa
    When tenant set active page to 2
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | VNAFORMAHASISWA   | VNAFORMAHASISWA   |
    Then tenant can see voucher is applied

  @continue
  Scenario: Invoice Karyawan and Voucher Applicable for Tenant Company
    When tenant set active page to 2
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VAFORCOMP         | VAFORCOMP         |
    Then tenant can see voucher is applied

  @continue
  Scenario: Invoice Karyawan and Voucher Not Applicable for Tenant Company
    When tenant set active page to 2
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VNAFORCOMP        | VNAFORCOMP        |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."

  @continue
  Scenario: Invoice Karyawan and Voucher Applicable for Other Tenant Company
    When tenant set active page to 2
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | VAFOROTHERCOMP    | VAFOROTHERCOMPA   |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."

  @continue
  Scenario: Invoice Karyawan and Voucher Not Applicable for Other Tenant Company
    When tenant set active page to 2
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | VNAFOROTHERCOMP   | VNAFOROTHERCOMP   |
    Then tenant can see voucher is applied

  @continue
  Scenario: Tenant Apply Voucher Not Applicable for Other Tenant Email Domain
    When tenant set active page to 2
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VNAFOROTHERDOM    | VNAFOROTHERDOM    |
    Then tenant can see voucher is applied

  @continue
  Scenario: Tenant Apply Voucher Not Applicable for Tenant Email
    When tenant set active page to 2
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VNAFORUSREMAIL    | VNAFORUSREMAIL    |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."

  Scenario: Tenant Apply Voucher Not Applicable for Other Tenant Email
    When tenant set active page to 2
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | VNAFOROTHEREM     | VNAFOROTHEREM     |
    Then tenant can see voucher is applied