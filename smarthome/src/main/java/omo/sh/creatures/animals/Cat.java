package omo.sh.creatures.animals;

import omo.sh.creatures.animals.utils.Animal;
import omo.sh.creatures.behavior.Behavior;
import omo.sh.house.Room;

/**
 * Class represents cat in Smart Home.
 */
public class Cat extends Animal {

    /**
     * Class constructor.
     *
     * @param name animal's name
     * @param behavior animal's behavior
     * @param room in which animal is now
     */
    public Cat(String name, Behavior behavior, Room room) {
        super(name, behavior, room);
    }
}
