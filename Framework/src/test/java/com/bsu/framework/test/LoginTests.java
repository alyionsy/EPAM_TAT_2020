package com.bsu.framework.test;

import com.bsu.framework.model.User;
import com.bsu.framework.page.ItemPage;
import com.bsu.framework.page.LandingPage;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class LoginTests extends CommonConditions {
    private final User userWithInvalidPassword = new User("erionolsen@gmail.com", "1111");
    private final User userWithInvalidLogin = new User("user@gmail.com", "PQ3cd$jc.c9rLBK");

    @Test
    public void loginWithInvalidPasswordTest() {
        boolean isLoginFieldEmpty = new LandingPage(driver)
                .openPage()
                .clickLoginButton()
                .openLoginPage()
                .login(userWithInvalidPassword)
                .isLoginFieldEmpty();

        assertThat(isLoginFieldEmpty, is(true));
    }

    @Test
    public void loginWithInvalidLoginTest() {
        boolean isLoginFieldEmpty = new LandingPage(driver)
                .openPage()
                .clickLoginButton()
                .openLoginPage()
                .login(userWithInvalidLogin)
                .isLoginFieldEmpty();

        assertThat(isLoginFieldEmpty, is(true));
    }

    @Test
    public void createAccountWithIncorrectPasswordTypeTest() {
        
    }
}
