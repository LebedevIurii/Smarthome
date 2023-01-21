package omo.sh.creatures.persons;

import omo.sh.creatures.behavior.Behavior;
import omo.sh.creatures.persons.utils.Person;
import omo.sh.house.Room;

/**
 * Class represents grandfather in Smart Home.
 */
public class GrandFather extends Person {

    /**
     * Class constructor.
     *
     * @param name person's name
     * @param behavior person's behavior
     * @param room in which person is
     */
    public GrandFather(String name, Behavior behavior, Room room) {
        super(name, behavior, room);
    }
}
