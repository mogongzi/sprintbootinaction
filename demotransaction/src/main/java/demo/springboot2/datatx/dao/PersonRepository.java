package demo.springboot2.datatx.dao;

import demo.springboot2.datatx.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
