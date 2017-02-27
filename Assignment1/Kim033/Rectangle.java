
/**
 * Created by justinkim on 2016-09-30.
 */
public class Rectangle implements Shape {
    private double length;
    private double width;

    //Constructor
    public Rectangle(double value1, double value2){
        length=value1;
        width=value2;
    }

    //Interface Implementations
    public double getPerimeter() {
        double result;
        result = (2*length)+(2*width);
        return result;
    }

    //Override functions of Object Superclass
    @Override
    public String toString(){
        return getClass().getName() + "{l=" + length + ", w=" + width + "} has perimeter: " + getPerimeter();
    }
    @Override
    public boolean equals(Object obj) {
        return this.getClass().equals(obj.getClass());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(length);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(width);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
