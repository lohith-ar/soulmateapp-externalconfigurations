package com.soulmate.soulmateapp.Controller;

import com.soulmate.soulmateapp.domain.SoulmateUser;
import com.soulmate.soulmateapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/adduser")
    public ResponseEntity<SoulmateUser> saveUSer(@RequestBody SoulmateUser smuser){
        SoulmateUser user = userService.saveUser(smuser);
        return new ResponseEntity<SoulmateUser>(user, HttpStatus.CREATED);
    }

    @GetMapping("/allusers/gender/{gender}")
    public ResponseEntity<List<SoulmateUser>> getUsersonGender(@PathVariable(value="gender") String gender13){

        return new ResponseEntity<List<SoulmateUser>>(userService.getAllUsersbyGender(gender13) ,HttpStatus.OK);
    }

    @GetMapping("/allusers/age/{age}")
    public ResponseEntity<List<SoulmateUser>> getUsersonAge(@PathVariable(value="age") int age1){

        return new ResponseEntity<List<SoulmateUser>>(userService.getAllUsersbyAge(age1) ,HttpStatus.OK);
    }

    @GetMapping("/allusers/name/{name}")
    public ResponseEntity<List<SoulmateUser>> getUsersonName(@PathVariable(value="name") String age1){

        return new ResponseEntity<List<SoulmateUser>>(userService.getAllUsersbyName(age1) ,HttpStatus.OK);
    }

    @GetMapping("/allusers")
    public ResponseEntity<List<SoulmateUser>> getAllUsers(){
        return new ResponseEntity<List<SoulmateUser>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PutMapping("/updateuser/{id}")
    public ResponseEntity<List<SoulmateUser>> updateUser(@PathVariable(value="id") Integer id1,
                                                         @RequestBody SoulmateUser user){
        userService.updateUser(id1, user);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deleteuser/{id}")
    public String deleteUser(@PathVariable(value="id") Integer id1){
       userService.deleteUseronID(id1);
       return "Deleted";
    }
}
