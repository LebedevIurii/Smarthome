package omo.sh.creatures.animals;

import omo.sh.SimulationTime;
import omo.sh.creatures.animals.utils.Animal;
import omo.sh.creatures.behavior.Behavior;
import omo.sh.house.Room;

/**
 * Class represents golden fish in Smart Home.
 */
public class GoldenFish extends Animal {

    /**
     * Class constructor.
     *
     * @param name fish's name
     * @param behavior fish's behavior – always null, because fish does nothing
     * @param room in which fish is now
     */
    public GoldenFish(String name, Behavior behavior, Room room) {
        super(name, null, room);
    }

    /**
     * Fish can't move and change their positions, it's always in one room
     *
     * @return true
     */
    @Override
    public boolean move(Room room, SimulationTime begin, SimulationTime end) {
        return this.getRoom() == room;
    }
}
