package com.example.Assessment.Teacher;

import com.example.Assessment.Register.Register;
import com.example.Assessment.Student.Student;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Table
@Entity
public class Teacher {

  @Id
  @SequenceGenerator(
    name = "teacher_sequence",
    sequenceName = "teacher_sequence",
    allocationSize = 1
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "teacher_sequence"
  )
  @Column(name = "TEACHER_ID", unique = true, nullable = false)
  private Long id;

  @Column(name = "TEACHER_NAME", unique = true, nullable = false)
  private String name;

  @Column(name = "TEACHER_EMAIL", nullable = false)
  private String email;

  @OneToMany(mappedBy = "teachers", cascade = CascadeType.ALL)
  private Set<Register> registers;

  public Teacher() {}

  public Teacher(Long id, String name, String email) {
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
