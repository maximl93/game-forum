package com.example.gameforum.service;

import com.example.gameforum.dto.user.UserCreateDTO;
import com.example.gameforum.dto.user.UserDTO;
import com.example.gameforum.model.User;
import com.example.gameforum.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO save(UserCreateDTO createDTO) {
        User user = new User();
        user.setUsername(createDTO.getUsername());

        userRepository.save(user);

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());

        return userDTO;
    }

    public UserDTO findById(long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(userDTO.getUsername());

        return userDTO;
    }
}
