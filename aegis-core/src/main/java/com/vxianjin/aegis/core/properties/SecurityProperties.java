package com.vxianjin.aegis.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author xiefei
 * @date 2018/02/21
 */
@ConfigurationProperties(prefix = "vxianjin.aegis")
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }
}
