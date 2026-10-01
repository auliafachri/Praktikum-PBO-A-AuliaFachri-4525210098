public class Persegi extends BangunDatar {

    private final double sisi;

    public Persegi(double sisi) {
        super("Persegi");
    
        // TODO 1: tolak sisi <= 0.
        if (sisi <= 0) {
            throw new IllegalArgumentException("gaboleh negatif");
        }
        this.sisi = sisi;
    }

    // TODO 2: lengkapi luas() dan keliling().
    @Override public double luas()     { return sisi * sisi; }
    @Override public double keliling() { return 4 * sisi; }

    public double sisi_persegi(double luas) { 
        return Math.sqrt(luas); 
    }
    public double sisi_persegi() { 
        return 4; 
    }

}
