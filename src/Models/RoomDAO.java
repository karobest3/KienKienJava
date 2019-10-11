package Models;

import java.util.ArrayList;

interface RoomDAO {
    void AddNewRoom(Room room);
    ArrayList<Room> GetListRooms();
}
