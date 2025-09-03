package yechan2468.inflearn_spring_core_basic.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import yechan2468.inflearn_spring_core_basic.AppConfig;

public class ConfigurationSingletonTest {

    @Test
    @DisplayName("바이트코드 조작 확인")
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean);
    }
    /*
    bean = yechan2468.inflearn_spring_core_basic.AppConfig$$SpringCGLIB$$0@200606de
     */
}
