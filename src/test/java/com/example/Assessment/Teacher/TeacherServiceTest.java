package com.example.Assessment.Teacher;

import com.example.Assessment.Student.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class TeacherServiceTest {

    @Mock
    private TeacherRepository teacherRepositoryMock;

    @InjectMocks
    private TeacherService teacherService;

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testGetTeacher(){
        teacherService.getTeachers();
    }

    @Test
    public void testAddNewTeacher(){
        teacherService.getTeachers();
        Teacher teacher = new Teacher();
        teacher.setId(1l);
        Mockito.when(teacherRepositoryMock.save(Mockito.any(Teacher.class))).thenReturn(teacher);
        teacherService.addNewTeacher(teacher);
        Assert.assertEquals(1, teacherService.addNewTeacher(teacher));
    }
}
