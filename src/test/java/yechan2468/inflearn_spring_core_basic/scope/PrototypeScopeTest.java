package yechan2468.inflearn_spring_core_basic.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeScopeTest {

    @Test
    @DisplayName("프로토타입 스코프 빈을 조회하면 항상 새로운 객체 반환")
    void findPrototypeScopedBean() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);

        System.out.println("find prototypeBean1");
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        System.out.println("find prototypeBean2");
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);

        System.out.println("prototypeBean1 = " + prototypeBean1);
        System.out.println("prototypeBean2 = " + prototypeBean2);

        ac.close();

        Assertions.assertThat(prototypeBean1).isNotSameAs(prototypeBean2);
    }
    /*
    find prototypeBean1
    PrototypeBean.init
    find prototypeBean2
    PrototypeBean.init
    prototypeBean1 = yechan2468.inflearn_spring_core_basic.scope.PrototypeScopeTest$PrototypeBean@2ce86164
    prototypeBean2 = yechan2468.inflearn_spring_core_basic.scope.PrototypeScopeTest$PrototypeBean@5e8f9e2d
     */

    @Scope("prototype")
    static class PrototypeBean {

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy
        public void close() {
            System.out.println("PrototypeBean.close");
        }
    }
}
