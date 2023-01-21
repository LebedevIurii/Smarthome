package omo.sh;

/**
 * Class represents time in simulation.
 */
public class SimulationTime {

    /**
     * Number of ticks in one day.
     */
    private static final int Day = 48;

    /**
     * Current time in ticks.
     */
    int currentTime;

    /**
     * @return current time
     */
    public int getIntCurrentTime(){
        return currentTime;
    }

    /**
     * @return number of ticks in one day
     */
    public static int Day() {
        return Day;
    }

    /**
     * Resets time.
     */
    public void initTime(){
        currentTime = 0;
    }

    /**
     * Sets current time.
     *
     * @param currentTime to set
     */
    public void setCurrentTime(int currentTime) {
        if (this.currentTime < currentTime){
            this.currentTime = currentTime;
        }
    }

    /**
     * @return time for report format
     */
    public String getCurrentClock() {
        String dayTime = " ";
        if (currentTime / 2  < 10){
            dayTime += 0;
        }
        dayTime += currentTime / 2;
        dayTime += " : ";
        if (currentTime % 2 == 0){
            dayTime += 0;
        }
        dayTime += currentTime % 2 * 30;
        dayTime += " ";
        return dayTime;
    }
}
