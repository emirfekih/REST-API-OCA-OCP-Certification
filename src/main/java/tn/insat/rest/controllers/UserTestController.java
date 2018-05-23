package tn.insat.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tn.insat.model.security.User;
import tn.insat.rest.entities.UserTest;
import tn.insat.rest.services.UserTestService;

import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by zied on 20/02/2018.
 */
@RestController
public class UserTestController{

    private UserTestService userTestService;

    @Autowired
    public void setUserTestService(UserTestService userTestService) {
        this.userTestService = userTestService;
    }

  @RequestMapping(method = RequestMethod.GET, value = "/usertests/{userId}")
    @ResponseBody()
    public List<UserTest> getUserTestsById(@PathVariable("userId") Integer userId){
        return userTestService.getUserTestsById(userId);
    }

    @RequestMapping(value="/addUserTest",method = RequestMethod.POST)
    public ResponseEntity<UserTest> addUserTest(@RequestBody UserTest userTest){

        userTest.getUserTestPK().setTestDate(new Timestamp(new Date().getTime()));
        userTestService.addUserTest(userTest);
        return new ResponseEntity<UserTest>(userTest, HttpStatus.CREATED);
    }
}
