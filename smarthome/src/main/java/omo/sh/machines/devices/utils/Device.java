package omo.sh.machines.devices.utils;

import omo.sh.house.Room;
import omo.sh.machines.Machine;

/**
 * Class represents devices (such as eelectronic devices) in Smart home.
 */
public class Device extends Machine {

    /**
     * Elecrticity consumption.
     */
    private int electricity = 0;

    /**
     * Every tick continues 30 minutes.
     */
    private int minutesPerTick = 30;

    /**
     * @return electricity consumption for one tick in abstract units.
     */
    public int getElectricity() {
        return electricity * minutesPerTick;
    }

    /**
     * Sets electricity consumption.
     *
     * @param electricity to add to electricity
     */
    public void setElectricity(int electricity) {
        this.electricity += electricity;
    }

    /**
     * Class constructor.
     *
     * @param name of new device
     * @param machineRoom in which add new device
     */
    public Device(String name, Room machineRoom) {
        super(name, machineRoom);
    }
}
