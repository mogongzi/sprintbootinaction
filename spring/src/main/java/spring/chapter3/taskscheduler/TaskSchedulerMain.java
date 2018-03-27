package spring.chapter3.taskscheduler;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TaskSchedulerMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(TaskSchedulerConfig.class);
    }
}
