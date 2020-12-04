package com.hunter.framework.schedule.callable;
import java.util.Date;
import java.util.concurrent.Future;

public class FutureEntry {

    private CommonCallableParam param;

    private Future future;

    private long taskCreateTime;

    private long taskStartRunTime;

    private long taskEndTime;

    public FutureEntry(CommonCallableParam param){
        this.param = param;
    }

    public CommonCallableParam getParam() {
        return param;
    }

    public void setParam(CommonCallableParam param) {
        this.param = param;
    }

    public Future getFuture() {
        return future;
    }

    public void setFuture(Future future) {
        this.future = future;
    }

    public long getTaskCreateTime() {
        return taskCreateTime;
    }

    public void setTaskCreateTime(long taskCreateTime) {
        this.taskCreateTime = taskCreateTime;
    }

    public long getTaskStartRunTime() {
        return taskStartRunTime;
    }

    public void setTaskStartRunTime(long taskStartRunTime) {
        this.taskStartRunTime = taskStartRunTime;
    }

    public long getTaskEndTime() {
        return taskEndTime;
    }

    public void setTaskEndTime(long taskEndTime) {
        this.taskEndTime = taskEndTime;
    }
}
