package omo.sh.events;

import omo.sh.house.Room;

/**
 * Class represents events in Smart Home.
 */
public class Event {

    /**
     * Room in whicn event takes place.
     */
    private final Room room;

    /**
     * Event's start time.
     */
    private final String begin;

    /**
     * Event's end time.
     */
    private final String end;

    /**
     * @return room in whicn event takes place.
     */
    public Room getRoom() {
        return room;
    }

    /**
     * @return begin evet's time
     */
    public String getBegin() {
        return begin;
    }

    /**
     * @return end event's time
     */
    public String getEnd() {
        return end;
    }

    /**
     * Class constructor.
     *
     * @param room in whicn event takes place
     * @param begin time
     * @param end time
     */
    public Event(Room room, String begin, String end) {
        this.room = room;
        this.begin = begin;
        this.end = end;
    }
}
