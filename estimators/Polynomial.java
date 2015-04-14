 public class Polynomial {
    private Double[] reversedCoefficients;
    private Double solvedValue = 0.0;
    

    public Polynomial(Double[] n) {
        int j = 0;
        reversedCoefficients = new Double[n.length];
        for(int i = n.length - 1 ; i >=0; i--) {
            this.reversedCoefficients[j] = n[i];
            j++;
        }
    }


    public double solver(Double x) {
        solvedValue = 0.0;
        for(int i = 0; i < reversedCoefficients.length; i++) {
            solvedValue += Math.pow(x, i) * reversedCoefficients[i];
        }
        return solvedValue;
    }

}