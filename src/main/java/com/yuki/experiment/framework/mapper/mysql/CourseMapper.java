package com.yuki.experiment.framework.mapper.mysql;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuki.experiment.framework.entity.Course;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
* @author 86180
* @description 针对表【course】的数据库操作Mapper
* @createDate 2021-11-16 23:26:40
* @Entity com.yuki.experiment.framework.entity.Course
*/
@Repository
public interface CourseMapper extends BaseMapper<Course> {

    JSONObject getCourseInfo(@Param("courseId")Integer courseId);



}




