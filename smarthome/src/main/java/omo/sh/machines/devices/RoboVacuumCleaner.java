package omo.sh.machines.devices;

import omo.sh.house.Room;
import omo.sh.machines.devices.utils.Device;

/**
 * Class represents vacuum cleaner in Smart home.
 */
public class RoboVacuumCleaner extends Device {

    /**
     * Class constructor.
     *
     * @param name of new device
     * @param machineRoom in which add new device
     */
    public RoboVacuumCleaner(String name, Room machineRoom) {
        super(name, machineRoom);
    }
}
