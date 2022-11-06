package kr.masirou.db;

import java.sql.*;

public class DatabaseManager {
    private static DatabaseManager instance;

    public static DatabaseManager getInstance() {

        if(instance == null) {
            new DatabaseManager();
        }
        return instance;

    }
    private DatabaseManager() {
        instance = this;
        init();
    }
    private void init() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버가 설치되어있지 않습니다");
            System.exit(1);
        }
        connect();

    }
    private Connection con;
    private void connect() {
        try {
            con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/masirou", "root", "1234");
        } catch (SQLException e) {
            System.out.println("데이터 베이스 연결 불가");
            System.exit(1);
        }
        createTable();
    }
    private void createTable() {
        try {
            Statement s = con.createStatement();
            s.execute("create table if not exists `info` (" +
                    "`num` int not null auto_increment, " +
                    "`name` varchar(50) not null, " +
                    "`phone` varchar(32) not null, " +
                    "`memo` text, " +
                    "primary key(`num`)" +
                    ")");
            s.close();
        } catch (SQLException e) {
            System.out.println("테이블 생성에 실패했습니다");
            System.exit(1);
        }
    }

    public <T> T execute(DatabaseConnector<T> connector, String sql) {
        try {
            PreparedStatement s = con.prepareStatement(sql);
            T result = connector.execute(s);
            s.close();
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
