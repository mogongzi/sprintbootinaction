package demo.chapter1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DIMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DiConfig.class);
        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);

        System.out.println(useFunctionService.sayHello("Dependency Injection"));
        context.close();

        AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(JavaConfig.class);
        AnotherUseFunctionService anotherUseFunctionService = context2.getBean(AnotherUseFunctionService.class);
        System.out.println(anotherUseFunctionService.sayHello("Java Config"));
        context2.close();
    }
}
