package id.ac.univpancasila.perpustakaan.service;

import java.util.ArrayList;

import id.ac.univpancasila.perpustakaan.model.Buku;

/**
 * Kerangka lapisan layanan.
 * Pada sesi 7 cukup struktur dan tanda tangan method; isinya boleh minimal.
 * Lapisan ini akan diperdalam pada sesi 10 (exception) dan 12 (SOLID).
 *
 * TODO: sesuaikan seluruh isi berkas ini dengan class diagram Anda sendiri.
 *       Kelas dan method di sini hanya contoh awal.
 */
public class PerpustakaanService {

    // TODO 1: tentukan bagaimana layanan ini menyimpan koleksi dan anggota.
    //         Agregasi atau komposisi? Tuliskan alasannya di analisis.md,
    //         lalu wujudkan keputusan itu di sini.
    private ArrayList<Buku> buku = new ArrayList<>();

    public void tambahKoleksi(Buku buku) {
        this.buku.add(buku);
    }

    public Buku cariKoleksi(String nomorInduk) {
        for (Buku buku : this.buku){
            if (buku.getNomorInduk().equals(nomorInduk)) {
                return  buku;
            }
        }
        // TODO 3
        return null;
    }

    public void pinjam(String nomorAnggota, String nomorInduk) {
        System.out.println("Anggota" + nomorAnggota + "meminjam buku" + nomorInduk);
        // TODO 4: terapkan aturan bisnis dari deskripsi-kebutuhan.md.
        //         Aturan lengkapnya akan disempurnakan pada sesi 10.
    }

    public void kembalikan(String nomorAnggota, String nomorInduk) {
        System.out.println("Anggota:" +nomorAnggota + "mengembalikan buku" +nomorInduk);
        // TODO 5
    }
}
