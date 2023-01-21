package omo.sh.house;

import omo.sh.SimulationTime;
import omo.sh.creatures.animals.utils.AnimalFactory;
import omo.sh.creatures.behavior.AnimalBehavior;
import omo.sh.creatures.behavior.PersonalBehavior;
import omo.sh.creatures.persons.utils.PersonFactory;
import omo.sh.events.EventManager;
import omo.sh.machines.devices.utils.DeviceFactory;
import omo.sh.machines.vehicles.util.VehicleFactory;
import omo.sh.reports.EventReport;
import omo.sh.sensors.HumiditySensor;
import omo.sh.sensors.SmokeSensor;
import omo.sh.sensors.TemperatureSensor;

import java.util.Objects;

/**
 * Class represents a director which rules houseBuilder.
 * Used to create a specific house depending on a config.
 */
public class Director {

    /**
     * Creates standard house with minimal requirements.
     * For more details see documentation.
     */
    public House buildStandardHouse (HouseBuilder builder, SimulationTime begin, SimulationTime end) {

        if (!builder.build().getFloors().isEmpty()) {
            builder.resetHouse();
        }
        VehicleFactory vehicleFactory = new VehicleFactory();
        DeviceFactory deviceFactory = new DeviceFactory();
        PersonFactory personFactory = new PersonFactory();
        AnimalFactory animalFactory = new AnimalFactory();

        builder.addFloor();
        builder.addFloor();
        Room room;
        // floor 0
        room = new Room(RoomType.Garage, 0);
        builder.addRoom(room);
        builder.addMachine(RoomType.Garage, 0, vehicleFactory.createAuto(room));
        builder.addMachine(RoomType.Garage, 0, vehicleFactory.createBike(room));
        builder.addMachine(RoomType.Garage, 0, vehicleFactory.createMoto(room));
        builder.addMachine(RoomType.Garage, 0, deviceFactory.createGarageDoors(room));
        builder.addSensor(RoomType.Garage, 0, new SmokeSensor("Smoke Sensor"));

        room = new Room(RoomType.Kitchen, 0);
        builder.addRoom(room);
        builder.addMachine(RoomType.Kitchen, 0, deviceFactory.createBlindWindow(room));
        builder.addMachine(RoomType.Kitchen, 0, deviceFactory.createFridge(room));
        builder.addMachine(RoomType.Kitchen, 0, deviceFactory.createDishwasher(room));
        builder.addMachine(RoomType.Kitchen, 0, deviceFactory.createOven(room));
        builder.addMachine(RoomType.Kitchen, 0, deviceFactory.createFeeder(room));
        builder.addMachine(RoomType.Kitchen, 0, deviceFactory.createToaster(room));
        builder.addMachine(RoomType.Kitchen, 0, deviceFactory.createCoffeeMachine(room));
        builder.addSensor(RoomType.Kitchen, 0, new SmokeSensor("Smoke Sensor"));
        builder.addSensor(RoomType.Kitchen, 0, new TemperatureSensor("Temperature Sensor"));

        room = new Room(RoomType.LivingRoom, 0);
        builder.addRoom(room);
        builder.addMachine(RoomType.LivingRoom, 0, deviceFactory.createAquarium(room));
        builder.addMachine(RoomType.LivingRoom, 0, deviceFactory.createRouter(room));
        builder.addMachine(RoomType.LivingRoom, 0, deviceFactory.createBlindWindow(room));
        builder.addMachine(RoomType.LivingRoom, 0, deviceFactory.createTV(room));
        builder.addMachine(RoomType.LivingRoom, 0, deviceFactory.createRoboVacuumCleaner(room));
        builder.addMachine(RoomType.LivingRoom, 0, deviceFactory.createPlayStation(room));
        builder.addMachine(RoomType.LivingRoom, 0, deviceFactory.createConditioner(room));
        builder.addSensor(RoomType.LivingRoom, 0, new SmokeSensor("Smoke Sensor"));

        room = new Room(RoomType.Bedroom, 0);
        builder.addRoom(room);  // bedroom for grandparents
        builder.addMachine(RoomType.Bedroom, 0, deviceFactory.createBlindWindow(room));
        builder.addMachine(RoomType.Bedroom, 0, deviceFactory.createTV(room));
        builder.addMachine(RoomType.Bedroom, 0, deviceFactory.createConditioner(room));
        builder.addSensor(RoomType.Bedroom, 0, new SmokeSensor("Smoke Sensor"));

        // floor 1
        room = new Room(RoomType.Bedroom, 1);
        builder.addRoom(room);  // bedroom for parents
        builder.addMachine(RoomType.Bedroom, 1, deviceFactory.createBlindWindow(room));
        builder.addMachine(RoomType.Bedroom, 1, deviceFactory.createTV(room));
        builder.addMachine(RoomType.Bedroom, 1, deviceFactory.createLaptop(room));
        builder.addMachine(RoomType.Bedroom, 1, deviceFactory.createConditioner(room));
        builder.addSensor(RoomType.Bedroom, 1, new SmokeSensor("Smoke Sensor"));

        room = new Room(RoomType.ChildrenBedroom, 1);
        builder.addRoom(room);
        builder.addMachine(RoomType.ChildrenBedroom, 1, deviceFactory.createBlindWindow(room));
        builder.addMachine(RoomType.ChildrenBedroom, 1, deviceFactory.createPC(room));
        builder.addMachine(RoomType.ChildrenBedroom, 1, deviceFactory.createConditioner(room));
        builder.addSensor(RoomType.ChildrenBedroom, 1, new SmokeSensor("Smoke Sensor"));

        room = new Room(RoomType.Bathroom, 1);
        builder.addRoom(room);
        builder.addMachine(RoomType.Bathroom, 1, deviceFactory.createWashingMachine(room));
        builder.addMachine(RoomType.Bathroom, 1, deviceFactory.createDryer(room));
        builder.addMachine(RoomType.Bathroom, 1, deviceFactory.createHairdryer(room));
        builder.addSensor(RoomType.Bathroom, 1, new HumiditySensor("Humidity Sensor"));

        // add people
        builder.addCreature(RoomType.Kitchen, 0, personFactory.createMother("Mother", new PersonalBehavior(builder.build()), builder.build().getFloor(0).getRoom(RoomType.Kitchen)), begin, end);
        builder.addCreature(RoomType.Garage, 0, personFactory.createFather("Father", new PersonalBehavior(builder.build()), builder.build().getFloor(0).getRoom(RoomType.Garage)), begin, end);
        builder.addCreature(RoomType.LivingRoom, 0, personFactory.createGrandFather("Grandfather", new PersonalBehavior(builder.build()), builder.build().getFloor(0).getRoom(RoomType.LivingRoom)), begin, end);
        builder.addCreature(RoomType.Bedroom, 0, personFactory.createGrandMother("Grandmother", new PersonalBehavior(builder.build()), builder.build().getFloor(0).getRoom(RoomType.Bedroom)), begin, end);
        builder.addCreature(RoomType.ChildrenBedroom, 1, personFactory.createOlderSister("Older sister", new PersonalBehavior(builder.build()), builder.build().getFloor(1).getRoom(RoomType.ChildrenBedroom)), begin, end);
        builder.addCreature(RoomType.ChildrenBedroom, 1, personFactory.createYoungerSister("Younger sister", new PersonalBehavior(builder.build()), builder.build().getFloor(1).getRoom(RoomType.ChildrenBedroom)), begin, end);

        // add animals
        builder.addCreature(RoomType.LivingRoom, 0, animalFactory.createGoldenFish("Fish", new AnimalBehavior(builder.build()), builder.build().getFloor(0).getRoom(RoomType.LivingRoom)), begin, end);
        builder.addCreature(RoomType.LivingRoom, 0, animalFactory.createCat("Cat", new AnimalBehavior(builder.build()), builder.build().getFloor(0).getRoom(RoomType.LivingRoom)), begin, end);
        builder.addCreature(RoomType.Bedroom, 1, animalFactory.createDog("Dog", new AnimalBehavior(builder.build()), builder.build().getFloor(1).getRoom(RoomType.Bedroom)), begin, end);

        return builder.build();
    }

