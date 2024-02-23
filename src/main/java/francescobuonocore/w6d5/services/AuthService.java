package francescobuonocore.w6d5.services;

import francescobuonocore.w6d5.entities.User;
import francescobuonocore.w6d5.exceptions.UnauthorizedException;
import francescobuonocore.w6d5.payloads.UserLoginDTO;
import francescobuonocore.w6d5.security.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsersService usersService;

    @Autowired
    private JWTTools jwtTools;

    public String authenticateAndGenerateToken(UserLoginDTO payload) {
        User user = usersService.findByEmail(payload.email());
        if (user.getPassword().equals(payload.password())) {
            return jwtTools.createToken(user);
        } else {
            throw new UnauthorizedException("Wrong Credentials");
        }
    }
}
