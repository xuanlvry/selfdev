
package com.my.test.encryption.sdk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Chengfei.Sun on 2015/12/02.
 */
public class LogUtil {
    private final static Logger GATELOG = LoggerFactory.getLogger("ACP_SDK_LOG");
    private final static Logger GATELOG_ERROR = LoggerFactory.getLogger("SDK_ERR_LOG");

    /**
     * 记录普通日志
     *
     * @param cont
     */
    public static void writeLog(String cont) {
        GATELOG.info(cont);
    }

    /**
     * 记录ERORR日志
     *
     * @param cont
     */
    public static void writeErrorLog(String cont) {
        GATELOG_ERROR.error(cont);
    }

    /**
     * 记录ERROR日志
     *
     * @param cont
     * @param ex
     */
    public static void writeErrorLog(String cont, Throwable ex) {
        GATELOG_ERROR.error(cont, ex);
    }

    /**
     * debug方法
     *
     * @param cont
     */
    public static void debug(String cont) {
        if (GATELOG.isDebugEnabled()) {
            GATELOG.debug(cont);
        }
    }
}
