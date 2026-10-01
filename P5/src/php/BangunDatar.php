<?php
declare(strict_types=1);

abstract class BangunDatar
{
    public function __construct(private readonly string $nama) {}

    abstract public function luas(): float;
    abstract public function keliling(): float;

    public function getNama(): string { return $this->nama; }

    public function __toString(): string
    {
        return sprintf('%-12s luas=%10.2f  keliling=%10.2f',
            $this->nama, $this->luas(), $this->keliling());
    }
}

class Lingkaran extends BangunDatar
{
    public function __construct(private readonly float $jariJari)
    {
        parent::__construct('Lingkaran');
        if ($jariJari <= 0) {
            throw new InvalidArgumentException("Jari-jari harus positif");
        }
    }

    // TODO 2: lengkapi. Gunakan M_PI, bukan 3.14.
    public function luas(): float     { return M_PI * $this->jariJari * $this->jariJari; }
    public function keliling(): float { return 2 * M_PI * $this->jariJari; }

    public function getJariJari(): float { return $this->jariJari; }
}

class Persegi extends BangunDatar
{
    public function __construct(private readonly float $sisi)
    {
        parent::__construct('Persegi');
        // TODO 1: tolak sisi <= 00.
        if ($sisi <= 0) {
            throw new InvalidArgumentException("Sisi harus positif");
        }
    }

    // TODO 2: lengkapi.
    public function luas(): float     { return $this->sisi * $this->sisi; }
    public function keliling(): float { return 4 * $this->sisi; }
}

// TODO Langkah 2: buat kelas Segitiga (tiga sisi, rumus Heron).
class segitiga extends BangunDatar
{
    public function __construct(private readonly float $sisiA, private readonly float $sisiB, private readonly float $sisiC)
    {
        parent::__construct('Segitiga');
        // TODO 3: tolak sisi <= 0.
        if ($sisiA <= 0 || $sisiB <= 0 || $sisiC <= 0) {
            throw new InvalidArgumentException("Sisi harus positif");
        }
        // TODO 3: tolak ketiga sisi tidak membentuk segitiga.
        if ($sisiA + $sisiB <= $sisiC || $sisiA + $sisiC <= $sisiB || $sisiB + $sisiC <= $sisiA) {
            throw new InvalidArgumentException("Ketiga sisi tidak membentuk segitiga");
        }
    }

    public function luas(): float
    {
        $s = ($this->sisiA + $this->sisiB + $this->sisiC) / 2;
        return sqrt($s * ($s - $this->sisiA) * ($s - $this->sisiB) * ($s - $this->sisiC));
    }

    public function keliling(): float
    {
        return $this->sisiA + $this->sisiB + $this->sisiC;
    }
}
//                 Tolak konstruksi bila ketiga sisi tidak membentuk segitiga.
// TODO Langkah 4: buat kelas Trapesium.
class Trapesium extends BangunDatar
{
    public function __construct(private readonly float $sisiA, private readonly float $sisiB, private readonly float $tinggi, private readonly float $sisiC)
    {
        parent::__construct('Trapesium');
        // TODO 5: tolak sisi <= 0.
        if ($sisiA <= 0 || $sisiB <= 0 || $tinggi <= 0 || $sisiC <= 0) {
            throw new InvalidArgumentException("Sisi harus positif");
        }
    }

    public function luas(): float
    {
        return (($this->sisiA + $this->sisiB) / 2) * $this->tinggi;
    }

    public function keliling(): float
    {
        return $this->sisiA + $this->sisiB + $this->tinggi + $this->sisiC;
    }
}