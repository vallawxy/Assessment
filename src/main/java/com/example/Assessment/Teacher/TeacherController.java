package com.example.Assessment.Teacher;

import com.example.Assessment.Student.Student;
import com.example.Assessment.Student.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/teachers")
@ResponseBody
@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class TeacherController {

  private final TeacherService teacherService;

  @Autowired
  public TeacherController(TeacherService teacherService) {
    this.teacherService = teacherService;
  }

  @GetMapping
  public List<Teacher> getTeachers() {
    return teacherService.getTeachers();
  }

  @PostMapping
  public ResponseEntity<Teacher> registerNewTeacher(
    @RequestBody Teacher teacher
  ) {
    Teacher teacher1 = teacherService.addNewTeacher(teacher);
    return new ResponseEntity<>(teacher1, HttpStatus.CREATED);
  }
}
