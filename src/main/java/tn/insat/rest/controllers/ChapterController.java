package tn.insat.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.insat.rest.entities.Chapter;
import tn.insat.rest.services.ChapterService;

import java.util.List;

/**
 * Created by zied on 23/02/2018.
 */
@RestController
public class ChapterController {

    private ChapterService chapterService;

    @Autowired
    public void setChapterService(ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/chapters/getAll")
    @ResponseBody()
    public List<Chapter> getChapters(){
        return chapterService.getChapters();
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(value = "/chapters/{chapterId}")
    public ResponseEntity<Chapter> findByChapterId(@PathVariable("chapterId") Integer chapterId){
        Chapter resultat = chapterService.findByChapterId(chapterId);
        if (resultat != null) {
            return new ResponseEntity<Chapter>(resultat, HttpStatus.OK);
        } else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
