package tn.insat.rest.entities;

/**
 * Created by zied on 03/04/2018.
 */
public class TestChapterDTO {
    private Integer testId;
    private Integer chapterId;
    private String chapterName;

    public TestChapterDTO(Integer testId, Integer chapterId, String chapterName) {
        this.testId = testId;
        this.chapterId = chapterId;
        this.chapterName = chapterName;
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    @Override
    public int hashCode() {
        return chapterId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TestChapterDTO other = (TestChapterDTO) obj;
        if (chapterId != other.chapterId)
            return false;
        return true;
    }
}
