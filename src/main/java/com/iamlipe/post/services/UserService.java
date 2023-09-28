package com.iamlipe.post.services;

import com.iamlipe.post.domain.User;
import com.iamlipe.post.dto.UserDTO;
import com.iamlipe.post.repositories.UserRepository;
import com.iamlipe.post.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("User not found"));
    }

    public void insert(User user) {
        repository.insert(user);
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    public User update(User user) {
        User newObj = findById(user.getId());
        updateData(newObj, user);
        return repository.save(newObj);
    }

    private void updateData(User newObj, User user) {
        newObj.setName(user.getName());
        newObj.setEmail(user.getEmail());
    }

    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
