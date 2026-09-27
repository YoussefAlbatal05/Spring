package com.example.college_lms.Service;

import com.example.college_lms.model.Course;
import com.example.college_lms.repository.CourseRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Long id, Course updatedCourse) {

        Course course = courseRepository.findById(id).orElse(null);

        if (course != null) {
            course.setName(updatedCourse.getName());
            course.setCredits(updatedCourse.getCredits());

            return courseRepository.save(course);
        }

        return null;
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}