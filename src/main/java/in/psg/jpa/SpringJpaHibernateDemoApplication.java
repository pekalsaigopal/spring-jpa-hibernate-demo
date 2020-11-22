package in.psg.jpa;

import in.psg.jpa.entity.Course;
import in.psg.jpa.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaHibernateDemoApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository courseRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaHibernateDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Course course = courseRepository.findById(10001L);
        logger.info("Course 10001L -{}",course);
    }
}
