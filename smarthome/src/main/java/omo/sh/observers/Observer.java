package omo.sh.observers;

import omo.sh.SimulationTime;
import omo.sh.events.EventManager;
import omo.sh.house.Room;

/**
 * CLass represents observer which generates events when updates.
 */
public class Observer {

    /**
     * Object to observe.
     */
    private final Object observable;

    /**
     * Event manager to generate event.
     */
    private final EventManager manager;

    /**
     * Room in which observer is.
     */
    private Room room;

    /**
     * Time of event.
     */
    private SimulationTime begin, end;

    /**
     * Class constructor.
     *
     * @param observable object to observe
     * @param manager event manager
     */
    public Observer(Object observable, EventManager manager) {
        this.observable = observable;
        this.manager = manager;
    }

    /**
     * Updates observer and generates new event.
     *
     * @param room in which observer is
     * @param begin time event
     * @param end time event
     */
    public void update(Room room, SimulationTime begin, SimulationTime end) {
        this.room = room;
        this.begin = begin;
        this.end = end;
        manager.generateObservedEvent(this);
    }

    /**
     * @return observable object
     */
    public Object getObservable() {
        return observable;
    }

    /**
     * @return roon in which observer is
     */
    public Room getObservedRoom() {
        return room;
    }

    /**
     * @return begin time of event
     */
    public String getBegin() {
        return begin.getCurrentClock();
    }

    /**
     * @return end time of event
     */
    public String getEnd() {
        return end.getCurrentClock();
    }
}
