package com.validate.validate.process;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by wanghongxing on 15/10/10.
 */

@Aspect
@Component
public class ModelInterceptor {


    /**
     * only point cut Validate annotation
     */
    @Pointcut("@annotation(com.validate.validate.annotation.Validate)")
    public void pointCut(){

    }

    /**
     *
     * @param joinPoint
     */
    @Before("pointCut()")
    public void beforePointCut(JoinPoint joinPoint){

        for(Object object : joinPoint.getArgs()){
            if(object instanceof Request){
                RequiredUtil.checkModel(object);
            }

        }
    }

}
