package com.examly.springapp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    public User saveUser(User user) {
        return repo.save(user);
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User getUserById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public User updateUser(Long id, User user) {
        user.setId(id);
        return repo.save(user);
    }

    public List<User> getUsersByRole(String role) {
        return repo.findByRole(role);
    }

    public Page<User> getUsersWithPagination(int page, int size) {
        return repo.findAll(PageRequest.of(page, size));
    }
}
