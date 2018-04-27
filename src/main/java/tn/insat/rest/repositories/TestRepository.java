package tn.insat.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.insat.rest.entities.Test;
import tn.insat.rest.entities.TestChapterDTO;
import tn.insat.rest.entities.TestDTO;

import java.util.List;
import java.util.Set;

/**
 * Created by zied on 19/02/2018.
 */
@Repository
public interface TestRepository extends JpaRepository<Test, Integer>{

    //Shuffle
    public Test findByTestId(Integer testId);

    @Query("SELECT new tn.insat.rest.entities.TestDTO(t.testId, t.testName, t.testType) FROM Test t ")
    public List<TestDTO> findAllDTO();

    @Query("SELECT new tn.insat.rest.entities.TestChapterDTO(t.testId,tqc.chapterId, tqc.chapterName) FROM Test t inner join t.questions tq inner join tq.chapter tqc where t.testId = :testId")
    public Set<TestChapterDTO> findTestChaptersDTOById(@Param("testId") Integer testId);

    public List<TestDTO> findByTestType(String testType);
}
