package Model;

import java.time.LocalDateTime;

public class Book {
    private int bookId;
    private String title;
    private String publisher;
    private int price;
    private String category;
    private String imgLink;
    private String purchaseTime;


    //생성자
    public Book(int bookId, String title, String publisher, int price, String category, String imgLink) {
        this.bookId = bookId;
        this.title = title;
        this.publisher = publisher;
        this.price = price;
        this.category = category;
        this.imgLink = imgLink;
    }

    //getter와 setter
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public String getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(String purchaseTime) {
        this.purchaseTime = purchaseTime;
    }
}
