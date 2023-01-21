package omo.sh.events;

import omo.sh.creatures.Creature;
import omo.sh.house.Room;
import omo.sh.machines.Machine;
import omo.sh.machines.devices.utils.Device;
import omo.sh.machines.state.*;
import omo.sh.machines.vehicles.util.Vehicle;

/**
 * Class represents event for a machine. Used to generate reports.
 */
public class MachineEvent extends Event {

    /**
     * Creature that uses machine.
     */
    private final Creature creature;

    /**
     * Machine itself.
     */
    private final Machine machine;

    /**
     * Type of the machine state.
     */
    private final MachineEventType type;

    /**
     * Class constructor. Depending on machine state sets machine event type.
     *
     * @param room in which event is happening
     * @param begin event time
     * @param end event time
     * @param creature who triggered event
     * @param machine which is
     */
    public MachineEvent(Room room, String begin, String end, Creature creature, Machine machine) {
        super(room, begin, end);
        this.creature = creature;
        this.machine = machine;
        if (machine.getState().getClass().equals(OnState.class)) {
            type = MachineEventType.SWICHEDON;
        }else if (machine.getState().getClass().equals(InUseState.class)){
            type = MachineEventType.USE;
        }else if (machine.getState().getClass().equals(BrokenState.class)){
            type = MachineEventType.CRASH;
        } else {
            type = MachineEventType.SWICHEDOFF;
        }
    }

    @Override
    public String toString() {
        switch (type) {
            case USE -> {
                return " || " + creature.toString() + " used " + machine.getName() + " in " + getRoom().getRoomType() + " ||: " + getBegin() + " -- " + getEnd() + "\n";
            }
            case SWICHEDON -> {
                String s = "";
                if(machine instanceof Vehicle){
                    s = " did something with ";
                } else if (machine instanceof Device){
                    s = " switched on ";
                }
                return " || " + creature.toString() +  s  + machine.getName() + " in " + getRoom().getRoomType() + " ||: " + getBegin() + " -- " + getEnd() + "\n";
            }
            case CRASH -> {
                return " || " + creature.toString() + " crashed " + machine.getName() + " in " + getRoom().getRoomType() + " ||: " + getBegin() + " -- " + getEnd() + "\n";
            }
            case SWICHEDOFF -> {
                String s = "";
                if(machine instanceof Vehicle){
                    s = " leave ";
                } else if (machine instanceof Device){
                    s = " switched off ";
                }
                return " || " + creature.toString() + s + machine.getName() + " in " + getRoom().getRoomType() + " ||: " + getBegin() + " -- " + getEnd() + "\n";
            }
        }
        return " || Nothing happens || ";
    }
}