    /**
     * Creates bigger house with more requirements.
     * For more details see documentation.
     */
    public House buildBigHouse (HouseBuilder builder, SimulationTime begin, SimulationTime end) {
        if (!builder.build().getFloors().isEmpty()) {
            builder.resetHouse();
        }
        VehicleFactory vehicleFactory = new VehicleFactory();
        DeviceFactory deviceFactory = new DeviceFactory();
        PersonFactory personFactory = new PersonFactory();
        AnimalFactory animalFactory = new AnimalFactory();

        builder.addFloor();
        builder.addFloor();
        builder.addFloor();
        Room room;
        // floor 0
        room = new Room(RoomType.Garage, 0);
        builder.addRoom(room);
        builder.addMachine(RoomType.Garage, 0, vehicleFactory.createAuto(room));
        builder.addMachine(RoomType.Garage, 0, vehicleFactory.createBike(room));
        builder.addMachine(RoomType.Garage, 0, vehicleFactory.createMoto(room));
        builder.addMachine(RoomType.Garage, 0, deviceFactory.createGarageDoors(room));
        builder.addSensor(RoomType.Garage, 0, new SmokeSensor("Smoke Sensor"));

        room = new Room(RoomType.Kitchen, 0);
        builder.addRoom(room);
        builder.addMachine(RoomType.Kitchen, 0, deviceFactory.createBlindWindow(room));
        builder.addMachine(RoomType.Kitchen, 0, deviceFactory.createFridge(room));
        builder.addMachine(RoomType.Kitchen, 0, deviceFactory.createDishwasher(room));
        builder.addMachine(RoomType.Kitchen, 0, deviceFactory.createOven(room));
        builder.addMachine(RoomType.Kitchen, 0, deviceFactory.createFeeder(room));
        builder.addMachine(RoomType.Kitchen, 0, deviceFactory.createToaster(room));
        builder.addMachine(RoomType.Kitchen, 0, deviceFactory.createCoffeeMachine(room));
        builder.addSensor(RoomType.Kitchen, 0, new SmokeSensor("Smoke Sensor"));
        builder.addSensor(RoomType.Kitchen, 0, new TemperatureSensor("Temperature Sensor"));

        room = new Room(RoomType.LivingRoom, 0);
        builder.addRoom(room);
        builder.addMachine(RoomType.LivingRoom, 0, deviceFactory.createAquarium(room));
        builder.addMachine(RoomType.LivingRoom, 0, deviceFactory.createRouter(room));
        builder.addMachine(RoomType.LivingRoom, 0, deviceFactory.createBlindWindow(room));
        builder.addMachine(RoomType.LivingRoom, 0, deviceFactory.createTV(room));
        builder.addMachine(RoomType.LivingRoom, 0, deviceFactory.createRoboVacuumCleaner(room));
        builder.addMachine(RoomType.LivingRoom, 0, deviceFactory.createPlayStation(room));
        builder.addMachine(RoomType.LivingRoom, 0, deviceFactory.createConditioner(room));
        builder.addSensor(RoomType.LivingRoom, 0, new SmokeSensor("Smoke Sensor"));

        // floor 1
        room = new Room(RoomType.Bedroom, 1);
        builder.addRoom(room);  // bedroom for parents
        builder.addMachine(RoomType.Bedroom, 1, deviceFactory.createBlindWindow(room));
        builder.addMachine(RoomType.Bedroom, 1, deviceFactory.createTV(room));
        builder.addMachine(RoomType.Bedroom, 1, deviceFactory.createLaptop(room));
        builder.addMachine(RoomType.Bedroom, 1, deviceFactory.createConditioner(room));
        builder.addSensor(RoomType.Bedroom, 1, new SmokeSensor("Smoke Sensor"));

        room = new Room(RoomType.Bathroom, 1);
        builder.addRoom(room);
        builder.addMachine(RoomType.Bathroom, 1, deviceFactory.createWashingMachine(room));
        builder.addMachine(RoomType.Bathroom, 1, deviceFactory.createDryer(room));
        builder.addMachine(RoomType.Bathroom, 1, deviceFactory.createHairdryer(room));
        builder.addSensor(RoomType.Bathroom, 1, new HumiditySensor("Humidity Sensor"));

        // floor 2
        room = new Room(RoomType.Bedroom, 2);
        builder.addRoom(room);  // bedroom for parents
        builder.addMachine(RoomType.Bedroom, 2, deviceFactory.createBlindWindow(room));
        builder.addMachine(RoomType.Bedroom, 2, deviceFactory.createTV(room));
        builder.addMachine(RoomType.Bedroom, 2, deviceFactory.createLaptop(room));
        builder.addMachine(RoomType.Bedroom, 2, deviceFactory.createConditioner(room));
        builder.addSensor(RoomType.Bedroom, 2, new SmokeSensor("Smoke Sensor"));

        room = new Room(RoomType.ChildrenBedroom, 2);
        builder.addRoom(room);
        builder.addMachine(RoomType.ChildrenBedroom, 2, deviceFactory.createBlindWindow(room));
        builder.addMachine(RoomType.ChildrenBedroom, 2, deviceFactory.createPC(room));
        builder.addMachine(RoomType.ChildrenBedroom, 2, deviceFactory.createConditioner(room));
        builder.addSensor(RoomType.ChildrenBedroom, 2, new SmokeSensor("Smoke Sensor"));

        room = new Room(RoomType.Bathroom, 2);
        builder.addRoom(room);
        builder.addMachine(RoomType.Bathroom, 2, deviceFactory.createWashingMachine(room));
        builder.addMachine(RoomType.Bathroom, 2, deviceFactory.createDryer(room));
        builder.addMachine(RoomType.Bathroom, 2, deviceFactory.createHairdryer(room));
        builder.addSensor(RoomType.Bathroom, 2, new HumiditySensor("Humidity Sensor"));

        // add people
        builder.addCreature(RoomType.Kitchen, 0, personFactory.createMother("Mother", new PersonalBehavior(builder.build()), builder.build().getFloor(0).getRoom(RoomType.Kitchen)), begin, end);
        builder.addCreature(RoomType.Garage, 0, personFactory.createFather("Father", new PersonalBehavior(builder.build()), builder.build().getFloor(0).getRoom(RoomType.Garage)), begin, end);
        builder.addCreature(RoomType.LivingRoom, 0, personFactory.createGrandMother("Grandmother 1", new PersonalBehavior(builder.build()), builder.build().getFloor(0).getRoom(RoomType.LivingRoom)), begin, end);
        builder.addCreature(RoomType.Bedroom, 2, personFactory.createGrandMother("Grandmother 2", new PersonalBehavior(builder.build()), builder.build().getFloor(2).getRoom(RoomType.Bedroom)), begin, end);
        builder.addCreature(RoomType.ChildrenBedroom, 2, personFactory.createOlderSister("Older sister", new PersonalBehavior(builder.build()), builder.build().getFloor(2).getRoom(RoomType.ChildrenBedroom)), begin, end);
        builder.addCreature(RoomType.ChildrenBedroom, 2, personFactory.createYoungerSister("Younger sister", new PersonalBehavior(builder.build()), builder.build().getFloor(2).getRoom(RoomType.ChildrenBedroom)), begin, end);

        // add animals
        builder.addCreature(RoomType.LivingRoom, 0, animalFactory.createGoldenFish("Fish", new AnimalBehavior(builder.build()), builder.build().getFloor(0).getRoom(RoomType.LivingRoom)), begin, end);
        builder.addCreature(RoomType.LivingRoom, 0, animalFactory.createCat("Cat 1", new AnimalBehavior(builder.build()), builder.build().getFloor(0).getRoom(RoomType.LivingRoom)), begin, end);
        builder.addCreature(RoomType.Bedroom, 1, animalFactory.createDog("Dog 1", new AnimalBehavior(builder.build()), builder.build().getFloor(1).getRoom(RoomType.Bedroom)), begin, end);
        builder.addCreature(RoomType.Bedroom, 2, animalFactory.createCat("Cat 2", new AnimalBehavior(builder.build()), builder.build().getFloor(2).getRoom(RoomType.Bedroom)), begin, end);
        builder.addCreature(RoomType.ChildrenBedroom, 2, animalFactory.createDog("Dog 2", new AnimalBehavior(builder.build()), builder.build().getFloor(2).getRoom(RoomType.ChildrenBedroom)), begin, end);

        return builder.build();
    }
}
