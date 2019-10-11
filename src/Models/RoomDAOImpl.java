package Models;

import Commons.FuncCloseConnectDB;
import Utils.MySQLConnUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public void AddNewRoom(Room room){
        String queryInsertVilla = "Insert into Rooms values (?,?,?,?,?,?,?)";
        try {
            Connection conn = MySQLConnUtils.getMySQLConnection(); //bắt buộc phải có
            PreparedStatement stmt = conn.prepareStatement(queryInsertVilla); //bắt buộc phải có
            stmt.setString(1, room.getId());
            stmt.setString(2, room.getNameService());
            stmt.setDouble(3, room.getAreaUsed());
            stmt.setDouble(4, room.getRentalCosts());
            stmt.setInt(5, room.getMaxNumberOfPeople());
            stmt.setString(6, room.getTypeRent());
            stmt.setString(7, room.getFreeService());
            stmt.executeUpdate(); // Sau khi set xong câu lệnh này sẽ đẩy dữ liệu vào SQL
            FuncCloseConnectDB.closeConnectDBNoResult(conn, stmt);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage()); // thông báo khi có lỗi kết nối với SQL
        }
    }
    @Override
    public ArrayList<Room> GetListRooms(){
        ArrayList<Room> listRooms =  new ArrayList<Room>();
        String query = "Select * from Rooms";

        try {
            Connection conn = MySQLConnUtils.getMySQLConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Room room = new Room();
                room.setId(rs.getString("id"));
                room.setNameService(rs.getString("nameRoom"));
                room.setAreaUsed(rs.getDouble("areaUsed"));
                room.setRentalCosts(rs.getDouble("rentalCosts"));
                room.setMaxNumberOfPeople(rs.getInt("maxNumberOfPeople"));
                room.setTypeRent(rs.getString("typeRent"));
                room.setFreeService(rs.getString("freeService"));
                listRooms.add(room);
            }
            FuncCloseConnectDB.closeConnectDB(conn, stmt,rs);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage()); // thông báo khi có lỗi kết nối với SQL
        }

        return listRooms;
    }
}
