package omo.sh.machines.devices.utils;

import omo.sh.house.Room;
import omo.sh.machines.devices.*;

/**
 * Class represents device factory and is used to create specific device.
 */
public class DeviceFactory {

    /**
     * Creates new aquarium in given room.
     *
     * @param machineRoom in which create new device
     * @return new created device
     */
    public Device createAquarium(Room machineRoom){
        return new Aquarium("Aquarium", machineRoom);
    }

    /**
     * Creates new blind window in given room.
     *
     * @param machineRoom in which create new device
     * @return new created device
     */
    public Device createBlindWindow(Room machineRoom){
        return new BlindWindow("BlindWindow", machineRoom);
    }

    /**
     * Creates new coffee machine in given room.
     *
     * @param machineRoom in which create new device
     * @return new created device
     */
    public Device createCoffeeMachine(Room machineRoom){
        return new CoffeeMachine("CoffeeMachine", machineRoom);
    }

    /**
     * Creates new conditioner in given room.
     *
     * @param machineRoom in which create new device
     * @return new created device
     */
    public Device createConditioner(Room machineRoom){
        return new Conditioner("Conditioner", machineRoom);
    }

    /**
     * Creates new dishwasher in given room.
     *
     * @param machineRoom in which create new device
     * @return new created device
     */
    public Device createDishwasher(Room machineRoom){
        return new Dishwasher("Dishwasher", machineRoom);
    }

    /**
     * Creates new dryer in given room.
     *
     * @param machineRoom in which create new device
     * @return new created device
     */
    public Device createDryer(Room machineRoom){
        return new Dryer("Dryer", machineRoom);
    }

    /**
     * Creates new feeder in given room.
     *
     * @param machineRoom in which create new device
     * @return new created device
     */
    public Device createFeeder(Room machineRoom){
        return new Feeder("Feeder", machineRoom);
    }

    /**
     * Creates new fridge in given room.
     *
     * @param machineRoom in which create new device
     * @return new created device
     */
    public Device createFridge(Room machineRoom){
        return new Fridge("Fridge", machineRoom);
    }

    /**
     * Creates new garage doors in given room.
     *
     * @param machineRoom in which create new device
     * @return new created device
     */
    public Device createGarageDoors(Room machineRoom){
        return new GarageDoors("GarageDoors", machineRoom);
    }

    /**
     * Creates new hairdryer in given room.
     *
     * @param machineRoom in which create new device
     * @return new created device
     */
    public Device createHairdryer(Room machineRoom){
        return new Hairdryer("Hairdryer", machineRoom);
    }

    /**
     * Creates new laptop in given room.
     *
     * @param machineRoom in which create new device
     * @return new created device
     */
    public Device createLaptop(Room machineRoom){
        return new Laptop("Laptop", machineRoom);
    }

    /**
     * Creates new oven in given room.
     *
     * @param machineRoom in which create new device
     * @return new created device
     */
    public Device createOven(Room machineRoom){
        return new Oven("Oven", machineRoom);
    }

    /**
     * Creates new PC in given room.
     *
     * @param machineRoom in which create new device
     * @return new created device
     */
    public Device createPC(Room machineRoom){
        return new PC("PC", machineRoom);
    }

    /**
     * Creates new PlayStation in given room.
     *
     * @param machineRoom in which create new device
     * @return new created device
     */
    public Device createPlayStation(Room machineRoom){
        return new PlayStation("PlayStation", machineRoom);
    }

    /**
     * Creates new vacuum cleaner in given room.
     *
     * @param machineRoom in which create new device
     * @return new created device
     */
    public Device createRoboVacuumCleaner(Room machineRoom){
        return new RoboVacuumCleaner("RoboVacuumCleaner", machineRoom);
    }

    /**
     * Creates new router in given room.
     *
     * @param machineRoom in which create new device
     * @return new created device
     */
    public Device createRouter(Room machineRoom){
        return new Router("Router", machineRoom);
    }

    /**
     * Creates new toaster in given room.
     *
     * @param machineRoom in which create new device
     * @return new created device
     */
    public Device createToaster(Room machineRoom){
        return new Toaster("Toaster", machineRoom);
    }

    /**
     * Creates new TV in given room.
     *
     * @param machineRoom in which create new device
     * @return new created device
     */
    public Device createTV(Room machineRoom){
        return new TV("TV", machineRoom);
    }

    /**
     * Creates new WashingMachine in given room.
     *
     * @param machineRoom in which create new device
     * @return new created device
     */
    public Device createWashingMachine(Room machineRoom){
        return new WashingMachine("WashingMachine", machineRoom);
    }
}
