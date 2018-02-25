package tn.insat.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.insat.rest.entities.Chapter;

/**
 * Created by zied on 23/02/2018.
 */
@Repository
public interface ChapterRepository extends JpaRepository<Chapter,Integer> {
    public Chapter findByChapterId(Integer chapterId);
}
