/**
 * Created by justinkim on 2016-09-30.
 */
public class Triangle implements Shape{
    private double a;
    private double b;
    private double c;

    //Constructor
    public Triangle(double value1, double value2, double value3){
        a=value1;
        b=value2;
        c=value3;
    }

    //Interface Implementations
    public double getPerimeter() {
        double result;
        result = a+b+c;
        return result;
    }

    //Override functions of Object Superclass
    @Override
    public String toString(){
        return getClass().getName() + "{a=" + a + ", b=" + b + ", c=" + c + "} has perimeter: " + getPerimeter();
    }
    @Override
    public boolean equals(Object obj) {
        return this.getClass().equals(obj.getClass());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(a);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(b);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(c);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
