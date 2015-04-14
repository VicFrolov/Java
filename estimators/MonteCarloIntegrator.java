public class MonteCarloIntegrator {
    private double lowerBound;
    private double upperBound;

    private void boundCalculator(Polynomial p, double xMin, double xMax) {
        lowerBound = p.solver(xMin);
        upperBound = p.solver(xMin);
        double fudgeFactor = 0.0;
        double intervalIncrease = Math.abs((xMin - xMax) / 1000000);

        for(double i = xMin; i <= xMax; i += intervalIncrease) {
            double currentValue = p.solver(i);  


            if(currentValue > upperBound) {
                upperBound = currentValue;
            }

            if(currentValue < lowerBound) {
                lowerBound = currentValue;
            }
        }

        //fudge-factor
        fudgeFactor = (upperBound - lowerBound) * 0.09;
        lowerBound -= fudgeFactor;
        upperBound += fudgeFactor;
    }


    public static void main(String[] args) {

    }
}