package com.example.Assessment.Teacher;

import com.example.Assessment.Student.Student;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
  Optional<Teacher> findTeacherByEmail(String email);
}
