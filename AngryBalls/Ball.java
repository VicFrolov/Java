public class Ball {

    private double radius;
    private Vector location;
    private Vector velocity;
    private Vector acceleration;
    private double grain;
    private double gravity = -9.8;
    
    public Ball(double radius, Vector location, Vector initialVelocity) {
        this.radius = radius;
        this.location = location;
        this.velocity = initialVelocity;
    }

    public Vector getLocation() {
        return location;
    }

    public double getRadius() {
        return radius;
    }

    public Vector getVelocity() {
        return velocity;
    }

    public static boolean equals(Vector a, Vector b) {
        if (a.x() == b.x() && a.y() == b.y()) {
            return true;
        } else {
            return false;
        }
    }

    public void accelerate(Vector acceleration, double grain) {

        velocity = velocity.add(acceleration.scale(grain));

    }

    public void move(double grain) {
        // Implement me!
    }

}
