package org.example.test;

import org.example.model.User;
import org.example.service.UserService;

public class TestUser {

    @Test
    public  void testUserCreation(){
        User u1 = new User("1","Aman","ROMANCE");
        UserService userService = new UserService();
        userService.registerUser(u1,5);
        user u  = userService.getUser("1");
        Assertions.assertNotNull(u);
        Assertions.assertEquals("Aman",u.getName());

    }
}
