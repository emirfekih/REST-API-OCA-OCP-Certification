package tn.insat.rest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.insat.rest.entities.UserTest;
import tn.insat.rest.services.UserTestService;

import java.util.List;

/**
 * Created by zied on 20/02/2018.
 */
@RestController
public class UserTestController{

    private UserTestService userTestService;

    public void setUserTestService(UserTestService userTestService) {
        this.userTestService = userTestService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/usertests/getAll")
    @ResponseBody()
    public List<UserTest> getUserTests(){
        return userTestService.getUserTests();
    }
}
