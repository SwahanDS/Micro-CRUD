package com.user.user_service.Controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;

import com.user.user_service.entity.AddResponse;
//import com.user.user_service.entity.Contact;
import com.user.user_service.entity.User;
import com.user.user_service.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //@Autowired
    //private RestTemplate restTemplate;

    @PostConstruct
    public void initUser() {
        userService.initUser();
    }
    
    /*@GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Long userId)
    {
        User user = this.userService.getUser(userId);

        List<Contact> contacts=this.restTemplate.getForObject("http://contact-service/contact/user/"+userId, List.class);
        user.setContacts(contacts);
        return user;
    }*/

    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user) {
        return userService.registerNewUser(user);
    }

    @GetMapping("/getUsers")
    public List<User> getUsers()
    {
        return userService.getAllUsers();
    }

    @GetMapping("/getUser/{key}")
    public ResponseEntity<User> getUserbyId(@PathVariable(value = "key") String key)
    {
        try
        {
            User user= userService.getUser(key);
            return new ResponseEntity<User>(user,HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteUser/{userName}")
    public AddResponse deleteUsers(@PathVariable(value = "userName") String userName)
    {
        return userService.deleteUser(userName);
    }

    @PutMapping("/updateUser/{userName}")
    public ResponseEntity<User> updateUsers(@PathVariable(value = "userName") String userName,@RequestBody User user)
    {
        try
        {
            User ex=userService.getUser(userName);
            ex.setUserName(user.getUserName());
            ex.setUserFirstName(user.getUserFirstName());
            ex.setUserLastName(user.getUserLastName());
            ex.setUserBg(user.getUserBg());
            User up=userService.updateUser(ex);
            return new ResponseEntity<User>(up,HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

}
