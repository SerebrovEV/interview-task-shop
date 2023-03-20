package com.task.shop.api.client;

import com.task.shop.api.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
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
        return restTemplate.getForEntity(uriUser+"?name="+userName, UserDto.class).getBody();
    }

}
