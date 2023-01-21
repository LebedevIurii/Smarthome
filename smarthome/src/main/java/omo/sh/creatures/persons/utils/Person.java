package omo.sh.creatures.persons.utils;

import omo.sh.SimulationTime;
import omo.sh.creatures.Creature;
import omo.sh.creatures.behavior.Behavior;
import omo.sh.house.Room;
import java.util.Objects;

/**
 * Class represents people in Smart Home.
 */
public class Person implements Creature {

    /**
     * Person's name.
     */
    private final String name;

    /**
     * Person's behavior.
     */
    private Behavior behavior;

    /**
     * Room in which person is now.
     */
    private Room room;

    /**
     * Class constructor.
     *
     * @param name person's name
     * @param behavior person's behavior
     * @param room in which person is
     */
    public Person(String name, Behavior behavior, Room room) {
        this.name = name;
        this.behavior = behavior;
        this.room = room;
    }

    /**
     * @return person's behavior
     */
    public Behavior getBehavior() {
        return behavior;
    }

    /**
     * Sets behavior to a person.
     *
     * @param behavior for a person
     */
    public void setBehavior(Behavior behavior) {
        this.behavior = behavior;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Room getRoom() {
        return room;
    }

    /**
     * Sets room to a person.
     *
     * @param room to set
     */
    public void setRoom(Room room, SimulationTime begin, SimulationTime end){
        this.room = room;
        room.addCreatureToRoom(this, begin, end);
    }

    /**
     * @return person's name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean move(Room room, SimulationTime begin, SimulationTime end) {
        Objects.requireNonNull(room);
        if (this.room != room){
            setRoom(room, begin, end);
        }
        return (this.room == room);
    }

    @Override
    public String toString() {
        return name;
    }
}
