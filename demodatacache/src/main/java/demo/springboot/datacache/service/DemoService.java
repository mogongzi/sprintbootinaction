package demo.springboot.datacache.service;

import demo.springboot.datacache.domain.Person;

public interface DemoService {
    Person save(Person person);
    void remove(Long id);
    Person findOne(Person person);
}
