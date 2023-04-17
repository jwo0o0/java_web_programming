package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    static Map<String, User> users = new HashMap<>();

    public List<User> findAllUser() { return new ArrayList<>(users.values()); }

    public User findUser(String id) {
        return users.get(id);}

    public void setUser(User newUser) {
        users.put(newUser.getId(), newUser);
    }

    public void setUserBook(String userId, Book book) {
        users.get(userId).addCart(book);
    }

    public Map<Integer, Book> getUserBooks(String userId) {
        return users.get(userId).getCart();
    }
}
