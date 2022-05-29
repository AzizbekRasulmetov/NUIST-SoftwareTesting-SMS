package cn.nuist.dbc;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Administrator
 */
public class DataBaseConnection {
    public Connection createConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");   // 加载驱动程序
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sms",
                    "root", "azizbek2000");  // 取得数据库连接
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
