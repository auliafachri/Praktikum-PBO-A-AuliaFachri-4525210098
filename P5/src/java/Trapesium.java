public class Trapesium extends BangunDatar {

    private final double sisiA;
    private final double sisiB;
    private final double sisiC;
    private final double sisiD;

    public Trapesium(double sisiA, double sisiB, double sisiC, double sisiD) {
        super("Trapesium");

        if (sisiA <= 0 || sisiB <= 0 || sisiC <= 0 || sisiD <= 0) {
            throw new IllegalArgumentException("Sisi harus positif");
        }
        this.sisiA = sisiA;
        this.sisiB = sisiB;
        this.sisiC = sisiC;
        this.sisiD = sisiD;
    }


    @Override public double luas()     { return ((sisiA + sisiB) / 2) * Math.sqrt(Math.pow(sisiC, 2) - Math.pow(((Math.pow(sisiB - sisiA, 2) + Math.pow(sisiC, 2) - Math.pow(sisiD, 2)) / (2 * (sisiB - sisiA))), 2)); }
    @Override public double keliling() { return sisiA + sisiB + sisiC + sisiD; }
    
}
