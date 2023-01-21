package omo.sh.creatures;

import omo.sh.SimulationTime;
import omo.sh.creatures.behavior.Behavior;
import omo.sh.house.Room;

/**
 * Interface represents Creature.
 * Creatures are animals and people in Smart Home.
*/
public interface Creature {

    /**
     * Gets room in which creature (animal or person) is now.
     *
     * @return specific room
     */
    Room getRoom();

    /**
     * Moves creature (animal or person) to anither room.
     *
     * @return true if creature successfully moved to specified room
     *         false otherwise
     */
    boolean move(Room room, SimulationTime begin, SimulationTime end);

    /**
     * Returns creature's behaior.
     */
    Behavior getBehavior();

    /**
     * Returns creature's name.
     */
    String  getName();
}
