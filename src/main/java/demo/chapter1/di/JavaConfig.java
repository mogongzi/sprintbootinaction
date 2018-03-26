package demo.chapter1.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

    @Bean
    public AnotherFunctionService anotherFunctionService() {
        return new AnotherFunctionService();
    }

    @Bean
    public AnotherUseFunctionService anotherUseFunctionService() {
        AnotherUseFunctionService anotherUseFunctionService = new AnotherUseFunctionService();
        anotherUseFunctionService.setAnotherFunctionService(anotherFunctionService());
        return anotherUseFunctionService;
    }
}
