package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String id;
    private String password;
    private String address;
    private String phoneNumber;
    private Map<Integer, Book> cart;

    //생성자
    public User(String id, String password, String address, String phoneNumber) {
        this.id = id;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.cart = new HashMap<>();
    }

    //getter와 setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Map<Integer, Book> getCart() {
        return cart;
    }

    public void setCart(Map<Integer, Book> cart) {
        this.cart = cart;
    }

    public void addCart(Book book) {
        this.cart.put(book.getBookId(), book);
    }
}
