package tn.insat.rest.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by zied on 20/02/2018.
 */
@Entity
@Table(name = "user_tests")
public class UserTest {

    @EmbeddedId
    private UserTestPK userTestPK;

    private Date testDate;

    private int testTimeTaken;

    private Integer testScore;

    public UserTest(Date testDate) {
        this.testDate = testDate;
    }

    public UserTest() {
    }

    public UserTest(UserTestPK userTestPK, Date testDate, int testTimeTaken, Integer testScore, Test test) {
        this.userTestPK = userTestPK;
        this.testDate = testDate;
        this.testTimeTaken = testTimeTaken;
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

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public int getTestTimeTaken() {
        return testTimeTaken;
    }

    public void setTestTimeTaken(int testTimeTaken) {
        this.testTimeTaken = testTimeTaken;
    }

    public Integer getTestScore() {
        return testScore;
    }

    public void setTestScore(Integer testScore) {
        this.testScore = testScore;
    }

}
