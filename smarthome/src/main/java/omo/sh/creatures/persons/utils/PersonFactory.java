package omo.sh.creatures.persons.utils;

import omo.sh.creatures.behavior.Behavior;
import omo.sh.creatures.persons.*;
import omo.sh.house.Room;

/**
 * Class represents person factory and is used to create specific person.
 */
public class PersonFactory {

    /**
     * Creates father with given parametrs.
     *
     * @param name father's name
     * @param behavior father's behavior
     * @param room in which father is
     *
     * @return new father created
     */
    public Person createFather(String name, Behavior behavior, Room room){
        return new Father(name, behavior, room);
    }

    /**
     * Creates grandfather with given parametrs.
     *
     * @param name grandfather's name
     * @param behavior grandfather's behavior
     * @param room in which grandfather is
     *
     * @return new grandfather created
     */
    public Person createGrandFather(String name, Behavior behavior, Room room){
        return new GrandFather(name, behavior, room);
    }

    /**
     * Creates grandmother with given parametrs.
     *
     * @param name grandmother's name
     * @param behavior grandmother's behavior
     * @param room in which grandmother is
     *
     * @return new grandmother created
     */
    public Person createGrandMother(String name, Behavior behavior, Room room){
        return new GrandMother(name, behavior, room);
    }

    /**
     * Creates mother with given parametrs.
     *
     * @param name mother's name
     * @param behavior mother's behavior
     * @param room in which mother is
     *
     * @return new mother created
     */
    public Person createMother(String name, Behavior behavior, Room room){
        return new Mother(name, behavior, room);
    }

    /**
     * Creates older sister with given parametrs.
     *
     * @param name older sister's name
     * @param behavior older sister's behavior
     * @param room in which older sister is
     *
     * @return new older sister created
     */
    public Person createOlderSister(String name, Behavior behavior, Room room){
        return new OlderSister(name, behavior, room);
    }

    /**
     * Creates younger sister with given parametrs.
     *
     * @param name younger sister's name
     * @param behavior younger sister's behavior
     * @param room in which younger sister is
     *
     * @return new younger sister created
     */
    public Person createYoungerSister(String name, Behavior behavior, Room room){
        return new YoungerSister(name, behavior, room);
    }
}
