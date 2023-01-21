package omo.sh.machines.devices;

import omo.sh.house.Room;
import omo.sh.machines.devices.utils.Device;

/**
 * Class represents conditioner in Smart home.
 */
public class Conditioner extends Device {

    /**
     * Class constructor.
     *
     * @param name of new device
     * @param machineRoom in which add new device
     */
    public Conditioner(String name, Room machineRoom) {
        super(name, machineRoom);
    }
}

