package com.vxianjin.aegis.core.properties;

/**
 * @author xiefei
 * @date 2018/02/21
 */
public class BrowserProperties {
    /**
     *默认登录页
     */
    private String loginPage = "/signIn.html";

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }
}
