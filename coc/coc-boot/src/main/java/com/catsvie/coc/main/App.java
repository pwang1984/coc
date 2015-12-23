/**
 *
 */
package com.catsvie.coc.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Peng Wang Peng Wang<br/>
 *         Sep 14, 2015
 * @version 1.0 <br/>
 */
@SpringBootApplication
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppDBConfig.class);
		ctx.register(AppBeanConfig.class);
		SpringApplication.run(App.class, args);
	}

}
