package omo.sh.reports;

import omo.sh.events.Event;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class represents report of all event of all time of simulation.
 */
public class EventReport extends  Report{

    /**
     * List of all events.
     */
    private ArrayList<Event> events = new ArrayList<>();

    /**
     * Adds new event to event list.
     *
     * @param event to add
     */
    public void addEvent(Event event){
        events.add(event);
    }

    /**
     * Class constructor.
     *
     * @param heading of report
     * @param ending of report
     */
    public EventReport(String heading, String ending) {
        super(heading, ending);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveToFile(String filename) {
        setOutputFile(new File(REPORT_FILEPATH + filename));
        try (FileWriter writer = new FileWriter(getOutputFile())) {
            writer.write(getHeading());
            writer.write(REPORT_SEPARATOR);
            for (Event event : events) {
                writer.write(event.toString());
            }
            writer.write(REPORT_SEPARATOR);
            writer.write(getEnding());
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
