package omo.sh.events;

import omo.sh.creatures.persons.utils.Person;
import omo.sh.house.Room;

/**
 * Class represents event that happened among 2 persons.
 */
public class PersonToPersonEvent extends Event{

    /**
     * Person who triggered event.
     */
    private final Person person1;

    /**
     * Person who is first person interacted with.
     */
    private final Person person2;

    /**
     * Class constructor.
     * @param room in which event is happening
     * @param begin event time
     * @param end event time
     * @param person1 who started event
     * @param person2 who was intereacted with
     */
    public PersonToPersonEvent(Room room, String begin, String end, Person person1, Person person2) {
        super(room, begin, end);
        this.person1 = person1;
        this.person2 = person2;
    }

    @Override
    public String toString() {
        return " || " + person1.toString() + " met " + person2.toString() + " in " + getRoom().getRoomType() + " ||: " + getBegin() + " -- " + getEnd()+ "\n";
    }
}
