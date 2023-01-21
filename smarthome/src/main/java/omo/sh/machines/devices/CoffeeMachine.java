package omo.sh.machines.devices;

import omo.sh.house.Room;
import omo.sh.machines.devices.utils.Device;

/**
 * Class represents coffee machine in Smart home.
 */
public class CoffeeMachine extends Device {

    /**
     * Class constructor.
     *
     * @param name of new device
     * @param machineRoom in which add new device
     */
    public CoffeeMachine(String name, Room machineRoom) {
        super(name, machineRoom);
    }
}
