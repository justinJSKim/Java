/**
 * Created by justinkim on 2016-09-30.
 */
public class Square implements Shape{
    private double length;

    //Constructor
    public Square(double value){
        length=value;
    }

    //Interface Implementations
    public double getPerimeter() {
        double result;
        result = 4 * length;
        return result;
    }

    //Override functions of Object Superclass
    @Override
    public String toString(){
        return getClass().getName() + "{l=" + length + "} has perimeter: " + getPerimeter();
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(length);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public boolean equals(Object obj) {
        return this.getClass().equals(obj.getClass());
    }
}
