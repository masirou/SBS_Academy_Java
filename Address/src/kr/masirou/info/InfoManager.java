package kr.masirou.info;

import kr.masirou.db.DatabaseManager;

import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class InfoManager {
    private static InfoManager instance;
    public static InfoManager getInstance() {
        if(instance == null) {
            instance = new InfoManager();
        }
        return instance;
    }
    private InfoManager() {
        instance = this;
    }
    public int updateInfo(int number, String phone) {
        return DatabaseManager.getInstance().execute((s) -> {
            s.setString(1, phone);
            s.setInt(2, number);
            return s.executeUpdate();
        }, "update `info` set `phone` = ? where `num` = ?");
    }
    public int unRegisterInfo(int number) {
        return DatabaseManager.getInstance().execute((s) -> {
            s.setInt(1, number);
            return s.executeUpdate();
        }, "delete from `info` where `num` = ?");
    }
    int registerInfo(Info info) {

        boolean check = DatabaseManager.getInstance().execute(s -> {
            s.setString(1, info.getPhone());
            ResultSet set = s.executeQuery();
            boolean result = set.next();
            set.close();
            return result;
        }, "select * from `info` where `phone` = ?");
        if(check) return -2;
        int update = DatabaseManager.getInstance().execute((s) -> {
            s.setString(1, info.getName());
            s.setString(2, info.getPhone());
            s.setString(3, info.getMemo());
            return s.executeUpdate();
        }, "insert into `info`(`name`, `phone`, `memo`) values(?,?,?)");
        if(update == 1) return DatabaseManager.getInstance().execute((s) -> {
            ResultSet set = s.executeQuery();
            int result = -1;
            if(set.next()) {
                result = set.getInt(1);
            }
            set.close();
            return result;

        }, "select LAST_INSERT_ID()");
        else return -1;
    }
    public List<Info> getInfos() {
        return DatabaseManager.getInstance().execute((s) -> {
            ResultSet set = s.executeQuery();
            List<Info> result = new ArrayList<Info>();
            while (set.next()) {

                result.add(new Info(
                        set.getInt("num"),
                        set.getString("name"),
                        set.getString("phone"),
                        set.getString("memo")));
            }
            set.close();
            return result;
        }, "select * from `info`");

    }

}
