package omo.sh.house;

import omo.sh.SimulationTime;
import omo.sh.creatures.Creature;
import omo.sh.events.EventManager;
import omo.sh.machines.Machine;
import omo.sh.observers.Observer;
import omo.sh.sensors.Sensor;

/**
 * Class represents house builder and contains functions to create a house.
 */
public class HouseBuilder {

    /**
     * House itself.
     */
    private final House house;

    /**
     * Event manager to create events in house.
     */
    private final EventManager eventManager;

    /**
     * Class constructor.
     *
     * @param eventManager to create new house
     */
    public HouseBuilder(EventManager eventManager) {
        this.eventManager = eventManager;
        this.house = new House();
    }

    /**
     * Resets house, deletes all house floors.
     */
    public void resetHouse() {
        this.house.getFloors().clear();
    }

    /**
     * Adds new floor to house.
     */
    public void addFloor() {
        this.house.getFloors().add(new Floor(house.getFloors().size()+1));
    }

    /**
     * Adds specific room to house and creates observer for new room.
     *
     * @param room to add
     */
    public void addRoom(Room room) {
        this.house.getFloor(room.getFloorNumber()).getRoomsOnFloor().add(room);
        Observer o = new Observer(room, eventManager);
        room.subscribe(o);
    }

    /**
     * Adds specific machine to room in house and creates observer for new machine.
     *
     * @param roomType of specific room
     * @param floorNum on which room is
     * @param machine to add
     */
    public void addMachine(RoomType roomType, int floorNum, Machine machine) {
        this.house.getFloor(floorNum).getRoom(roomType).addMachineToRoom(machine);
        Observer o = new Observer(machine, eventManager);
        machine.subscribe(o);
    }

    /**
     * Adds specific sensor to room in house and creates observer for new sensor.
     *
     * @param roomType of specific room
     * @param floorNum on which room is
     * @param sensor to add
     */
    public void addSensor(RoomType roomType, int floorNum, Sensor sensor) {
        this.house.getFloor(floorNum).getRoom(roomType).addSensorToRoom(sensor);
        Observer o = new Observer(sensor, eventManager);
        sensor.subscribe(o);
    }

    /**
     * Adds specific creature to room in house and creates observer for new creature.
     * Uses in house creation and when cretures move from room to room.
     *
     * @param roomType of specific room
     * @param floorNum on which room is
     * @param creature to add
     * @param begin event time
     * @param end event time
     */
    public void addCreature(RoomType roomType, int floorNum, Creature creature, SimulationTime begin, SimulationTime end) {
        this.house.addCreatures(creature);
        this.house.getFloor(floorNum).getRoom(roomType).addCreatureToRoom(creature, begin, end);
    }

    /**
     * @return house created
     */
    public House build() {
        return this.house;
    }
}
