package com.bod.entity;

import java.util.Properties;

public enum LifeStyleEnum {
    M,
    A,
    I,
    H,
    U;

    private static final String PATH = "/amrConstants.properties";

//    private static final Logger logger = LoggerFactory.getLogger(Constants.class);

    private static Properties properties;

    private String value;

    private void init() {
        if (properties == null) {
            properties = new Properties();
            try {
                properties.load(LifeStyleEnum.class.getResourceAsStream(PATH));
            } catch (Exception e) {
//                logger.error("Unable to load " + PATH + " file from classpath.", e);
                System.exit(1);
            }
        }
        value = (String) properties.get(this.toString());
    }

    public String getValue() {
        if (value == null) {
            init();
        }
        return value;
    }

}