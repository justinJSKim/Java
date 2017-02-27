/**
 * Created by justinkim on 2016-11-19.
 *
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.Vector;

public class Labs {

    public Lab[] labs;        // a collection of labs of type array
    public int numberOfLabs;  // number of labs in collection
    private int count = 0;

    public Labs(int labNumber) {
        //TODO
        numberOfLabs=labNumber;
        labs = new Lab[labNumber];
    }

    /** The follow are the @Overrides for the class
     *
     */
    @Override
    public String toString() {
        return "Labs{" +
                "labs=" + Arrays.toString(labs) +
                ", numberOfLabs=" + numberOfLabs +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Labs labs1 = (Labs) o;

        if (numberOfLabs != labs1.numberOfLabs) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(labs, labs1.labs);

    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(labs);
        result = 31 * result + numberOfLabs;
        return result;
    }

    /**
     * This function builds a new lab from a file that contains a set of devices.
     *
     * @param labName
     *        Is the name you want for the lab.
     * @param labFileName
     *        Is the file that you are building the lab from.
     * @return
     *        Returns your new lab.
     */
    public Lab addDevicesToLab(String labName, String labFileName) {

        Lab lab = buildLabFromFile(labName, labFileName);
        System.out.println("Lab = " + labName + "\n[\n" + lab + "]");
        return lab;
    }

    /**
     *  This function builds a lab from a file that contains a list of devices.
     *
     * @param labName
     *          Name you want for the lab you are building.
     * @param fileName
     *          Name of file that you're using to build lab.
     * @return
     *          Returns your new lab.
     */
    public Lab buildLabFromFile(String labName, String fileName) {

        Lab lab = new Lab(labName);
        MobileDevice md;
        String s;


        try (BufferedReader br = new BufferedReader(new FileReader("./Root/" + fileName))) {

            while ((s = br.readLine()) != null) {
                //TODO
                    String[] device = s.split(",");
                    String dName = device[0];
                    int dValue = Integer.parseInt(device[1]);
                    md = new MobileDevice(dName, dValue);

                    md.setLab(lab);

                labs[count] = lab;
                labs[count].addDevice(md);

                }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        count++;
        return lab;
    }

    /**
     *  This function checks to see if a device is contained within any of the labs.
     *
     * @param md
     *       Is the device you're looking for.
     *
     * @return
     *      Returns a list of labs that contain the device.
     */
    public Lab isThereDeviceInLabs(MobileDevice md) {
        //TODO
        String s = "The device can be found in the following labs: ";
        for(int i = 0; i < numberOfLabs; i++){
            if(labs[i].isThereDevice(md)){
               s += "\n" + labs[i].labName;
            }
            else{
                s += "None";
            }
        }

        System.out.println(s);

        return null;
    }

    /**
     *  This function checks to see if a device is available at the requested dates.
     *
     * @param md
     *      Device that you are looking for.
     *
     * @param requestDate
     *      Date that you need the device.
     *
     * @param dueDate
     *      Date that you would like to return the device.
     *
     * @return
     *      Returns a lab that has the device available at the requested times.
     */
    public Lab rentDeviceAvailable(MobileDevice md, String requestDate, String dueDate) {

        Lab foundLab = null;

        int j;
        //TODO
        for(j = 0; j < numberOfLabs; j++){
            if(labs[j].devices.contains(md)){
                ListIterator itr = labs[j].devices.listIterator();
                MobileDevice avail = (MobileDevice) itr.next();
                if(md.equals(avail)){
                    try {
                        if (Helper.timeDifference(avail.availableDate(labs[j]), requestDate) < 0) {
                            System.out.println("The device is available at lab: " + labs[j].labName);
                            foundLab = labs[j];
                        }
                    }
                    catch (DateFormatException e){
                        System.out.println("The device is unavailable at lab: " + labs[j].labName);
                    }
                }
                else{
                    System.out.println("The device is unavailable at lab: " + labs[j].labName);
                }

            }
            else{
                System.out.println("The device is not in any of the labs.");
            }
        }
        return foundLab;
    }
}
