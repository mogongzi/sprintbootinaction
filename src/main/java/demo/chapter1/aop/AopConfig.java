package demo.chapter1.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("demo.chapter1.aop")
@EnableAspectJAutoProxy
public class AopConfig {}
