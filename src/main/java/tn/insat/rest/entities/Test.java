package tn.insat.rest.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by zied on 19/02/2018.
 */
@Entity
@Table(name = "tests")
public class Test {

    @Id
    @GeneratedValue()
    private Integer testId;

    private String testName;

    private String testType;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="test_question", catalog="finalDB", joinColumns = {
            @JoinColumn(name="testId", nullable=true, updatable=true) }, inverseJoinColumns = {
            @JoinColumn(name="questionId", nullable=true, updatable=true) })
    @JsonIgnoreProperties("tests")
    private Set<Question> questions;

    public Test() {
    }

    public Test(String testName, String testType) {
        this.testName = testName;
        this.testType = testType;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }


}
