package com.example.Assessment.Student;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.event.annotation.BeforeTestClass;


public class StudentControllerTest {
    @Mock
    private StudentService studentServiceMock;

    @InjectMocks
    private StudentController studentController;

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetStudents()
    {
        studentController.getStudents();
    }

    @Test
    public void testRegisterNewStudent()
    {
        Student student = new Student();
        student.setId(1l);
        studentController.registerNewStudent(student);
    }

}
