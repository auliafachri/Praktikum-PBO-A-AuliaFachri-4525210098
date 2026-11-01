# LAPORAN PRAKTIKUM PEMROGRAMAN BERBASIS OBJEK

| Informasi Praktikan | Keterangan                                            |
| :------------------ | :---------------------------------------------------- |
| **Nama**            | Aulia Fachri                                          |
| **NPM**             | 4525210098                                            |
| **Kelas**           | A                                                     |
| **Mata Kuliah**     | Pemrograman Berbasis Objek (PBO)                      |
| **Pertemuan**       | Pertemuan 9 - Package, Namespace, Maven, dan Composer |
| **Tanggal**         | 31/10/2026                                            |

---

## 1. Implementasi Java

### 1.1. File: pom.xml

**Penjelasan Kode:**

> Berkas `pom.xml` adalah konfigurasi build Maven yang menetapkan koordinat unik proyek (`groupId`, `artifactId` bernilai `perpustakaan`, dan versi `1.0.0`), versi compiler Java 25 melalui `maven.compiler.release`, serta encoding sumber UTF-8. Dependensi eksternal yang ditambahkan adalah **Datafaker** versi `2.1.0` yang dipakai di `Main.java` untuk membuat nama mahasiswa secara acak. Selain itu, `exec-maven-plugin` dikonfigurasi dengan `mainClass` `id.ac.univpancasila.perpustakaan.Main` sehingga program cukup dijalankan dengan perintah `mvn exec:java`.

**Bukti Eksekusi (Screenshot):**

_Before_ (Kondisi awal / Bagian TODO belum diisi):
![SS Before pom.xml](images/pomxmlsebelum.png)

_After_ (Kondisi akhir / Dependensi dan plugin sudah dikonfigurasi):
![SS After pom.xml](images/pomxmlsesudah.png)

### 1.2. File: Struktur Package Maven (model, service, util)

**Penjelasan Kode:**

> Kode Sistem Perpustakaan dari pertemuan 7 dipindahkan ke struktur folder baku Maven, yaitu `src/main/java/id/ac/univpancasila/perpustakaan/`. Kelas dikelompokkan ke dalam sub-package `model` (`Buku`, `Jurusan`, `Anggota`), `service` (`PerpustakaanService`), dan `util` (`Format`). Baris `package` pada setiap berkas ditulis sama persis dengan jalur foldernya, misalnya `package id.ac.univpancasila.perpustakaan.model;` pada `model/Buku.java`, karena ketidakcocokan keduanya menyebabkan galat kompilasi atau `ClassNotFoundException`. Kelas antar-package kemudian dipakai melalui `import`, seperti `import id.ac.univpancasila.perpustakaan.model.*;` dan `import id.ac.univpancasila.perpustakaan.service.*;` pada `Main.java`.

**Bukti Eksekusi (Screenshot):**

_Before_ (Kondisi awal / Kesalahan kompilasi akibat package atau import belum sesuai):
![SS Before Struktur Package](images/packagejavasebelum.png)

_After_ (Kondisi akhir / Struktur folder dan package sudah sesuai):
![SS After Struktur Package](images/packagejavasesudah.png)

### 1.3. File: Main.java

**Penjelasan Kode:**

> Kelas `Main` berada di package `id.ac.univpancasila.perpustakaan` dan berfungsi sebagai titik masuk program. Kelas ini mengimpor kelas dari package `model` dan `service` serta pustaka eksternal `net.datafaker.Faker`. Program mendemonstrasikan relasi komposisi `Buku` dan `Bab` (termasuk penolakan perubahan koleksi bab dari luar), relasi agregasi `Jurusan` dan `Mahasiswa` (dengan nama mahasiswa dari Datafaker), pencarian dan peminjaman buku melalui `PerpustakaanService`, serta pengecekan masa keanggotaan melalui kelas `Anggota`.

**Bukti Eksekusi (Screenshot):**

_Before_ (Kondisi awal / Kesalahan kompilasi):
![SS Before Main.java](images/mainjavasebelum.png)

_After_ (Kondisi akhir / Eksekusi berhasil):
![SS After Main.java](images/mainjavasesudah.png)

### Output

**Hasil Perintah Maven:**

![Output mvn clean](images/mvnclean.png)

![Output mvn compile](images/mvncompile.png)

**Output Program Java:**

![Output Java](images/runningprogramjava.png)

