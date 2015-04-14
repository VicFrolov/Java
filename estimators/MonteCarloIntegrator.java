public class MonteCarloIntegrator {
    private static final int DEFAULT_NUMBER_OF_DARTS = 10000;    
    private Double lowerBound;
    private Double upperBound;


    private void fudgeFactorize() {
        Double fudgeFactor = 0.0;
        upperBound = upperBound < 0 ? 0 : upperBound;
        lowerBound = lowerBound > 0 ? 0 : lowerBound;        
        fudgeFactor = (upperBound - lowerBound) * 0.10;
        lowerBound -= fudgeFactor;
        upperBound += fudgeFactor;

    }

    private void boundCalculator(Polynomial p, Double xMin, Double xMax) {
        if (xMin > xMax) {
            Double oldxMin = xMin;
            xMin = xMax;
            xMax = oldxMin;
        }

        lowerBound = p.solver(xMin);
        upperBound = p.solver(xMin);
        Double intervalIncrease = Math.abs((xMin - xMax) / 1000000);

        for (Double i = xMin; i <= xMax; i += intervalIncrease) {
            Double currentValue = p.solver(i);  
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
        Double timesHit = 0.0;

        System.out.println("Minimum in range: " + lowerBound);
        System.out.println("Maximum in range: " + upperBound);

        //add 10% buffer
        fudgeFactorize();
        
        System.out.println("Final lower bound: " + lowerBound);
        System.out.println("Final upper bound: " + upperBound);
        System.out.println("start");
    
        for (int j = 0; j < dartAmount; j++) {
            Double x = xMin + Math.random()*(xMax - xMin);
            Double y = lowerBound + Math.random() * (upperBound - lowerBound);            
            String result = "";
            
            if (Polynomial.solver(x) <= y && y <= 0) {
                timesHit--;
                result = "in";
            } else if (Polynomial.solver(x) >= y && y >= 0) {
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
        int dartsToThrow = DEFAULT_NUMBER_OF_DARTS;
        int customSettingUsed = 0;
        int j = 0;

        if (!"poly".equals(args[0])) {
            errorMessage();
            return;
        }

        if (args[args.length-1].length() >= 6 && "total=".equals(args[args.length -1].substring(0,6))) {
            int checkNumber;

            try {
                checkNumber = Integer.parseInt(args[args.length-1].substring(6));
            } catch (NumberFormatException nfe) {
                errorMessageCustomDarts();
                return;
            }

            int customDartNumber = Integer.parseInt(args[args.length-1].substring(6));

            if (customDartNumber< 0) {
                errorMessageCustomDarts();
                return;
            }

            dartsToThrow = customDartNumber;
            customSettingUsed++;
        }

        //check that coefficients and bounds are Doubles
        for (int i = 1; i < args.length - customSettingUsed; i++) {
            Double checkDoubleNumber;
            try {
                checkDoubleNumber = Double.parseDouble(args[i]);
            } catch (NumberFormatException nfe) {
                errorMessage();
                return;
            }
        }

        Double bound1 = Double.parseDouble(args[args.length - 1 - customSettingUsed]);
        Double bound2 = Double.parseDouble(args[args.length - 2 - customSettingUsed]);

        //find total coefficient values, and assign reversed array
        int totalCoefficients = args.length - 3 - customSettingUsed;
        Double[] coefficientArray = new Double[totalCoefficients];

        // store reversedArray of coefficients
        for(int i = (args.length - 3 - customSettingUsed); i > 0; i--) {
            coefficientArray[j] = Double.parseDouble(args[i]);
            j++;
        }

        MonteCarloIntegrator test = new MonteCarloIntegrator();

        // test.boundCalculator(new Polynomial(new Double[]{1.0,1.0,1.0}), 5, -5);
        // test.dartThrow(dartsToThrow, -5.0, 5.0);


    }

    private static void inputSafetyChecker() {

    }

    private static void errorMessage() {
        System.out.println("This can only estimate the area of a polynomial. please enter 'poly' as the first argument, followed by as many coefficients, followed by two inputs\nfor bounds.");
        System.out.println("\nEntries would look as the following: <poly> <coefficient> <coefficient> <coefficient> <bound> <bound>");
        System.out.println("\nCoefficients increment the functions exponents from the furthest to the right, moving up to the left, starting at 0");
        System.out.println("\nOptional: Last argument can start with a 'total:', and you can set the custom amount of darts to be thrown!");
        return;
    }

    private static void errorMessageCustomDarts() {
        System.out.println("Positive integer values only for darts");
    }
}