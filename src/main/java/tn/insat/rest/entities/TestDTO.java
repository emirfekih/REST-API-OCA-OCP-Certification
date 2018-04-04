package tn.insat.rest.entities;

/**
 * Created by zied on 02/04/2018.
 */
public class TestDTO {
    private Integer testId;
    private String testName;
    private String testType;

    public TestDTO(Integer testId, String testName, String testType) {
        this.testId = testId;
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
}
