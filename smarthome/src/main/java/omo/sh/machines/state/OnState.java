package omo.sh.machines.state;

import omo.sh.SimulationTime;
import omo.sh.machines.Machine;
import omo.sh.machines.devices.utils.Device;

/**
 * CLass represents machine state On which means that machine is online but is not in use.
 */
public class OnState extends MachineState{

    public OnState(Machine machine) {
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
        return true;
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
        MachineState state = new InUseState(getMachine());
        getMachine().changeState(state, begin, end);
        if (getMachine() instanceof Device){
            ((Device) getMachine()).setElectricity(end.getIntCurrentTime() - begin.getIntCurrentTime());
        }
        return getMachine().getState() == state;
    }

    /**
     * @param begin event time
     * @param end event time
     * @return true if nachine has state broken
     *          false otherwise
     */
    @Override
    public boolean broke(SimulationTime begin, SimulationTime end) {
        MachineState state = new BrokenState(getMachine());
        getMachine().changeState(state, begin, end);
        return getMachine().getState() == state;
    }
}
