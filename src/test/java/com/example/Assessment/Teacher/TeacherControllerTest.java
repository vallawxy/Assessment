package com.example.Assessment.Teacher;

import com.example.Assessment.Student.Student;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TeacherControllerTest {
    @Mock
    private TeacherService teacherServiceMock;

    @InjectMocks
    private TeacherController teacherController;

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetSTeachers()
    {
        teacherController.getTeachers();
    }

    @Test
    public void testRegisterNewTeacher()
    {
        Teacher teacher = new Teacher();
        teacher.setId(1l);
        teacherController.registerNewTeacher(teacher);
    }
}
