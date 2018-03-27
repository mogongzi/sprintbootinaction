package demo.chapter3.annotation;

import org.springframework.stereotype.Service;

@Service
public class DemoService {
    public void outputResult() {
        System.out.println("Get bean from combined configuration annotation.");
    }
}
