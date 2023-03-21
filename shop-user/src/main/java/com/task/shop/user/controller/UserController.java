package com.task.shop.user.controller;

import com.task.shop.user.dto.UserDto;
import com.task.shop.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.addUser(userDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id,
                                              @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.updateUser(id, userDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping()
    public ResponseEntity<UserDto> getUserByName(@RequestParam String name) {
        return ResponseEntity.ok(userService.getByName(name));
    }

    @PatchMapping("/{userId}/balance")
    public ResponseEntity<UserDto> addToUserBalance(@PathVariable Long userId,
                                                    @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.addToBalance(userId, userDto));
    }

    @PatchMapping("/user/{userId}/status")
    public ResponseEntity<UserDto> updateUserStatus(@PathVariable Long userId,
                                                    @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.updateUserStatus(userId, userDto));
    }
}
