package francescobuonocore.w6d5.services;

import francescobuonocore.w6d5.entities.User;
import francescobuonocore.w6d5.exceptions.BadRequestException;
import francescobuonocore.w6d5.exceptions.NotFoundException;
import francescobuonocore.w6d5.payloads.NewUserDTO;
import francescobuonocore.w6d5.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UserRepository userRepository;



   public User findById(long id) {
       return userRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
   }
   public Page<User> getUsers(int page, int size, String sort) {
       Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
       return userRepository.findAll(pageable);
   }
   public void findAndDelete(long id) {
        User found = this.findById(id);
        this.userRepository.delete(found);
   }
   public User findAndUpdate(long id, User newUser) {
        User found = this.findById(id);
        found.setUsername(newUser.getUsername());
        found.setName(newUser.getName());
        found.setSurname(newUser.getSurname());
        found.setEmail(newUser.getEmail());
        found.setPassword(newUser.getPassword());
        return this.userRepository.save(found);
   }
   public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("Email " + email + " not found"));
   }
}
