
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Bookdao {
    public Bookdao() {
    }

    public boolean addBook(Book book) {
        boolean result = false;
        Connection conn = Dbutil.getConn();

        try {
            PreparedStatement ps = conn.prepareStatement("insert into books(bname,price) values(?,?)");
            ps.setString(1, book.getName());
            ps.setFloat(2, book.getPrice());
            ps.execute();
            result = true;
        } catch (SQLException var8) {
            var8.printStackTrace();
        } finally {
            Dbutil.close();
        }

        return result;
    }

    public Book queryBookById(int id) {
        Connection conn = Dbutil.getConn();
        Book book = null;

        try {
            PreparedStatement ps = conn.prepareStatement("select id,bname,price from books where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                book = new Book(rs.getInt(1), rs.getString(2), rs.getFloat(3));
            }
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

        return book;
    }

    public int deleteBook(int id) {
        Connection conn = Dbutil.getConn();
        int ret = 0;

        try {
            PreparedStatement ps = conn.prepareStatement("delete from books where id = ?");
            ps.setInt(1, id);
            ret = ps.executeUpdate();
        } catch (SQLException var5) {
            var5.printStackTrace();
        }

        return ret;
    }

    public int modifyBook(int id, String name, float price) {
        Connection conn = Dbutil.getConn();
        int ret = 0;

        try {
            PreparedStatement ps = conn.prepareStatement("update books set bname=? , price=? where id =?");
            ps.setString(1, name);
            ps.setFloat(2, price);
            ps.setInt(3, id);
            ret = ps.executeUpdate();
        } catch (SQLException var7) {
            var7.printStackTrace();
        }

        return ret;
    }

    public ArrayList<Book> queryAllBook() {
        ArrayList<Book> list = new ArrayList();
        Connection conn = Dbutil.getConn();

        try {
            PreparedStatement ps = conn.prepareStatement("select * from books");
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                float price = rs.getFloat(3);
                Book book = new Book(id, name, price);
                list.add(book);
            }
        } catch (SQLException var9) {
            var9.printStackTrace();
        }

        return list;
    }
}
