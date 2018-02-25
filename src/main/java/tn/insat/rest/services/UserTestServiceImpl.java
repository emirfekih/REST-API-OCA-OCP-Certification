package tn.insat.rest.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.insat.rest.entities.UserTest;
import tn.insat.rest.repositories.UserTestRepository;

import java.util.List;

/**
 * Created by zied on 20/02/2018.
 */
@Service
public class UserTestServiceImpl implements UserTestService {

    private UserTestRepository userTestRepository;

    @Autowired
    public void setUserTestRepository(UserTestRepository userTestRepository) {
        this.userTestRepository = userTestRepository;
    }

    @Override
    public List<UserTest> getUserTests() {
        return userTestRepository.findAll();
    }
}
