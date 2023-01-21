package omo.sh;

import omo.sh.creatures.Creature;
import omo.sh.creatures.animals.GoldenFish;
import omo.sh.creatures.persons.Father;
import omo.sh.events.EventManager;
import omo.sh.exceptions.NullHouseException;
import omo.sh.house.*;
import omo.sh.machines.Machine;
import omo.sh.reports.EventReport;
import omo.sh.reports.HouseConfigReport;
import omo.sh.reports.ResourceReport;
import omo.sh.sensors.Sensor;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

/**
 * Class represents simulation of Smart home.
 */
public class Simulation {

    /**
     * Number of simulation's days.
     */
    private int lifeCycles;

    /**
     * Director of simulation.
     */
    private final Director director;

    /**
     * House of simulation.
     */
    private House house;

    /**
     * Simulation itself.
     */
    private static Simulation simulation;

    /**
     * Class constructor.
     */
    public Simulation() {
        this.director = new Director();
    }

    /**
     * Get a singleton instance of api.
     *
     * @return Simulation instance
     */
    public static synchronized Simulation getInstance() {
        if (simulation == null){
            simulation = new Simulation();
        }
        return simulation;
    }

    /**
     * Runs simulation.
     */
    public void startSimulation(){
        Random ran = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter House configuration:\n     's' - Standard house;\n     'b' - Big house.\n");
        String config = scanner.next();
        while (!Objects.equals(config, "s") && !Objects.equals(config, "b")){
            System.out.println("Enter House configuration:\n   's' - Standard house;\n   'b' - Big house.\n");
            System.out.println("Please enter a valid House configuration");
            config = scanner.next();
        }
        EventReport eR = new EventReport("SmartHome Event Report:", "\n");
        EventManager em = new EventManager(eR);
        SimulationTime simulationTime = new SimulationTime();
        simulationTime.initTime();
        switch (config) {
            case "s" -> house = director.buildStandardHouse(new HouseBuilder(em), simulationTime, simulationTime);
            case "b" -> house = director.buildBigHouse(new HouseBuilder(em), simulationTime, simulationTime);
            default -> {
                NullHouseException.create();
            }
        }
        HouseConfigReport hCR = new HouseConfigReport( "SmartHome House Config Report:", "\n", house);
        ResourceReport rR = new ResourceReport("SmartHome Electricity Consumption Report:", "\n", house.getFloors());
        System.out.println("Enter number of simulation days:");
        try {
            lifeCycles = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number of loops to run, in digits.");
        }
        for (int i = 0; i < lifeCycles; i++) {
            simulationTime.initTime();
            SimulationTime endSimTime = new SimulationTime();
            while (simulationTime.currentTime <= SimulationTime.Day() - 1) {
                endSimTime.setCurrentTime(simulationTime.currentTime + 1);
                creaturesSimulation(simulationTime, endSimTime);
                sensorSimulation(simulationTime, endSimTime);
                ++simulationTime.currentTime;
            }
        }
        eR.saveToFile("EventReportAfter" + lifeCycles+ "Days.txt");
        hCR.saveToFile("HouseConfigReportAfter" + lifeCycles+ "Days.txt");
        rR.saveToFile("ResourceReportAfter" + lifeCycles+ "Days.txt");
    }

    private void creaturesSimulation(SimulationTime simulationTime, SimulationTime endSimTime){
        Objects.requireNonNull(simulationTime);
        Objects.requireNonNull(endSimTime);
        Objects.requireNonNull(house);
        for (Creature creature : house.getCreatures()) {
            if (creature.getClass() != GoldenFish.class) {
                creatureMoveSimulation(creature, simulationTime, endSimTime);
                creatureUseSimulation(creature, simulationTime, endSimTime);
            }
        }
    }

    private void creatureMoveSimulation(Creature creature, SimulationTime simulationTime, SimulationTime endSimTime){
        Objects.requireNonNull(creature);
        Objects.requireNonNull(simulationTime);
        Objects.requireNonNull(endSimTime);
        Random ran = new Random();
        if (ran.nextInt() % 5 == 0) {
            if (creature.getClass() != GoldenFish.class) {
                creature.move(creature.getBehavior().chooseRandomRoom(), simulationTime, endSimTime);
            }
        }
    }
    private void creatureUseSimulation(Creature creature, SimulationTime simulationTime, SimulationTime endSimTime){
        Objects.requireNonNull(creature);
        Objects.requireNonNull(simulationTime);
        Objects.requireNonNull(endSimTime);
        Random ran = new Random();
        if (ran.nextInt() % 2 == 0){
            Machine usedMachine = creature.getBehavior().use(creature.getRoom(), simulationTime, endSimTime, ran);
            if (usedMachine.getState().broke(null, null)) {
                for (Creature calledCreature : house.getCreatures()) {
                    if (calledCreature.getClass() == Father.class) {
                        calledCreature.move(creature.getRoom(), simulationTime, endSimTime);
                        ((Father) calledCreature).repair(usedMachine, simulationTime, endSimTime);
                        break;
                    }
                }
            }
        }
    }

    private void sensorSimulation(SimulationTime simulationTime, SimulationTime endSimTime){
        Random ran = new Random();
        for (Floor floor : house.getFloors()) {
            for (Room room : floor.getRoomsOnFloor()) {
                for (Sensor sensor : room.getSensorsInRoom()) {
                    if (ran.nextInt() % 2 == 0) {
                        sensor.notifyListeners(room, simulationTime, endSimTime);
                        callingFather(room, simulationTime, endSimTime);
                    }
                }
            }
        }
    }

    private void callingFather(Room room, SimulationTime simulationTime, SimulationTime endSimTime){
        for (Creature calledCreature : house.getCreatures()) {
            if (calledCreature.getClass() == Father.class) {
                calledCreature.move(room, simulationTime, endSimTime);
            }
        }
    }
}
