package com.yuki.experiment.framework.controller;

import com.yuki.experiment.common.result.CommonResult;
import com.yuki.experiment.common.utils.EmptyUtil;
import com.yuki.experiment.framework.entity.CourseScore;
import com.yuki.experiment.framework.entity.Practice;
import com.yuki.experiment.framework.service.PracticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(tags = "对抗练习模块")
@RequestMapping("/api/practice")
public class PracticeController {

    @Resource
    private PracticeService practiceService;

    @ApiOperation("上传对抗练习题目")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public CommonResult<Practice> addPractice(@RequestBody Practice practice) {

        if (practice.getCourseId() == null) {
            return CommonResult.failed("课程Id不能为空");
        } else if (practice.getTeacherId() == null) {
            return CommonResult.failed("教师Id不能为空");
        }
        return CommonResult.success(practiceService.addSomeProblems(practice));
    }

    @ApiOperation("更新对抗练习")
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public CommonResult<Practice> modifyPractice(@RequestBody Practice practice) {
        if (practice.getId() == null) {
            return CommonResult.failed("对抗练习Id不能为空");
        }
        return CommonResult.success(practiceService.update(practice));
    }

    @ApiOperation("查看对抗练习")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public CommonResult<List<Practice>> queryPractice(
            @RequestParam(value = "courseId", required = false) Integer courseId,
            @RequestParam(value = "teacherId", required = false) Integer teacherId) {
        List<Practice> all = practiceService.getAll(courseId, teacherId);
        if (EmptyUtil.isEmpty(all)) {
            return CommonResult.failed();
        }
        return CommonResult.success(all);
    }

    @ApiOperation("查看对抗练习ById")
    @RequestMapping(value = "/practiceId", method = RequestMethod.GET)
    public CommonResult<Practice> queryForOnePractice(@RequestParam(value = "practiceId") String practiceId) {
        Practice oneById = practiceService.getOneById(practiceId);
        if (oneById == null) {
            return CommonResult.failed();
        }
        return CommonResult.success(oneById);
    }

    @ApiOperation("判断能否进行对抗练习")
    @RequestMapping(value = "/judge/{courseId}/{studentId}",method = RequestMethod.GET)
    public CommonResult<Boolean> judgePractice(@PathVariable Integer courseId,
                                               @PathVariable Integer studentId) {
        return CommonResult.success(practiceService.judgePractice(courseId, studentId));

    }


}
