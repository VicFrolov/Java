public class PiEstimator {
    private static double timesHit = 0.0;

    public static void dartThrow(int dartAmount) {
        double x = 0.0;
        double y = 0.0;
        int squareArea = 4;

        System.out.println("start");

        for (int j = 0; j < dartAmount; j++) {
            x = Math.random() * 2.0 - 1.0;
            y = Math.random() * 2.0 - 1.0;
            boolean hit = ((x*x + y*y) <= 1);

            System.out.print(x + " " + y);

            if (hit) {
                timesHit++;
                System.out.print(" " + "in\n");
            } else {
                System.out.print(" " + "out\n");
            }
        }
        
        System.out.println("end\n" + "Darts: " + dartAmount + " Hits: " + timesHit + 
            " Pi estimate: " +  timesHit / dartAmount * squareArea);
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            dartThrow(10000);
        } else {
            dartThrow(Integer.parseInt(args[0]));
        }
    }

}