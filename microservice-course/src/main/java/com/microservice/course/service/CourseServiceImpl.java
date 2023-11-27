package com.microservice.course.service;

import com.microservice.course.client.StudentClient;
import com.microservice.course.entities.Course;
import com.microservice.course.entities.dto.StudentDTO;
import com.microservice.course.http.response.StudentByCourseResponse;
import com.microservice.course.persistence.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements ICourseService{
    @Autowired
    private ICourseRepository courseRepository;

    @Autowired
    private StudentClient studentClient;


    @Override
    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);

    }

    @Override
    public StudentByCourseResponse findStudentByIdCourse(Long id) {
        //Consultar el curso
        Course course = courseRepository.findById(id).orElse(new Course());

        //Obtener los estudiantes

        List<StudentDTO> studentDTOList = studentClient.findAllStudentByCourse(id);
        return StudentByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentDTOList(studentDTOList)
                .build();
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.delete(courseRepository.findById(id).orElse(null));
    }
}