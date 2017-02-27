/**
 * Created by justinkim on 2016-09-30.
 */
public class Circle implements Shape {

    private double radius;

    //Constructor
    public Circle(double value){
        radius = value;
    }

    //Interface Implementations
    public double getPerimeter() {
        double result;
        result = 2 * 3.142 * radius;
        return result;
    }

    /*
    //bit testing
    public void bitTest(){
        long test;
        long temp = Double.doubleToLongBits(radius);
        System.out.println(temp);
        test = temp >>> 32;
        System.out.println(test);
        test = temp ^ (temp >>> 32);
        System.out.println(test);

    }
    */

    //Override functions of Object Superclass
    @Override
    public String toString(){
        return getClass().getName() + "{r=" + radius + "} has perimeter: " + getPerimeter();
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(radius);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public boolean equals(Object obj) {
        return this.getClass().equals(obj.getClass());
    }

}
