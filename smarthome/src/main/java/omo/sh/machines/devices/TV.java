package omo.sh.machines.devices;

import omo.sh.house.Room;
import omo.sh.machines.devices.utils.Device;

/**
 * Class represents TV in Smart home.
 */
public class TV extends Device {

    /**
     * Class constructor.
     *
     * @param name of new device
     * @param machineRoom in which add new device
     */
    public TV(String name, Room machineRoom) {
        super(name, machineRoom);
    }
}
