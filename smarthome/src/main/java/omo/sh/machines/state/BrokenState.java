package omo.sh.machines.state;

import omo.sh.SimulationTime;
import omo.sh.machines.Machine;

/**
 * Class represents state of machine Broken which means that machine is broken,
 * doesn't work and required father's repair.
 */
public class BrokenState extends MachineState {

    /**
     * Class constructor.
     *
     * @param machine that has state
     */
    public BrokenState(Machine machine) {
        super(machine);
    }

    /**
     * @param begin event time
     * @param end event time
     * @return true if nachine has state turnOn
     *          false otherwise
     */
    @Override
    public boolean turnOn(SimulationTime begin, SimulationTime end) {
        MachineState state = new OnState(getMachine());
        getMachine().changeState(state, begin, end);
        return getMachine().getState() == state;
    }

    /**
     * @param begin event time
     * @param end event time
     * @return true if nachine has state turnOff
     *          false otherwise
     */
    @Override
    public boolean turnOff(SimulationTime begin, SimulationTime end) {
        return false;
    }

    /**
     * @param begin event time
     * @param end event time
     * @return true if nachine has state use
     *          false otherwise
     */
    @Override
    public boolean use(SimulationTime begin, SimulationTime end) {
        return false;
    }

    /**
     * @param begin event time
     * @param end event time
     * @return true if nachine has state broken
     *          false otherwise
     */
    @Override
    public boolean broke(SimulationTime begin, SimulationTime end) {
        return true;
    }
}
