package com.example.Assessment.Student;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/students")
@ResponseBody
@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class StudentController {

  private StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping
  public List<Student> getStudents() {
    return studentService.getStudents();
  }

  @PostMapping
  public ResponseEntity<Student> registerNewStudent(
    @RequestBody Student student
  ) {
    Student student1 = studentService.addNewStudent(student);
    return new ResponseEntity<>(student1, HttpStatus.CREATED);
  }
}
