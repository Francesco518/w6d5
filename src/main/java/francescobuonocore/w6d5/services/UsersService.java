package francescobuonocore.w6d5.services;

import francescobuonocore.w6d5.entities.User;
import francescobuonocore.w6d5.exceptions.NotFoundException;
import francescobuonocore.w6d5.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UserRepository userRepository;

   public User findById(long id) {
       return userRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
   }




}
