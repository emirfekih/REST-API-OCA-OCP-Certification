package tn.insat.rest.services;


import tn.insat.rest.entities.UserTest;

import java.util.List;

/**
 * Created by zied on 20/02/2018.
 */
public interface UserTestService {

    public List<UserTest> getUserTestsById(Integer userId);
    public UserTest addUserTest(UserTest userTest);
}
