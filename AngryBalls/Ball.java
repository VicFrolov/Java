public class Ball {

    private double radius;
    private Vector location;
    private Vector initialVelocity;
    
    public Ball(double radius, Vector location, Vector initialVelocity) {
        this.radius = radius;
        this.location = location;
        this.initialVelocity = initialVelocity;
    }

    public Vector getLocation() {
        return location;
    }

    public double getRadius() {
        return radius;
    }

    public void accelerate(Vector acceleration, double grain) {
        // implement me
    }

    public void move(double grain) {
        // Implement me!
    }

}
