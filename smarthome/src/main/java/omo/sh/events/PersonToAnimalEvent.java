package omo.sh.events;

import omo.sh.creatures.animals.utils.Animal;
import omo.sh.creatures.persons.GrandMother;
import omo.sh.creatures.persons.YoungerSister;
import omo.sh.creatures.persons.utils.Person;
import omo.sh.house.Room;

/**
 * Class represents event that happened among person and animal.
 */
public class PersonToAnimalEvent extends Event{

    /**
     * Person that interacts with animal.
     */
    private final Person person;

    /**
     * Animal that is intereacted with person.
     */
    private final Animal animal;

    /**
     * Class constructor.
     *
     * @param room in which event is happening
     * @param begin event time
     * @param end event time
     * @param person who triggered event
     * @param animal that was intereacted with
     */
    public PersonToAnimalEvent(Room room, String begin, String end, Person person, Animal animal) {
        super(room, begin, end);
        this.person = person;
        this.animal = animal;
    }

    @Override
    public String toString() {
        if (!(person instanceof GrandMother) && !(person instanceof YoungerSister)){
            return " || " + person.toString() + " met " + animal.getName() + " in " + getRoom().getRoomType() + " ||: " + getBegin() + " -- " + getEnd() + "\n";
        }
        return " || " + person.toString() + " played with " + animal.getName() + " in " + getRoom().getRoomType() + " ||: " + getBegin() + " -- " + getEnd() + "\n";
    }
}
