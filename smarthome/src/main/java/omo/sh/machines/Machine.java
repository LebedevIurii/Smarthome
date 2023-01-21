package omo.sh.machines;

import omo.sh.SimulationTime;
import omo.sh.house.Room;
import omo.sh.machines.state.*;
import omo.sh.observers.Observer;
import java.util.ArrayList;

/**
 * Class represents machines (devices and vehicles) in Smart home.
 */
public class Machine {

    /**
     * Machine's name
     */
    private final String name;

    /**
     * Machine's state
     */
    private MachineState state;

    /**
     * Room in which machine is.
     */
    private Room room;

    /**
     * All machine's listeners.
     */
    private final ArrayList<Observer> listeners = new ArrayList<>();

    /**
     * Adds new listener to machine.
     *
     * @param o observer to add
     */
    public void subscribe(Observer o){
        listeners.add(o);
    }

    /**
     * Removes listener from machine.
     *
     * @param o observer to remove
     */
    public void unsubscribe(Observer o){
        listeners.remove(o);
    }

    /**
     * Notifies all machine's listeners and updates observers.
     *
     * @param room in which machine is
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
     * @param name of new machine
     * @param machineRoom in which add new machine
     */
    public Machine(String name, Room machineRoom) {
        this.name = name;
        this.state = new OffState(this);
        this.room = machineRoom;
    }

    /**
     * Generates machine's manual in case of machine's damage.
     *
     * @return newly created manual
     */
    public Manual generateManual(){
        Manual manual = new Manual(this);
        return manual;
    }

    /**
     * Changes machine state.
     *
     * @param machineState new state of machine
     * @param begin event time
     * @param end event time
     */
    public void changeState(MachineState machineState, SimulationTime begin, SimulationTime end) {
        state = machineState;
        if (!listeners.isEmpty()){
            notifyListeners(this.getRoom(), begin, end);
        }
    }

    /**
     * @return machine's state
     */
    public MachineState  getState() {
        return state;
    }

    /**
     * @return machine's name
     */
    public String getName() {
        return name;
    }

    /**
     * @return room in which machine is
     */
    public Room getRoom() {
        return room;
    }
}
