package omo.sh.creatures.persons;

import omo.sh.SimulationTime;
import omo.sh.creatures.behavior.Behavior;
import omo.sh.creatures.persons.utils.Person;
import omo.sh.house.Room;
import omo.sh.machines.Machine;
import omo.sh.machines.state.BrokenState;

import java.util.Objects;

/**
 * Class represents father in Smart Home.
 */
public class Father extends Person {

    /**
     * Class constructor.
     *
     * @param name person's name
     * @param behavior person's behavior
     * @param room in which person is
     */
    public Father(String name, Behavior behavior, Room room) {
        super(name, behavior, room);
    }

    /**
     * Repairs machine with new generated manual for it.
     *
     * @param machine to repair
     */
    public void repair(Machine machine, SimulationTime begin, SimulationTime end){
        Objects.requireNonNull(machine);
        if (machine.getState().getClass() == BrokenState.class){
            machine.generateManual();
            machine.getState().turnOn(begin, end);
        }
    }
}
