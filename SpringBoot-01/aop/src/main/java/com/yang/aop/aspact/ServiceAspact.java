package com.yang.aop.aspact;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class ServiceAspact {

    @Pointcut(value = "execution( * com.yang.aop.service.impl.*ServiceImpl.A(..))")
    public void serviceAspact(){

    }

    @Around("serviceAspact()")
    public Object doBefore(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("拦截Service层的切面");
        Object proceed = null;
        
        
        try {
            // 执行拦截的目标 （执行ServiceImpl里边的方法）
            proceed = joinPoint.proceed();
            // proceed 为执行拦截目标方法后的返回值！
            // 抛异常，不抓会直接抛异常，抓异常处理后，proceed 返回值为 null
        }catch (Exception e){
            e.printStackTrace();
        }
        log.info("拦截Service层的切面,执行完成");
        
        // joinPoint.getArgs(); 可以获取拦截目标的参数
        Object[] args = joinPoint.getArgs();
        System.out.println(args);
        
        // 通过 joinPoint.proceed(); 可以执行拦截的目标！
        // TODO: 2022/2/21 切记， joinPoint.proceed();执行后的值 就是拦截目标的返回值
        // TODO: 2022/2/21 切记，拦截以后一定要将执行后的返回值，return出去！！！ 
        return proceed;
    }

}
