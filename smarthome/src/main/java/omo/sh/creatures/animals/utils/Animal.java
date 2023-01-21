package omo.sh.creatures.animals.utils;

import omo.sh.SimulationTime;
import omo.sh.creatures.Creature;
import omo.sh.creatures.behavior.Behavior;
import omo.sh.house.Room;

import java.util.Objects;

/**
 * Class represents Animals in Smart Home.
 */
public class Animal implements Creature {

    /**
     * Animal's name.
     */
    private final String name;

    /**
     * Animal's behavior.
     */
    private Behavior behavior;

    /**
     * Room in which animal is now.
     */
    private Room room;

    /**
     * Class constructor.
     *
     * @param name animal's name
     * @param behavior animal's behavior
     * @param room in which animal is now
     */
    public Animal(String name, Behavior behavior, Room room) {
        this.name = name;
        this.behavior = behavior;
        this.room = room;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Room getRoom() {
        return room;
    }

    /**
     * Sets room in which animal is.
     *
     * @param room the room to set
     */
    public void setRoom(Room room, SimulationTime begin, SimulationTime end){
        this.room = room;
        room.addCreatureToRoom(this, begin, end);
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

    /**
     * Gets animal's name.
     *
     * @return animal's name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * @return animal's behavior
     */
    @Override
    public Behavior getBehavior() {
        return behavior;
    }

    /**
     * Sets behavior to animal.
     *
     * @param behavior to set
     */
    public void setBehavior(Behavior behavior) {
        this.behavior = behavior;
    }
}
