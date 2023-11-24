package com.durgesh.ecommerce.controller;

import com.durgesh.ecommerce.model.User;
import com.durgesh.ecommerce.model.UserDto;
import com.durgesh.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@CrossOrigin( "*")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("{id}")
    public User getById(@PathVariable int id){
        return this.userService.getById(id);
    }

    @PostMapping("add")
    public String addUser(@RequestBody User user){
        return userService.addUser(user);

    }
    @GetMapping("{userId}/{productId}")
    public ResponseEntity<String> linkProductWithUser(@PathVariable int userId, @PathVariable int productId){
        return ResponseEntity.ok(this.userService.linkProductWithUser(userId,productId));
    }
    @GetMapping("users")
    public List<User> getAll(){
        return userService.getAll();
    }
    @DeleteMapping("/products/{id1}/{id2}")
    public String deleteProductFromUser(@PathVariable int id1,@PathVariable  int id2){
        return userService.deleteProductFromUser(id1,id2);
    }
    @PostMapping("validate")
    UserDto ValidateUser(@RequestBody User user){
        return this.userService.ValidateUser(user);
    }
}
