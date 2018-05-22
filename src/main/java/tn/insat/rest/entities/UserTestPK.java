package tn.insat.rest.entities;

import javax.persistence.Basic;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by zied on 20/02/2018.
 */
@Embeddable
public class UserTestPK  implements Serializable {

    @Basic(optional = false)
    private Integer testId;

    @Basic(optional =false)
    private Integer user_id;

    @Temporal(TemporalType.TIMESTAMP)
    public Timestamp getTestDate() {
        return testDate;
    }

    public void setTestDate(Timestamp testDate) {
        this.testDate = testDate;
    }

    @Basic(optional =false)
    private Timestamp testDate;


    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public Integer getUserId() {
        return user_id;
    }

    public void setUserId(Integer user_id) {
        this.user_id = user_id;
    }

}
