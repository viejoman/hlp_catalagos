package corp.galvan.hlp.catalogos;

import corp.galvan.hlp.catalogos.config.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplicationClass {

    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        registrationBean.addUrlPatterns("/inhibidor/*");

        return registrationBean;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplicationClass.class, args);
    }
}