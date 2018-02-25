package tn.insat.rest.services;

import tn.insat.rest.entities.Chapter;

import java.util.List;

/**
 * Created by zied on 23/02/2018.
 */

public interface ChapterService  {

    public List<Chapter> getChapters();
    public Chapter findByChapterId(Integer chapterId);

}
