package omo.sh.creatures.animals.utils;

import omo.sh.creatures.animals.Cat;
import omo.sh.creatures.animals.Dog;
import omo.sh.creatures.animals.GoldenFish;
import omo.sh.creatures.behavior.Behavior;
import omo.sh.house.Room;

/**
 * Class represents animal factory and is used to create specific animal.
 */
public class AnimalFactory {

    /**
     * Creates new cat with given parametrs.
     *
     * @param name cat's name
     * @param behavior cat's behavior
     * @param room in which new cat is
     *
     * @return new cat created
     */
    public Animal createCat(String name, Behavior behavior, Room room){
        return new Cat(name, behavior, room);
    }

    /**
     * Creates new dog with given parametrs.
     *
     * @param name dog's name
     * @param behavior dog's behavior
     * @param room in which new dog is
     *
     * @return new dog created
     */
    public Animal createDog(String name, Behavior behavior, Room room){
        return new Dog(name, behavior, room);
    }

    /**
     * Creates new golden fish with given parametrs.
     *
     * @param name fish's name
     * @param behavior fish's behavior
     * @param room in which new fish is
     *
     * @return new fish created
     */
    public Animal createGoldenFish(String name, Behavior behavior, Room room){
        return new GoldenFish(name, behavior, room);
    }
}
