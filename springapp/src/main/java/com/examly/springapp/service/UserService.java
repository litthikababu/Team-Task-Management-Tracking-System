package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.User;
import org.springframework.data.domain.Page;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    User updateUser(Long id, User user);

    List<User> getUsersByRole(String role);

    Page<User> getUsersWithPagination(int page, int size);
}