---

## 2. Implementasi PHP

### 2.1. File: composer.json

**Penjelasan Kode:**

> Berkas `composer.json` menetapkan kebutuhan proyek, yaitu PHP `^8.5.12` dan pustaka **Carbon** (`nesbot/carbon` `^3.15`) untuk mengolah tanggal. Pemetaan `autoload.psr-4` dengan isi `"Perpustakaan\\": "src/"` mengaktifkan autoload PSR-4 sehingga namespace `Perpustakaan\` menunjuk ke folder `src/`. Backslash pada JSON ditulis ganda. Pemetaan `autoload-dev.psr-4` untuk `Perpustakaan\\Tests\\` ke `tests/` disiapkan untuk kode pengujian pada pertemuan berikutnya, dan berkas `composer.lock` dipertahankan agar versi dependensi konsisten.

**Bukti Eksekusi (Screenshot):**

_Before_ (Kondisi awal / Pemetaan autoload masih kosong):
![SS Before composer.json](images/composersebelum.png)

_After_ (Kondisi akhir / Autoload PSR-4 dan dependensi sudah terisi):
![SS After composer.json](images/composersesudah.png)

### 2.2. File: Namespace pada src/Model dan src/Service

**Penjelasan Kode:**

> Seluruh kelas PHP dipindahkan ke folder `src/` dan diberi namespace sesuai lokasi foldernya: `Perpustakaan\Model` untuk `Buku`, `Bab`, `Jurusan`, `Mahasiswa`, dan `Anggota`, serta `Perpustakaan\Service` untuk `PerpustakaanService`. Dengan autoload PSR-4, `Perpustakaan\Model\Buku` otomatis dipetakan ke `src/Model/Buku.php`, sehingga seluruh `require_once` tidak diperlukan lagi. Nama folder ditulis persis seperti namespace-nya (huruf besar-kecil) agar tetap berjalan di server Linux. Kelas `Anggota` memakai Carbon untuk memeriksa masa keanggotaan maksimal 3 tahun.

**Bukti Eksekusi (Screenshot):**

_Before_ (Kondisi awal / Galat kelas tidak ditemukan):
![SS Before Namespace PHP](images/namespacephpsebelum.png)

_After_ (Kondisi akhir / Kelas termuat otomatis melalui autoload):
![SS After Namespace PHP](images/namespacephpsesudah.png)

### 2.3. File: main.php

**Penjelasan Kode:**

> Berkas `main.php` berfungsi sebagai titik masuk eksekusi utama (_entry point_) PHP. Berkas ini hanya memuat satu baris `require __DIR__ . '/vendor/autoload.php';`, lalu menggunakan kelas melalui pernyataan `use` seperti `Perpustakaan\Model\Buku` dan `Carbon\Carbon`. Program menguji relasi komposisi dan agregasi, perubahan stok sebelum dan sesudah peminjaman, perhitungan tanggal jatuh tempo 14 hari menggunakan Carbon, serta status keanggotaan.

**Bukti Eksekusi (Screenshot):**

_Before_ (Kondisi awal / Galat autoload):
![SS Before main.php](images/mainphpsebelum.png)

_After_ (Kondisi akhir / Eksekusi berhasil):
![SS After main.php](images/mainphpsesudah.png)

### Output

**Hasil Perintah Composer:**

![Output composer validate](images/composervalidate.png)

![Output composer install](images/composerinstall.png)

**Output Program PHP:**

![Output PHP](images/runningprogramphp.png)

---

## 3. Kesimpulan

> Praktikum Pertemuan 9 ini berhasil menerapkan pengelolaan struktur proyek dan dependensi pada Java dan PHP. Pada Java, kode ditata dalam struktur folder baku Maven dengan package domain terbalik `id.ac.univpancasila.perpustakaan`, di mana deklarasi `package` harus sama persis dengan jalur folder dan antar-package dihubungkan melalui `import`. Pada PHP, namespace `Perpustakaan` dipetakan ke folder `src/` melalui autoload PSR-4 Composer sehingga kelas termuat otomatis tanpa `require_once`. Maven (`pom.xml`) dan Composer (`composer.json` serta `composer.lock`) mengelola dependensi eksternal, yaitu Datafaker pada Java dan Carbon pada PHP, sehingga proyek dapat dibangun dan dijalankan ulang dengan langkah yang terukur di perangkat lain.
