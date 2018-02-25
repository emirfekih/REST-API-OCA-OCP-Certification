package tn.insat.rest.entities;

import javax.persistence.Basic;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by zied on 20/02/2018.
 */
@Embeddable
public class UserTestPK  implements Serializable {

    @Basic(optional = false)
    private Integer testId;

    @Basic(optional =false)
    private Integer user_id;


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
