package br.com.carlosrubim.todolist.user;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Modificador
 * public
 * private
 * protected
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserRepository userRepository;
    @PostMapping("")
    public ResponseEntity create(@RequestBody UserModel userModel){
        var user = this.userRepository.findByUsername(userModel.getUsername());
            if(user != null) {
                return ResponseEntity.status(400).body("Usuário já existe");
            }
        var userCreated = this.userRepository.save(userModel);
        return ResponseEntity.status(200).body(userCreated);
           }
}