package omo.sh.reports;

import omo.sh.house.Floor;
import omo.sh.machines.devices.utils.Device;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Math.round;

/**
 * Class represents report of devices' resourse consumption.
 */
public class ResourceReport extends Report {

    /**
     * Cost of one unit of electricity in CZK.
     */
    private static final double HOUSEHOLD = 8.111;

    /**
     * Iterator to go through all devices.
     */
    private final ResourceIterator resourceIterator;

    /**
     * @return resourse iterator
     */
    public ResourceIterator getResourceIterator() {
        return resourceIterator;
    }

    /**
     * Class constructor.
     *
     * @param heading of report
     * @param ending of report
     * @param floors to go through
     */
    public ResourceReport(String heading, String ending, ArrayList<Floor> floors) {
        super(heading, ending);
        resourceIterator = new ResourceIterator(floors);
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
            Device device = resourceIterator.next();
            while (resourceIterator.hasNext()) {
                var cost = device.getElectricity()*HOUSEHOLD;
                writer.write(device.getName() + " in " + device.getRoom().getRoomType() + " used " + device.getElectricity() + " unit(s) of electricity which cost " + Math.round(cost) + "Kč;\n");
                device = resourceIterator.next();
            }
            writer.write(REPORT_SEPARATOR);
            writer.write(getEnding());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
