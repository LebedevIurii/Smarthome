package omo.sh.machines.devices;

import omo.sh.house.Room;
import omo.sh.machines.devices.utils.Device;

/**
 * Class represents blind window in Smart home.
 */
public class BlindWindow extends Device {

    /**
     * Class constructor.
     *
     * @param name of new device
     * @param machineRoom in which add new device
     */
    public BlindWindow(String name, Room machineRoom) {
        super(name, machineRoom);
    }
}
