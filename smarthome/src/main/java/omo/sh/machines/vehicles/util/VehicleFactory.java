package omo.sh.machines.vehicles.util;

import omo.sh.house.Room;
import omo.sh.machines.vehicles.Auto;
import omo.sh.machines.vehicles.Bike;
import omo.sh.machines.vehicles.Moto;

/**
 * Class represents vehicle factory and is used to create specific vehicle.
 */
public class VehicleFactory {

    /**
     * Creates new auto in given room.
     *
     * @param machineRoom in which create new vehicle
     */
    public Vehicle createAuto(Room machineRoom){
        return new Auto("Auto", machineRoom);
    }

    /**
     * Creates new moto in given room.
     *
     * @param machineRoom in which create new vehicle
     */
    public Vehicle createMoto(Room machineRoom){
        return  new Moto("Moto", machineRoom);
    }

    /**
     * Creates new bike in given room.
     *
     * @param machineRoom in which create new vehicle
     */
    public  Vehicle createBike(Room machineRoom){
        return  new Bike("Bike", machineRoom);
    }
}
