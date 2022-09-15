package com.example.Assessment.Student;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


public class StudentServiceTest {
    @Mock
    private StudentRepository studentRepositoryMock;

    @InjectMocks
    private StudentService studentService;

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetStudent(){
        studentService.getStudents();
    }

    @Test
    public void testAddNewStudent(){
        studentService.getStudents();
        Student student = new Student();
        student.setId(1l);
        Mockito.when(studentRepositoryMock.save(Mockito.any(Student.class))).thenReturn(student);
        studentService.addNewStudent(student);
        Assert.assertEquals(1, studentService.addNewStudent(student));
    }
}
