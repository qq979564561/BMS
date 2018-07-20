
public class Book {
    private int id;
    private String name;
    private float price;
    private String author;

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
    // FIXME
    public Book(int id, String name, float price, String author) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
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
    public Book(String name, float price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }
}
