package com.nray.ticketmanagement.service;

import com.nray.ticketmanagement.dto.UserDTO;
import com.nray.ticketmanagement.dto.UsersDTO;

import java.util.Optional;

public interface UserService {
    Optional<UsersDTO> getAllUsers();
    Optional<UserDTO> getUser(String name);
}
