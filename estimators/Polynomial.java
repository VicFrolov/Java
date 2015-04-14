 public class Polynomial {
    private static Double[] reversedCoefficients;


    public Polynomial(Double[] n) {
        int j = 0;
        reversedCoefficients = new Double[n.length];


        for(int i = n.length - 1 ; i >=0; i--) {
            this.reversedCoefficients[j] = n[i];
            j++;
        }
    }


    public static double Solver(Double x) {
        Double solvedValue = 0.0; 

        for(int i = 0; i < reversedCoefficients.length; i++) {
            solvedValue += Math.pow(x, i) * reversedCoefficients[i];
        }
        return solvedValue;
    }

    public static void main(String[] args) {
        Polynomial test = new Polynomial(new Double[]{19.0, 4.0, 3.0});
        System.out.println(Solver(3.0));

     }
}