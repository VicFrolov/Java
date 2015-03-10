public class AngryBallsSimulation {

    public static void String EWrrorCode() {
        System.out.println("The arguments supplied do not match what AngryBallsSimulation expects.");
        System.out.println("Usage: java AngryBallsSimulation <red radius> <red x> <red y> <red velocity x> <red velocity y> <blue radius> <blue x> <blue y> <blue velocity x> <blue velocity y> [ <grain> ]");
    }

    public static void main(String[] args) {
        Vector redLocation = (parseInt(args[1]), parseInt(args[2]));
        Vector redVelocity = (praseInt(args[4]), praseInt([args[5]));
        Vector blueLocation = (parseInt(args[7]), parseInt(args[8]));
        Vector blueVelocity = (praseInt(args[9]), praseInt([args[10]));

        Ball red = new Ball(parseInt(args[0]), redLocation, redVelocity);
        Ball blue = new Ball(parseInt(args[6]), blueLocation, blueVelocity);

      }
}