package omo.sh.machines.state;

import omo.sh.SimulationTime;
import omo.sh.machines.Machine;

/**
 * Class represents machines' states.
 */
public abstract class MachineState {

    /**
     * */
    private final Machine machine;

    /**
     * Class constructor.
     *
     * @param machine that has state
     */
    public MachineState(Machine machine) {
        this.machine = machine;
    }

    /**
     * @return machine
     */
    public Machine getMachine() {
        return machine;
    }

    /**
     * @param begin event time
     * @param end event time
     * @return true if nachine has state turnOn
     *          false otherwise
     */
    public abstract boolean turnOn(SimulationTime begin, SimulationTime end);

    /**
     * @param begin event time
     * @param end event time
     * @return true if nachine has state turnOff
     *          false otherwise
     */
    public abstract boolean turnOff(SimulationTime begin, SimulationTime end);

    /**
     * @param begin event time
     * @param end event time
     * @return true if nachine has state use
     *          false otherwise
     */
    public abstract boolean use(SimulationTime begin, SimulationTime end);

    /**
     * @param begin event time
     * @param end event time
     * @return true if nachine has state broken
     *          false otherwise
     */
    public abstract boolean broke(SimulationTime begin, SimulationTime end);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}
