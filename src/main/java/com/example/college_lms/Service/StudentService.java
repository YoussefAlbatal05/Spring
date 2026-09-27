package com.example.college_lms.Service;

import com.example.college_lms.model.Course;
import com.example.college_lms.model.Student;
import com.example.college_lms.repository.CourseRepository;
import com.example.college_lms.repository.StudentRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;


    public StudentService(StudentRepository studentRepository , CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;

    }

   
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

  
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

   
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

   
    public Student updateStudent(Long id, Student updatedStudent) {

        Student student = studentRepository.findById(id).orElse(null);

        if (student != null) {
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());

            return studentRepository.save(student);
        }

        return null;
    }


    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }


    public Student enrollStudentInCourse(Long studentId, Long courseId) {

    Student student = studentRepository.findById(studentId).orElse(null);

    Course course = courseRepository.findById(courseId).orElse(null);

    if (student != null && course != null) {
        student.getCourses().add(course);

        return studentRepository.save(student);
    }

        return null;
   }
}