package omo.sh.machines.state;

import omo.sh.SimulationTime;
import omo.sh.machines.Machine;
import omo.sh.machines.devices.utils.Device;

/**
 * Class represents state of machine inUse which means that machine is being used and it is on.
 */
public class InUseState extends MachineState {
    public InUseState(Machine machine) {
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
        if (getMachine() instanceof Device){
            ((Device) getMachine()).setElectricity(end.getIntCurrentTime() - begin.getIntCurrentTime());
        }
        return false;
    }

    /**
     * @param begin event time
     * @param end event time
     * @return true if nachine has state turnOff
     *          false otherwise
     */
    @Override
    public boolean turnOff(SimulationTime begin, SimulationTime end) {
        MachineState state = new OffState(getMachine());
        getMachine().changeState(state, begin, end);
        return getMachine().getState() == state;
    }

    /**
     * @param begin event time
     * @param end event time
     * @return true if nachine has state use
     *          false otherwise
     */
    @Override
    public boolean use(SimulationTime begin, SimulationTime end) {
        if (getMachine() instanceof Device){
            ((Device) getMachine()).setElectricity(end.getIntCurrentTime() - begin.getIntCurrentTime());
        }
        return true;
    }

    /**
     * @param begin event time
     * @param end event time
     * @return true if nachine has state broken
     *          false otherwise
     */
    @Override
    public boolean broke(SimulationTime begin, SimulationTime end) {
        return false;
    }
}
