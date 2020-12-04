package com.hunter.framework.schedule.controller;
import com.hunter.framework.schedule.service.BusinessService;
import com.hunter.framework.schedule.callable.FutureEntryService;
import com.hunter.framework.schedule.callable.CommonCallableParam;
import com.hunter.framework.schedule.callable.CommonCallable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: TODO</p>
 *
 * @author : tivy.He
 * @date : 2020-11-17 14:02:32
 */
@RestController
public class HomeController {

    private  final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private FutureEntryService futureEntryService;

    @GetMapping("/hello")
    public void hello() {
        //设置任务的业务数据参数,同时提供业务实现类和方法名称
        CommonCallableParam callableParam = new CommonCallableParam(BusinessService.class,"test");
        callableParam.setName("zhangsan");
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("age",26);
        dataMap.put("phone","13888888");
        callableParam.setDataMap(dataMap);
        CommonCallable commonCallable = new CommonCallable(callableParam);

        //提交任务
        futureEntryService.submit(commonCallable);
    }

}
