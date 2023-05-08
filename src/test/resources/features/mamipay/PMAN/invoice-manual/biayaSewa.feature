@regression @pman @mamipay @invoice-manual @biaya-sewa

  Feature: Invoice Manual - Biaya Sewa

    @TEST_PMAN-5626 @pman-prod
    Scenario Outline: Add Biaya Sewa in Invoice Manual
      Given admin go to mamikos mamipay admin
      When admin login to mamipay:
        | email stag                   | email prod                   | password  |
        | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
      And the admin creates Invoice Manual "Biaya Sewa" and input all fields "<Nama Biaya>", "<Lainnya>", "<Awal>", "<Akhir>", "<Durasi Biaya>", "<Jumlah Biaya>"
      Then "<Nama Biaya on Table>", "<Awal on Table>", "<Akhir on Table>", "<Jumlah Biaya on Table>" are displayed in the biaya sewa table

      Examples:
        | Nama Biaya                        | Lainnya | Awal  | Akhir     | Durasi Biaya    | Jumlah Biaya  | Nama Biaya on Table                         | Awal on Table | Akhir on Table  | Jumlah Biaya on Table |
        | Perpanjang sewa harian            | -       | today | tomorrow  | 2 hari          | 500000        | Perpanjang sewa harian (2 hari)             | today         | tomorrow        | Rp500.000             |
        | Kekurangan biaya sewa kamar       | -       | -     | -         | 3 hari          | 500000        | Kekurangan biaya sewa kamar (3 hari)        | -             | -               | Rp500.000             |
        | Pindah tipe kamar/kos (relokasi)  | -       | today | tomorrow  | 2A ke 1A        | 20000         | Pindah tipe kamar/kos (relokasi) (2A ke 1A) | today         | tomorrow        | Rp20.000              |
        | Lainnya                           | Sampah  | today | tomorrow  | Tambahan Kasur  | 100000        | Sampah (Tambahan Kasur)                     | today         | tomorrow        | Rp100.000             |