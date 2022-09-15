package com.example.Assessment.Register;

import com.example.Assessment.Student.Student;
import com.example.Assessment.Student.StudentService;
import com.example.Assessment.Teacher.Teacher;
import com.example.Assessment.Teacher.TeacherService;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "api")
@RestController
public class RegisterController {

  private RegisterService registerService;
  private StudentService studentService;
  private TeacherService teacherService;

  @Autowired
  public RegisterController(
    RegisterService registerService,
    StudentService studentService,
    TeacherService teacherService
  ) {
    this.registerService = registerService;
    this.studentService = studentService;
    this.teacherService = teacherService;
  }

  @GetMapping("/register")
  public List<Register> getRegister() {
    return registerService.getRegister();
  }

  @GetMapping("/commonstudents")
  public Map getStudentByTeacherEmail(@RequestParam String teacher) {
    System.out.println(teacher);

    List<String> myList = new ArrayList<String>(
      Arrays.asList(teacher.split(","))
    );
    System.out.println(myList);

    Set<String> emails = registerService.getCommonStudent(myList);

    Map obj = new HashMap();
    obj.put("students", emails);
    return obj;
  }

  @PostMapping("/register")
  public ResponseEntity<Register> registerStudent(
    @RequestBody Map<String, Object> payload
  ) {
    registerService.registerStudent(payload);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PostMapping("/suspend")
  public ResponseEntity<Map> suspendStudent(@RequestBody Map student_email) {
    System.out.println(student_email.get("student"));
    registerService.suspendStudent((String) student_email.get("student"));
    return new ResponseEntity<>(student_email, HttpStatus.NO_CONTENT);
  }
}
