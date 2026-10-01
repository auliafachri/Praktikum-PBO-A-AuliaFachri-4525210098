public class Segitiga  extends BangunDatar {
    
    private final double sisiA;
    private final double sisiB;
    private final double sisiC;

    public Segitiga(double sisiA, double sisiB, double sisiC) {
        super("Segitiga");
        if (sisiA <= 0 || sisiB <= 0 || sisiC <= 0) {
            throw new IllegalArgumentException("Sisi harus positif");
        }
        this.sisiA = sisiA;
        this.sisiB = sisiB;
        this.sisiC = sisiC;
    }


    @Override public double luas() {
        double s = (sisiA + sisiB + sisiC) / 2;
        return Math.sqrt(s * (s - sisiA) * (s - sisiB) * (s - sisiC));
    }

    @Override public double keliling() {
        return sisiA + sisiB + sisiC;
    }
}
