/**
 * Created by justinkim on 2016-11-19.
 */
class MobileDevice {

    String       deviceName;  // the device name
    int          valueTag;    // an integer between -100 and 100
    Lab          lab;         // the lab having this device it its inventory
    RentSettings rs;          // rent settings

    public MobileDevice() {
        deviceName="";
        valueTag=0;
        lab=new Lab();
        try {
            rs = new RentSettings();
        }
        catch (DateFormatException d){
            System.out.println("You must enter a correct date format.");
        }
    }

    public MobileDevice(String device, int value) {
        //TODO
        deviceName=device;
        valueTag=value;
        lab=new Lab();
        try {
            rs = new RentSettings();
        }
        catch (DateFormatException d){
            System.out.println("You must enter a correct date format.");
        }
    }

    /**
     *  This are the core @Overrides for the class MobileDevice.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MobileDevice that = (MobileDevice) o;

        if (valueTag != that.valueTag) return false;
        return deviceName != null ? deviceName.equals(that.deviceName) : that.deviceName == null;

    }

    @Override
    public int hashCode() {
        int result = deviceName != null ? deviceName.hashCode() : 0;
        result = 31 * result + valueTag;
        return result;
    }

    @Override
    public String toString() {

        String s = "(" + deviceName + ", " + valueTag + " =>  " +
                lab.labName + ") RentSettings(" + rs + ')';
        //TODO
        return s;
    }

    /**
     *  This simply sets the lab of the device
     * @param labSet
     *          The lab you want to set the device to.
     */
    public void setLab(Lab labSet) {
        //TODO
        lab=labSet;
    }


    /**
     *  This function receives a request to rent the device and then sets the RentSettings object accordingly
     *
     * @param rentDate
     *          Date that the device is rented.
     * @param dueDate
     *          Date that the device is due.
     * @param lab
     *          Lab that the object is rented from.
     * @return
     *      Returns true if the settings have been changed.
     */
    // set the rent dates; if dates are not valid catch DateFormatException and return false,
    // if rentDate > dueDate catch RentPeriodException and return false
    // if one the exceptions occur there is no RentSettings object
    public boolean rentDevice(String rentDate, String dueDate, Lab lab) {

    //TODO
        try {

            if(Helper.timeDifference(rentDate, dueDate) < 0){
                throw new RentPeriodException(dueDate + "cannot be earlier than " + rentDate);
            }
                this.rs = new RentSettings(rentDate, dueDate, lab);
                return true;

        } catch (DateFormatException d){
            System.out.println(d);
            return false;

        } catch (RentPeriodException r){
            System.out.println(r);
            return false;
        }

    }

    /**
     *  This function resets the RentSettings object and allows the device to be rented again.
     * @param lab
     *          The lab that the device was returned to.
     */

    // destroy the RentSettings object for this device
    public void returnDevice(Lab lab) {
        //TODO

        for (MobileDevice d : lab.devices) {
            if(this.equals(d)){
                this.rs.borrowed = false;
                this.rs.dueDate = "";
                this.rs.rentDate = "";
                System.out.println("You have returned the device to lab : " + lab.labName);
                break;
            }
        }
    }

    /**
     *  This function returns the date that the device is due. If available, it lets the user know.
     *
     * @param lab
     *          lab that device belongs to.
     * @return
     *      Returns a string that lets the user know when the device is available.
     */
    // return the date when this device is available
    public String availableDate(Lab lab) {
        //TODO
        if(this.lab == lab){
            if(this.rs.dueDate != null){
                return this.rs.dueDate;
            }
            else{
                String s = null;
                return s + "The device is available now!";
            }
        }
        else{
            return "The device is not in the lab.";
        }
    }

    /**
     *  This checks if the due date of the device is past the current date.
     *
     * @return
     *      Returns true if the current date is past dueDate.
     */
    // returns true if the current date is greater than the due date
    public boolean isDeviceOverdue() {
        //TODO
        try {
            if (Helper.timeDifference(Helper.getCurrentDate(), rs.dueDate) < 0){
                return true;
            }

        }catch(DateFormatException d){
            System.out.println("You must enter the correct date format.");
        }
        return false;
    }

    /**
     *  This check is the borrowed status of the device is true.
     *
     * @param l
     *      The lab that the device belongs to.
     *
     * @return
     *      Returns true if the device is borrowed.
     */
    public boolean isRented(Lab l) {
        //TODO

        for (MobileDevice d : l.devices) {
            if(this == d){
                return this.rs.borrowed;
            }
        }

        System.out.println("Could not find the device.");
        return false;
    }

    /**
     *  Returns the RentSettings object for the device.
     *
     */
    public RentSettings getRs() {
        //TODO
        return rs;
    }

    /**
     *  Sets the RentSettings object for the device.
     *
     * @param rentSet
     *          The dates that the device needs to be rented for.
     */
    public void setRs(RentSettings rentSet) {
        //TODO
        rs.rentDate=rentSet.rentDate;
        rs.dueDate=rentSet.dueDate;
        rs.borrowed=true;
    }


    /**
     *  Redundant toString function. Doesn't contain the rent settings.
     *
     */
    public String deviceName() {
        return "(" + deviceName + ", " + valueTag + ')';
    }


    /**
     *  Inner class for MobileDevice.
     *  No functions, two constructors depending on whether a device is rented or not.
     */
    private class RentSettings {

        private String rentDate;          // date when the item is requested
        private String dueDate;           // date when the item must be returned
        private boolean borrowed = false; // true if the item is rented

        //default ctr
        private RentSettings() throws DateFormatException {
            //TODO
                rentDate = "";
                dueDate = "";
                borrowed = false;
        }

        // private ctr must throw DateFormatException and RentPeriodException
        private RentSettings(String rent, String due, Lab lab) throws DateFormatException, RentPeriodException {
            //TODO

            rentDate=rent;
            dueDate=due;
            borrowed=true;
        }

        @Override
        public String toString() {
            return  "Rent date is: " + rentDate +
                    ", Due Date is: " + dueDate +
                    ", Lab name is: " + MobileDevice.this.lab.labName +
                    ", Borrowed status is: " + borrowed;
        }
    }
}
