package demo.springcloud.ui.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import demo.springcloud.ui.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonHystrixService {

    @Autowired
    PersonService personService;

    @HystrixCommand(fallbackMethod = "fallbackSave")
    public List<Person> save(String name) {
        return personService.save(name);
    }

    public List<Person> fallbackSave() {
        List<Person> list = new ArrayList<>();
        Person p = new Person("Person Service Err");
        list.add(p);
        return list;
    }
}
