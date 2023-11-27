package com.microservice.course.controller;


import com.microservice.course.entities.Course;
import com.microservice.course.service.ICourseService;
import jdk.jfr.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course")
@CrossOrigin(origins = "*")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCourse(@RequestBody Course course){
        courseService.save(course);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(courseService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(courseService.findById(id));
    }

    @GetMapping("/search-student/{courseId}")
    public ResponseEntity<?> findStudentsByIdCourse(@PathVariable Long courseId){
        return ResponseEntity.ok(courseService.findStudentByIdCourse(courseId));
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable("id")Long id){
        courseService.deleteCourse(id);

        return "Curso eliminado con exito..";
    }
}
