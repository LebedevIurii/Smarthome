package omo.sh.sensors;

import omo.sh.SimulationTime;
import omo.sh.house.Room;
import omo.sh.observers.Observer;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Class represents sensors in Smart home.
 */
public class Sensor {

    /**
     * Name of sensor.
     */
    private final String sensorName;

    /**
     * List of all listenters of sensor.
     */
    private final ArrayList<Observer> listeners = new ArrayList<>();

    /**
     * Class constructor.
     *
     * @param sensorName new sensor name
     */
    public Sensor(String sensorName) {
        this.sensorName = sensorName;
    }

    /**
     * @return sensor's name
     */
    public String getSensorName() {
        return sensorName;
    }

    /**
     * Adds listener to sensor.
     *
     * @param o observer to add
     */
    public void subscribe(Observer o){
        listeners.add(o);
    }

    /**
     * Removes listener to sensor.
     *
     * @param o observer to remove
     */
    public void unsubscribe(Observer o){
        listeners.remove(o);
    }

    /**
     * Notifies all sensor's listeners and updates observers.
     *
     * @param room in which sensor is
     * @param begin event time
     * @param end event time
     */
    public void notifyListeners(Room room, SimulationTime begin, SimulationTime end){
        for (Observer observer : listeners) {
            observer.update(room, begin, end);
        }
    }
}
