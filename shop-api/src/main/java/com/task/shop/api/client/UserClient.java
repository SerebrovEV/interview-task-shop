package com.task.shop.api.client;

import com.task.shop.api.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class UserClient {

    @Value("${url.user}")
    private URI uriUser;

    private final RestTemplate restTemplate;

    public UserDto getUserByName(String userName) {
        return restTemplate.getForEntity(uriUser + "?name=" + userName, UserDto.class).getBody();
    }

    public ResponseEntity<UserDto> addToUserBalance(Long userId, UserDto userDto) {
        return ResponseEntity.ok(restTemplate.patchForObject(uriUser + userId.toString() + "/balance", userDto, UserDto.class));
    }

    public ResponseEntity<UserDto> getUser(Long userId) {
        return ResponseEntity.ok(restTemplate.getForEntity(uriUser + userId.toString(), UserDto.class).getBody());
    }

    public ResponseEntity<Void> deleteUser(Long userId) {
        restTemplate.delete(uriUser + userId.toString());
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<UserDto> updateUserStatus(Long userId, UserDto userDto) {
        return ResponseEntity.ok(restTemplate.patchForObject(
                uriUser + userId.toString() + "/status",
                userDto, UserDto.class));
    }
}
