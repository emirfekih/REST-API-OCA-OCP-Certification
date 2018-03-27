package tn.insat.rest.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by zied on 19/02/2018.
 */
@Entity
@Table(name = "choices")
public class Choice  {

    @Id
    @GeneratedValue()
    private Integer choiceId;

    private String choiceStatement;

    private boolean correct;

    @ManyToOne
    @JoinColumn(name = "questionId")
    @JsonIgnoreProperties("choices")
    private Question questionId;

    public Integer getChoiceId() {
        return choiceId;
    }

    public void setChoiceId(Integer choiceId) {
        this.choiceId = choiceId;
    }

    public String getChoiceStatement() {
        return choiceStatement;
    }

    public void setChoiceStatement(String choiceStatement) {
        this.choiceStatement = choiceStatement;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

}
