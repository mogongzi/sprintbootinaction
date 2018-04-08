package demo.springboot2.datatx.service.impl;

import demo.springboot2.datatx.dao.PersonRepository;
import demo.springboot2.datatx.domain.Person;
import demo.springboot2.datatx.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    PersonRepository personRepository;

    @Override
    @Transactional(rollbackFor = {IllegalArgumentException.class})
    public Person savePersonWithRollBack(Person person) {
        Person p = personRepository.save(person);

        if(person.getName().equals("ryan")) {
            throw new IllegalArgumentException("Ryan is existed, data will be rollback");
        }

        return p;
    }

    @Override
    @Transactional(noRollbackFor = {IllegalArgumentException.class})
    public Person savePersonWithoutRollBack(Person person) {
        Person p = personRepository.save(person);

        if(person.getName().equals("ryan")) {
            throw new IllegalArgumentException("Ryan is existed, data won't be rollback");
        }

        return p;
    }
}
