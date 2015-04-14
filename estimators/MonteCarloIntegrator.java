public class MonteCarloIntegrator {
    private static final int DEFAULT_NUMBER_OF_DARTS = 10000;    
    private double lowerBound;
    private double upperBound;


    private void fudgeFactorize() {
        double fudgeFactor = 0.0;
        upperBound = upperBound < 0 ? 0 : upperBound;
        lowerBound = lowerBound > 0 ? 0 : lowerBound;        
        fudgeFactor = (upperBound - lowerBound) * 0.10;
        lowerBound -= fudgeFactor;
        upperBound += fudgeFactor;

    }

    private void boundCalculator(Polynomial p, double xMin, double xMax) {
        if (xMin > xMax) {
            Double oldxMin = xMin;
            xMin = xMax;
            xMax = oldxMin;
        }

        lowerBound = p.solver(xMin);
        upperBound = p.solver(xMin);
        double intervalIncrease = Math.abs((xMin - xMax) / 1000000);

        for (double i = xMin; i <= xMax; i += intervalIncrease) {
            double currentValue = p.solver(i);  
            upperBound = currentValue > upperBound ? currentValue : upperBound;
            lowerBound = currentValue < lowerBound ? currentValue : lowerBound;
        }
        //Add 10% buffer
        // fudgeFactorize();
        //
        //
        //
        //

    }


    private void dartThrow(int dartAmount, Double xMin, Double xMax) {
        double timesHit = 0.0;

        System.out.println("Minimum in range: " + lowerBound);
        System.out.println("Maximum in range: " + upperBound);

        //add 10% buffer
        fudgeFactorize();
        
        System.out.println("Final lower bound: " + lowerBound);
        System.out.println("Final upper bound: " + upperBound);
        System.out.println("start");
    
        for (int j = 0; j < dartAmount; j++) {
            double x = xMin + Math.random()*(xMax - xMin);
            double y = lowerBound + Math.random() * (upperBound - lowerBound);            
            String result = "";
            
            if(Polynomial.solver(x) <= y && y <= 0) {
                timesHit--;
                result = "in";
            } else if(Polynomial.solver(x) >= y && y >= 0) {
                timesHit++;
                result = "in";
            } else {
                result = "out";
            }

            System.out.println(x + " " + y + " " + result);
        }
        
        System.out.println("end");
        System.out.println("Estimate: " + (timesHit / dartAmount) * (xMax - xMin) * (upperBound - lowerBound));
        
    }   

    public static void main(String[] args) {
        MonteCarloIntegrator test = new MonteCarloIntegrator();

        test.boundCalculator(new Polynomial(new Double[]{1.0,1.0,1.0}), 5, -5);
        test.dartThrow(10000, -5.0, 5.0);


    }
}