package service;

import model.HocSinh;
import model.Lop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HocSinhServiceImpl implements HocSinhservice{
    Lopservice lopservice = new LopserviceImpl();
    List<HocSinh>hocSinhs = new ArrayList<>();
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
    public List<HocSinh> findAll() {
        List<HocSinh> hocSinhs = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select *from hocsinh");) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String name = rs.getString("name");
                int classId = rs.getInt("classId"); // lấy ra classId từ bảng student trong db
                Lop lop = lopservice.findById(classId); // từ classId vừa lấy được, dùng ClassService để tìm đối tượng class tương ứng
                hocSinhs.add(new HocSinh(id, name, lop, age)); //thêm đối tượng là danh sách
            }
        } catch (SQLException e) {
        }
        return hocSinhs;
    }

    @Override
    public void add(HocSinh hocSinh) throws Exception {
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement("insert into hocsinh( name, age, classId) values (?,?,?)");) {
                preparedStatement.setString(1, hocSinh.getName());
                preparedStatement.setInt(2, hocSinh.getAge());
                preparedStatement.setInt(3, hocSinh.getLop().getId());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
            }
    }

    @Override
    public HocSinh findById(int id) {
        HocSinh hocSinh = new HocSinh();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from hocsinh where id = ?");) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement); //in ra câu truy vấn.
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int age = rs.getInt("age");
                String name = rs.getString("name");
                int classId = rs.getInt("classId"); // lấy ra classId từ bảng student trong db
                Lop lop = lopservice.findById(classId); // từ classId vừa lấy được, dùng ClassService để tìm đối tượng class tương ứng
                hocSinh = new HocSinh(id , name ,lop ,age);
            }
        } catch (SQLException e) {
        }
        return hocSinh;
    }

    @Override
    public boolean update(HocSinh hocSinh) throws SQLException {
        boolean upDate;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = getConnection().prepareStatement("update hocsinh set name = ? , age = ?  where id = ?");) {
            preparedStatement.setString(1, hocSinh.getName());
            preparedStatement.setInt(2, hocSinh.getAge());
            preparedStatement.setInt(3, hocSinh.getId());
            upDate= preparedStatement.executeUpdate()>0;
        }
        return upDate;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("delete from hocsinh where id=?");) {
            statement.setInt(1, id);
            System.out.println(statement);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public List<HocSinh> findAllByClass(int classId) {
        List<HocSinh> hocSinhs = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select *from hocsinh where classId = ? ");) {
            preparedStatement.setInt(1,classId);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String name = rs.getString("name");
                int clazzId = rs.getInt("classId"); // lấy ra classId từ bảng student trong db
                Lop lop = lopservice.findById(clazzId); // từ classId vừa lấy được, dùng ClassService để tìm đối tượng class tương ứng
                hocSinhs.add(new HocSinh(id, name, lop, age)); //thêm đối tượng là danh sách
            }
        } catch (SQLException e) {
        }
        return hocSinhs;
    }

    @Override
        public List<HocSinh> findAllByCNameContains(String findName) {
        List<HocSinh> hocSinhs = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select *from hocsinh where classId = ? ");) {
            preparedStatement.setString(1,"%"+findName+"%");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String name = rs.getString("name");
                int classId = rs.getInt("classId"); // lấy ra classId từ bảng student trong db
                Lop lop = lopservice.findById(classId); // từ classId vừa lấy được, dùng ClassService để tìm đối tượng class tương ứng
                hocSinhs.add(new HocSinh(id, name, lop, age)); //thêm đối tượng là danh sách
            }
        } catch (SQLException e) {
        }
        return hocSinhs;

    }
}
