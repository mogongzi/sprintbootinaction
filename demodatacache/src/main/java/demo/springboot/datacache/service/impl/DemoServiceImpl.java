package demo.springboot.datacache.service.impl;

import demo.springboot.datacache.dao.PersonRepository;
import demo.springboot.datacache.domain.Person;
import demo.springboot.datacache.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    PersonRepository personRepository;

    @Override
    @CachePut(value = "people", key="#person.id")
    public Person save(Person person) {
        Person p = personRepository.save(person);
        System.out.println("Cached id,key: " + p.getId());
        return p;
    }

    @Override
    @CacheEvict(value = "people")
    public void remove(Long id) {
        System.out.println("Removed cache for id,key: " + id);
        personRepository.deleteById(id);
    }

    @Override
    @Cacheable(value = "people", key = "#person.id")
    public Person findOne(Person person) {
        Optional<Person> p = personRepository.findById(person.getId());
        System.out.println("Cached id,key: " + p.get().getId());
        return p.get();
    }
}
