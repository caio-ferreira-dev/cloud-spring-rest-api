package dev.caioferreira.cloud_api.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import dev.caioferreira.cloud_api.domain.model.User;
import dev.caioferreira.cloud_api.domain.repository.UserRepository;
import dev.caioferreira.cloud_api.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if(userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())) {
            throw new IllegalArgumentException("This user id already exists");
        }
        return userRepository.save(userToCreate);
    }

}
