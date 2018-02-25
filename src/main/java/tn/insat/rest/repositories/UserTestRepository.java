package tn.insat.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.insat.rest.entities.UserTestPK;
import tn.insat.rest.entities.UserTest;

/**
 * Created by zied on 20/02/2018.
 */
@Repository
public interface UserTestRepository extends JpaRepository<UserTest, UserTestPK>{
}
