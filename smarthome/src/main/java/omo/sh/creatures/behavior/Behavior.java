package omo.sh.creatures.behavior;

import omo.sh.SimulationTime;
import omo.sh.house.Floor;
import omo.sh.house.House;
import omo.sh.house.Room;
import omo.sh.house.RoomType;
import omo.sh.machines.Machine;

import java.util.Objects;
import java.util.Random;

/**
 * Class represents creatures' (animals' and people's) behavior.
 * It makes creatures move to a random room, use a random machine or gets hungry.
 */
public class Behavior {

    /**
     * House in which creature is.
     */
    private final House house;

    /**
     * @return house
     */
    public House getHouse() {
        return house;
    }

    /**
     * Class constructor.
     *
     * @param house in which creature is
     */
    public Behavior(House house) {
        this.house = house;
    }

    /**
     * Makes creature go to a kitchen.
     *
     * @return room kitchen
     *         or null if kitchen hasn't been created
     */
    public Room hungry(){
        Room room;
        for (Floor floor : getHouse().getFloors()) {
            room = floor.getRoom(RoomType.Kitchen);
            if (room != null){
                return room;
            }
        }
        return null;
    }

    /**
     * Makes creature use random machine.
     *
     * @param room in which use machine
     * @param begin event time
     * @param end event time
     */
    public Machine use(Room room, SimulationTime begin, SimulationTime end, Random random){
        Machine machine =  chooseRandomMachine(room);
        machine.getState().turnOn(begin, end);
        if (random.nextBoolean()){
            machine.getState().broke(begin, end);
        } else {
            machine.getState().use(begin, end);
            machine.getState().turnOff(begin, end);
        }
        return machine;
    }

    /**
     * Chooses random room from array of all rooms.
     *
     * @return chosen room
     */
    public Room chooseRandomRoom() {
        Room randomRoom;
        Floor floor = house.getFloor((int) (Math.random()*house.getFloors().size()));
        randomRoom = floor.getRoomByID((int) (Math.random()*floor.getRoomsOnFloor().size()));
        return randomRoom;
    }

    /**
     * Chooses random machine in room for a person to use.
     *
     * @param room to choose machine from
     * @return chosen machine
     */
    public  Machine chooseRandomMachine(Room room){
        Objects.requireNonNull(room);
        Machine randomMachine = room.getMachine((int) (Math.random()*room.getMachinesInRoom().size()));
        return randomMachine;
    }
}
