package in.psg.jpa.repository;

import in.psg.jpa.SpringJpaHibernateDemoApplication;
import in.psg.jpa.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = SpringJpaHibernateDemoApplication.class)
public class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void contextLoads() {
        logger.info("Test is Running...");
    }

    @Test
    public void findById_basic(){
        Course course = courseRepository.findById(10001L);
        assertEquals("JPA Course in 50 Steps",course.getName());
    }

    @Test
    @DirtiesContext
    public void deleteById_basic(){
        courseRepository.deleteById(10002L);
        assertNull(courseRepository.findById(10002L));
    }




}