package omo.sh.reports;

import omo.sh.house.Floor;
import omo.sh.house.Room;
import omo.sh.machines.devices.utils.Device;

import java.util.ArrayList;

/**
 * Class represents iterator which goes through all devices and gets their consumption's measurements.
 * Used to generate resoure report.
 */
public class ResourceIterator {

    /**
     * Current device on which iterator now is.
     */
    private Device currDevice;

    /**
     * Index of the last outputed device.
     */
    private int lastDeviceIndex;

    /**
     * Current room.
     */
    private int currRoom;

    /**
     * List of all floors in house.
     */
    private final ArrayList<Floor> floorsCollection;

    /**
     * Shows if there is next device.
     */
    private boolean hasNext;

    /**
     * Class constructor.
     *
     * @param floorsCollection for iterator
     */
    public ResourceIterator(ArrayList<Floor> floorsCollection) {
        this.floorsCollection = floorsCollection;
    }

    /**
     * Explores if there is next device.
     *
     * @return hasNext
     */
    public boolean hasNext(){
        if (currDevice == null){
            return true;
        }
        Floor currFloor = floorsCollection.get(currDevice.getRoom().getFloorNumber());
        if ((currDevice.getRoom().getFloorNumber() == floorsCollection.size()) &&
                (currDevice.getRoom() == currFloor.getRoomByID(currFloor.getRoomsOnFloor().size()-1)) &&
                    (currDevice != currDevice.getRoom().getMachinesInRoom().get(currDevice.getRoom().getMachinesInRoom().size()-1))){
                return false;
        } else {
            return hasNext;
        }
    }

    /**
     * Switches iterator to next device.
     *
     * @return new current device
     */
    public Device next(){
        if (currDevice == null){
            for (Floor floor : floorsCollection) {
                for (int i = 0; i < floor.getRoomsOnFloor().size(); i++) {
                    var machines = floor.getRoomsOnFloor().get(i).getMachinesInRoom();
                    for (int j = 0; j < machines.size(); j++) {
                        if (machines.get(j) instanceof Device){
                            hasNext = true;
                            currDevice = (Device) machines.get(j);
                            currRoom = i;
                            lastDeviceIndex = j;
                            return currDevice;
                        }
                    }
                }
            }
        } else {
            if (currDevice == currDevice.getRoom().getMachinesInRoom().get(currDevice.getRoom().getMachinesInRoom().size() - 1)){
                int floor = currDevice.getRoom().getFloorNumber();
                if (++currRoom >= floorsCollection.get(floor).getRoomsOnFloor().size()){
                    if (floor == floorsCollection.size()){
                        this.hasNext = false;
                        return null;
                    } else{
                        if (floor + 1 < floorsCollection.size()){
                            var rooms = floorsCollection.get(++floor).getRoomsOnFloor();
                            for (int i = 0; i < rooms.size(); i++) {
                                var machines = rooms.get(i).getMachinesInRoom();
                                for (int j = 0; j < machines.size(); j++) {
                                    if (machines.get(j) instanceof Device){
                                        currDevice = (Device) machines.get(j);
                                        currRoom = i;
                                        lastDeviceIndex = j;
                                        return currDevice;
                                    }
                                }
                            }
                        }
                    }
                } else {
                    var rooms = floorsCollection.get(floor).getRoomsOnFloor();
                    for (int i = currRoom; i < rooms.size(); i++) {
                        var machines = rooms.get(i).getMachinesInRoom();
                        for (int j = 0; j < machines.size(); j++) {
                            if (machines.get(j) instanceof Device){
                                currDevice = (Device) machines.get(j);
                                currRoom = i;
                                lastDeviceIndex = j;
                                return currDevice;
                            }
                        }
                    }
                }
            } else {
                for (int i = lastDeviceIndex + 1; i < currDevice.getRoom().getMachinesInRoom().size(); i++) {
                    if (currDevice.getRoom().getMachinesInRoom().get(i) instanceof Device){
                        currDevice = (Device) currDevice.getRoom().getMachinesInRoom().get(i);
                        lastDeviceIndex = i;
                        return currDevice;
                    }
                }
            }
            this.hasNext = false;
        }
        return null;
    }
}
