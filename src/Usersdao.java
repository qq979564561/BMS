import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Usersdao {
    /**
     * 构造器：空
     */
    public Usersdao() {

    }

    /**
     * 方法：查询并判断用户名和密码是否正确
     * @return
     */
    public Users ifRight() {
        boolean result = false;
        Connection conn = Dbutil.getConn();
        Users users = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select username,password from users where id = ?");
            ps.setInt(1,1);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                users = new Users(rs.getString(1), rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

}

