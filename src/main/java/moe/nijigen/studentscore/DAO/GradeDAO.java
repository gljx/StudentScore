package moe.nijigen.studentscore.DAO;

import moe.nijigen.studentscore.Pojo.Grade;
import moe.nijigen.studentscore.Pojo.Mapper.GradeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GradeDAO {

    @Autowired
    GradeMapper gradeMapper;

    public List<Grade> queryByTeacherUUID(String teacherUUID){
        return gradeMapper.queryByTeacherUUID(teacherUUID);
    }

}
