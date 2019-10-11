package Models;

import java.util.ArrayList;

interface HouseDAO {
    void AddNewHouse(House house);
    ArrayList<House> GetListHouses();
}
