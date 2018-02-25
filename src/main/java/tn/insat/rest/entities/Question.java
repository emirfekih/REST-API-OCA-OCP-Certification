package tn.insat.rest.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by zied on 19/02/2018.
 */
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue()
    private Integer questionId;

    private String questionStatement;

    private String questionType;

    private String questionExplanation;

    @ManyToOne
    @JoinColumn(name = "chapterId")
    @JsonIgnoreProperties("questions")
    private Chapter chapter;

    @OneToMany(mappedBy = "choiceId")
    private Set<Choice> choices;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="test_question", catalog="finalDB", joinColumns = {
            @JoinColumn(name="questionId", nullable=true, updatable=true) }, inverseJoinColumns = {
            @JoinColumn(name="testId", nullable=true, updatable=true) })
    @JsonIgnoreProperties("questions")
    private Set<Test> tests;

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionStatement() {
        return questionStatement;
    }

    public void setQuestionStatement(String questionStatement) {
        this.questionStatement = questionStatement;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getQuestionExplanation() {
        return questionExplanation;
    }

    public void setQuestionExplanation(String questionExplanation) {
        this.questionExplanation = questionExplanation;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public Set<Choice> getChoices() {
        return choices;
    }

    public void setChoices(Set<Choice> choices) {
        this.choices = choices;
    }

    public Set<Test> getTests() {
        return tests;
    }

    public void setTests(Set<Test> tests) {
        this.tests = tests;
    }
}
