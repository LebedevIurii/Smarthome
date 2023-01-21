package omo.sh.machines.devices;

import omo.sh.house.Room;
import omo.sh.machines.devices.utils.Device;

/**
 * Class represents garage doors in Smart home.
 */
public class GarageDoors extends Device {

    /**
     * Class constructor.
     *
     * @param name of new device
     * @param machineRoom in which add new device
     */
    public GarageDoors(String name, Room machineRoom) {
        super(name, machineRoom);
    }
}
