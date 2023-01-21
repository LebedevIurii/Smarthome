package omo.sh.machines.vehicles.util;

import omo.sh.house.Room;
import omo.sh.machines.Machine;

/**
 * Class represents vehicles in Smart home.
 */
public class Vehicle extends Machine {

    /**
     * Class constructor.
     *
     * @param name of new vehicle
     * @param machineRoom in which add new vehicle
     */
    public Vehicle(String name, Room machineRoom) {
        super(name, machineRoom);
    }
}
