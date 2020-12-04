package com.hunter.framework.schedule.callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

/**
 * 线程状态监听类
 */
@Component
public class FutureEntryWatcher implements ApplicationRunner {

    private  final Logger logger = LoggerFactory.getLogger(FutureEntryWatcher.class);

    private static List<FutureEntry> futureList = new ArrayList<>();

    @Autowired
    private ExecutorService executorService;

    public void add(FutureEntry futureEntry){
        futureList.add(futureEntry);
    }

    public void remove(FutureEntry futureEntry){
        futureList.remove(futureEntry);
    }

    public void removeAll(List<FutureEntry> futureEntryList){
        futureList.removeAll(futureEntryList);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        executorService.execute(() -> {
            logger.info("FutureEntryWatcher start......");
            while (true) {
                try{
                    Thread.sleep(5000);
                    List<FutureEntry> removeFutureList = new ArrayList<>();
                    if(!futureList.isEmpty()){
                        for (FutureEntry futureEntry : futureList) {
                            CommonCallableParam param = futureEntry.getParam();
                            String threadNum = param.getThreadNum();
                            FutureTask futureTask = (FutureTask)futureEntry.getFuture();
                            if(futureTask.isCancelled()){
                                logger.debug("Thread:{} is Cancelled.");
                                removeFutureList.add(futureEntry);
                                continue;
                            }else if (futureTask.isDone()) {
                                logger.info("Thread:{} is Done,result:{},lose time:{}",threadNum,futureTask.get(),futureEntry.getTaskEndTime() - futureEntry.getTaskCreateTime());
                                removeFutureList.add(futureEntry);
                                continue;
                            } else{
                                logger.debug("Thread:{} is running!",threadNum);
                            }
                        }
                    }else{
                        logger.debug("Thread watch list is empty.");
                    }
                    removeAll(removeFutureList);
                }catch (Exception e){
                    e.printStackTrace();
                    try{
                        Thread.sleep(30000);
                    }catch (Exception e2){
                    }
                }
            }
        });
    }
}
