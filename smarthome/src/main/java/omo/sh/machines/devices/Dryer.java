package omo.sh.machines.devices;

import omo.sh.house.Room;
import omo.sh.machines.devices.utils.Device;

/**
 * Class represents dryer in Smart home.
 */
public class Dryer extends Device {

    /**
     * Class constructor.
     *
     * @param name of new device
     * @param machineRoom in which add new device
     */
    public Dryer(String name, Room machineRoom) {
        super(name, machineRoom);
    }
}
