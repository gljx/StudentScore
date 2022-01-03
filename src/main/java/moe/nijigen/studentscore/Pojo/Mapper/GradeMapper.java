package moe.nijigen.studentscore.Pojo.Mapper;

import lombok.Data;
import moe.nijigen.studentscore.Pojo.Grade;
import moe.nijigen.studentscore.Pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GradeMapper {

    public List<Grade> queryByUUID(String UUID);

    public List<Grade> queryByName(String name);

    public List<Grade> queryByGradeAndClassAndTeacherUUID(int grade,int Class_,String teacherUUID);

    public List<Grade> queryByTeacherUUID(@Param("TeacherUUID")String TeacherUUID);


}
