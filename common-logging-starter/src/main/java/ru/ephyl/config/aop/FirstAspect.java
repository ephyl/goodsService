package ru.ephyl.config.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
public class FirstAspect {
    /*
     * @within - проверяет аннотации над классами
     * */

    @Pointcut("execution(public * *.goodsService.service.*.getAllGoodsDtoByStoreID(*))")
    public void anyGetAllGoodsDtoByStoreID() {
    }


    @Before(value = "anyGetAllGoodsDtoByStoreID() && args(id) && target(service)", argNames = "joinPoint,id,service")
    public void addLogging(JoinPoint joinPoint, int id, Object service) {
        log.info("Invoked BEFORE getAllGoodsDtoByStoreID method in class {} with id {}", service, id);
    }

    @AfterReturning(value = "anyGetAllGoodsDtoByStoreID()" +
            " && target(service)", returning = "result", argNames = "service,result")
    public void addLogging(Object service, Object result) {
        log.info("Invoked AFTER_RETURNING getAllGoodsDtoByStoreID method in class {}, {}", service, result);
    }
    @AfterThrowing(value = "anyGetAllGoodsDtoByStoreID()" +
            " && target(service)", throwing = "ex")
    public void addLogging(Throwable ex, Object service) {
        log.info("Invoked THROWING getAllGoodsDtoByStoreID method in class {}, {}, {}", service, ex.getClass(), ex.getMessage());
    }
    @After(value = "anyGetAllGoodsDtoByStoreID()" +
            " && target(service)")
    public void addLogging(Object service) {
        log.info("Invoked AFTER getAllGoodsDtoByStoreID method in class {}", service);
    }

}
