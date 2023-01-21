package omo.sh.house;

import java.util.ArrayList;

/**
 *  Class represents Floor which contains rooms.
 */
public class Floor {

    /**
     * Floor number on which room is.
     */
    final int floorNumber;

    /**
     * Rooms on floor.
     */
    private ArrayList<Room> roomsOnFloor;

    /**
     * Class constructor.
     *
     * @param floorNumber on which new room is
     */
    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        roomsOnFloor = new ArrayList<>();
    }

    /**
     * @return list of all room on floor
     */
    public ArrayList<Room> getRoomsOnFloor() {
        return roomsOnFloor;
    }

    @Override
    public String toString() {
        return "Floor number " + floorNumber;
    }

    /**
     * @param i index of room
     * @return room from list of all room on floor
     */
    public Room getRoomByID(int i) {
        return roomsOnFloor.get(i);
    }

    /**
     * Return room based on its type.
     *
     * @param roomType to return
     * @return room required or null if there is no room in house
     */
    public Room getRoom(RoomType roomType) {
        for (Room room: roomsOnFloor) {
            if (room.getRoomType().equals(roomType)) {
                return room;
            }
        }
        return null;
    }
}
