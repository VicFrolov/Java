 public class Polynomial {
    private Double[] reversedCoefficients;

    public Polynomial(Double[] n) {
        int j = 0;
        reversedCoefficients = new Double[n.length];


        for(int i = n.length - 1 ; i >=0; i--) {
            this.reversedCoefficients[j] = n[i];
            j++;
        }
    }

    public static void main(String[] args) {
        Polynomial test = new Polynomial(new Double[]{1.0,2.0,3.0,4.0,5.0});
        System.out.println(test.reversedCoefficients[0]);

     }
}