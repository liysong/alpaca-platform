package com.alpaca.admin.aspect;

import com.alpaca.admin.domain.SysOperationLog;
import com.alpaca.admin.service.ISysOperationLogService;
import com.alpaca.admin.annotation.OperationLog;
import com.alpaca.admin.shiro.ShiroUtils;

import com.grace.commons.util.IdGenerator;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @ClassName: SystemLogAspect
 * @Description: TODO
 * @Author：song
 * @Date: 2018/11/11 22:08
 * @Version: 1.0.0
 */
@Aspect
@Component
public class SystemLogAspect {

    @Autowired
    private ISysOperationLogService sysOperationLogService;

    @Pointcut(value = "@annotation(com.alpaca.admin.annotation.OperationLog)")
    public void logPointCut() {

    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        long beginTime = System.currentTimeMillis();
        //执行方法
        Object result = joinPoint.proceed();
        //执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;

        //保存日志
        saveSysLog(joinPoint, time);
        return  result;
    }

  //  @AfterThrowing(pointcut = "logPointCut()", throwing="e")
    public  void doAfterThrowing(ProceedingJoinPoint joinPoint, Throwable e) {
        //保存日志
        saveSysLog(joinPoint, 0L);
    }

    private void saveSysLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        SysOperationLog sysLog = new SysOperationLog();
        OperationLog operationLog = method.getAnnotation(OperationLog.class);
        if(operationLog != null){
            //注解上的描述
            sysLog.setName(operationLog.operationName());
            sysLog.setLogType(operationLog.operationType().getType());
        }

        //请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setClassName(className);
        sysLog.setMethod( methodName + "()");

        //请求的参数
        Object[] args = joinPoint.getArgs();
        try{
         //   System.out.println(args[0]);
         //   System.out.println(args[1]);
          //  String params = FastJsonUtils.getBeanToJson(args[0]);
            sysLog.setParams(args[0].toString());
        }catch (Exception e){

        }

        //获取request
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //设置IP地址
        sysLog.setIp(request.getRemoteAddr());

        //用户名id
        if(ShiroUtils.getUserEntity() != null) {
            sysLog.setUserId(ShiroUtils.getUserEntity().getId());
        }
        sysLog.setId(IdGenerator.getNextId());
        sysLog.setTotalTime(time);
        sysLog.setCreateTime(new Date());

        //保存系统日志
        sysOperationLogService.save(sysLog);
    }
}

