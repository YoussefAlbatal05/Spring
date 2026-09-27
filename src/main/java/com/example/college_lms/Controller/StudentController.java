package com.example.college_lms.Controller;

import com.example.college_lms.model.Student;
import com.example.college_lms.Service.StudentService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

   @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

   @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

   @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
   }


   @PutMapping("/{id}")
   public Student updateStudent( @PathVariable Long id, @RequestBody Student student) {
    return studentService.updateStudent(id, student);
   }


   @DeleteMapping("/{id}")
   public void deleteStudent(@PathVariable Long id) {
    studentService.deleteStudent(id);
   }
   

   @PostMapping("/{studentId}/courses/{courseId}")
   public Student enrollStudentInCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
    return studentService.enrollStudentInCourse(studentId, courseId);
   }

}