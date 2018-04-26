package tn.insat.rest.services;

import tn.insat.rest.entities.Test;
import tn.insat.rest.entities.TestChapterDTO;
import tn.insat.rest.entities.TestDTO;

import java.util.List;
import java.util.Set;

/**
 * Created by zied on 19/02/2018.
 */
public interface TestService {

    public List<Test> getTests();
    public Test findByTestId(Integer testId);
    public List<TestDTO> findAllDTO();
    public Set<TestChapterDTO> findTestChaptersDTOById(Integer testId);
    public List<TestDTO> findByTestType(String testType);
}
