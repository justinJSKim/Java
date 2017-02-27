import java.util.Iterator;

public class Main {

    public static void main(String[] args) {


        /* TASK 1 - build labs from files - at least two labs */

        System.out.println("\n\n *" + " TASK 1 " + "*");
        //TODO

        Labs labs = new Labs(2);
        labs.labs[0] = labs.buildLabFromFile("Seneca@York", args[0]);
        Lab york = labs.labs[0];

        labs.labs[1] = labs.buildLabFromFile("Newnham", args[1]);
        Lab newnham = labs.labs[1];


        MobileDevice test = new MobileDevice("iPhone", 45);

        york.rentRequest(test, "11/25/2016", "12/10/2016");
        System.out.println(york);
        System.out.println(newnham);

        /* TASK 2 - ask for a device that is not in any lab inventory */

        System.out.println("\n\n *" + " TASK 2 " + "*");
        //TODO
        MobileDevice test2 = new MobileDevice("Unknown", 0);
        york.rentRequest(test2, "11/25/2016", "12/10/2016");


         /* TASK 3 - ask for a device that is in a lab inventory
         *  issue a rent request and print the device
         *  issue the same rent request and print the device
         *  return the device
         *  issue the rent request with new dates and print the device
         */
        System.out.println("\n\n *" + " TASK 3 " + "*");
        //TODO

        MobileDevice test3 = new MobileDevice("Android", 53);
        newnham.isThereDevice(test3);
        newnham.rentRequest(test3, "11/25/2016", "12/14/2016");
        newnham.rentRequest(test3, "11/25/2016", "12/14/2016");
        test3.returnDevice(newnham);
        newnham.rentRequest(test3, "11/30/2016", "12/20/2016");
        System.out.println(test3);

         /* TASK 4 - ask for the same device in all labs
          * if you can find a lab, rent the device from that lab
          */
        //TODO
        System.out.println("\n\n *" + " TASK 4 " + "*");
        labs.isThereDeviceInLabs(test3);
        labs.rentDeviceAvailable(test3, "11/30/2016", "12/20/2016");

        /* TASK 5 - calculate maximum value tag for each lab
        * */
        //TODO

        System.out.println("\n\n *" + " TASK 5 " + "*");
        int[] max = new int[10];
        for (int i = 0; i < labs.labs.length; i++) {
            max[i] = labs.labs[i].findMaximumValueTag();
        }

        System.out.println("The maximum value tag for all the labs is " + Finder.findMaximumValueTag(max));


        /* TASK 6 - inquire about a device
        *
        * */
        System.out.println("\n\n *" + " TASK 6 " + "*");
        //TODO
        MobileDevice test4 = new MobileDevice("iPhone", 45);
        labs.isThereDeviceInLabs(test4);
        labs.rentDeviceAvailable(test4, "01/03/1983", "06/06/2016");

    }
}
