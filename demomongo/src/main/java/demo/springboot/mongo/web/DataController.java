package demo.springboot.mongo.web;

import demo.springboot.mongo.dao.PersonRepository;
import demo.springboot.mongo.domain.Location;
import demo.springboot.mongo.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

@RestController
public class DataController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/save")
    public Person save() {
        Person p = new Person("ryan", 33);

        Collection<Location> locations =  new LinkedHashSet<Location>();
        Location loc1 = new Location("Shanghai","2009");
        Location loc2 = new Location("Hefei","2010");
        Location loc3 = new Location("Guangzhou","2011");
        Location loc4 = new Location("Hangzhou","2012");
        locations.add(loc1);
        locations.add(loc2);
        locations.add(loc3);
        locations.add(loc4);
        p.setLocations(locations);

        return personRepository.save(p);
    }

    @RequestMapping("/q1")
    public Person q1(String name) {
        return personRepository.findByName(name);
    }

    @RequestMapping("/q2")
    public List<Person> q2(Integer age) {
        return personRepository.withQueryFindByAge(age);
    }
}
