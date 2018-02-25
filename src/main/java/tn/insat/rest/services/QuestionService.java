package tn.insat.rest.services;

import tn.insat.rest.entities.Question;

import java.util.List;

/**
 * Created by zied on 19/02/2018.
 */
public interface QuestionService {

    public List<Question> getQuestions();
}
