package demo.chapter1.aop;

import demo.chapter1.aop.Action;
import org.springframework.stereotype.Service;

@Service
public class DemoAnnotationService {
    @Action(name="Annotation class intercept add method")
    public void add() {}
}
