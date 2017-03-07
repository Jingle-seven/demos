package xz.controller;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Jinhua on 2017/3/7.
 */
@Aspect
@Configuration
public class Speaker {
	@Pointcut("execution(* xz.controller..*.*(..))")
	public void commonSpeak() {}
	@Pointcut("execution(* xz.controller.JingleApi.get*(..))")
	public void apiSpeak(){}
	
	@Before("commonSpeak()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		
		// 记录下请求内容
		System.out.println("URL : " + request.getRequestURL().toString());
		System.out.println("HTTP_METHOD : " + request.getMethod());
		System.out.println("IP : " + request.getRemoteAddr());
	}
	
	@AfterReturning(returning = "ret", pointcut = "commonSpeak()")
	public void doAfterReturning(Object ret) throws Throwable {
		// 处理完请求，返回内容
		System.out.println("RESPONSE : " + ret);
	}
	//和其他不同,@around是主动型aop,可以控制被代理的接入点,改变其参数和返回值
	@Around("apiSpeak()")
	public Object doAround(ProceedingJoinPoint jp) throws Throwable {
		Object obj = jp.proceed();
		String resp = obj+" and it was checked by speaker with aop tool";
		System.out.println("JoinPoint : " + jp.toLongString());
		return resp;
	}
	//AfterThrowing可以处理异常,但是并不能终止异常传播,可以用Around解决
	@AfterThrowing(throwing="e",pointcut = "commonSpeak()")
	public void doError(Exception e) throws Throwable {
		try {
			throw e;
		} catch (Exception ex) {
			Logger logger = Logger.getLogger(this.getClass());
			logger.info(e);
		}
		
	}
}
