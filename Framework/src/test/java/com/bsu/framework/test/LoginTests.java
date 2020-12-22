package com.bsu.framework.test;

import com.bsu.framework.model.AccountInfo;
import com.bsu.framework.model.User;
import com.bsu.framework.page.LandingPage;
import com.bsu.framework.page.MemberJoinPage;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LoginTests extends CommonConditions {
    private final User userWithInvalidPassword = new User("erionolsen@gmail.com", "1111");
    private final User userWithInvalidLogin = new User("user@gmail.com", "PQ3cd$jc.c9rLBK");
    private final AccountInfo accountInfoWithIncorrectPassword = new AccountInfo("Andorra", "name",
            "sample@gmail.com", "111");

    @Test
    public void loginWithInvalidPasswordTest() {
        boolean isLoginFieldEmpty = new LandingPage(driver)
                .openPage()
                .goToLoginPage()
                .openLoginPage()
                .login(userWithInvalidPassword)
                .isLoginFieldEmpty();

        assertThat(isLoginFieldEmpty, is(true));
    }

    @Test
    public void loginWithInvalidLoginTest() {
        boolean isLoginFieldEmpty = new LandingPage(driver)
                .openPage()
                .goToLoginPage()
                .openLoginPage()
                .login(userWithInvalidLogin)
                .isLoginFieldEmpty();

        assertThat(isLoginFieldEmpty, is(true));
    }

    @Test
    public void createAccountWithIncorrectPasswordTypeTest() {
        boolean isPasswordFieldActive = new MemberJoinPage(driver)
                .openPage()
                .createNewAccount(accountInfoWithIncorrectPassword)
                .isPasswordFieldActive();

        assertThat(isPasswordFieldActive, is(true));
    }
}
