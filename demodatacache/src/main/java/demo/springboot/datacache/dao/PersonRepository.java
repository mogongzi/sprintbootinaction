package demo.springboot.datacache.dao;

import demo.springboot.datacache.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {}