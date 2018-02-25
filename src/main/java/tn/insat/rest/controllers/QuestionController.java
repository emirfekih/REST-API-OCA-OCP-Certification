package tn.insat.rest.controllers;;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.insat.rest.entities.Question;
import tn.insat.rest.services.QuestionService;

import java.util.List;

/**
 * Created by zied on 19/02/2018.
 */
@RestController
public class QuestionController {

    private QuestionService questionService;

    @Autowired
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/questions/getAll")
    @ResponseBody()
    List<Question> getQuestions(){
        return questionService.getQuestions();
    }
}
