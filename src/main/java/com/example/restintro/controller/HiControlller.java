package com.example.restintro.controller;

import com.example.restintro.model.Hi;
import com.example.restintro.model.UserEntity;
import com.example.restintro.repository.UserRepository;
import com.example.restintro.service.InterfaceUserService;
import com.example.restintro.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class HiControlller {

    Hi hi = new Hi(true);

    private InterfaceUserService userService;

    public HiControlller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<Hi> sayHi(){
        return new ResponseEntity<Hi>(new Hi(), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<String>> getTriple(){

        return new ResponseEntity<>(hi.getTriple(), HttpStatus.OK);
    }
    @GetMapping("/addUser/{new_user}")
    public ResponseEntity<UserEntity> addUser(@PathVariable("new_user") String newUser){

        UserEntity UE = new UserEntity(newUser);
        userService.save(UE);

        return new ResponseEntity<>(UE, HttpStatus.OK);
    }
    @PostMapping("/addUser")
    public ResponseEntity<UserEntity> addUserFromRequest(@RequestParam("new_user") String newUser){

        UserEntity UE = new UserEntity(newUser);

        userService.save(UE);

        return new ResponseEntity<>(UE, HttpStatus.OK);
    }

    @GetMapping("/delete/{user}")
    public ResponseEntity<Set<UserEntity>> deleteUserSecond(@PathVariable("user") String user){

        UserEntity UE = new UserEntity(user);
        userService.delete(UE);

        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/showAll")
    public ResponseEntity<Set<UserEntity>> showAllUsers(){

        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/x/{new_user}")
    public ResponseEntity<List<String>> showNewUser(@PathVariable("new_user") String newUser){

        hi.addUser(newUser);

        return new ResponseEntity<>(hi.getTriple(), HttpStatus.OK);
    }
    @GetMapping("/y/{delete}")
    public ResponseEntity<List<String>> deleteUser(@PathVariable("delete") String deleteUser){
        hi.deleteUser(deleteUser);

        return new ResponseEntity<>(hi.getTriple(), HttpStatus.OK);
    }
    @GetMapping("/z/{edit}/{edited}")
    public ResponseEntity<List<String>> editUser(@PathVariable("edit") String toEdit, @PathVariable("edited") String changedTo){

        hi.editFromTo(toEdit, changedTo);

        return new ResponseEntity<>(hi.getTriple(), HttpStatus.OK);

    }
}

