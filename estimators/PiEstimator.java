public class PiEstimator {
    static int timesHit = 0;
    static int timesMissed = 0;


    public static void dartThrow(int dartAmount) {
        double x = 0.0;
        double y = 0.0;

        System.out.println("start");

        for(int j = 0; j < dartAmount; j++) {
            boolean hit = false;
            x = Math.random() * 2.0 - 1.0;
            y = Math.random() * 2.0 - 1.0;
            hit = ((x*x + y*y) <= 1);

            if (Math.pow(x, 2.0) + Math.pow(y, 2.0) <= 1) {
                timesHit++;
            } else {
                timesMissed++;
            }

            System.out.print(x + " ");
            System.out.print(y);
            
            if (hit) {
                System.out.print(" " + "in\n");
            } else {
                System.out.print(" " + "out\n");
            }
        }
        
        System.out.println("end");

    }



    public static void main(String[] args) {

        if(args.length == 0) {
            dartThrow(10000);
        } else {
            dartThrow(Integer.parseInt(args[0]));
        }
    }

}