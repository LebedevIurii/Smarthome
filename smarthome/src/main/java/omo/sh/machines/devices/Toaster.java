package omo.sh.machines.devices;

import omo.sh.house.Room;
import omo.sh.machines.devices.utils.Device;

/**
 * Class represents toaster in Smart home.
 */
public class Toaster extends Device {

    /**
     * Class constructor.
     *
     * @param name of new device
     * @param machineRoom in which add new device
     */
    public Toaster(String name, Room machineRoom) {
        super(name, machineRoom);
    }
}
