package com.xs.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ClassName: SwitchProperties
 * Package: com.xs.properties
 * Description: 配置开关
 *
 * @Author 高伟
 * @Create 2025/5/7 18:33
 * @Version 1.0
 */

@ConfigurationProperties(prefix = "switch")
@Component
public class SwitchProperties {

    private boolean test1;
    private boolean test2;
    private String test3;

    public Object get(String key) {
        if ("test1".equals(key)) {
            return test1;
        } else if ("test2".equals(key)) {
            return test2;
        } else if ("test3".equals(key)) {
            return test3;
        }
        return null;
    }

    public String getTest3() {
        return test3;
    }

    public void setTest3(String test3) {
        this.test3 = test3;
    }

    public boolean getTest1() {
        return test1;
    }

    public void setTest1(boolean test1) {
        this.test1 = test1;
    }

    public boolean getTest2() {
        return test2;
    }

    public void setTest2(boolean test2) {
        this.test2 = test2;
    }
}
