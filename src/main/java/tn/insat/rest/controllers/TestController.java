package tn.insat.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.insat.rest.entities.Chapter;
import tn.insat.rest.entities.Test;
import tn.insat.rest.entities.TestChapterDTO;
import tn.insat.rest.entities.TestDTO;
import tn.insat.rest.services.TestService;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;

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

//    returns the tests (name and type only)
    @RequestMapping(method = RequestMethod.GET, value = "/tests/getAllDTO")
    @ResponseBody()
    public List<TestDTO> getTestsDTO(){
        return testService.findAllDTO();
    }

//    Gets the the name and id of the chapters within a test
    @RequestMapping(method = RequestMethod.GET, value = "/tests/getAllChaptersDTO/{testId}")
    @ResponseBody()
    public Set<TestChapterDTO> getTestChaptersDTO(@PathVariable("testId") Integer testId) {
         return testService.findTestChaptersDTOById(testId);
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

    @RequestMapping(value="/test",method = RequestMethod.GET)
    @ResponseBody()
    public List<TestDTO> getTestDTOByType(@RequestParam("testType") String testType) {
        return testService.findByTestType(testType);
    }
}
