package yechan2468.inflearn_spring_core_basic.beanfind;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yechan2468.inflearn_spring_core_basic.discount.AmountDiscountPolicy;
import yechan2468.inflearn_spring_core_basic.discount.DiscountPolicy;
import yechan2468.inflearn_spring_core_basic.discount.RateDiscountPolicy;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationContextInheritanceFindTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모 타입으로 조회 시 자식이 둘 이상 있으면 중복 오류 발생")
    void findBeanByParentTypeNonUnique() {
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("부모 타입으로 조회 시 자식이 둘 이상 있으면, 빈 이름 지정하면 됨")
    void findBeanByParentTypeAndName() {
        DiscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);

        assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("특정 하위 타입으로 조회")
    void findBeanByChildType() {
        RateDiscountPolicy rateDiscountPolicy = ac.getBean(RateDiscountPolicy.class);

        assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회")
    void findAllBeansByParentType() {
        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);

        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }

        assertThat(beansOfType.size()).isEqualTo(2);
    }
    /*
    key = rateDiscountPolicy value = yechan2468.inflearn_spring_core_basic.discount.RateDiscountPolicy@63fd4873
    key = amountDiscountPolicy value = yechan2468.inflearn_spring_core_basic.discount.AmountDiscountPolicy@1734f68
     */

    @Test
    @DisplayName("Object 타입으로 모두 조회")
    void findAllBeans() {
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);

        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
    }
    /*
    key = org.springframework.context.annotation.internalConfigurationAnnotationProcessor value = org.springframework.context.annotation.ConfigurationClassPostProcessor@1e11bc55
    key = org.springframework.context.annotation.internalAutowiredAnnotationProcessor value = org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor@77b7ffa4
    key = org.springframework.context.annotation.internalCommonAnnotationProcessor value = org.springframework.context.annotation.CommonAnnotationBeanPostProcessor@5ed190be
    key = org.springframework.context.event.internalEventListenerProcessor value = org.springframework.context.event.EventListenerMethodProcessor@402f80f5
    key = org.springframework.context.event.internalEventListenerFactory value = org.springframework.context.event.DefaultEventListenerFactory@5bbc9f97
    key = applicationContextInheritanceFindTest.TestConfig value = yechan2468.inflearn_spring_core_basic.beanfind.ApplicationContextInheritanceFindTest$TestConfig$$SpringCGLIB$$0@133e019b
    key = rateDiscountPolicy value = yechan2468.inflearn_spring_core_basic.discount.RateDiscountPolicy@41382722
    key = amountDiscountPolicy value = yechan2468.inflearn_spring_core_basic.discount.AmountDiscountPolicy@7dac3fd8
    key = environment value = StandardEnvironment {...}
    key = systemProperties value = {...}
    key = systemEnvironment value = {...}
    key = applicationStartup value = org.springframework.core.metrics.DefaultApplicationStartup@6c451c9c
    key = org.springframework.context.annotation.ConfigurationClassPostProcessor.importRegistry value = []
    key = messageSource value = Empty MessageSource
    key = applicationEventMulticaster value = org.springframework.context.event.SimpleApplicationEventMulticaster@31c269fd
     */

    @Configuration
    static class TestConfig {

        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy amountDiscountPolicy() {
            return new AmountDiscountPolicy();
        }
    }
}
