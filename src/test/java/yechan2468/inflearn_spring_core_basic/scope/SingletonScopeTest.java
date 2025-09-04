package yechan2468.inflearn_spring_core_basic.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonScopeTest {

    @Test
    @DisplayName("싱글톤 스코프 빈을 조회하면 항상 같은 객체 반환")
    void findSingletonScopedBean() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);

        SingletonBean singletonBean1 = ac.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = ac.getBean(SingletonBean.class);

        System.out.println("singletonBean1 = " + singletonBean1);
        System.out.println("singletonBean2 = " + singletonBean2);

        ac.close();

        Assertions.assertThat(singletonBean1).isSameAs(singletonBean2);
    }
    /*
    SingletonBean.init
    singletonBean1 = yechan2468.inflearn_spring_core_basic.scope.SingletonScopeTest$SingletonBean@fd46303
    singletonBean2 = yechan2468.inflearn_spring_core_basic.scope.SingletonScopeTest$SingletonBean@fd46303
    SingletonBean.close
     */

    @Scope("singleton")
    static class SingletonBean {

        @PostConstruct
        public void init() {
            System.out.println("SingletonBean.init");
        }

        @PreDestroy
        public void close() {
            System.out.println("SingletonBean.close");
        }
    }
}
