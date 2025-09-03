package yechan2468.inflearn_spring_core_basic.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import yechan2468.inflearn_spring_core_basic.AppConfig;

public class ApplicationContextTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("beanDefinitionName = " + beanDefinitionName + " object = " + bean);
        }
    }
    /*
    beanDefinitionName = org.springframework.context.annotation.internalConfigurationAnnotationProcessor object = org.springframework.context.annotation.ConfigurationClassPostProcessor@7249dadf
    beanDefinitionName = org.springframework.context.annotation.internalAutowiredAnnotationProcessor object = org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor@6ab72419
    beanDefinitionName = org.springframework.context.annotation.internalCommonAnnotationProcessor object = org.springframework.context.annotation.CommonAnnotationBeanPostProcessor@3aacf32a
    beanDefinitionName = org.springframework.context.event.internalEventListenerProcessor object = org.springframework.context.event.EventListenerMethodProcessor@4fdfa676
    beanDefinitionName = org.springframework.context.event.internalEventListenerFactory object = org.springframework.context.event.DefaultEventListenerFactory@82c57b3
    beanDefinitionName = appConfig object = yechan2468.inflearn_spring_core_basic.AppConfig$$SpringCGLIB$$0@5be82d43
    beanDefinitionName = memberService object = yechan2468.inflearn_spring_core_basic.member.MemberServiceImpl@600b0b7
    beanDefinitionName = orderService object = yechan2468.inflearn_spring_core_basic.order.OrderServiceImpl@345e5a17
    beanDefinitionName = discountPolicy object = yechan2468.inflearn_spring_core_basic.discount.RateDiscountPolicy@5ea502e0
    beanDefinitionName = memberRepository object = yechan2468.inflearn_spring_core_basic.member.MemoryMemberRepository@443dbe42
     */

    @Test
    @DisplayName("모든 애플리케이션 빈 출력")
    void findAllApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            // BeanDefinition.ROLE_APPLICATION: 직접 등록한 어플리케이션 빈
            // BeanDefinition.ROLE_SUPPORT
            // BeanDefinition.ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("beanDefinitionName = " + beanDefinitionName + " object = " + bean);
            }
        }
    }
    /*
    beanDefinitionName = appConfig object = yechan2468.inflearn_spring_core_basic.AppConfig$$SpringCGLIB$$0@82c57b3
    beanDefinitionName = memberService object = yechan2468.inflearn_spring_core_basic.member.MemberServiceImpl@425357dd
    beanDefinitionName = orderService object = yechan2468.inflearn_spring_core_basic.order.OrderServiceImpl@2102a4d5
    beanDefinitionName = discountPolicy object = yechan2468.inflearn_spring_core_basic.discount.RateDiscountPolicy@210386e0
    beanDefinitionName = memberRepository object = yechan2468.inflearn_spring_core_basic.member.MemoryMemberRepository@3d4d3fe7
     */
}
