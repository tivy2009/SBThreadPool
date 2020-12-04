package com.hunter.framework.schedule.callable;

import com.hunter.framework.schedule.util.GetBeanUtil;
import com.hunter.framework.schedule.util.ReflectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonCallable extends AbstractCallable{

    private  final Logger logger = LoggerFactory.getLogger(CommonCallable.class);

    public CommonCallable(CommonCallableParam callableParam){
        this.callableParam = callableParam;
    }

    @Override
    public Object task() throws Exception {
        logger.debug("running threadNum:{}",callableParam.getThreadNum());
        Class serviceClazz = callableParam.getServiceClazz();
        String methodName = callableParam.getMethodName();
        Object serviceObj = GetBeanUtil.getBean(serviceClazz);
        Class<?>[] parameterTypes = new Class[]{CommonCallableParam.class};
        Object[] parameters = new Object[]{callableParam};
        Object result = ReflectionUtils.invokeMethod(serviceObj,methodName,parameterTypes,parameters);
        return result;
    }

}
