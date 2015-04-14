public class PiEstimator {
    private static final int DEFAULT_NUMBER_OF_DARTS = 10000;

    private static void errorMessage() {
        System.out.println("Enter no arguments for 10,000 darts to be thrown, and one positive numerical integer, of size 2,147,483,647 or less, for a custom amount of darts");
    }

    private void dartThrow(int dartAmount) {
        double timesHit = 0.0;
        double squaredArea = 4.0;

        System.out.println("start");
    
        for (int j = 0; j < dartAmount; j++) {
            
            double x = Math.random() * 2.0 - 1.0;
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
            " Pi estimate: " +  timesHit / dartAmount * squaredArea);
    }

    public static void main(String[] args) {
        int integerCheck;
        int numberOfDarts = DEFAULT_NUMBER_OF_DARTS;

        if (args.length > 1 || args.length == 1 && Integer.parseInt(args[0]) < 0) {
            errorMessage();
            return;
        }
        
        if (args.length == 1) {
            try {
                integerCheck = Integer.parseInt(args[0]);

            } catch (NumberFormatException nfe) {
                errorMessage();
                return;
            }
            numberOfDarts = Integer.parseInt(args[0]);
        }

        PiEstimator piEstimate = new PiEstimator();
        piEstimate.dartThrow(numberOfDarts);
        
    }

}