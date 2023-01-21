package omo.sh.machines.devices;

import omo.sh.house.Room;
import omo.sh.machines.devices.utils.Device;

/**
 * Class represents PC in Smart home.
 */
public class PC extends Device {

    /**
     * Class constructor.
     *
     * @param name of new device
     * @param machineRoom in which add new device
     */
    public PC(String name, Room machineRoom) {
        super(name, machineRoom);
    }
}
