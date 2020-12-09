package com.hunter.framework.schedule.service.impl;

import com.hunter.framework.schedule.callable.CommonCallableParam;
import com.hunter.framework.schedule.service.IBusinessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BusinessServiceImpl implements IBusinessService {

    private  final Logger logger = LoggerFactory.getLogger(BusinessServiceImpl.class);

    public String executeTask(CommonCallableParam callableParam){
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
