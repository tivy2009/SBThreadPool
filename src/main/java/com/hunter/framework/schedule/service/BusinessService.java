package com.hunter.framework.schedule.service;

import com.hunter.framework.schedule.callable.CommonCallableParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class BusinessService {

    private  final Logger logger = LoggerFactory.getLogger(BusinessService.class);

    public String test(CommonCallableParam callableParam){
        logger.info("BuinessService test threadName:{}",Thread.currentThread().getName());
        //获取任务参数
        logger.info("params:{}",callableParam);
        if(callableParam != null){
            logger.info("params name:{}",callableParam.getName());
            Map<String,Object> dataMap = callableParam.getDataMap();
            if(dataMap != null && dataMap.size() > 0){
                for(Map.Entry<String,Object> entry : dataMap.entrySet()){
                    logger.info("params--> {} : {}",entry.getKey(),entry.getValue());
                }
            }
        }

        return "test";
    }

}
