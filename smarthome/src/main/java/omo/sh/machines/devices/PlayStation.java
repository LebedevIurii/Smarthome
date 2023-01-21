package omo.sh.machines.devices;

import omo.sh.house.Room;
import omo.sh.machines.devices.utils.Device;

/**
 * Class represents playStation in Smart home.
 */
public class PlayStation extends Device {

    /**
     * Class constructor.
     *
     * @param name of new device
     * @param machineRoom in which add new device
     */
    public PlayStation(String name, Room machineRoom) {
        super(name, machineRoom);
    }
}
