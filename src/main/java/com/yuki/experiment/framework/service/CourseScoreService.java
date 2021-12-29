package com.yuki.experiment.framework.service;

import com.alibaba.fastjson.JSONObject;
import com.yuki.experiment.framework.dto.SignInDTO;
import com.yuki.experiment.framework.entity.CourseScore;

import java.util.List;

public interface CourseScoreService {

    List<JSONObject> getCourseInfoAndIsActive(Integer studentId);

    int setCourseActive(Integer studentId,Integer courseId);

   SignInDTO signIn(Integer studentId, Integer courseId);
}
