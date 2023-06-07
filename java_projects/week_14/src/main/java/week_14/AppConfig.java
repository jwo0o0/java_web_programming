package week_14;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class AppConfig {
    @Bean
    public MessageSource messageSource() {
        // 메시지 파일로 프로퍼티 형식 사용을 위한 MessageSource 구현체 클래스
        ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
        ms.setBasenames("label"); // src/main/resources 폴더에 label.properties가 있기 때문
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }

}
