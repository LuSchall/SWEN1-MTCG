package at.technikum.apps.mtcg.service;

import at.technikum.apps.mtcg.repository.UserRepositoryInterface;

public class UserService {
    private final UserRepositoryInterface userRepository;
    public UserService(UserRepositoryInterface userRepository) {
        this.userRepository = userRepository;
    }



}
