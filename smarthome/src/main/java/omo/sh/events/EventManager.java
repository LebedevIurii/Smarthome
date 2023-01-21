package omo.sh.events;

import omo.sh.creatures.Creature;
import omo.sh.creatures.animals.utils.Animal;
import omo.sh.creatures.persons.utils.Person;
import omo.sh.house.Room;
import omo.sh.machines.Machine;
import omo.sh.observers.Observer;
import omo.sh.reports.EventReport;
import omo.sh.sensors.Sensor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Class represents event manager which is used to generate events. Kindy of event factory.
 */
public class EventManager {

    /**
     * Event report that will be write into report text file.
     */
    private final EventReport eventReport;

    /**
     * Class constructor.
     *
     * @param eventReport that will be write into report text file
     */
    public EventManager(EventReport eventReport) {
        this.eventReport = eventReport;
    }

    /**
     * Event generator.
     *
     * @param observer that triggered event and define event based on its object
     */
    public void generateObservedEvent(Observer observer){
        Objects.requireNonNull(observer);
        ArrayList<Event> newEvent = new ArrayList<>();
        Room eventRoom = observer.getObservedRoom();
        if (observer.getObservable() instanceof Machine) {
            if (eventRoom.getPersonInRoom() != null){
                newEvent.add(new MachineEvent(eventRoom, observer.getBegin(), observer.getEnd(), eventRoom.getPersonInRoom(), (Machine) observer.getObservable()));
            }
        }
        if (observer.getObservable() instanceof Room) {
            Creature trigger = eventRoom.getCreaturesInRoom().get(eventRoom.getCreaturesInRoom().size() - 1);
            Creature creature = eventRoom.getCreaturesInRoom().get(0);
            if (creature instanceof  Person || trigger instanceof Person){
                if (creature instanceof Person && trigger instanceof Person && !trigger.equals(creature) ){
                    newEvent.add(new PersonToPersonEvent(eventRoom, observer.getBegin(), observer.getEnd(), (Person) creature, (Person) trigger));
                } else {
                    if (creature instanceof Person && trigger instanceof Animal){
                        newEvent.add(new PersonToAnimalEvent(eventRoom, observer.getBegin(), observer.getEnd(), (Person) creature, (Animal) trigger));
                    } else if (creature instanceof Animal){
                        newEvent.add(new PersonToAnimalEvent(eventRoom, observer.getBegin(), observer.getEnd(), (Person) trigger, (Animal) creature));
                    }
                }
            }
        }
        if(observer.getObservable() instanceof Sensor){
            newEvent.add(new SensorEvent(eventRoom, observer.getBegin(), observer.getEnd(), (Sensor) observer.getObservable()));
        }
        for (Event event : newEvent) {
            reporting(event);
        }
    }

    /**
     * Adds event to report.
     *
     * @param e event to add
     */
    public void reporting(Event e){
        eventReport.addEvent(e);
    }
}
