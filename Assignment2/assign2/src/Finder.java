/**
 * Created by justinkim on 2016-11-19.
 *
 * This class has one function that receives an array of valueTag integers and finds the highest value.
 */

public class Finder {

    public static int findMaximumValueTag(int[] input) {

        int maxElement = -100;
        //TODO
        for(int i = 0; i < input.length; i++) {
            if(input[i] > maxElement){
                maxElement = input[i];
            }
        }
        return maxElement;
    }

}
