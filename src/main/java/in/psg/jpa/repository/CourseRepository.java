package in.psg.jpa.repository;

import in.psg.jpa.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional // Other wise we will get the below error
    public void deleteById(Long id){
        Course course = findById(id);
        entityManager.remove(course);//No EntityManager with actual transaction available for current thread - cannot reliably process 'remove' call
    }
}
