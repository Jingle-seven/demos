package xz.mybatislog;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Created by Jinhua on 2016/8/31.
 */
public class LogTest {
	public static void main(String[] args) {
		
		Logger logger = LogManager.getLogger(LogTest.class);
		logger = LogManager.getRootLogger();
		logger.debug("输出debug");
		logger.info("输出info");
		logger.warn("输出warn");
		logger.error("输出error");
		logger.fatal("输出fatal");
	}
}
