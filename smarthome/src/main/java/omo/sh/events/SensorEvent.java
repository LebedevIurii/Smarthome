package omo.sh.events;

import omo.sh.house.Room;
import omo.sh.sensors.Sensor;

/**
 * Class represents sensor's event.
 */
public class SensorEvent extends Event{

    /**
     * Sensor of event.
     */
    private final Sensor sensor;

    /**
     * Class constructor.
     *
     * @param room in which event is happening
     * @param begin event time
     * @param end event time
     * @param sensor that is used in event
     */
    public SensorEvent(Room room, String begin, String end, Sensor sensor) {
        super(room, begin, end);
        this.sensor = sensor;
    }

    public String toString() {
        return " || " + sensor.getSensorName() + " alarmed in " + getRoom().getRoomType() + " ||: " + getBegin() + " -- " + getEnd() + "\n";
    }
}
