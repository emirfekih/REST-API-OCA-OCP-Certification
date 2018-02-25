package tn.insat.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.insat.rest.entities.Choice;
import tn.insat.rest.services.ChoiceService;

import java.util.List;

/**
 * Created by zied on 19/02/2018.
 */
@RestController
public class ChoiceController {

    private ChoiceService choiceService;

    @Autowired
    public void setChoiceService(ChoiceService choiceService) {
        this.choiceService = choiceService;
    }

    @RequestMapping(method = RequestMethod.GET , value = "/choices/getAll")
    @ResponseBody()
    public List<Choice> getChoices(){
        return choiceService.getChoices();
    }
}
