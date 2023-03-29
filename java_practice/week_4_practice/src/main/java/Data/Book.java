package Data;

public class Book {
    private int bookId;
    private String title;
    private String publisher;
    private int price;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Book(int bookId, String title, String publisher, int price) {
        setBookId(bookId);
        setTitle(title);
        setPublisher(publisher);
        setPrice(price);
    }
}
