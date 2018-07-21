
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
            PreparedStatement ps = conn.prepareStatement("insert into books(bname,price,author,publisher,pdate,pamount) values(?,?,?,?,?,?)");
            ps.setString(1, book.getName());
            ps.setFloat(2, book.getPrice());
            ps.setString(3, book.getAuthor());
            ps.setString(4, book.getPublisher());
            ps.setString(5, book.getPdate());
            ps.setInt(6,book.getPamount());
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
            PreparedStatement ps = conn.prepareStatement("select id,bname,price,author,publisher,pdate,pamount from books where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                book = new Book(rs.getInt(1), rs.getString(2), rs.getFloat(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
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

    public int modifyBook(int id, String name, float price, String author, String publisher, String pdate, int pamount) {
        Connection conn = Dbutil.getConn();
        int ret = 0;

        // FIXME
        try {
            PreparedStatement ps = conn.prepareStatement("update books set bname=? , price=?, author=?, publisher=?, pdate=?, pamount=? where id =?");
            ps.setString(1, name);
            ps.setFloat(2, price);
            ps.setString(3, author);
            ps.setString(4, publisher);
            ps.setString(5, pdate);
            ps.setInt(6, pamount);
            ps.setInt(7, id);
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
                String author = rs.getString(4);
                String publisher = rs.getString(5);
                String pdate = rs.getString(6);
                int pamount = rs.getInt(7);
                Book book = new Book(id, name, price, author, publisher, pdate, pamount);
                list.add(book);
            }
        } catch (SQLException var9) {
            var9.printStackTrace();
        }

        return list;
    }
}
