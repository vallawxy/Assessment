package com.example.Assessment.Student;

import com.example.Assessment.Register.Register;
import com.example.Assessment.Teacher.Teacher;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table
public class Student {

  @Id
  @SequenceGenerator(
    name = "student_sequence",
    sequenceName = "student_sequence",
    allocationSize = 1
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "student_sequence"
  )
  @Column(name = "STUDENT_ID", unique = true, nullable = false)
  private Long id;

  @Column(name = "STUDENT_NAME", unique = true, nullable = false)
  private String name;

  @Column(name = "STUDENT_EMAIL", nullable = false)
  private String email;

  @OneToMany(mappedBy = "students", cascade = CascadeType.ALL)
  private Set<Register> registers;

  public Student() {}

  public Student(Long id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
