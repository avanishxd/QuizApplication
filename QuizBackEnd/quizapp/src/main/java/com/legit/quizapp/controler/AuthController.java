package com.legit.quizapp.controler;

import com.legit.quizapp.model.User;
import com.legit.quizapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user){
        if(userService.userRepository.findByUsername(user.getUsername()).isPresent()){
            return ResponseEntity.badRequest().body("Username already exists");
        }
        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> userMap){
        String username = userMap.get("username");
        String password = userMap.get("password");

        Optional<User> optionalUser = userService.userRepository.findByUsername(username);
        if(optionalUser.isEmpty()){
            return ResponseEntity.status(401).body("Invalid username or password");
        }
        User user = optionalUser.get();
        if(!passwordEncoder.matches(password, user.getPassword())){
            return ResponseEntity.status(401).body("Invalid username or password");
        }
        // Return user role on success
        return ResponseEntity.ok(Map.of("role", user.getRole()));
    }
}
