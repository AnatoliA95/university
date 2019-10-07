package university.department.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import university.department.entity.Student;



@Aspect
@Component
public class MyLoggingAspect {
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* university.department.service.*.*(..))")
	public void service() {
	}
	
	@Pointcut("execution(* university.department.dao.*.*(..))")
	public void dao() {
	}
	
	@Pointcut("execution(* university.department.controller.*.*(..))")
	public void controller() {
	}
	
	@Pointcut("controller() || dao() || service()")
	public void allProject() {
	}
	
	@Before("allProject()")
	private void before(JoinPoint theJP) {
		String theMethod = theJP.getSignature().toShortString();
		myLogger.info("----> Before method: " + theMethod);
		Object[] args = theJP.getArgs();
		for(Object arg: args) {
			myLogger.info("Arguments: " + arg);
		}
	}
	
	@AfterReturning(pointcut = "allProject()", returning = "result") 
	private void afterReturning(JoinPoint theJP) {
		String theMethod = theJP.getSignature().toShortString();
		myLogger.info("----> AfterReturning method: " + theMethod);

	}
}
