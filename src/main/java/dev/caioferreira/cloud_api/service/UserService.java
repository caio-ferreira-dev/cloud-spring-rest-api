package dev.caioferreira.cloud_api.service;

import dev.caioferreira.cloud_api.domain.model.User;

public interface UserService {
    User findById(long id);
    User create(User userToCreate);
}
