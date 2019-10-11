package Models;

import java.util.ArrayList;

interface VillaDAO {
    void AddNewVilla(Villa villa);
    ArrayList<Villa> GetListVillas();
}
