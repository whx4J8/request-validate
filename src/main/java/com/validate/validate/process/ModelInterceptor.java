package com.validate.validate.process;

import com.validate.validate.annotation.Request;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by wanghongxing on 15/10/10.
 */

@Aspect
@Component
public class ModelInterceptor {


    /**
     * only point cut Validate annotation
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void pointCut(){

    }

    /**
     *
     * @param joinPoint
     */
    @Before("pointCut()")
    public void beforePointCut(JoinPoint joinPoint) throws IllegalAccessException, InvocationTargetException, IntrospectionException {

        for(Object object : joinPoint.getArgs()){
            Request requestAno = object.getClass().getAnnotation(Request.class);
            if(requestAno != null){
                RequiredUtil.checkModel(object);
            }

        }
    }

}
