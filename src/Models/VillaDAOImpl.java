package Models;

import Commons.FuncCloseConnectDB;
import Utils.MySQLConnUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VillaDAOImpl implements VillaDAO{
    @Override
    public void AddNewVilla(Villa villa){
        String queryInsertVilla = "Insert into Villas values (?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection conn = MySQLConnUtils.getMySQLConnection();
            PreparedStatement stmt = conn.prepareStatement(queryInsertVilla);
            stmt.setString(1, villa.getId());
            stmt.setString(2, villa.getNameService());
            stmt.setDouble(3, villa.getAreaUsed());
            stmt.setDouble(4, villa.getRentalCosts());
            stmt.setInt(5, villa.getMaxNumberOfPeople());
            stmt.setString(6, villa.getTypeRent());
            stmt.setString(7, villa.getRoomStandard());
            stmt.setString(8, villa.getConvenientDescription());
            stmt.setDouble(9, villa.getAreaPool());
            stmt.setInt(10, villa.getNumberOfFloors());
            stmt.executeUpdate(); // Sau khi set xong câu lệnh này sẽ đẩy dữ liệu vào SQL
            FuncCloseConnectDB.closeConnectDBNoResult(conn, stmt);

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage()); // thông báo khi có lỗi kết nối với SQL
        }
    }
    @Override
    public ArrayList<Villa> GetListVillas(){
        ArrayList<Villa> listVillas =  new ArrayList<Villa>();
        String query = "Select * from Villas";

        try {
            Connection conn = MySQLConnUtils.getMySQLConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Villa villa = new Villa();
                villa.setId(rs.getString("id"));
                villa.setNameService(rs.getString("nameVilla"));
                villa.setAreaUsed(rs.getDouble("areaUsed"));
                villa.setRentalCosts(rs.getDouble("rentalCosts"));
                villa.setMaxNumberOfPeople(rs.getInt("maxNumberOfPeople"));
                villa.setTypeRent(rs.getString("typeRent"));
                villa.setRoomStandard(rs.getString("roomStandard"));
                villa.setConvenientDescription(rs.getString("convenientDescription"));
                villa.setAreaPool(rs.getDouble("areaPool"));
                villa.setNumberOfFloors(rs.getInt("numberOfFloors"));
                listVillas.add(villa);
            }
            FuncCloseConnectDB.closeConnectDB(conn, stmt,rs);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage()); // thông báo khi có lỗi kết nối với SQL
        }

        return listVillas;
    }
}
