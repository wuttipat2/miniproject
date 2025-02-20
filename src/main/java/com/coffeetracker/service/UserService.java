package com.coffeetracker.service;

import com.coffeetracker.dto.UserDTO;
import com.coffeetracker.mapper.UserMapper;
import com.coffeetracker.Entity.User;
import com.coffeetracker.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UserDTO addUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        user = userRepository.save(user);
        return userMapper.toDTO(user);
    }

    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
        return userMapper.toDTO(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
