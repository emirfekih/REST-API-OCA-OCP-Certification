package tn.insat.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.insat.rest.entities.Test;
import tn.insat.rest.entities.TestChapterDTO;
import tn.insat.rest.entities.TestDTO;
import tn.insat.rest.repositories.TestRepository;

import java.util.List;
import java.util.Set;

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
    public Set<TestChapterDTO> findTestChaptersDTO() {
        return testRepository.findTestChaptersDTO();
    }
}
