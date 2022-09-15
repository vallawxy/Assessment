package com.example.Assessment.Register;

import com.example.Assessment.Student.Student;
import com.example.Assessment.Student.StudentRepository;
import com.example.Assessment.Teacher.Teacher;
import com.example.Assessment.Teacher.TeacherRepository;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class RegisterService {

  private RegisterRepository registerRepository;
  private StudentRepository studentRepository;
  private TeacherRepository teacherRepository;

  @Autowired
  public RegisterService(
    RegisterRepository registerRepository,
    TeacherRepository teacherRepository,
    StudentRepository studentRepository
  ) {
    this.registerRepository = registerRepository;
    this.teacherRepository = teacherRepository;
    this.studentRepository = studentRepository;
  }

  public List<Register> getRegister() {
    return registerRepository.findAll();
  }


  public void registerStudent(Map<String, Object> payload)
    throws IllegalStateException {
    List<Register> registerOptional = registerRepository.findRegisterByTeachersEmail(
      (String) payload.get("teacher")
    );

    for (String studentEmail : (List<String>) payload.get("students")) {
      Optional<Student> studentOptional = studentRepository.findStudentByEmail(
        (studentEmail)
      );
      Optional<Teacher> teacherOptional = teacherRepository.findTeacherByEmail(
        (String) payload.get("teacher")
      );

      if (studentOptional.isEmpty() && teacherOptional.isEmpty()) {
        System.out.println("both error");
        throw new IllegalStateException(
          "invalid student email: " +
          studentEmail +
          " and invalid teacher email: " +
          (String) payload.get("teacher")
        );
      } else if (studentOptional.isEmpty()) {
        System.out.println("student empty");
        throw new IllegalStateException(
          "invalid student email: " + studentEmail
        );
      } else if (teacherOptional.isEmpty()) {
        System.out.println("teacher empty");
        throw new IllegalStateException(
          "invalid teacher email: " + (String) payload.get("teacher")
        );
      }

      for (Register reg : registerOptional) {
        if (reg.getStudents().getEmail().equals(studentEmail)) {
          System.out.println("both error");
          throw new IllegalStateException(
            "duplicate registered student email :" + studentEmail
          );
        }
      }

      Register register = new Register();
      register.setStudents(
        studentRepository.findStudentByEmail(studentEmail).get()
      );
      register.setTeachers(
        teacherRepository
          .findTeacherByEmail((String) payload.get("teacher"))
          .get()
      );
      registerRepository.save(register);
    }
  }

  public Set<String> getCommonStudent(List<String> emailList) {
    List<Register> reg = new ArrayList<Register>();

    for (String email : emailList) {
      reg.addAll(registerRepository.findRegisterByTeachersEmail(email));
    }
    System.out.println(reg);
    List<String> emails = new ArrayList<String>();

    for (Register num : reg) {
      emails.add(num.getStudents().getEmail());
    }

    System.out.println(emails);
    Set<String> result = new HashSet<>(emails);

    if (emailList.size() > 1) {
      result = findDuplicates(emails);
    }

    return result;
  }

  public Set<String> findDuplicates(List<String> listContainingDuplicates) {
    final Set<String> setToReturn = new HashSet<>();
    final Set<String> set1 = new HashSet<>();

    for (String yourInt : listContainingDuplicates) {
      if (!set1.add(yourInt)) {
        setToReturn.add(yourInt);
      }
    }
    return setToReturn;
  }

  public void suspendStudent(String student_email) {
    Optional<Student> studentOptional = studentRepository.findStudentByEmail(
      (student_email)
    );

    if (studentOptional.isEmpty()) {
      throw new IllegalStateException("invalid student email");
    }
    Long id = studentRepository.findStudentByEmail(student_email).get().getId();
    studentRepository.deleteById(id);
  }
}
