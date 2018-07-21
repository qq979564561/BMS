
public class Book {
    private int id;
    private String name;
    private float price;
    private String author;
    private String publisher;
    private String pdate;
    private int pamount;

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPdate() {
        return pdate;
    }

    public void setPdate(String pdate) {
        this.pdate = pdate;
    }

    public int getPamount() {
        return pamount;
    }

    public void setPamount(int pamount) {
        this.pamount = pamount;
    }


    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public Book() {
    }


    /**
     * 构造器，Book 类
     * @param id
     * @param name
     * @param price
     * @param author
     */
    public Book(int id, String name, float price, String author, String publisher, String pdate, int pamount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
        this.publisher = publisher;
        this.pdate = pdate;
        this.pamount = pamount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    // FIXME
    public Book(String name, float price, String author, String publisher, String pdate, int pamount) {
        this.name = name;
        this.price = price;
        this.author = author;
        this.publisher = publisher;
        this.pdate = pdate;
        this.pamount = pamount;
    }
}
