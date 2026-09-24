public class PegawaiHarian extends Pegawai {

	private final int jumlahHari;

   
	public PegawaiHarian(String nip, String nama, double gajiPerHari, int jumlahHari) {
		super(nip, nama, gajiPerHari);
		if (jumlahHari < 0) {
			throw new IllegalArgumentException("Jumlah hari tidak boleh negatif");
		}
		this.jumlahHari = jumlahHari;
	}

	@Override
	public double hitungGaji() {
		return super.hitungGaji() * jumlahHari;
	}

	@Override
	public String jenis() { return "HARIAN"; }
}
