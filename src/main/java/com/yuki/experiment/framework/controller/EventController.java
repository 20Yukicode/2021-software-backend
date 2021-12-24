package com.yuki.experiment.framework.controller;

import com.alibaba.fastjson.JSONObject;
import com.yuki.experiment.common.result.CommonResult;
import com.yuki.experiment.common.utils.EmptyUtil;
import com.yuki.experiment.framework.entity.Event;
import com.yuki.experiment.framework.service.EventService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {
    @Resource
    private EventService eventService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public CommonResult<List<JSONObject>>getInfo(@RequestParam("beginDate") Date beginDate,
                                    @RequestParam(value = "endDate",required = false) Date endDate){
        endDate=(endDate==null?beginDate:endDate);
        if(endDate.getTime()<beginDate.getTime()){
            return CommonResult.failed("后者时间不能小于前者时间");
        }
        return CommonResult.success(eventService.getInfo(beginDate,endDate));
    }

    @ApiOperation("插入事件")
    @RequestMapping(value = "",method = RequestMethod.POST)
    public CommonResult insertEvent(@RequestBody Event event){
        if(event.getStudentId()==null){
            return CommonResult.failed("学生Id不能为空");
        }
        else if(EmptyUtil.isEmpty(event.getTitle())){
            return CommonResult.failed("title不能为空");
        }
        else if(event.getDoTime()==null){
            return CommonResult.failed("要做某件事的时间不能为空");
        }
        if(eventService.insertEvent(event)>0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @ApiOperation("更新事件")
    @RequestMapping(value = "",method = RequestMethod.PUT)
    public CommonResult<Event> updateEvent(@RequestBody Event event){
        if(event.getId()==null){
            return CommonResult.failed("事件Id不能为空");
        }
        else if(EmptyUtil.isEmpty(event.getTitle())){
            return CommonResult.failed("title不能为空");
        }
        else if(event.getDoTime()==null){
            return CommonResult.failed("要做某件事的时间不能为空");
        }
        if(eventService.updateEvent(event)!=null){
            return CommonResult.success(event);
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除事件")
    @RequestMapping(value = "/{eventId}",method = RequestMethod.DELETE)
    public CommonResult deleteEvent(@PathVariable("eventId")Integer eventId){
        if(eventId==null){
            return CommonResult.failed("事件Id不能为空");
        }
        if(eventService.deleteEvent(eventId)>0){
            return CommonResult.success();
        }
        return CommonResult.failed();
    }



}