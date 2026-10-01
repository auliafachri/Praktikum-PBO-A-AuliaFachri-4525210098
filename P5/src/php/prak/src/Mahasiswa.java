/**
 * Sesi 2 - enkapsulasi yang menjaga invariant.
 *
 * Sistem akademik mencatat mahasiswa dengan NIM, nama, dan tiga komponen
 * nilai: tugas, UTS, dan UAS. NIM tidak pernah berubah setelah mahasiswa
 * terdaftar. Setiap komponen nilai berada dalam rentang 0 sampai 100.
 */
public class Mahasiswa {

    public static final double BOBOT_TUGAS = 0.30;
    public static final double BOBOT_UTS = 0.30;
    public static final double BOBOT_UAS = 0.40;

    private static final double NILAI_MIN = 0;
    private static final double NILAI_MAX = 100;

    private final String nim;
    private final String nama;
    private double nilaiTugas;
    private double nilaiUts;
    private double nilaiUas;

    public Mahasiswa(String nim, String nama, double nilaiTugas, double nilaiUts, double nilaiUas) {
        if (nim == null || nim.trim().isEmpty()) {
            throw new IllegalArgumentException("NIM tidak boleh kosong atau null");
        }

        pastikanNilaiSah("nilai tugas", nilaiTugas);
        pastikanNilaiSah("nilai UTS", nilaiUts);
        pastikanNilaiSah("nilai UAS", nilaiUas);

        this.nim = nim;
        this.nama = nama;
        this.nilaiTugas = nilaiTugas;
        this.nilaiUts = nilaiUts;
        this.nilaiUas = nilaiUas;
    }

    private static void pastikanNilaiSah(String namaKomponen, double nilai) {
        if (Double.isNaN(nilai) || nilai < NILAI_MIN || nilai > NILAI_MAX) {
            throw new IllegalArgumentException(
                    namaKomponen + " harus berada dalam rentang 0 sampai 100");
        }
    }

    public double nilaiAkhir() {
        return nilaiTugas * BOBOT_TUGAS
                + nilaiUts * BOBOT_UTS
                + nilaiUas * BOBOT_UAS;
    }

    public String hurufMutu() {
        double nilai = nilaiAkhir();
        if (nilai >= 80) {
            return "A";
        } else if (nilai >= 70) {
            return "B";
        } else if (nilai >= 60) {
            return "C";
        } else if (nilai >= 50) {
            return "D";
        }
        return "E";
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public double getNilaiAkhir() {
        return nilaiAkhir();
    }

    public double getNilaiTugas() {
        return nilaiTugas;
    }

    public double getNilaiUts() {
        return nilaiUts;
    }

    public double getNilaiUas() {
        return nilaiUas;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-18s akhir=%6.2f  mutu=%s",
                nim, nama, nilaiAkhir(), hurufMutu());
    }
}
