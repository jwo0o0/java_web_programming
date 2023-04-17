package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class BookService {
    static Map<Integer, Book> books = new HashMap<>();

    public BookService() {
        Book b = new Book(1,"축구의 역사", "굿스포츠", 7000, "스포츠", "");
        books.put(1, b);
        b = new Book(2,"골프 바이블", "대한미디어", 35000, "스포츠", "");
        books.put(2, b);
        b = new Book(3,"피겨 교본", "굿스포츠", 8000, "스포츠", "");
        books.put(3, b);
    }

    public void setBook(Book book) {
        books.put(book.getBookId(), book);
    }

    public Book getBook(int bookId) {
        return books.get(bookId);
    }

    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }
}
