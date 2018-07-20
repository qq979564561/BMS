import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbutil {
    public static Connection conn = null;
    // 设置数据库URL
    private static String MyUrl = "jdbc:mysql://localhost:3306/java?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false" ;

    public Dbutil() {
    }

    public static Connection getConn() {

        try {
            conn = DriverManager.getConnection(MyUrl, "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return conn;
    }

    public static void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception var1) {
            var1.printStackTrace();
        }

    }
}
