package omo.sh.reports;

import java.io.File;

/**
 * Class represents report which is used to generate reports and write them to text file.
 */
public abstract class Report {

    /**
     * Path where save report.
     */
    protected static final String REPORT_FILEPATH = "generatedReports/";

    /**
     * Report's separator.
     */
    protected static final String REPORT_SEPARATOR = "===========================================================================\n";

    /**
     * Heading of report.
     */
    private final  String heading;

    /**
     * Ending of report.
     */
    private final  String ending;

    /**
     * File where to save report.
     */
    private File outputFile;

    /**
     * @return report heading
     */
    public String getHeading() {
        return heading;
    }

    /**
     * @return report ending
     */
    public String getEnding() {
        return ending;
    }

    /**
     * @return report outputFile
     */
    public File getOutputFile() {
        return outputFile;
    }

    /**
     * Sets output file.
     *
     * @param outputFile where to save report
     */
    public void setOutputFile(File outputFile) {
        this.outputFile = outputFile;
    }

    /**
     * Class constructor.
     *
     * @param heading of report
     * @param ending of report
     */
    public Report(String heading, String ending) {
        this.heading = heading + "\n";
        this.ending = ending + "\n";
    }

    /**
     * Saves report to specific file.
     *
     * @param filename where to save report
     */
    public abstract void saveToFile(String filename);
}
