package kr.masirou.db;

import kr.masirou.PersonDTO;

import java.sql.*;

public class DataBaseManager {
    private static DataBaseManager instance;

    public static DataBaseManager getInstance() {
        if (instance == null) {
            new DataBaseManager();
        }
        return instance;
    }
    private DataBaseManager() {
        instance = this;
    }
    private boolean connected = false;
    private Connection con;
    public void setUp() {
        if(connected) return;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/masirou", "root", "1234");
            createTable();
            System.out.println("Connected");
            connected = true;
        } catch (ClassNotFoundException e) {
            connected = false;
            System.out.println("드라이버가 설치되어있지 않습니다.");
        } catch (SQLException e) {
            connected = false;
            System.out.println("데이터베이스에 연결할 수 없습니다.");
        }

    }
    private void createTable() throws SQLException{
        Statement s = con.createStatement();
        s.execute("CREATE TABLE IF NOT EXISTS `PERSON` (" +
                "`NAME` VARCHAR(32) NOT NULL," +
                "`AGE` INT NOT NULL" +
                ");");
        s.close();
    }
    public PersonDTO setPerson(String name, int age) throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO `PERSON`(`NAME`, `AGE`) VALUES(?,?)");
        ps.setString(1, name);
        ps.setInt(2, age);
        PersonDTO result;
        if(ps.execute()) {
            result = new PersonDTO(name, age);
        } else {
            result = null;
        }
        ps.close();
        return  result;
    }
    public PersonDTO getPerson(String name) throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT * FROM `PERSON` WHERE `NAME` =?");
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        PersonDTO result;
        if(rs.next()) {
            String personName = rs.getString("name");
            int personAge = rs.getInt("age");
            result = new PersonDTO(personName, personAge);
        } else {
            result = null;
        }
        rs.close();
        ps.close();

        return result;
    }

}
