public class AngryBallsSimulation {

    public static String errorMessage() {
        return "Usage:java AngryBallsSimulation <red radius>" + 
        " <red x> <red y> <red velocity x> <red velocity y> <blue radius>" +
        "<blue x> <blue y> <blue velocity x> <blue velocity y> [ <grain> ]\n" +
        "All sizes are in meters and the grain is in seconds. The grain is optional and defaults to 1 second if not supplied.";
    }

    public static void createBalls() {

    }

    public static void main(String[] args) {
        double valueCheck;
        double grainCheck;
        boolean collideCheck = false;
        double redBallXValueCollide = 0;
        double redBallYValueCollide = 0;
        double blueBallXValueCollide = 0;
        double blueBallYValueCollide = 0;
        //Making sure the user inputs are valid
        if(args.length == 0) {
            System.out.println(errorMessage());
            return;
        } else if(args.length != 10 && args.length != 11) {
            System.out.println("The arguments supplied do not match what AngryBalls Simulation expects. ");
            System.out.println(errorMessage());
            return;
        }

        for(int i = 0; i < args.length; i ++) {
            try {
                valueCheck = Double.parseDouble(args[i]);

            } catch(NumberFormatException nfe) {
                System.out.println("The arguments supplied do not match what AngryBalls Simulation expects. ");
                System.out.println(errorMessage());
                return;
            }
        }

        //creating Balls
        Vector redLocation = new Vector(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
        Vector redVelocity = new Vector(Double.parseDouble(args[3]), Double.parseDouble(args[4]));
        Vector blueLocation = new Vector(Double.parseDouble(args[6]), Double.parseDouble(args[7]));
        Vector blueVelocity = new Vector(Double.parseDouble(args[8]), Double.parseDouble(args[9]));

        Ball redBall = new Ball(Double.parseDouble(args[0]), redLocation, redVelocity);
        Ball blueBall = new Ball(Double.parseDouble(args[5]), blueLocation, blueVelocity);

        //Setting the grain (time slices)
        if(args.length == 11) {
            grainCheck = Double.parseDouble(args[10]);
        } else {
            grainCheck = 1.0;
        }

        //moving the balls, and the third if checks whether they collided
        while(redBall.getLocation().y() > 0 || blueBall.getLocation().y() > 0) {
            if(redBall.getLocation().y() >0) {
                redBall.move(grainCheck);
                redBall.accelerate(new Vector(0, -9.8), grainCheck);
            }
           
            if(blueBall.getLocation().y() >0) {
                blueBall.move(grainCheck);
                blueBall.accelerate(new Vector(0, -9.8), grainCheck);
            }

            if(redBall.collide(blueBall)) {
                redBallXValueCollide = redBall.getLocation().x();
                redBallYValueCollide = redBall.getLocation().y();
                blueBallXValueCollide = blueBall.getLocation().x();
                blueBallYValueCollide = blueBall.getLocation().y();
                collideCheck = true;
            }

            System.out.println(redBall.getRadius() + " " + redBall.getLocation().x() + " " + redBall.getLocation().y() +
            " " + blueBall.getRadius() + " " + blueBall.getLocation().x() + " " + blueBall.getLocation().y());
        }
        System.out.println("end");

        //output whether balls touched or not
        if(collideCheck){
            System.out.println("The balls collided at timestamp t with the red ball at (" + redBallXValueCollide +
                ", " + redBallYValueCollide + ") and the blue ball at (" + blueBallXValueCollide + ", " + blueBallYValueCollide + ").");
        } else {
            System.out.println("The balls did not collide.");
        }        
    }
}