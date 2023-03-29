public class Book {
    String title;
    String author;

    public Book() {
        this("", "");
        System.out.println("생성자 호출됨");
    }
    public Book(String title) {
        this(title, "작자미상");
    }
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public static void main(String[] args) {
        Book littlePrince = new Book("어린 왕자", "생텍 쥐페리");

        Book copyBook = littlePrince;
        System.out.println(copyBook.title + copyBook.author);
    }
}
