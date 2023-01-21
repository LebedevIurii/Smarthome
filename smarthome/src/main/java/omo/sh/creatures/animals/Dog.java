package omo.sh.creatures.animals;

import omo.sh.creatures.animals.utils.Animal;
import omo.sh.creatures.behavior.Behavior;
import omo.sh.house.Room;

/**
 * CLass represents dog in Smart Home.
 */
public class Dog extends Animal {

    /**
     * Class constructor.
     *
     * @param name animal's name
     * @param behavior animal's behavior
     * @param room in which animal is now
     */
    public Dog(String name, Behavior behavior, Room room) {
        super(name, behavior, room);
    }
}
