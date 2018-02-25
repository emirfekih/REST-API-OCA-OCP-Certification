package tn.insat.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.insat.rest.entities.Chapter;
import tn.insat.rest.repositories.ChapterRepository;

import java.util.List;

/**
 * Created by zied on 24/02/2018.
 */
@Service
public class ChapterServiceImpl implements ChapterService {

    private ChapterRepository chapterRepository;

    @Autowired
    public void setChapterRepository(ChapterRepository chapterRepository) {
        this.chapterRepository = chapterRepository;
    }


    public List<Chapter> getChapters() {
        return chapterRepository.findAll();
    }

    public Chapter findByChapterId(Integer chapterId) {
        return chapterRepository.findByChapterId(chapterId);
    }
}
