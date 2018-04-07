package demo.springboot.datatx.dao;

import demo.springboot.datatx.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
