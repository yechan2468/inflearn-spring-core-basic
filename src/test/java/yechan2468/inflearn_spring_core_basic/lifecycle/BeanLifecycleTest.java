package yechan2468.inflearn_spring_core_basic.lifecycle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifecycleTest {

    @Test
    @DisplayName("더미 네트워크 클라이언트를 통해 빈 라이프사이클(connect, disconnect) 테스트")
    void lifecycleTest() {
        // close 메서드는 ConfigurableApplicationContext에 존재
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifecycleTestConfig.class);

        DummyNetworkClient dummyNetworkClient = ac.getBean("dummyNetworkClient", DummyNetworkClient.class);

        ac.close();
    }
    /*
    Constructor: url = null
    connect: http://test.com
    send: http://test.com msg: 초기 연결
    disconnect: http://test.com
     */

    @Configuration(proxyBeanMethods = false) // proxyBeanMethods: 버전차로 인한 오류로 인해 넣어줌
    private static class LifecycleTestConfig {

        @Bean
        public DummyNetworkClient dummyNetworkClient() {
            DummyNetworkClient dummyNetworkClient = new DummyNetworkClient();
            dummyNetworkClient.setUrl("http://test.com");

            return dummyNetworkClient;
        }
    }
}
