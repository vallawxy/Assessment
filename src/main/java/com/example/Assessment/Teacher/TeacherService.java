package com.example.Assessment.Teacher;

import com.example.Assessment.Student.Student;
import com.example.Assessment.Student.StudentRepository;
import java.io.PipedOutputStream;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

  private final TeacherRepository teacherRepository;

  @Autowired
  public TeacherService(TeacherRepository teacherRepository) {
    this.teacherRepository = teacherRepository;
  }

  public List<Teacher> getTeachers() {
    return teacherRepository.findAll();
  }

  public Optional<Teacher> getTeacherByEmail(String teacherEmail) {
    return teacherRepository.findTeacherByEmail(teacherEmail);
  }

  public Teacher addNewTeacher(Teacher teacher) throws IllegalStateException {
    Optional<Teacher> teacherOptional = teacherRepository.findTeacherByEmail(
      teacher.getEmail()
    );

    System.out.println(teacherOptional.isPresent());

    if (teacherOptional.isPresent()) {
      throw new IllegalStateException("email taken");
    }
    teacherRepository.save(teacher);
    return teacher;
  }

  public void registerStudent(Teacher teacher, Set<Student> students) {
    Optional<Teacher> teacherOptional = teacherRepository.findById(
      teacher.getId()
    );
    if (!teacherOptional.isPresent()) {
      throw new IllegalStateException(
        "Failed to register course. Invalid CourseId "
      );
    }
    Teacher teacher1 = teacherOptional.get();

    System.out.println(teacherOptional.isPresent());
    System.out.println(teacher1);

    teacherRepository.save(teacher1);
  }
}
