package tn.insat.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.insat.rest.entities.Test;
import tn.insat.rest.services.TestService;

import java.util.List;

/**
 * Created by zied on 19/02/2018.
 */
@RestController
public class TestController {

    private TestService testService;

    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/tests/getAll")
    @ResponseBody()
    public List<Test> getTests(){
        return testService.getTests();
    }
}
