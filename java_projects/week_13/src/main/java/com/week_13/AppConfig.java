package com.week_13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Bean
    public MessageSource messageSource() {
        // 메시지 파일로 프로퍼티 형식 사용을 위한 MessageSource 구현체 클래스
        ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
        ms.setBasenames("label"); // src/main/resources 폴더에 label.properties가 있기 때문
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }

    @Autowired
    AuthCheckInterceptor authCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registery) {
        registery.addInterceptor(authCheckInterceptor).addPathPatterns("/userInfo");
    }

}
