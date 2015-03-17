public class Ball {

    private double radius;
    private Vector location;
    private Vector velocity;
    private Vector acceleration;
    private double grain;
    private Ball ball;
    private Ball ballTwo;
    
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

    public static boolean equals(Vector a, Vector b) {
        return (a.x() == b.x() && a.y() == b.y());
    }

    public void accelerate(Vector acceleration, double grain) {
        this.velocity = this.velocity.add(acceleration.scale(grain));
    }

    public void move(double grain) {
        this.location = this.location.add(this.velocity.scale(grain));
    }

    public boolean collide(Ball otherBall) {
        double horizontalDistance = this.location.x() - otherBall.getLocation().x();
        double verticalDistance = this.location.y() - otherBall.getLocation().y();
        return Math.sqrt(Math.pow(horizontalDistance,2) + Math.pow(verticalDistance,2)) <= (this.radius + otherBall.getRadius()) ;
    }
}
