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

@ConfigurationProperties(prefix = "downstream.system.switch")
@Component
public class SwitchProperties {

    private boolean shipout;
    private boolean koda;

    public Object get(String key) {
        if ("shipout".equals(key)) {
            return shipout;
        } else if ("koda".equals(key)) {
            return koda;
        }
        return null;
    }

    public boolean getShipout() {
        return shipout;
    }

    public boolean getKoda() {
        return koda;
    }

    public void setKoda(boolean koda) {
        this.koda = koda;
    }

    public void setShipout(boolean shipout) {
        this.shipout = shipout;
    }
}
