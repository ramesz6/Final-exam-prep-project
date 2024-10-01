package org.example.backend.controllers;

import lombok.RequiredArgsConstructor;
import org.example.backend.services.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;
}
