package com.hunter.framework.schedule.callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@Component
public class FutureEntryService {

    @Autowired
    private ExecutorService executorService;

    @Autowired
    private FutureEntryWatcher sBThreadPoolWatch;

    public FutureEntry submit(AbstractCallable callable){
        FutureEntry futureEntry = new FutureEntry(callable.getCallableParam());
        futureEntry.setTaskCreateTime(System.currentTimeMillis());
        callable.setFutureEntry(futureEntry);
        Future future = executorService.submit(callable);
        futureEntry.setFuture(future);
        sBThreadPoolWatch.add(futureEntry);
        return futureEntry;
    }

}
