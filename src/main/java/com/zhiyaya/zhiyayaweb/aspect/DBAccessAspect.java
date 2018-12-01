package com.zhiyaya.zhiyayaweb.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by zhouqianhao on 11/03/2017.
 */
@Aspect
@Component
public class DBAccessAspect {

  private static final Logger logger = LoggerFactory.getLogger(DBAccessAspect.class);
  private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

  @Pointcut("execution(public * com.zhiyaya.zhiyayaweb.mapper..*.*(..))")
  public void mapperTime() {
  }

  /**
   * 统计方法执行的时长
   *
   * @param joinPoint the join point
   * @return object
   */
  @Around("mapperTime()")
  public Object mapperCostTime(ProceedingJoinPoint joinPoint) throws Throwable {
    return countTimes(joinPoint);
  }

  private Object countTimes(ProceedingJoinPoint joinPoint) throws Throwable {
    Integer integer = threadLocal.get();
    if (integer == null) {
      threadLocal.set(1);
    } else {
      threadLocal.set(integer + 1);
    }
    return joinPoint.proceed();
  }

  public int getTimes() {
    Integer integer = threadLocal.get();
    if (integer == null) {
      return 0;
    } else {
      return integer;
    }
  }
}
