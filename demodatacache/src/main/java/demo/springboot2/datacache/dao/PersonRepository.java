package demo.springboot2.datacache.dao;

import demo.springboot2.datacache.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {}