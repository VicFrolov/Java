public class Ball {

    private double radius;
    private Vector location;
    private Vector velocity;
    private Vector acceleration;
    private double grain;
    
    public Ball(double radius, Vector location, Vector initialVelocity) {
        this.radius = radius;
        this.location = location;
        this.velocity = initialVelocity;
    }

    public Vector getLocation() {
        return this.location;
    }

    public double getRadius() {
        return this.radius;
    }

    public Vector getVelocity() {
        return this.velocity;
    }

    public static boolean equals(Vector a, Vector b) {
        if (a.x() == b.x() && a.y() == b.y()) {
            return true;
        } else {
            return false;
        }
    }

    public void accelerate(Vector acceleration, double grain) {
        this.velocity = this.velocity.add(acceleration.scale(grain));
    }

    public void move(double grain) {
        this.location = this.location.add(this.velocity.scale(grain));
    }
}
