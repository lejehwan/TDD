package chap07_ex02;

public interface UserRepository {
    void save(User user);

    User findById(String id);
}
