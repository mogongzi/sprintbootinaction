package demo.springboot.datatx.service;

import demo.springboot.datatx.domain.Person;

public interface DemoService {
    Person savePersonWithRollBack(Person person);
    Person savePersonWithoutRollBack(Person person);
}
