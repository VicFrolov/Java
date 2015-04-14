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
        fudgeFactorize();
    }


    private void dartThrow(int dartAmount, Double xMin, Double xMax) {
        double timesHit = 0.0;
        double area = xMax - xMin;

        System.out.println("start");
    
        for (int j = 0; j < dartAmount; j++) {
            
            double x = Math.random()*(upperBound - lowerBound) - lowerBound;
            double y = Math.random() * 2.0 - 1.0;
            String result = "";
            
            boolean hit = ((x*x + y*y) <= 1);

            if (hit) {
                timesHit++;
                result = "in";
            } else {
                result = "out";
            }

            System.out.println(x + " " + y + " " + result);
        }
        
        System.out.println("end");
        System.out.println("Darts: " + dartAmount + " Hits: " + timesHit + 
            " Pi estimate: " +  timesHit / dartAmount * area);
    }   

    public static void main(String[] args) {
        MonteCarloIntegrator test = new MonteCarloIntegrator();

        test.boundCalculator(new Polynomial(new Double[]{1.0,1.0,1.0}), 5, -5);

        System.out.println(test.lowerBound);
                System.out.println(test.upperBound);


    }
}