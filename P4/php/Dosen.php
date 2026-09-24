<?php
declare(strict_types=1);

require_once __DIR__ . '/Pegawai.php';

class Dosen extends PegawaiTetap
{
	public function __construct(
		string $nip,
		string $nama,
		float $gajiPokok,
		int $masaKerjaTahun,
		private readonly float $tunjanganFungsional,
	) {
		parent::__construct($nip, $nama, $gajiPokok, $masaKerjaTahun);

		if ($this->tunjanganFungsional < 0) {
			throw new InvalidArgumentException('Tunjangan fungsional tidak boleh negatif');
		}
	}

	public function hitungGaji(): float
	{
		return parent::hitungGaji() + $this->tunjanganFungsional;
	}

	public function jenis(): string { return 'DOSEN'; }
}
