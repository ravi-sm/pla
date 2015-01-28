package org.nthdimenzion.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nthdimenzion.common.service.JpaRepositoryFactory;
import org.nthdimenzion.security.domain.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: Samir
 * @since 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Configuration(value = "classpath:testContext.xml")
public class TestContext {

    @Autowired
    private JpaRepositoryFactory jpaRepositoryFactory;

    @Test
    public void createUserLogin() {

        CrudRepository userLoginRepo = jpaRepositoryFactory.getCrudRepository(UserLogin.class);
        UserLogin userLogin = new UserLogin("samir", "samir", "5");
        userLogin = userLogin.updateValidDate();
        userLoginRepo.save(userLogin);

    }

}
