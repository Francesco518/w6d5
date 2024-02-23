package francescobuonocore.w6d5.controllers;

import francescobuonocore.w6d5.entities.User;
import francescobuonocore.w6d5.payloads.NewUserDTO;
import francescobuonocore.w6d5.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping
    public Page<User> getUsers(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "10") int size,
                               @RequestParam(defaultValue = "id") String sortBy) {
        return usersService.getUsers(page, size, sortBy);
    }
    @GetMapping("/{userId}")
    public User findById(@PathVariable int userId) {
        return usersService.findById(userId);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody NewUserDTO newUser) throws Exception {
        return usersService.save(newUser);
    }
    @PutMapping("/{userId}")
    public User findAndUpdate(@PathVariable int userId, @RequestBody User newUser) {
        return this.usersService.findAndUpdate(userId, newUser);
    }
    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findAndDelete(@PathVariable int userId){
         this.usersService.findAndDelete(userId);
    }
}
