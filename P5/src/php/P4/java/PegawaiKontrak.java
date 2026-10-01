public class PegawaiKontrak extends Pegawai {

    private final int bulanKontrak;

    public PegawaiKontrak(String nip, String nama, double gajiPokok, int bulanKontrak) {
        super(nip, nama, gajiPokok);
        this.bulanKontrak = bulanKontrak;
    }

    @Override
    public double hitungGaji() {
        return super.hitungGaji();
    }

    @Override
    public String jenis() { return "KONTRAK"; }

    public int getBulanKontrak() { return bulanKontrak; }
}
