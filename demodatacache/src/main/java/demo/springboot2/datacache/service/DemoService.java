package demo.springboot2.datacache.service;

import demo.springboot2.datacache.domain.Person;

public interface DemoService {
    Person save(Person person);
    void remove(Long id);
    Person findOne(Person person);
}
