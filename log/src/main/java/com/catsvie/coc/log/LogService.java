package com.catsvie.coc.log;

import java.util.Arrays;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
@NoLogging
public class LogService {
	private Throwable throwable;

	@Inject
	private Logger logger;

	public LogService() {
		logger = Logger.getLogger("test");
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	@Pointcut("execution(* *(..)) " + "&& !within(*..*Test) " + "&& !execution(* *..domain..*.get*(..))"
			+ "&& !execution(* *..domain..*.set*(..))")
	public void allFunctions() {

	}

	@Pointcut("(execution(public * *(..)) || @annotation(Loggable)) " + "&& !within(*..*Test)"
			+ "&& !within(@NoLogging *)" + "&& !@annotation(NoLogging) " + "&& !execution( String *.toString()) "
			+ "&& !execution(* *..domain..*.get*(..))" + "&& !execution(* *..domain..*.set*(..))")
	public void logableFunctions() {

	}

	@AfterThrowing(pointcut = "allFunctions()", throwing = "throwable")
	public void logThrowable(JoinPoint jp, Throwable throwable) throws Throwable {
		if (this.throwable == throwable) {
			throw throwable;
		} else {
			this.throwable = throwable;
		}
		if (throwable instanceof Error) {
			logger.fatal("Error Detected. " + jp.toString(), throwable);
		} else {
			logger.error("Exception Detected. " + jp.toString(), throwable);
		}
		throwable.printStackTrace();
		throw throwable;
	}

	@Before("logableFunctions()")
	public void logEnterFunction(final JoinPoint jp) {
		logger.debug(jp.getSignature() + " START: " + Arrays.toString(jp.getArgs()));
	}

	@AfterReturning(pointcut = "logableFunctions()", returning = "o")
	public void logReturningFunction(final JoinPoint jp, Object o) {
		logger.info(jp.getSignature() + " DONE: " + Arrays.toString(jp.getArgs()) + " Returning: " + o);
	}

}