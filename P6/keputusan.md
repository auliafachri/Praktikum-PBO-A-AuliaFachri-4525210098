# Keputusan rancangan

1. `Kendaraan` dibuat sebagai abstract class karena semua kendaraan memiliki identitas yang sama: merek dan tahun, serta perilaku bawaan seperti menghitung umur. Ini bukan sekadar kontrak, melainkan model umum yang memang dibagi oleh semua kendaraan.
2. `Movable` dibuat sebagai interface karena ia menjelaskan kemampuan yang bisa dilakukan, bukan apa benda itu. Sebuah mobil, sepeda, atau bahkan robot bisa bergerak tanpa harus menjadi satu kelas yang sama.
3. `Fuelable` dibuat sebagai interface karena tidak semua benda yang bisa bergerak butuh bahan bakar, dan tidak semua yang butuh bahan bakar bergerak. Pemisahan ini menjaga prinsip Interface Segregation.
4. Java membatasi `extends` hanya satu kelas tetapi memperbolehkan banyak `implements` karena pewarisan kelas harus linear dan punya satu hierarki induk, sementara banyak interface lebih cocok sebagai komposisi kontrak.

## Pesan kompilator saat `isiPenuh(sepeda)`

Pada Java, `Sepeda` tidak mengimplementasikan `Fuelable`, sehingga pemanggilan berikut ditolak saat kompilasi:

```java
// isiPenuh(sepeda);
```

Error yang muncul kira-kira:

```text
Main.java:...: error: incompatible types: Sepeda cannot be converted to Fuelable
```

Penolakan saat kompilasi ini menguntungkan karena kesalahan kontrak dapat tertangkap sejak awal, sebelum program berjalan. Ini mencegah objek yang tidak layak dipakai pada operasi tertentu masuk ke runtime dan membuat bug sulit dilacak.

## Catatan tambahan

- `TipeBahanBakar` menggunakan enum agar nilai yang valid dibatasi hanya pada konstanta yang didefinisikan.
- `Loggable` pada PHP digunakan oleh kelas yang tidak berhubungan secara inheritance untuk mengulang perilaku secara horizontal.
- Trait bisa berbahaya bila dipakai terlalu luas karena menambah perilaku yang tidak terlihat dari struktur kelas dan bisa menimbulkan konflik method ketika beberapa trait memiliki nama method yang sama.
