package com.hunter.framework.schedule.controller;
import com.hunter.framework.schedule.service.impl.BusinessServiceImpl;
import com.hunter.framework.schedule.callable.FutureEntryService;
import com.hunter.framework.schedule.callable.CommonCallableParam;
import com.hunter.framework.schedule.callable.CommonCallable;
import com.hunter.framework.schedule.service.IMailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    /**
     * 注入发送邮件的接口
     */
    @Autowired
    private IMailService mailService;

    @GetMapping("/hello")
    public void hello() {
        //设置任务的业务数据参数,同时提供业务实现类和方法名称
        CommonCallableParam callableParam = new CommonCallableParam(BusinessServiceImpl.class,"executeTask");
        callableParam.setName("zhangsan");
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("age",26);
        dataMap.put("phone","13888888");
        callableParam.setDataMap(dataMap);
        CommonCallable commonCallable = new CommonCallable(callableParam);

        //提交任务
        futureEntryService.submit(commonCallable);
    }

    @GetMapping("/sendmail")
    public void sendmail() {
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        logger.info("开始测试邮件发送功能");
        mailService.sendSimpleMail("tivy_he@szedi.cn","主题：测试邮件"+sdf.format(now),"内容：这是一封测试邮件!");
        logger.info("结束测试邮件发送功能");
    }

}
