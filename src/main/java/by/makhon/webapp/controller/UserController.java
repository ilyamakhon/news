package by.makhon.webapp.controller;

import by.makhon.webapp.entity.UserEntity;
import by.makhon.webapp.exception.ResourceNotFoundException;
import by.makhon.webapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    private List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    private UserEntity getUserById(@PathVariable("id") Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }

    @PostMapping
    private UserEntity createUser(@Valid @RequestBody UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @PutMapping
    private UserEntity updateUser(@Valid @RequestBody UserEntity userEntityToUpdate) {
        UserEntity userEntity = userRepository.findById(userEntityToUpdate.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userEntityToUpdate.getId()))
                .setLogin(userEntityToUpdate.getLogin())
                .setPassword(userEntityToUpdate.getPassword())
                .setRole(userEntityToUpdate.getRole());

        return userRepository.save(userEntity);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        userRepository.delete(userEntity);

        return ResponseEntity.ok().build();
    }
}
