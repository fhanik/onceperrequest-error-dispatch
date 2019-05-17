package example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	FilterRegistrationBean<RequestWrapperFilter> requestWrapperFilterFilterRegistrationBean(RequestWrapperFilter filter) {
		FilterRegistrationBean<RequestWrapperFilter> result = new FilterRegistrationBean<>(filter);
		result.setDispatcherTypes(EnumSet.of(DispatcherType.REQUEST, DispatcherType.ERROR));
		return result;
	}
}
