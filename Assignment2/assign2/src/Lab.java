/**
 * Created by justinkim on 2016-11-19.
 *
 * This is the Lab class which handles the various functions for accessing, storing and retrieving Labs
 * that hold Mobile devices of various types.
 */
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

public class Lab implements MaxTagValue {


    String labName;
    Vector<MobileDevice> devices;

    public  Lab(){
        labName="";
        devices=new Vector<>();
    }
    public Lab(String name) {
        //TODO
        labName=name;
        devices=new Vector<>();
    }

    /** The following functions are the Overrides for the core functions of the class
    *
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lab lab = (Lab) o;

        if (labName != null ? !labName.equals(lab.labName) : lab.labName != null) return false;
        return devices != null ? devices.equals(lab.devices) : lab.devices == null;

    }

    @Override
    public int hashCode() {
        int result = labName != null ? labName.hashCode() : 0;
        result = 31 * result + (devices != null ? devices.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String s = labName + " [" + "\n";

        for(MobileDevice d : devices){
            s += "(" + d.deviceName + ", " + d.valueTag + " => " + labName + ") ";
            if(d.isRented(this)) {
                s += "RentSettings (" + d.rs + ")\n";
            }
            else{
                s += "\n";
            }
        }
        s += " ]";
        return s;
    }

    /**  This checks if a device is contained within the vector of the Lab.
    *   Returns true if it is there.
     */
    public boolean isThereDevice(MobileDevice md) {
        boolean found;
        //TODO
        found = devices.contains(md);
       if(found == true){
           System.out.println("There is a matching device in the lab: " + this.labName);
        }
        return found;
    }


    /**  Checks for the highest valueTag value in the vector of devices.
    *
     */

    public int findMaximumValueTag() {
        //TODO
        Iterator itr = devices.iterator();
        MobileDevice max = new MobileDevice();

        /*  Traverses through the vector and if there is a higher valueTag
        *   assigns it to max.
         */
        while(itr.hasNext()){
            MobileDevice next = (MobileDevice) itr.next();
            if(max.valueTag < next.valueTag) {
                max = next;
            }
        }
        return max.valueTag;
    }

    /**  Adds a MobileDevice element to the end of the devices vector.
    *
     */
    public void addDevice(MobileDevice md) {
        //TODO
        devices.addElement(md);
    }

    /**  This function checks to see if the request to rent a device is valid
    *   (device exists, dates valid, device available), and then issues the
    *   rent request for the user.
     */

    public boolean rentRequest(MobileDevice wanted, String requestDate, String dueDate) {

        //TODO

        try {
                /* Verifies that the due date is after the request date.
                *
                 */
                if (Helper.timeDifference(requestDate, dueDate) < 0) {
                    System.out.println("The due date is earlier than the rent date");
                    return false;
                }

                ListIterator itr = devices.listIterator();
                MobileDevice inventory = (MobileDevice) itr.next();

                /**  This if statement is required to check the first element of the vector.
                *   Used for the edge case otherwise the while loop will produce an
                *   exception.
                *
                *   The checks are they are the same device and that the device requested is available.
                 */
                if((inventory.equals(wanted)) && (!inventory.isRented(this))){
                    inventory.rentDevice(requestDate, dueDate, this);
                    wanted.rs = inventory.rs;
                    wanted.lab = inventory.lab;
                    System.out.println("The wanted device is available and has been rented to you from lab: " + inventory.lab.labName);
                    return true;
                }
                else if ((inventory.equals(wanted)) && (inventory.isRented(this))){
                    System.out.println("The wanted device is rented. ");
                    return false;
                }

                /**  The while loop iterates through the vector and checks each device.
                *   If there is a match and passes the checks, the device is rented and
                *   the rent settings in the vector object are updated.
                 */
                while(itr.hasNext()){

                   inventory = (MobileDevice) itr.next();

                    if(wanted.equals(inventory)){
                            if(inventory.isRented(this)) {
                            //checks for availability
                            System.out.println("The wanted device is rented. ");
                            return false;
                        }
                        else{
                                inventory.rentDevice(requestDate, dueDate, this);
                                wanted.rs = inventory.rs;
                                wanted.lab = inventory.lab;
                                System.out.println("The wanted device is available and has been rented to you from lab: " + inventory.lab.labName);
                                return true;
                        }
                    }
                }

        }
        catch(DateFormatException date){
            System.out.println("You must enter the correct date format mm/dd/yyyy.");
        }
        System.out.println("The device is not in the lab.");
        return false;
    }
}
