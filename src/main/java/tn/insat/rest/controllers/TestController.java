package tn.insat.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.insat.rest.entities.Chapter;
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

    @RequestMapping(method = RequestMethod.GET, value = "/test/{testId}")
    public ResponseEntity<Test> findByTestId(@PathVariable("testId") Integer testId){
        Test resultat = testService.findByTestId(testId);
        if(resultat != null){
            return new ResponseEntity<Test>(resultat, HttpStatus.OK);
        }else {
            return new ResponseEntity<Test>(HttpStatus.NOT_FOUND);
        }
    }
}
