<?php
declare(strict_types=1);

require_once __DIR__ . '/Pegawai.php';

class PegawaiHarian extends Pegawai
{
	public function __construct(
		string $nip,
		string $nama,
		float $gajiPerHari,
		private readonly int $jumlahHari,
	) {
		parent::__construct($nip, $nama, $gajiPerHari);

		if ($this->jumlahHari < 0) {
			throw new InvalidArgumentException('Jumlah hari tidak boleh negatif');
		}
	}

	public function hitungGaji(): float
	{
		return parent::hitungGaji() * $this->jumlahHari;
	}

	public function jenis(): string { return 'HARIAN'; }
}
