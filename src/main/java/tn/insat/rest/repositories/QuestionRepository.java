package tn.insat.rest.repositories;;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.insat.rest.entities.Question;

/**
 * Created by zied on 19/02/2018.
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer>{

}
