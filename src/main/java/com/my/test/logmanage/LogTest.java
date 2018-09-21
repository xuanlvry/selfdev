package com.my.test.logmanage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by sunchengfei on 2018/6/21.
 */
public class LogTest {
    public static void main(String[] args) {
//        org.apache.log4j.Logger log = org.apache.log4j.LogManager.getLogger(LogTest.class);
//        log.debug("log4j:debug-AAAAAAAAAAAAAAAAAAAAAAAA");
//        log.info("log4j:info-AAAAAAAAAAAAAAAAAAAAAAAA");

//        Logger logger = LogManager.getLogger(LogTest.class);
//        logger.debug("log4j2:debug-AAAAAAAAAAAAAAAAAAAAAAAA");
//        logger.info("log4j2:info-AAAAAAAAAAAAAAAAAAAAAAAA");

//        Log logger2 = LogFactory.getLog(LogTest.class);
//        logger2.debug("commons-logger:debug-AAAAAAAAAAAAAAAAAAAAAAAA");
//        logger2.info("commons-logger:info-AAAAAAAAAAAAAAAAAAAAAAAA");

        org.slf4j.Logger logger3 = LoggerFactory.getLogger(LogTest.class);
        logger3.debug("slf4j:debug-AAAAAAAAAAAAAAAAAAAAAAAA");
        logger3.info("slf4j:info-AAAAAAAAAAAAAAAAAAAAAAAA");
    }
}
