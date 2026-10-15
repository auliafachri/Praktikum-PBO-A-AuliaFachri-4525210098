# Analisis Rancangan Sistem Perpustakaan

## 1. Analisis Domain & Kata Kunci (Deskripsi Kebutuhan)
- **Calon Kelas Entitas**: `Koleksi`, `Buku`, `Majalah`, `Skripsi`, `Bab`, `Anggota`, `Peminjaman`.
- **Calon Enum / Value Object**: `StatusKoleksi`, `JenisKeanggotaan`.
- **Aturan Invarian**:
  - `Buku` max pinjam 14 hari, `Majalah` 3 hari, `Skripsi` 0 hari (hanya baca).
  - Anggota maksimal meminjam 3 koleksi bersamaan.
  - `Bab` tidak dapat berdiri sendiri di luar `Buku` (Komposisi).

## 2. Keputusan Relasi pada `PerpustakaanService`
- **Agregasi vs Komposisi**: Relasi antara `PerpustakaanService` terhadap `Koleksi` dan `Anggota` adalah **Agregasi (`o--`)**.
- **Alasan**:
  1. Objek `Koleksi` dan `Anggota` dapat ada sebelum dimasukkan ke dalam layanan perpustakaan.
  2. Jika instance `PerpustakaanService` dihancurkan, data koleksi dan anggota secara logis tetap ada di sistem / database.