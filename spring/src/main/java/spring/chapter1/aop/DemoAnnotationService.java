package spring.chapter1.aop;

import spring.chapter1.aop.Action;
import org.springframework.stereotype.Service;

@Service
public class DemoAnnotationService {
    @Action(name="Annotation class intercept add method")
    public void add() {}
}
