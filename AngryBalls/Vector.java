public class Vector {

    private double x;
    private double y;


    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double x() {
        return this.x;
    }
    
    public double y() {
        return this.y;
    }

    public Vector add(Vector v) {
        Vector sum = new Vector(this.x+v.x(),this.y + v.y());
        return sum;
    }

    public Vector scale(double magnitude) {
        Vector scaledG = new Vector(this.x * magnitude, this.y * magnitude);
        return scaledG;
    }

}
