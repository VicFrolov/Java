public class Vector {

    private double x;
    private double y;


    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double x() {
        return x;
    }
    
    public double y() {
        return y;
    }

    public Vector add(Vector v) {
        Vector sum = new Vector(x+v.x(),y + v.y());
        return sum;
    }

    public Vector scale(double magnitude) {
        Vector scaledG = new Vector(x * magnitude, y * magnitude);
        return scaledG;
    }

}
