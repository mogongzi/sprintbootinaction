package demo.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringBootApp {

//    This is the first example
//    @RequestMapping("/")
//    String index() {
//        return "Hello Spring Boot!";
//    }

    @Value("${book.author}")
    private String bookAuthor;
    @Value("${book.name}")
    private String bookName;

    @Autowired
    private AuthorSettings authorSettings;

    @RequestMapping("/")
    String index() {
        //return "book name is:\"" + bookName + "\" and book author is:" + bookAuthor;
        return "author name is:\"" + authorSettings.getName() + "\" and author age is:" + authorSettings.getAge();
    }

    public static void main(String[] args) {
        SpringApplication app  = new SpringApplication(SpringBootApp.class);
        //app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
