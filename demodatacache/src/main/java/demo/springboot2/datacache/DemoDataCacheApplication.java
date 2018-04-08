package demo.springboot2.datacache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DemoDataCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoDataCacheApplication.class, args);
    }
}
