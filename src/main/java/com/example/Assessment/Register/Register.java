package com.example.Assessment.Register;

import com.example.Assessment.Student.Student;
import com.example.Assessment.Teacher.Teacher;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "registration")
public class Register {

  @Id
  @SequenceGenerator(
    name = "register_sequence",
    sequenceName = "register_sequence",
    allocationSize = 1
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "register_sequence"
  )
  @Column(name = "REGISTER_ID", unique = true, nullable = false)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "STUDENT_EMAIL")
  private Student students;

  @ManyToOne
  @JoinColumn(name = "TEACHER_EMAIL")
  private Teacher teachers;


  public Register() {}

  public Register(Long id, Student students, Teacher teachers) {
    this.id = id;
    this.students = students;
    this.teachers = teachers;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Student getStudents() {
    return students;
  }

  public void setStudents(Student students) {
    this.students = students;
  }

  public Teacher getTeachers() {
    return teachers;
  }

  public void setTeachers(Teacher teachers) {
    this.teachers = teachers;
  }
}
