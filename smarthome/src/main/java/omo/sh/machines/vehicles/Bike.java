package omo.sh.machines.vehicles;

import omo.sh.house.Room;
import omo.sh.machines.vehicles.util.Vehicle;

/**
 * Class represents bike in Smart home.
 */
public class Bike extends Vehicle {

    /**
     * Class constructor.
     *
     * @param name of new vehicle
     * @param machineRoom in which add new vehicle
     */
    public Bike(String name, Room machineRoom) {
        super(name, machineRoom);
    }
}
