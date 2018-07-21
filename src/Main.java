
import java.util.ArrayList;
import java.util.Scanner;

class Main {
    static Scanner in;
    Bookdao dao = new Bookdao();

    static {
        in = new Scanner(System.in);
    }

    Main() {
    }

    public void print() {
        System.out.println("********************");
        System.out.println("1. 添加图书");
        System.out.println("2. 查询所有图书");
        System.out.println("3. 根据图书编号查询图书");
        System.out.println("4. 修改图书");
        System.out.println("5. 删除图书");
        System.out.println("0. 退出");
    }

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
        boolean flag = this.dao.addBook(book);
        if (flag) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }

    }

    public void queryAllBook() {
        ArrayList<Book> list = this.dao.queryAllBook();

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

    public void queryBookById() {
        System.out.println("请输入要查询的书号");
        int id = in.nextInt();
        Book bk = this.dao.queryBookById(id);
        if (bk != null) {
            System.out.println("编号：" + bk.getId() + "，书名：" + bk.getName() + "，价格：" + bk.getPrice()
                    + "，作者：" + bk.getAuthor() + "，出版商：" + bk.getPublisher() + ", 发行日期：" + bk.getPdate() + "，数量：" + bk.getPamount());
        } else {
            System.out.println("查找的图书不存在");
        }
    }

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
        int ret = this.dao.modifyBook(id, name, price, author, publisher, pdate, pamount);
        if (ret == 1) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }

    }

    public void deleteBook() {
        System.out.println("请输入如要删除的图书的图书号");
        int id = in.nextInt();
        int ret = this.dao.deleteBook(id);
        if (ret == 1) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除的图书不存在");
        }

    }

    public static void main(String[] args) {
        Main mainui = new Main();

        while(true) {
            while(true) {
                mainui.print();
                System.out.println("请选择你要进行的操作");
                int choice = in.nextInt();
                switch(choice) {
                    case 0:
                        System.exit(0);
                        break;
                    case 1:
                        mainui.addBook();
                        break;
                    case 2:
                        mainui.queryAllBook();
                        break;
                    case 3:
                        mainui.queryBookById();
                        break;
                    case 4:
                        mainui.modifyBook();
                        break;
                    case 5:
                        mainui.deleteBook();
                }
            }
        }
    }
}
