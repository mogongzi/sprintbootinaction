package demo.springboot.test.dao;

import demo.springboot.test.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {}
