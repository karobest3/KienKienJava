package Models;

import Commons.FuncCloseConnectDB;
import Utils.MySQLConnUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HouseDAOImpl implements HouseDAO{
    @Override
    public void AddNewHouse(House house){
        String queryInsertVilla = "Insert into Houses values (?,?,?,?,?,?,?,?,?)";
        try {
            Connection conn = MySQLConnUtils.getMySQLConnection(); //bắt buộc phải có
            PreparedStatement stmt = conn.prepareStatement(queryInsertVilla); //bắt buộc phải có
            stmt.setString(1, house.getId());
            stmt.setString(2, house.getNameService());
            stmt.setDouble(3, house.getAreaUsed());
            stmt.setDouble(4, house.getRentalCosts());
            stmt.setInt(5, house.getMaxNumberOfPeople());
            stmt.setString(6, house.getTypeRent());
            stmt.setString(7, house.getRoomStandard());
            stmt.setString(8, house.getConvenientDescription());
            stmt.setInt(9, house.getNumberOfFloors());
            stmt.executeUpdate(); // Sau khi set xong câu lệnh này sẽ đẩy dữ liệu vào SQL
            FuncCloseConnectDB.closeConnectDBNoResult(conn, stmt);

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage()); // thông báo khi có lỗi kết nối với SQL
        }
    }
    @Override
    public ArrayList<House> GetListHouses(){
        ArrayList<House> listRooms =  new ArrayList<House>();
        String query = "Select * from Houses";

        try {
            Connection conn = MySQLConnUtils.getMySQLConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                House house = new House();
                house.setId(rs.getString("id"));
                house.setNameService(rs.getString("nameHouse"));
                house.setAreaUsed(rs.getDouble("areaUsed"));
                house.setRentalCosts(rs.getDouble("rentalCosts"));
                house.setMaxNumberOfPeople(rs.getInt("maxNumberOfPeople"));
                house.setTypeRent(rs.getString("typeRent"));
                house.setRoomStandard(rs.getString("roomStandard"));
                house.setConvenientDescription(rs.getString("convenientDescription"));
                house.setNumberOfFloors(rs.getInt("numberOfFloors"));
                listRooms.add(house);
            }
            FuncCloseConnectDB.closeConnectDB(conn, stmt,rs);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage()); // thông báo khi có lỗi kết nối với SQL
        }

        return listRooms;
    }
}
