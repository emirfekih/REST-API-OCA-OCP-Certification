package tn.insat.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.insat.rest.entities.*;
import tn.insat.rest.repositories.TestRepository;

import java.util.*;

/**
 * Created by zied on 19/02/2018.
 */
@Service
public class TestServiceImpl implements TestService {

    private TestRepository testRepository;

    @Autowired
    public void setTestRepository(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public List<Test> getTests() {
        return testRepository.findAll();
    }

    @Override
    public Test findByTestId(Integer testId) {
        return testRepository.findByTestId(testId);
    }

    @Override
    public List<TestDTO> findAllDTO() {
        return testRepository.findAllDTO();
    }

    @Override
    public Set<TestChapterDTO> findTestChaptersDTOById(Integer testId) {
        return testRepository.findTestChaptersDTOById(testId);
    }

    @Override
    public List<TestDTO> findByTestType(String testType) {
        return testRepository.findByTestType(testType);
    }

    @Override
    public Test getOrderedTest(Integer testId) {
        Test result = testRepository.findByTestId(testId);
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

    @Override
    public Test getTestById(Integer testId, boolean shuffleOptions, boolean questionRange, Integer firstQuestion, Integer lastQuestion, boolean takeOnlyChapters, List<Integer> chapters) {
        Test result;
//        Get ordered or shuffled test
        if(shuffleOptions == true){
            result = this.findByTestId(testId);
        }
        else{
            result = this.getOrderedTest(testId);
        }

//        Get subQuestions if questionRange is true
        Set<Question> questions = result.getQuestions();
        if(questionRange == true){
            List<Question> list = new ArrayList<>(questions);
            Set<Question> subQuestions = new LinkedHashSet<>(list.subList(firstQuestion-1, lastQuestion));
            result.setQuestions(subQuestions);
        }

//        Get only chapters chosen
        Set<Question> questions1 = result.getQuestions();
        boolean trouve;
        if(takeOnlyChapters == true) {
            if(!chapters.isEmpty()){
                Iterator<Question> iterator = questions1.iterator();
                while (iterator.hasNext() ){
                    Question s = iterator.next();
                    Chapter chapter = s.getChapter();
                    trouve = false;
                    Iterator<Integer> iterator1 = chapters.iterator();
                    while (iterator1.hasNext()) {
                        Integer id = iterator1.next();
                        if (chapter.getChapterId() == id) {
                            trouve = true;
                        }
                    }
                    if (trouve == false) {
                        iterator.remove();
                    }
                }
            }
        }
        result.setQuestions(questions1);
        return result;

    }
}
