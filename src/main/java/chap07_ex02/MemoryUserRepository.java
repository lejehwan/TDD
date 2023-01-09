package chap07_ex02;

import java.util.HashMap;
import java.util.Map;

public class MemoryUserRepository implements UserRepository{

    private Map<String, User> users = new HashMap<>();

    // fake 대역 사용
    @Override
    public void save(User user) {
        users.put(user.getId(), user);
    }

    // fake 대역 사용
    @Override
    public User findById(String id) {
        return users.get(id);
    }
}
