/**
 *
 */
package com.catsvie.coc.main;

import org.apache.log4j.Logger;
import org.aspectj.lang.Aspects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.catsvie.coc.log.LogService;
import com.catsvie.coc.log.NoLogging;

/**
 *
 * @author Peng Wang <br/>
 *         Sep 14, 2015
 * @version 1.0 <br/>
 */
@Configuration
@ComponentScan(basePackages = "com.catsvie.coc.service")
@NoLogging
public class AppBeanConfig {

	@Bean
	public LogService logService() {
		LogService ls = Aspects.aspectOf(LogService.class);
		ls.setLogger(logger());
		return ls;
	}

	@Bean
	public Logger logger() {
		return Logger.getLogger("coc");
	}
}
