package omo.sh.house;

import omo.sh.creatures.Creature;

import java.util.ArrayList;

/**
 * Class represents House with floor.
 */
public class House {

    /**
     * Floors in house.
     */
    private ArrayList<Floor> floors;

    /**
     * Creatures live in house.
     */
    private  ArrayList<Creature> creatures;

    /**
     * Class constructor.
     */
    public House() {
        floors = new ArrayList<>();
        creatures = new ArrayList<>();
    }

    /**
     * Adds creatures to house.
     *
     * @param creature to add
     */
    public void addCreatures(Creature creature) {
        creatures.add(creature);
    }

    /**
     * @return list of all creatures in house
     */
    public ArrayList<Creature> getCreatures() {
        return creatures;
    }

    /**
     * @return list of all floors in house
     */
    public ArrayList<Floor> getFloors() {
        return floors;
    }

    @Override
    public String toString() {
        return "Smart home \n";
    }

    /**
     * Returns specific floor.
     *
     * @param i number of floor to return
     * @return floor required
     */
    public Floor getFloor(int i) {
        return floors.get(i);
    }
}
