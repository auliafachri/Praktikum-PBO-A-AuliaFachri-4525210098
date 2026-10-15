
# Bukti & Evaluasi Relasi Objektif (Sesi 7)

## Percobaan 1: Pengujian Komposisi pada Java (`getBab()`)
- **Eksperimen**: Memanggil `buku.getBab().clear()` dari luar kelas `Buku`.
- **Hasil**: Method `getBab()` menggunakan `List.copyOf(bab)` yang mengembalikan *Unmodifiable List*.
- **Perilaku System**: Exception `java.lang.UnsupportedOperationException` dilemparkan.
- **Kesimpulan**: Koleksi internal `Bab` tidak dapat diubah atau dimanipulasi dari luar kelas `Buku`. Syarat enkapsulasi komposisi terpenuhi.

## Percobaan 2: Perbedaan Komposisi pada PHP
- **Karakteristik PHP**: PHP tidak mendukung *nested inner class* privat seperti Java.
- **Solusi Komposisi**:
  1. Instansiasi kelas `Bab` dijaga melalui konvensi (hanya dipanggil di dalam method `Buku::tambahBab`).
  2. Properti `$nomor` dan `$judul` pada `Bab` dideklarasikan sebagai `readonly`.
  3. PHP mengembalikan array secara *by-value* saat dipanggil lewat `$buku->getBab()`, sehingga modifikasi elemen array tidak akan mempengaruhi `$bab` internal milik `Buku`.