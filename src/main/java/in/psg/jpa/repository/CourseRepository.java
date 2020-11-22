package in.psg.jpa.repository;

import in.psg.jpa.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

/*
CourseRepository will talk to EntiryManager
We should AutoWire EntityManager
 */
@Repository
public class CourseRepository {
    @Autowired
    EntityManager entityManager;

    public Course findById(Long id){
        return  entityManager.find(Course.class,id);
    }
}
