package tn.insat.rest.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.insat.rest.entities.UserTest;
import tn.insat.rest.repositories.UserTestRepository;

import java.util.Iterator;
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
    public List<UserTest> getUserTestsById(Integer userId) {
        List<UserTest> userTests = userTestRepository.findAll();
        Iterator<UserTest> iterator = userTests.iterator();
        while (iterator.hasNext() ){
            UserTest s = iterator.next();
            Integer id = s.getUserTestPK().getUserId();
            if (id != userId) {
                iterator.remove();
            }
        }
        return userTests;
    }


    @Override
    public UserTest addUserTest(UserTest userTest) {
        return userTestRepository.save(userTest);
    }
}
