package com.user.user_service.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.user_service.Dao.UserDao;
import com.user.user_service.entity.AddResponse;
import com.user.user_service.entity.Role;
import com.user.user_service.entity.User;

@Service
public class UserServiceImpl implements UserService{

    /*List<User> list=List.of(
        new User(20333194L,"swahan","8184927099"),
        new User(2033319L,"swaha","818492709"),
        new User(203331L,"swah","81849270")
    );*/

    @Autowired
    private UserDao userDao;

    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public User getUser(String key) {
        //return list.stream().filter(user->user.getUserId().equals(id)).findAny().orElse(null);
        return userDao.findById(key).get();
    }

    @Override
    public List<User> getAllUsers()
    {
        return (List<User>) userDao.findAll();
    }

    @Override
    public void initUser() {
        String roleString= "Admin";
        Role adminRole = this.restTemplate.getForObject("http://localhost:9002/role/"+roleString, Role.class);
        /*Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");*/

        User adminUser = new User();
        adminUser.setUserName("admin123");
        adminUser.setUserPassword(getEncodedPassword("admin@pass"));
        adminUser.setPsNo(20333000);
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setUserEmail("admin.admin@lntds.com");
        adminUser.setUserBg("AB+");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);
        
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public int getMaxPs(){
        int max=0;
        List<User>users=userDao.findAll();
        for(User u:users)
        {
            if(u.getPsNo()>-max)
                max=u.getPsNo();
        }
        return max+1;
    }

    @Override
    public User registerNewUser(User user) {
        user.setPsNo(getMaxPs());
        user.setUserEmail(user.getUserFirstName().toLowerCase()+"."+user.getUserLastName().toLowerCase()+"@lntds.com");
        //Role role = roleDao.findById("User").get();
        String roleString="User";
        Role role=this.restTemplate.getForObject("http://localhost:9002/role/"+roleString, Role.class);
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));

        return userDao.save(user);
    }

    @Override
    public AddResponse deleteUser(String userName) {
        userDao.deleteById(userName);
        AddResponse res=new AddResponse();
        res.setMsg("User Deleted"); 
        res.setUserName(userName);
        return res;
    }

    @Override
    public User updateUser(User user) {
        user.setUserEmail(user.getUserFirstName().toLowerCase()+"."+user.getUserLastName().toLowerCase()+"@lntds.com");
        userDao.save(user);
        return user;
    }
    
}
