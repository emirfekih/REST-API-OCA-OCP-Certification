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

//    Shuffled test
    @RequestMapping(method = RequestMethod.GET, value = "/shuffledTest/{testId}")
    public ResponseEntity<Test> findByTestId(@PathVariable("testId") Integer testId){
        Test resultat = testService.findByTestId(testId);
        if(resultat != null){
            return new ResponseEntity<Test>(resultat, HttpStatus.OK);
        }else {
            return new ResponseEntity<Test>(HttpStatus.NOT_FOUND);
        }
    }

//    Ordered Test
    @RequestMapping(method = RequestMethod.GET, value = "/test/{testId}")
    public Test findByTestIdOrderedByChoiceID(@PathVariable("testId") Integer testId){
        Test result = testService.findByTestId(testId);
        // order Questions
        Set<Question> questions = result.getQuestions();
        Set<Question> sortedQuestions = new TreeSet<Question>(new Comparator<Question>() {
            @Override
            public int compare(Question o1, Question o2) {
                return o1.getQuestionId().compareTo(o2.getQuestionId());
            }
        });
        sortedQuestions.addAll(questions);
        result.setQuestions(sortedQuestions);

        //order choices
        for (Question s : sortedQuestions) {
            Set<Choice> choices = s.getChoices();
            Set<Choice> sortedChoices = new TreeSet<Choice>(new Comparator<Choice>() {
                @Override
                public int compare(Choice c1, Choice c2) {
                    return c1.getChoiceId().compareTo(c2.getChoiceId());
                }
            });
            sortedChoices.addAll(choices);
            s.setChoices(sortedChoices);
        }

        return result;

    }

    @RequestMapping(value="/test",method = RequestMethod.GET)
    @ResponseBody()
    public List<TestDTO> getTestDTOByType(@RequestParam("testType") String testType) {
        return testService.findByTestType(testType);
    }
}
