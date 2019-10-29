package zcq.com.morning.aspect;
/**
 * ***************************************************************************
 * Copyright (C) 2017 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 * ****************************************************************************
 */

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import zcq.com.morning.annotation.PrintLog;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author zhengchuqin
 * @version 1.0
 * @since 2019/09/30
 */
@Aspect
@Component
public class PrintLogAspect {


    @Pointcut("@within(zcq.com.morning.annotation.PrintLog)")
    void executeType(){}

    @Pointcut("@annotation(zcq.com.morning.annotation.PrintLog)")
    void executeMethod(){}

    @Before(value = "executeMethod()")
    public void before(JoinPoint joinPoint) {
        System.out.println(Arrays.toString(joinPoint.getArgs()));
        printAnnotation(joinPoint);
    }

    @Before(value = "executeType()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println(joinPoint.getTarget().toString());
        printAnnotation(joinPoint);
    }

    @Around(value = "executeMethod()")
    public Object around(JoinPoint joinPoint) throws Throwable {
        System.out.println("in.......");
        final Object[] args = joinPoint.getArgs();
        args[0] += "ok=";
        Object result = ((ProceedingJoinPoint) joinPoint).proceed(args);
        System.out.println("result = "+result);
        System.out.println("out.......");
        return result;
    }

    private void printAnnotation(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Class clazz = joinPoint.getTarget().getClass();
        String methodName = joinPoint.getSignature().getName();
        //获取注解desc
        String desc = StringUtils.EMPTY;
        for (Method method : clazz.getMethods()) {
            if (method.getName().equals(methodName)) {
                Class[] params = method.getParameterTypes();
                if (params.length == args.length) {
                    PrintLog annotation = method.getAnnotation(PrintLog.class);
                    if (annotation != null) {
                        desc = annotation.desc();
                    }
                }
            }
        }
        System.out.println("desc = " + desc);
    }
}
