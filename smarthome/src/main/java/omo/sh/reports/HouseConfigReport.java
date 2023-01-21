package omo.sh.reports;

import omo.sh.creatures.Creature;
import omo.sh.creatures.animals.utils.Animal;
import omo.sh.creatures.persons.utils.Person;
import omo.sh.house.Floor;
import omo.sh.house.House;
import omo.sh.house.Room;
import omo.sh.machines.Machine;
import omo.sh.sensors.Sensor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class represents report of house configuration. Depends on chosen configuration.
 */
public class HouseConfigReport extends Report {

    /**
     * House to make report of.
     */
    private final House house;

    /**
     * Class constructor.
     *
     * @param heading of report
     * @param ending of report
     * @param house to make report of
     */
    public HouseConfigReport(String heading, String ending, House house) {
        super(heading, ending);
        this.house = house;
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
            writer.write(house.toString());
            for (Floor floor : house.getFloors()) {
                writer.write("  " + floor.toString() + "\n");
                for (Room room : floor.getRoomsOnFloor()) {
                    writer.write("      " + room.toString() + "\n");
                    for (Machine machine : room.getMachinesInRoom()) {
                        writer.write("          " + machine.getName() + "\n");
                    }
                    for (Sensor sensor : room.getSensorsInRoom()) {
                        writer.write("          " + sensor.getSensorName() + "\n");
                    }
                }
            }
            writer.write(REPORT_SEPARATOR);
            for (Creature creature : house.getCreatures()) {
                writer.write("          " + creature.getName() + "\n");
            }
            writer.write(REPORT_SEPARATOR);
            writer.write(getEnding());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
