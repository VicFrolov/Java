 public class Polynomial {
    private static Double[] reversedCoefficients;
    private static Double solvedValue = 0.0;

    public Polynomial(Double[] n) {
        int j = 0;
        reversedCoefficients = new Double[n.length];
        for(int i = n.length - 1 ; i >=0; i--) {
            this.reversedCoefficients[j] = n[i];
            j++;
        }
    }

    public static double solver(Double x) {
        solvedValue = 0.0;
        for(int i = 0; i < reversedCoefficients.length; i++) {
            solvedValue += Math.pow(x, i) * reversedCoefficients[i];
        }
        return solvedValue;
    }
}