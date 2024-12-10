package com.nray.ticketmanagement.service.impl;

import com.nray.ticketmanagement.dto.UserDTO;
import com.nray.ticketmanagement.dto.UsersDTO;
import com.nray.ticketmanagement.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    public static final String BASE_URL = "https://api.github.com";

    WebClient webClient = WebClient.builder().baseUrl(BASE_URL).build();

    @Override
    public Optional<UsersDTO> getAllUsers() {
        return Optional.ofNullable(webClient.get()
                .uri("/search/users?q=YOUR_NAME")
                .retrieve()
                .bodyToMono(UsersDTO.class)
                .block()
        );
    }

    @Override
    public Optional<UserDTO> getUser(String name) {
        return Optional.ofNullable(webClient.get()
                .uri("/users/" + name)
                .retrieve()
                .bodyToMono(UserDTO.class)
                .block()
        );
    }
}
