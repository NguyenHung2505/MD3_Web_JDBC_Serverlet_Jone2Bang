package service;

import model.HocSinh;
import model.Lop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LopserviceImpl implements Lopservice{
    List<Lop>lops = new ArrayList<>();
    protected static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysv?useSSL=false", "root", "1234");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }


    @Override
    public List<Lop> findAll() {
        List<Lop> lops = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select *from lop");) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                lops.add(new Lop(id, name));
            }
        } catch (SQLException e) {

        }
        return lops;
    }

    @Override
    public void add(HocSinh lop) throws Exception {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into lop(name,age) value (?,?)");) {
            preparedStatement.setInt(1, lop.getId());
            preparedStatement.setString(2, lop.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    @Override
    public Lop findById(int id) {
        Lop lop = new Lop();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from lop where id = ?");) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement); //in ra câu truy vấn.
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idClass = rs.getInt("id");
                String name = rs.getString("name");
                lop = new Lop(idClass, name);
            }
        } catch (SQLException e) {
        }
        return lop;
    }

    @Override
    public boolean update(HocSinh lop) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

}
