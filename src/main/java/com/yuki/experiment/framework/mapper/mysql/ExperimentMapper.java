package com.yuki.experiment.framework.mapper.mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuki.experiment.framework.entity.Experiment;
import org.springframework.stereotype.Repository;

/**
* @author 86180
* @description 针对表【experiment】的数据库操作Mapper
* @createDate 2021-11-12 21:43:09
* @Entity com.yuki.experiment.framework.entity.Experiment
*/
@Repository
public interface ExperimentMapper extends BaseMapper<Experiment> {

}




