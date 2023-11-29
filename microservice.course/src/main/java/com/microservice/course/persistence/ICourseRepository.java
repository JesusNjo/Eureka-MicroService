package com.microservice.course.persistence;

import com.microservice.course.entities.Course;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ICourseRepository extends CrudRepository<Course,Long> {

    /*@Query("SELECT c FROM Course c WHERE id = :idStudent")
    public*/
}
