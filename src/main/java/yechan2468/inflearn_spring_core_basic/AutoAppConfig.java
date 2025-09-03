package yechan2468.inflearn_spring_core_basic;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // 기존 예제를 깨지지 않게 하기 위해 excludeFilters 사용
        // 기존에 만들었던 AppConfig, TestConfig 등에 @Configuration이 붙어 있는데, 이들은 컴포넌트 스캔의 대상이 되기 때문
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}
