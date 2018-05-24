package tn.insat.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.insat.rest.entities.*;
import tn.insat.rest.services.TestService;

import java.util.*;
import java.util.stream.Collectors;
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

//    Return all the tests
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

//    get Test by testType
    @RequestMapping(value="/test",method = RequestMethod.GET)
    @ResponseBody()
    public List<TestDTO> getTestDTOByType(@RequestParam("testType") String testType) {
        return testService.findByTestType(testType);
    }

//    Generic get test (gets a Test according to request parameters)
    @RequestMapping(value = "/getTest/{testId}",method = RequestMethod.GET)
    @ResponseBody()
    public Test getTestById(@PathVariable("testId") Integer testId,
                            @RequestParam("shuffleOptions") boolean shuffleOptions,
                            @RequestParam("questionRange") boolean questionRange,
                            @RequestParam("firstQuestion") Integer firstQuestion,
                            @RequestParam("lastQuestion") Integer lastQuestion,
                            @RequestParam("takeOnlyChapters") boolean takeOnlyChapters,
                            @RequestParam("chapters") List<Integer> chapters){
        return testService.getTestById(testId,shuffleOptions,questionRange,firstQuestion,lastQuestion,takeOnlyChapters,chapters);
    }

    @RequestMapping(value="/freeTest/{testId}",method=RequestMethod.GET)
    @ResponseBody()
    public Test getFreeTest(@PathVariable("testId") Integer testId){
        return (testService.findByTestId(testId));
    }

}
