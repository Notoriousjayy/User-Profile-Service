package com.example.UserProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user-profiles")
public class UserProfileController {
    @Autowired
    private UserProfileRepository userProfileRepository;

    @PostMapping
    public ResponseEntity<Void> createUserProfile(@RequestBody UserProfile userProfile) {
        userProfileRepository.createUserProfile(userProfile);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserProfile> getUserProfile(@PathVariable String userId) {
        UserProfile userProfile = userProfileRepository.getUserProfile(userId);
        if (userProfile != null) {
            return ResponseEntity.ok(userProfile);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Implement endpoints for updating and deleting user profiles
}

