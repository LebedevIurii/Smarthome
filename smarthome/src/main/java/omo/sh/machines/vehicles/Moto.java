package omo.sh.machines.vehicles;

import omo.sh.house.Room;
import omo.sh.machines.vehicles.util.Vehicle;

/**
 * Class represents moto in Smart home.
 */
public class Moto extends Vehicle {

    /**
     * Class constructor.
     *
     * @param name of new vehicle
     * @param machineRoom in which add new vehicle
     */
    public Moto(String name, Room machineRoom) {
        super(name, machineRoom);
    }
}
