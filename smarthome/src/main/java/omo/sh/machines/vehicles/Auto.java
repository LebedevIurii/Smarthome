package omo.sh.machines.vehicles;

import omo.sh.house.Room;
import omo.sh.machines.vehicles.util.Vehicle;

/**
 * Class represents auto in Smart home.
 */
public class Auto extends Vehicle {

    /**
     * Class constructor.
     *
     * @param name of new vehicle
     * @param machineRoom in which add new vehicle
     */
    public Auto(String name, Room machineRoom) {
        super(name, machineRoom);
    }
}
