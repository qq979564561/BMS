
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 主程序入口
 */
class Main {
    static Scanner in;
    Bookdao dao = new Bookdao();

    static {
        in = new Scanner(System.in);
    }

    Main() {
    }

    public static void main(String[] args) {
        Operation mainui = new Operation();
        // 判断是否登入成功的标志
        boolean key = mainui.ifRight();
        while (true) {
            if (!key) {
                key = mainui.ifRight();
            }
            if (key) {
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
                                mainui.queryBookByName();
                                break;
                            case 5:
                                mainui.modifyBook();
                                break;
                            case 6:
                                mainui.deleteBook();
                        }
                    }
                }
            }
        }
    }
}
