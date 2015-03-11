public class AngryBallsSimulation {

    private static boolean errorMessageTest;

    public static String errorMessage() {
        return "Usage:java AngryBallsSimulation <red radius>" + 
        " <red x> <red y> <red velocity x> <red velocity y> <blue radius>" +
        "<blue x> <blue y> <blue velocity x> <blue velocity y> [ <grain> ]\n" +
        "All sizes are in meters and the grain is in seconds. The grain is optional and defaults to 1 second if not supplied.";
    }

    public static void main(String[] args) {
        

        if(args.length == 0 || errorMessageTest) {
            System.out.println(errorMessage());
            return;
        }

        Vector redLocation = new Vector(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
        Vector redVelocity = new Vector(Double.parseDouble(args[3]), Double.parseDouble(args[4]));
        Vector blueLocation = new Vector(Double.parseDouble(args[6]), Double.parseDouble(args[7]));
        Vector blueVelocity = new Vector(Double.parseDouble(args[8]), Double.parseDouble(args[9]));

        Ball red = new Ball(Double.parseDouble(args[0]), redLocation, redVelocity);
        Ball blue = new Ball(Double.parseDouble(args[5]), blueLocation, blueVelocity);
      }
}