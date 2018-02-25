package tn.insat.rest.entities;

import javax.persistence.*;

/**
 * Created by zied on 18/02/2018.
 */

@Entity
@Table(name = "chapters")
public class Chapter {

    @Id
    @GeneratedValue()
    private Integer chapterId;

    private String chapterName;

    public Chapter() {
    }

    public Chapter(String chapterName) {
        this.chapterName = chapterName;
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

}
