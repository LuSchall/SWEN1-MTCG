package at.technikum.apps.mtcg.service;

import at.technikum.apps.mtcg.repository.UserRepository;

public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



}
