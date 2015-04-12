public class PiEstimator {
    private float timesHit = 0;
    private float timesMissed = 0;


    public static void dartThrow(int dartAmount) {
        double x = 0.0;
        double y = 0.0;

        for(int j = 0; j < dartAmount; j++) {
            x = Math.random() * 2.0 -1.0;
            y = Math.random() * 2.0 -1.0;
            System.out.println(x);
            System.out.println(y);

        }
    }



    public static void main(String[] args) {
        dartThrow(100);

    }   

}