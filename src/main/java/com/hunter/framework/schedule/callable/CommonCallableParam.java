package com.hunter.framework.schedule.callable;

import java.util.Map;
import java.util.UUID;

/**
 * 线程任务参数定义类
 */
public class CommonCallableParam implements java.io.Serializable{

    private String threadNum;

    private String name;

    private Map<String,Object> dataMap;

    private Class serviceClazz;

    private String methodName;

    public CommonCallableParam(Class serviceClazz,String methodName){
        this.threadNum = UUID.randomUUID().toString().replace("-", "");
        this.serviceClazz = serviceClazz;
        this.methodName = methodName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, Object> dataMap) {
        this.dataMap = dataMap;
    }

    public String getThreadNum() {
        return threadNum;
    }

    public void setThreadNum(String threadNum) {
        this.threadNum = threadNum;
    }

    public Class getServiceClazz() {
        return serviceClazz;
    }

    public void setServiceClazz(Class serviceClazz) {
        this.serviceClazz = serviceClazz;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
