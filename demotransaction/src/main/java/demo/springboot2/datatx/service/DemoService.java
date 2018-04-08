package demo.springboot2.datatx.service;

import demo.springboot2.datatx.domain.Person;

public interface DemoService {
    Person savePersonWithRollBack(Person person);
    Person savePersonWithoutRollBack(Person person);
}
