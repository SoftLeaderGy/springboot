package com.yang.aop.aspact;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: Yang.Guo
 * @Date: 2021/08/26/10:47
 */


@Aspect  // 设置该类为切面类
@Slf4j
@Component  // 将切面类注入进Spring中
public class LoggerAspact {
    /**
     *  设置切点拦截
     * 使用注解@Pointcut 完成 如：@Pointcut（public * com.xxx.xxx.*.*(..)）
     * 规则：修饰符（可以不写，，但不能用*）+ 返回值类型 + 哪些包下的类 + 哪些方法 + 方法参数
     * "*" 代表不限
     * ".." 代表参数不限
     * @Pointcut(value = "execution(* com.yang.aop.controller.*.*(..))")
     *
     */
    @Pointcut(value = "execution(* com.yang.aop.controller.*.*(..))") // 设置切点集合
    public void myPointcut(){

    }

    /**
     *  定义通知，也就是切点拦截后执行的动作
     * 利用通知的5种类型注解：
     * @Before
     * @After
     * @AfterReturning
     * @AfterThrowing
     * @Around
     * 来完成某个切点的增强动作
     * 如@before("myPointcut()")，myPointcut()为第二部定义的切点
     */

    /**
     *
     * @param pjp
     * @return
     */
    @SneakyThrows
    @Around("myPointcut()")
    public Object myLogger(ProceedingJoinPoint pjp){
        String className = pjp.getClass().getName().toString();
        String methodName = pjp.getSignature().getName();

        Object[] array = pjp.getArgs();

        ObjectMapper objectMapper = new ObjectMapper();

        log.info("调用前：类："+className + "方法："+methodName + "参数为：" + objectMapper.writeValueAsString(array));

        Object proceed = pjp.proceed();

        log.info("调用后：类："+className + "方法："+methodName + "参数为：" + objectMapper.writeValueAsString(proceed));

        return proceed;

    }
}
