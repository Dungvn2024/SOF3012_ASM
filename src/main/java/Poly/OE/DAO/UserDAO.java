package Poly.OE.DAO;

import java.util.List;

import Poly.OE.Entity.User;

public interface UserDAO {
    List<User> findAll();
    User findById(String id);
    void create(User entity);
    void update(User entity);
    void deleteById(String id);
    
    public User findByIdOrEmail(String idOrEmail);
}