package com.my.test.encryption.sdk;

import java.util.Properties;

/**
 * @author Chengfei.Sun on 2015/12/02.
 */
public class SDKConfig {
    public static final String FILE_NAME = "acp_sdk.properties";

    /**
     * 签名证书路径.
     */
    private String signCertPath;
    /**
     * 签名证书密码.
     */
    private String signCertPwd;
    /**
     * 签名证书类型.
     */
    private String signCertType;
    /**
     * 加密公钥证书路径.
     */
    private String encryptCertPath;
    /**
     * 验证签名公钥证书目录.
     */
    private String validateCertDir;
    /**
     * 按照商户代码读取指定签名证书目录.
     */
    private String signCertDir;

    /**
     * 配置文件中签名证书路径常量.
     */
    public static final String SDK_SIGNCERT_PATH = "acpsdk.signCert.path";
    /**
     * 配置文件中签名证书密码常量.
     */
    public static final String SDK_SIGNCERT_PWD = "acpsdk.signCert.pwd";
    /**
     * 配置文件中签名证书类型常量.
     */
    public static final String SDK_SIGNCERT_TYPE = "acpsdk.signCert.type";
    /**
     * 配置文件中密码加密证书路径常量.
     */
    public static final String SDK_ENCRYPTCERT_PATH = "acpsdk.encryptCert.path";
    /**
     * 配置文件中验证签名证书目录常量.
     */
    public static final String SDK_VALIDATECERT_DIR = "acpsdk.validateCert.dir";
    /**
     * 配置文件中证书使用模式
     */
    public static final String SDK_SINGLEMODE = "acpsdk.singleMode";

    /**
     * 操作对象.
     */
    private static SDKConfig config;
    /**
     * 属性文件对象.
     */
    private Properties properties;

    /**
     * 获取config对象.
     *
     * @return
     */
    public static SDKConfig getConfig() {
        if (null == config) {
            config = new SDKConfig();
        }
        return config;
    }

    public String getSignCertPath() {
        return signCertPath;
    }

    public void setSignCertPath(String signCertPath) {
        this.signCertPath = signCertPath;
    }

    public String getSignCertPwd() {
        return signCertPwd;
    }

    public void setSignCertPwd(String signCertPwd) {
        this.signCertPwd = signCertPwd;
    }

    public String getSignCertType() {
        return signCertType;
    }

    public void setSignCertType(String signCertType) {
        this.signCertType = signCertType;
    }

    public String getEncryptCertPath() {
        return encryptCertPath;
    }

    public void setEncryptCertPath(String encryptCertPath) {
        this.encryptCertPath = encryptCertPath;
    }

    public String getValidateCertDir() {
        return validateCertDir;
    }

    public void setValidateCertDir(String validateCertDir) {
        this.validateCertDir = validateCertDir;
    }

    public String getSignCertDir() {
        return signCertDir;
    }

    public void setSignCertDir(String signCertDir) {
        this.signCertDir = signCertDir;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public SDKConfig() {
        super();
    }

}
