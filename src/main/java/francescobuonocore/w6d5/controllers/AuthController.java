package francescobuonocore.w6d5.controllers;

import francescobuonocore.w6d5.entities.User;
import francescobuonocore.w6d5.payloads.LoginResponseDTO;
import francescobuonocore.w6d5.payloads.NewUserDTO;
import francescobuonocore.w6d5.payloads.UserLoginDTO;
import francescobuonocore.w6d5.services.AuthService;
import francescobuonocore.w6d5.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody UserLoginDTO payload) {
        return new LoginResponseDTO(authService.authenticateAndGenerateToken(payload));
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody NewUserDTO newUser) {
        return this.authService.saveUser(newUser);
    }
}
