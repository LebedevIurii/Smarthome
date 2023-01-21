package omo.sh.house;

import omo.sh.SimulationTime;
import omo.sh.creatures.Creature;
import omo.sh.creatures.animals.utils.Animal;
import omo.sh.creatures.persons.utils.Person;
import omo.sh.machines.Machine;
import omo.sh.observers.Observer;
import omo.sh.sensors.Sensor;
import java.util.ArrayList;

/**
 * Class represents Room in Smart home.
 */
public class Room {

    /**
     * Room type.
     */
    private final RoomType roomType;

    /**
     * Floor on which room is.
     */
    private final int floorNumber;

    /**
     * Sensors in room.
     */
    private ArrayList<Sensor> sensorsInRoom;

    /**
     * All machines in room.
     */
    private ArrayList<Machine> machinesInRoom;

    /**
     * All creatures in room.
     */
    private ArrayList<Creature> creaturesInRoom;

    /**
     * All listeners in room.
     */
    private final ArrayList<Observer> listeners = new ArrayList<>();

    /**
     * Adds Observer to room.
     *
     * @param o observer to add
     */
    public void subscribe(Observer o){
        listeners.add(o);
    }

    /**
     * Removes Observer to room.
     *
     * @param o observer to remove
     */
    public void unsubscribe(Observer o){
        listeners.remove(o);
    }

    /**
     * Notifies all listeners in room.
     *
     * @param room in which we need to notify all licteners
     * @param begin event time
     * @param end event time
     */
    public void notifyListeners(Room room, SimulationTime begin, SimulationTime end){
        for (Observer observer : listeners) {
            observer.update(room, begin, end);
        }
    }

    /**
     * Class constructor.
     *
     * @param roomType to create specific room
     * @param floorNumber on which room will be created
     */
    public Room(RoomType roomType, int floorNumber) {
        this.roomType = roomType;
        this.floorNumber = floorNumber;
        sensorsInRoom = new ArrayList<>();
        machinesInRoom = new ArrayList<>();
        creaturesInRoom = new ArrayList<>();
    }

    /**
     * @return room type
     */
    public RoomType getRoomType() {
        return roomType;
    }

    /**
     * @return floor number on which room is
     */
    public int getFloorNumber() {
        return floorNumber;
    }

    /**
     * @return all sensors that are in room
     */
    public ArrayList<Sensor> getSensorsInRoom() {
        return sensorsInRoom;
    }

    /**
     * @return all machines that are in room
     */
    public ArrayList<Machine> getMachinesInRoom() {
        return machinesInRoom;
    }

    /**
     * @return all creatures that are in room
     */
    public ArrayList<Creature> getCreaturesInRoom() {
        return creaturesInRoom;
    }

    /**
     * Add new creature into room.
     *
     * @param creature to add
     * @param begin event time
     * @param end event time
     */
    public void addCreatureToRoom(Creature creature, SimulationTime begin, SimulationTime end) {
        creaturesInRoom.add(creature);
        if (!listeners.isEmpty() && !getCreaturesInRoom().isEmpty()){
            notifyListeners(this, begin, end);
        }
    }

    /**
     * Deletes specific creature from room.
     *
     * @param creature to delete
     */
    public void deleteCreatureFromRoom(Creature creature) {
        creaturesInRoom.remove(creature);
    }

    /**
     * Adds specific machine to room.
     *
     * @param machine to add
     */
    public void addMachineToRoom(Machine machine) {
        machinesInRoom.add(machine);
    }

    /**
     * Adds specific sensor to room.
     *
     * @param sensor to add
     */
    public void addSensorToRoom(Sensor sensor) {
        sensorsInRoom.add(sensor);
    }

    /**
     * @return persons in room or null if there are no persons in room
     */
    public Person getPersonInRoom () {
        if (!creaturesInRoom.isEmpty()) {
            for (Creature creature: creaturesInRoom) {
                if (creature instanceof  Person) {
                    return (Person) creature;
                }
            }
        }
        return null;
    }

    /**
     * @return animals in room or null if there are no animals in room
     */
    public Animal getAnimalInRoom () {
        if (!creaturesInRoom.isEmpty()) {
            for (Creature creature: creaturesInRoom) {
                if (creature instanceof Animal) {
                    return (Animal) creature;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return roomType + " on the floor number " + floorNumber;
    }

    /**
     * @param i index for required machine
     * @return specific machine at index
     */
    public Machine getMachine(int i) {
        return machinesInRoom.get(i);
    }
}
