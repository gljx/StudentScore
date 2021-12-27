package moe.nijigen.studentscore.Pojo.Mapper;

import moe.nijigen.studentscore.Pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//这是一个mybatis 的 mapper类
@Mapper
@Repository//DAO层
public interface StudentMapper {

    List<Student> queryAllStudent();

    List<Student> queryByName(String name);

    int addStudent(Student student);

    int deleteStudednt(Student student);

    int updateStudent(Student student);

    Student queryByUUID(String uuid);

    Student queryByID(int id);

}
