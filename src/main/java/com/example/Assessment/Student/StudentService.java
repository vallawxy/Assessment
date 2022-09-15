package com.example.Assessment.Student;

import com.example.Assessment.Teacher.Teacher;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  private final StudentRepository studentRepository;

  @Autowired
  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public List<Student> getStudents() {
    return studentRepository.findAll();
  }

  public Student addNewStudent(Student student) throws IllegalStateException {
    Optional<Student> studentOptional = studentRepository.findStudentByEmail(
      (student.getEmail())
    );

    System.out.println(studentOptional.isPresent());

    if (studentOptional.isPresent()) {
      throw new IllegalStateException("email taken");
    }
    studentRepository.save(student);
    return student;
  }
}
