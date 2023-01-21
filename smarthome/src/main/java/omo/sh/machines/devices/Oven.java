package omo.sh.machines.devices;

import omo.sh.house.Room;
import omo.sh.machines.devices.utils.Device;

/**
 * Class represents oven in Smart home.
 */
public class Oven extends Device {

    /**
     * Class constructor.
     *
     * @param name of new device
     * @param machineRoom in which add new device
     */
    public Oven(String name, Room machineRoom) {
        super(name, machineRoom);
    }
}
