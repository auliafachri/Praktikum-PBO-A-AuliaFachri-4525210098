# Laporan Praktikum PBO - Sesi 4

## Topik

Implementasi pewarisan, kelas abstrak, polymorphism, overriding method, dan constructor chaining pada hierarki kelas pegawai menggunakan Java dan PHP.

## Tujuan

1. Membuat kelas induk abstrak `Pegawai`.
2. Membuat kelas turunan `PegawaiTetap`, `PegawaiKontrak`, `Dosen`, dan `PegawaiHarian`.
3. Menerapkan overriding pada method `hitungGaji()` dan `jenis()`.
4. Menggunakan polymorphism melalui array atau daftar bertipe `Pegawai`.
5. Membandingkan implementasi konsep OOP pada Java dan PHP.

## Struktur Kelas

```text
Pegawai (abstract)
├── PegawaiTetap
│   └── Dosen
├── PegawaiKontrak
└── PegawaiHarian
```

### Kelas `Pegawai`

`Pegawai` merupakan kelas abstrak yang menyimpan data umum:

- `nip`
- `nama`
- `gajiPokok`

Kelas ini menyediakan method dasar `hitungGaji()` yang mengembalikan gaji pokok dan method abstrak `jenis()` yang wajib diimplementasikan oleh setiap kelas turunan. Gaji pokok negatif ditolak melalui `IllegalArgumentException` pada Java dan `InvalidArgumentException` pada PHP.

### Kelas `PegawaiTetap`

Pegawai tetap memperoleh tunjangan masa kerja sebesar 2% dari gaji pokok untuk setiap tahun masa kerja, dengan batas maksimum 40%.

Rumus:

```text
tunjangan = min(masa kerja x 2%, 40%)
gaji      = gaji pokok x (1 + tunjangan)
```

Method ini memanggil `super.hitungGaji()` pada Java atau `parent::hitungGaji()` pada PHP agar gaji dasar tetap berasal dari kelas induk.

### Kelas `PegawaiKontrak`

Pegawai kontrak tidak memperoleh tunjangan masa kerja sehingga menggunakan perhitungan dasar dari kelas `Pegawai`. Data tambahan yang disimpan adalah lama kontrak dalam bulan.

### Kelas `Dosen`

`Dosen` merupakan turunan dari `PegawaiTetap`. Gaji dosen terdiri dari gaji pegawai tetap ditambah tunjangan fungsional.

```text
gaji dosen = gaji pegawai tetap + tunjangan fungsional
```

### Kelas `PegawaiHarian`

Pegawai harian dibayar berdasarkan jumlah hari kerja.

```text
gaji harian = gaji per hari x jumlah hari
```

## Implementasi Java

File Java berada pada folder `java/`:

- `Pegawai.java`
- `PegawaiTetap.java`
- `PegawaiKontrak.java`
- `dosen.java`
- `PegawaiHarian.java`
- `Main.java`

`Main.java` menggunakan array bertipe `Pegawai[]` untuk menyimpan berbagai objek turunan. Saat method `hitungGaji()` dipanggil melalui referensi `Pegawai`, Java menjalankan implementasi sesuai objek sebenarnya. Hal ini menunjukkan polymorphism.

## Implementasi PHP

File PHP berada pada folder `php/`:

- `Pegawai.php`
- `Dosen.php`
- `PegawaiHarian.php`
- `main.php`

PHP menggunakan `require_once` untuk memuat definisi kelas. Daftar pegawai diproses menggunakan array dan `array_map()`. Type declaration seperti `string`, `float`, `int`, dan `: float` membantu menjaga konsistensi tipe data.

## Data Pengujian

| Pegawai | Gaji Pokok / Hari | Data Tambahan | Hasil Gaji |
|---|---:|---|---:|
| Ani Lestari | Rp6.000.000 | Pegawai tetap, 15 tahun | Rp7.800.000 |
| Budi Santoso | Rp5.000.000 | Pegawai kontrak, 12 bulan | Rp5.000.000 |
| Citra Dewi | Rp8.000.000 | Dosen, 10 tahun, tunjangan Rp1.500.000 | Rp11.100.000 |
| Dedi Pratama | Rp250.000 per hari | Pegawai harian, 20 hari | Rp5.000.000 |

### Perhitungan Ani

```text
tunjangan = 15 x 2% = 30%
gaji      = Rp6.000.000 x 130%
		  = Rp7.800.000
```

### Total Beban Gaji

```text
Rp7.800.000 + Rp5.000.000 + Rp11.100.000 + Rp5.000.000
= Rp28.900.000
```

## Hasil Pengujian

Program Java dijalankan dengan:

```powershell
cd P4\java
javac *.java
java Main
```

Program PHP diperiksa dan dijalankan dengan:

```powershell
cd P4\php
php -l Pegawai.php
php -l Dosen.php
php -l PegawaiHarian.php
php -l main.php
php main.php
```

Hasil kedua implementasi:

```text
Total beban gaji: Rp28.900.000
```

Semua file Java dan PHP berhasil dikompilasi atau diperiksa sintaksnya, dan hasil perhitungan Java serta PHP sama.

## Perbandingan Java dan PHP

| Aspek | Java | PHP |
|---|---|---|
| Kelas abstrak | `abstract class Pegawai` | `abstract class Pegawai` |
| Constructor induk | `super(...)` | `parent::__construct(...)` |
| Pemanggilan method induk | `super.hitungGaji()` | `parent::hitungGaji()` |
| Override method | `@Override` | Method dengan signature yang sama |
| Penyimpanan data tetap | `final` | `readonly` |
| Polymorphism | `Pegawai[]` | Array objek dan type hint `Pegawai` |
| Validasi sintaks | `javac` | `php -l` |

## Kesimpulan

Implementasi berhasil menerapkan konsep dasar pemrograman berorientasi objek pada Java dan PHP. Kelas `Pegawai` menjadi abstraksi untuk data dan perilaku umum, sedangkan kelas turunan menambahkan aturan penggajian masing-masing. Overriding dan polymorphism memungkinkan setiap objek menghitung gaji sesuai jenisnya walaupun diproses melalui referensi kelas induk.

