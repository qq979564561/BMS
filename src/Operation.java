import java.util.ArrayList;
import java.util.Scanner;

/**
 * 【控制层】
 * 作用：连接模型层和视图层
 * 具体功能: 对书本类的增删改查；用户登入
 */
public class Operation {
    static Scanner in;
    Bookdao dao1 = new Bookdao();
    Usersdao dao2 = new Usersdao();
    static {
        in = new Scanner(System.in);
    }

    Operation() {
    }

    /**
     * 方法：打印主操作界面
     */
    public void print() {
        System.out.println("********************");
        System.out.println("1. 添加图书");
        System.out.println("2. 查询所有图书");
        System.out.println("3. 根据图书编号查询图书");
        System.out.println("4. 根据图书名字查询");
        System.out.println("5. 修改图书");
        System.out.println("6. 删除图书");
        System.out.println("0. 退出");
    }

    /**
     * 方法：添加图书
     * 控制层
     */
    public void addBook() {
        System.out.println("请输入图书的名称");
        String bname = in.next();
        System.out.println("请输入图书的价钱");
        float price = in.nextFloat();
        System.out.println("请输入图书的作者");
        String author = in.next();
        System.out.println("请输入图书的出版商");
        String publisher = in.next();
        System.out.println("请输入图书的发行日期");
        String pdate = in.next();
        System.out.println("请输入图书的数量");
        int pamount = in.nextInt();
        // FIXME
        Book book = new Book(bname, price, author, publisher, pdate, pamount);
        boolean flag = this.dao1.addBook(book);
        if (flag) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }

    }

    /**
     * 方法：查询所有图书
     */
    public void queryAllBook() {
        ArrayList<Book> list = this.dao1.queryAllBook();

        for(int i = 0; i < list.size(); ++i) {
            int id = ((Book)list.get(i)).getId();
            String name = ((Book)list.get(i)).getName();
            float price = ((Book)list.get(i)).getPrice();
            String author = ((Book)list.get(i)).getAuthor();
            String publisher = ((Book)list.get(i)).getPublisher();
            String pdate = ((Book)list.get(i)).getPdate();
            int pamount =  ((Book)list.get(i)).getPamount();
            System.out.println("编号: "+ id + ", 书名: " + name + "，价格: " + price
                    + "，作者: " + author + "，出版商: " + publisher + ", 发行日期: " + pdate + "，数量：" + pamount);
        }

    }

    /**
     * 方法：根据编号查询图书
     */
    public void queryBookById() {
        System.out.println("请输入要查询的书号");
        int id = in.nextInt();
        Book bk = this.dao1.queryBookById(id);
        if (bk != null) {
            System.out.println("编号：" + bk.getId() + "，书名：" + bk.getName() + "，价格：" + bk.getPrice()
                    + "，作者：" + bk.getAuthor() + "，出版商：" + bk.getPublisher() + ", 发行日期：" + bk.getPdate() + "，数量：" + bk.getPamount());
        } else {
            System.out.println("查找的图书不存在");
        }
    }

    /**
     * 方法：根据书名查询图书
     */
    public void queryBookByName() {
        System.out.println("请输入要查询的书名");
        String name = in.next();
        Book bk = this.dao1.queryBookByName(name);
        if (bk != null) {
            System.out.println("编号：" + bk.getId() + "，书名：" + bk.getName() + "，价格：" + bk.getPrice()
                    + "，作者：" + bk.getAuthor() + "，出版商：" + bk.getPublisher() + ", 发行日期：" + bk.getPdate() + "，数量：" + bk.getPamount());
        } else {
            System.out.println("查找的图书不存在");
        }
    }

    /**
     * 方法：修改图书
     */
    public void modifyBook() {
        System.out.println("请输入要修改的图书的编号");
        int id = in.nextInt();
        System.out.println("请输入新的书名");
        String name = in.next();
        System.out.println("请输入新的价格");
        float price = in.nextFloat();
        System.out.println("请输入新的作者名字");
        String author = in.next();
        System.out.println("请输入出版商的名字");
        String publisher = in.next();
        System.out.println("请输入新的发行日期");
        String pdate = in.next();
        System.out.println("请输入新的数量");
        int pamount = in.nextInt();
        int ret = this.dao1.modifyBook(id, name, price, author, publisher, pdate, pamount);
        if (ret == 1) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }

    }

    /**
     * 方法：删除图书
     */
    public void deleteBook() {
        System.out.println("请输入如要删除的图书的图书号");
        int id = in.nextInt();
        int ret = this.dao1.deleteBook(id);
        if (ret == 1) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除的图书不存在");
        }
    }

    /**
     * 方法：查询并核对用户名、密码是否正确
     */
    public boolean ifRight() {

        boolean key = false;
        Users users = this.dao2.ifRight();
        System.out.println("***** 默认用户名和密码为" + users.getUsername() +", "+ users.getPassword() +  "***** ");
        System.out.println("请输入用户名：");
        String usernameInput = in.next();
        System.out.println("请输入密码：");
        String passwordInput = in.next();

            if (users != null) {
                // 判断用户名密码是否正确
                if ((users.getUsername().equals(usernameInput) ) && (users.getPassword().equals(passwordInput) )) {
                    System.out.println("登入成功！");
                    key = true;

                }
                else {
                    System.out.println("用户名或密码输入错误！");
                }
            }

        return key;
    }
}
