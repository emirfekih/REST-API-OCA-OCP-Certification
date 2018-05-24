package tn.insat.rest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


/**
 * Created by zied on 20/02/2018.
 */
@Entity
@Table(name = "user_tests")
public class UserTest {

    @EmbeddedId
    private UserTestPK userTestPK;



    private int elapsedTime;

    private int timeLimit;

    private Integer testScore;

    private int nbrCorrectAnwsers;




    public UserTest() {
    }

    public UserTest(UserTestPK userTestPK, int elapsedTime, Integer testScore, Test test) {
        this.userTestPK = userTestPK;
        this.elapsedTime = elapsedTime;
        this.testScore = testScore;
        this.test = test;
    }

    @ManyToOne
    @JoinColumn(name = "testId",insertable = false, updatable = false)
    @JsonIgnoreProperties("user_tests")
    private Test test;


    public UserTestPK getUserTestPK() {
        return userTestPK;
    }

    public void setUserTestPK(UserTestPK userTestPK) {
        this.userTestPK = userTestPK;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }



    public int getElapsedTime() {
        return elapsedTime;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public void setElapsedTime(int elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public Integer getTestScore() {
        return testScore;
    }

    public void setTestScore(Integer testScore) {
        this.testScore = testScore;
    }

    public int getNbrCorrectAnwsers() {
        return nbrCorrectAnwsers;
    }

    public void setNbrCorrectAnwsers(int nbrCorrectAnwsers) {
        this.nbrCorrectAnwsers = nbrCorrectAnwsers;
    }
}
