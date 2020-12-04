package com.hunter.framework.schedule.callable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.Callable;

public abstract class AbstractCallable implements Callable<Object> {

    private  final Logger logger = LoggerFactory.getLogger(AbstractCallable.class);

    protected CommonCallableParam callableParam;

    protected FutureEntry futureEntry;

    public CommonCallableParam getCallableParam() {
        return callableParam;
    }

    public void setCallableParam(CommonCallableParam callableParam) {
        this.callableParam = callableParam;
    }

    public FutureEntry getFutureEntry() {
        return futureEntry;
    }

    public void setFutureEntry(FutureEntry futureEntry) {
        this.futureEntry = futureEntry;
    }

    public abstract Object task() throws Exception;

    @Override
    public Object call() throws Exception {
        futureEntry.setTaskStartRunTime(System.currentTimeMillis());
        Thread.currentThread().setName(callableParam.getThreadNum());
        logger.info("threadNum:{} starting.-------->>>>>>",callableParam.getThreadNum());
        Object resultObj = task();
        logger.info("threadNum:{} end.<<<<<<--------",callableParam.getThreadNum());
        futureEntry.setTaskEndTime(System.currentTimeMillis());
        return resultObj;
    }

}
